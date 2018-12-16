package mbortnic.Weather;

import mbortnic.Tower.Tower;
import mbortnic.Aircrafts.Coordinates;

/*
** To handle all the coordanates.
*/

public class WeatherTower extends Tower {

    // WeatherProvider WeatherProvider = new WeatherProvider();

    public String getWeather(Coordinates coordinates) {
        return (WeatherProvider.getProvider().getCurrentWeather(coordinates));
    }

    public void changeWeather() {
        this.conditionsChanged();
    }
}