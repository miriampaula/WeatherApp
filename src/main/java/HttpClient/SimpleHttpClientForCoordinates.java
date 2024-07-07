package HttpClient;

import org.json.JSONArray;
import org.json.JSONObject;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SimpleHttpClientForCoordinates {

    // SOFTVISION //
   /* private final HttpClient httpClient = HttpClients.createDefault();
    private static final String URI_TEMPLATE = "https://api.open-meteo.com/v1/forecast?latitude=%s&longitude=%s&current_weather=true&hourly=temperature_2m,relativehumidity_2m,windspeed_10m";

    public String doRequestForLatititudeAndLongitude(String latitude, String longitude) {

        String uri = String.format(URI_TEMPLATE, latitude, longitude);

        HttpGet httpGet = new HttpGet(uri);
        try {
            HttpResponse httpResponse = httpClient.execute(httpGet);
            InputStream inputStream = httpResponse.getEntity().getContent();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String response = "";
            String line = "";
            while ((line = bufferedReader.readLine()) != null) {
                response += line;
            }
        } catch (IOException e) {
            System.out.println(e);
        }

        return  null;
    }*/




    // De pe net + de la mine




    String link="https://api.open-meteo.com/v1/forecast?latitude=%s&longitude=%s&current_weather=true&hourly=temperature_2m,relativehumidity_2m,windspeed_10m";

    public float doRequestForLatitudeAndLonngitudeForTemp(String latitude,String longitude) {
        link=String.format(link, latitude, longitude);


            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder().uri(URI.create(link)).build();
           return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .thenApply(SimpleHttpClientForCoordinates::parseForTemp)
                    .join();
    }
    public float doRequestForLatitudeAndLongituteForHumidity(String latitude,String longitude){
        link=String.format(link, latitude, longitude);
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(link)).build();
        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(SimpleHttpClientForCoordinates::parseForHumidty)
                .join();
    }
    public static float parseForTemp(String responseBody){

        JSONObject data=new JSONObject(responseBody);
        JSONObject data1=data.getJSONObject("current_weather");
        float temp= data1.getFloat("temperature");
        return temp;
    }

    public static float parseForHumidty(String responseBody)
    {
        JSONObject data=new JSONObject(responseBody);
       JSONObject data1=data.getJSONObject("hourly");
       JSONArray data2=data1.getJSONArray("relativehumidity_2m");
       float humidity=data2.getFloat(0);
        return humidity;
    }

}




