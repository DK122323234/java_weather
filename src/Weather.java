import netscape.javascript.JSObject;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.net.ssl.HttpsURLConnection;
import javax.sound.sampled.Line;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Weather {
    private static String apiKey = "29ed5ca47c3d0c32385b18f1e82e522f";
    public static String cityName;

    public static void main(String[] args) throws IOException {

        try {
            // URL для получения информации о местоположении по IP
            String locationUrl = "https://ipinfo.io/city";
            BufferedReader locationReader = new BufferedReader(new InputStreamReader(new URL(locationUrl).openStream()));
            StringBuilder locationResponse = new StringBuilder();
            String locationLine;
            while ((locationLine = locationReader.readLine()) != null) {
                locationResponse.append(locationLine);
            }
            cityName = locationResponse.toString();
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        try {
            String weatherUrl = "https://api.openweathermap.org/data/2.5/forecast?q=" + cityName + "&appid=" + apiKey + "&units=metric";
            BufferedReader weatherReader = new BufferedReader(new InputStreamReader(new URL(weatherUrl).openStream()));

            StringBuilder weatherResponse = new StringBuilder();
            String weatherLine;
            while ((weatherLine = weatherReader.readLine()) != null) {
                weatherResponse.append(weatherLine);
            }

            for (int i = 0; i < 7; i++) {
                JSONObject jsonObject = new JSONObject(weatherResponse.toString());
                JSONArray weatherArray = jsonObject.getJSONArray("list");
                JSONObject forecast = weatherArray.getJSONObject(i);
                JSONObject mainData = forecast.getJSONObject("main");
                double temperature = mainData.getDouble("temp");
                System.out.println("Температура: " + temperature);
            }

        } catch (Exception e) {
            System.out.println("Что-то пошло не так");
            e.printStackTrace();
        }
    }
}
