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
        int generator = new Random().nextInt(weather.length);
        generator = (coordinates.getHeight() > 20) ? generator++ : generator--;
        generator = (generator < 0) ? 3 : generator;
        generator = (generator > 3) ? 0 : generator;
        return weather[generator];
    }

}
