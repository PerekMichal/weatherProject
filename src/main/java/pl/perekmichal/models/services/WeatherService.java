package pl.perekmichal.models.services;

import org.json.JSONObject;
import pl.perekmichal.models.utils.Config;
import pl.perekmichal.models.utils.HttpUtils;

public class WeatherService {
    private float temp;
    private float pressure;
    private float humidity;
    private float speedWind;
    private float clouds;

    public WeatherService() {
    }

    public String makeCall(String city){
        parseJsonData(HttpUtils.makeHttpRequest(Config.App_URL + city + "&appid=" + Config.App_ID));

        return null;
    }

    private void parseJsonData(String text){
        JSONObject root = new JSONObject(text);
        JSONObject main = root.getJSONObject("main");
        JSONObject wind = root.getJSONObject("wind");
        JSONObject cloudsWeb = root.getJSONObject("clouds");

        temp = main.getFloat("temp");
        System.out.println("Temperatura: " + (temp - 273.15));

        pressure = main.getFloat("pressure");
        System.out.println("Ciśnienie: " + pressure);

        humidity = main.getFloat("humidity");
        System.out.println("Wilgtność: " + humidity);

        speedWind = wind.getFloat("speed");
        System.out.println("Prędkość wiatru: " + speedWind);

        clouds = cloudsWeb.getFloat("all");
        System.out.println("Zachmurzenie: " + clouds);
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getSpeedWind() {
        return speedWind;
    }

    public void setSpeedWind(float speedWind) {
        this.speedWind = speedWind;
    }

    public float getClouds() {
        return clouds;
    }

    public void setClouds(float clouds) {
        this.clouds = clouds;
    }
}
