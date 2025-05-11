import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;

public class home {

    private static final String API_KEY = "ВАШ_API_КЛЮЧ"; // Замените на ваш API-ключ
    private static final String BASE_URL = "http://api.openweathermap.org/data/2.5/forecast";

    public static void main(String[] args) {
        try {
            String city = "Москва"; // Замените на нужный город
            getWeatherForecast(city);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void getWeatherForecast(String city) throws Exception {
        String urlString = BASE_URL + "?q=" + city + "&appid=" + API_KEY + "&units=metric";
        URL url = new URL(urlString);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("HTTP error code: " + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = br.readLine()) != null) {
            response.append(line);
        }
        br.close();

        // Обработка JSON-ответа
        JSONObject jsonResponse = new JSONObject(response.toString());
        JSONArray list = jsonResponse.getJSONArray("list");

        // Получаем прогноз на завтра (индекс 8) и послезавтра (индекс 16)
        // Индексы могут варьироваться в зависимости от времени запроса, поэтому лучше использовать логику для определения нужных индексов
        long currentTime = System.currentTimeMillis() / 1000; // текущее время в секундах
        long tomorrowTime = currentTime + 86400; // время на завтра
        long dayAfterTomorrowTime = currentTime + 2 * 86400; // время на послезавтра

        // Перебираем массив и ищем ближайшие прогнозы
        for (int i = 0; i < list.length(); i++) {
            JSONObject forecast = list.getJSONObject(i);
            long forecastTime = forecast.getLong("dt");

            if (forecastTime >= tomorrowTime && forecastTime < tomorrowTime + 86400) {
                // Прогноз на завтра
                JSONObject main = forecast.getJSONObject("main");
                String weatherDescription = forecast.getJSONArray("weather").getJSONObject(0).getString("description");
                System.out.println("Прогноз на завтра: " + main.getDouble("temp") + "°C, " + weatherDescription);
            }

            if (forecastTime >= dayAfterTomorrowTime && forecastTime < dayAfterTomorrowTime + 86400) {
                // Прогноз на послезавтра
                JSONObject main = forecast.getJSONObject("main");
                String weatherDescription = forecast.getJSONArray("weather").getJSONObject(0).getString("description");
                System.out.println("Прогноз на послезавтра: " + main.getDouble("temp") + "°C, " + weatherDescription);
            }
        }
    }
}