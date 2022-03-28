import com.google.gson.Gson;
import dto.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static String apiUrl = "http://dapi.kakao.com/v2/local/search/address.json?query=";
    private static String apiKey = "";

    public static void main(String[] args) {
        String[] arr = new String[]{
                "판교로228번길 15","상동 551-2"
        };
        List<Response> responses = new ArrayList<>();
        System.out.println("CHECK POINT1");
        for (String arg : arr) {
            System.out.println("CHECK POINT2");
            try {
                String address = URLEncoder.encode(arg, "UTF-8");
                URL url = new URL(apiUrl + address);
                Gson gson = new Gson();

                StringBuffer response = new StringBuffer();
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setRequestMethod("POST");
                conn.setRequestProperty("Authorization", apiKey);
                conn.setDoOutput(true);

                BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine = br.readLine();
                if (inputLine != null) {
                    response.append(inputLine);
                    StringBuffer str = new StringBuffer(response.toString());
                    System.out.println("CHECK POINT3");
                    System.out.println(str.toString());
                    Response res = gson.fromJson(str.toString(), Response.class);
                    responses.add(res);
                    System.out.println("RESULT: " + res.toString());
                    System.out.println();
                }
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        CsvWriter.writeCSV("/home/seongjin/bufferCsv/imsi.csv", responses);
    }
}
//KakaoAK 73bee8d216781ddebb1d741bfdbb08d9