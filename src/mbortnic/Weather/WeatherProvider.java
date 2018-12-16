package mbortnic.Weather;

import mbortnic.Aircrafts.Coordinates;
import java.util.Random;

/*
** To handle all different kinds of weathers.
*/

public class WeatherProvider {
    private static WeatherProvider weatherProvider = null;
    private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider(){
    }

    public static WeatherProvider getProvider() {
        if (weatherProvider == null)
        weatherProvider = new WeatherProvider();
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int randomGenerator = new Random().nextInt(weather.length);
        String randomWeather = (weather[randomGenerator]);
        return randomWeather;
    }

}
