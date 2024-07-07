package controller;

import model.request.ApiRequest;
import model.request.WeatherByCityApiRequest;
import model.request.WeatherByCoordinatesApiRequest;
import spark.Spark;
import handler.*;

public class ApiController {
    static ApiRequestHandler apiRequestHandlerByCity=new WeatherByCityRequestHandler();
    static ApiRequestHandler getApiRequestHandlerByCoordinates=new WeatherByCoordinatesRequestHandler();
    public ApiController(){

    }

    public void startSparkHttpServer(){
        Spark.get("/api/v1/weather/cities/city/:city",(request, response) -> {

            String city= request.params(":city");
            ApiRequest apiRequest=new WeatherByCityApiRequest(city);
            response.type("application/json");
            response.status(200);

            return apiRequestHandlerByCity.handleWeatherRequest(apiRequest);
        });
        Spark.get("/api/v1/weather/coordinates/latitude/:lat/longitude/:long",(request, response) -> {

            String longitude=request.params(":long");
            String latitude=request.params(":lat");
            ApiRequest apiRequest=new WeatherByCoordinatesApiRequest(latitude,longitude);
            response.type("application/json");
            response.status(200);
            return getApiRequestHandlerByCoordinates.handleWeatherRequest(apiRequest);
        });

    }
}
