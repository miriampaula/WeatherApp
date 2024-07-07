package handler;

import handler.ApiRequestHandler;
import model.request.ApiRequest;
import model.request.WeatherByCityApiRequest;

public class WeatherByCityRequestHandler extends ApiRequestHandler {

    public WeatherByCityRequestHandler(){

    }

    public String handleWeatherRequest(ApiRequest apiRequest)
    {
        return this.converter.convertCurrentWeatherToJson(this.getWeatherProvider().provideWeatherByCity((WeatherByCityApiRequest)apiRequest));
    }

}
