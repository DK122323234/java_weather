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

public class Main {
    private static String ip = "29ed5ca47c3d0c32385b18f1e82e522f";
    public static String city;

    public static void main(String[] args) throws IOException {

        try {
            // URL для получения информации о местоположении по IP
            String url1 = "https://ipinfo.io/city";
            BufferedReader br = new BufferedReader(new InputStreamReader(new URL(url1).openStream()));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            city = sb.toString();
        } catch (Exception e) {
            System.out.println(e.toString());
        }


        try {
            String url2 = "https://api.openweathermap.org/data/2.5/forecast?q=" + city + "&appid=" + ip + "&units=metric";
            BufferedReader br = new BufferedReader(new InputStreamReader(new URL(url2).openStream()));

            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            for (int i = 0; i < 7; i++) {

                JSONObject jsonObject = new JSONObject(sb.toString());
                JSONArray jsonArray = jsonObject.getJSONArray("list");
                JSONObject arrayJSONObject = jsonArray.getJSONObject(i);
                JSONObject main = arrayJSONObject.getJSONObject("main");
                double temperature = main.getDouble("temp");
                System.out.println("Температура:" + temperature);
            }


        } catch (Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }
}
