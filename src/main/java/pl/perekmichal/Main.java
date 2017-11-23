package pl.perekmichal;


import pl.perekmichal.models.services.WeatherService;

public class Main  {
    public static void main(String[] args) {

        WeatherService weatherService = new WeatherService();
        weatherService.makeCall("krakow");
    }
}
