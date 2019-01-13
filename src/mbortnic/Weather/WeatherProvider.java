package mbortnic.Weather;

import mbortnic.Aircrafts.Coordinates;
import java.util.Random;

/*
** To handle all different kinds of weathers.
*/

public class WeatherProvider {

    // private properties
    private static WeatherProvider weatherProvider = new WeatherProvider();
    private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    // private constructor
    private WeatherProvider() {
    }

    // public methods
    public static WeatherProvider getProvider() {
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        // int randomWeatherGenerator = new Random().nextInt(weather.length);
        // String randWeather = (weather[randomWeatherGenerator]);
        // return randWeather;

        int total = coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongitude() + weather.length;
        int index = total % weather.length;
        return (weather[index]);
    }

}
