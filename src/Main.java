import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

public class Main {
    private static String apiKey = "29ed5ca47c3d0c32385b18f1e82e522f";
    public static String cityName;

    public static void main(String[] args) throws IOException {

        try {

            String locationUrl = "https://ipinfo.io/city";
            BufferedReader locationReader = new BufferedReader(new InputStreamReader(new URL(locationUrl).openStream()));
            StringBuilder locationResponse = new StringBuilder();
            String line;
            while ((line = locationReader.readLine()) != null) {
                locationResponse.append(line);
            }
            cityName = locationResponse.toString();
        } catch (Exception e) {
            System.out.println("Ошибка в ip" + e.toString());
        }

        try {
            String weatherUrl = "https://api.openweathermap.org/data/2.5/forecast?q=" + cityName + "&appid=" + apiKey + "&units=metric";
            BufferedReader weatherReader = new BufferedReader(new InputStreamReader(new URL(weatherUrl).openStream()));

            StringBuilder weatherResponse = new StringBuilder();
            String line;
            while ((line = weatherReader.readLine()) != null) {
                weatherResponse.append(line);
            }

            for (int i = 0; i < 7; i++) {
                JSONObject jsonObject = new JSONObject(weatherResponse.toString());
                JSONArray jsonArray = jsonObject.getJSONArray("list");
                JSONObject forecastObject = jsonArray.getJSONObject(i);
                JSONObject mainWeatherData = forecastObject.getJSONObject("main");
                double temperature = mainWeatherData.getDouble("temp");
                System.out.println("Температура: " + temperature);
            }

        } catch (Exception e) {
            System.out.println("Ошибка в сайте погоды:" + e.toString());
            e.printStackTrace();
        }
    }
}
