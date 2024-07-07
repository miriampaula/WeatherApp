package model.request;

public class WeatherByCityApiRequest implements ApiRequest {
    private String city;
    public WeatherByCityApiRequest(String city)
    {
        this.city = city;
    }
    public String getCity()
    {
        return this.city;
    }
    public void setCity(String city)
    {
        this.city=city;
    }

}
