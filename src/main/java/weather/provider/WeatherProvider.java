package weather.provider;

import HttpClient.SimpleHttpClientForCoordinates;
import model.response.CurrentWeather;
import model.request.WeatherByCityApiRequest;
import model.request.WeatherByCoordinatesApiRequest;

public class WeatherProvider {
    public WeatherProvider(){}

    public CurrentWeather provideWeatherByCity(WeatherByCityApiRequest weatherByCityApiRequest)
    {
        //return new CurrentWeather((new Random()).nextFloat(50),"whatever");
        return null;
    }
    public CurrentWeather provideWeatherByCoordinates(WeatherByCoordinatesApiRequest weatherByCoordinatesApiRequest)
    {
       String latitude= weatherByCoordinatesApiRequest.getLatitude();

       String longitude=weatherByCoordinatesApiRequest.getLongitude();

       SimpleHttpClientForCoordinates simpleHttpClientForTemp=new SimpleHttpClientForCoordinates();



       float temp= simpleHttpClientForTemp.doRequestForLatitudeAndLonngitudeForTemp(latitude,longitude);

       float humidity=simpleHttpClientForTemp.doRequestForLatitudeAndLongituteForHumidity(latitude,longitude);



       return  new CurrentWeather(temp,humidity);

    }
}
