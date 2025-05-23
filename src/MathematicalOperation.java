import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class MathematicalOperation {
    private static String ip = "29ed5ca47c3d0c32385b18f1e82e522f";

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String city = scanner.nextLine();


        try {
            String ur = "https://api.openweathermap.org/data/2.5/forecast?q=" + city + "&appid=" + ip + "&units=metric";
            BufferedReader br = new BufferedReader(new InputStreamReader(new URL(ur).openStream()));

            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }

            JSONObject jsonObject = new JSONObject(sb.toString());
            JSONArray jsonArray = jsonObject.getJSONArray("list");
            JSONObject mai = jsonArray.getJSONObject(0);
            JSONObject main = mai.getJSONObject("main");
            double temperature = main.getDouble("temp");
            JSONObject maiQ = jsonArray.getJSONObject(1);
            JSONObject maiP = mai.getJSONObject("main");
            double temperatur = main.getDouble("temp");
            System.out.println("Температура:" + temperatur);
            System.out.println(temperature);


        } catch (Exception e) {
            System.out.println("Что то не так");
            e.printStackTrace();
        }
    }
}