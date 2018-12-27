package mbortnic.Weather;

import mbortnic.Tower.Tower;
import mbortnic.Aircrafts.Coordinates;

/*
** To handle all the coordinates.
*/

public class WeatherTower extends Tower {

    // public methods
    public String getWeather(Coordinates coordinates) {
        return (WeatherProvider.getProvider().getCurrentWeather(coordinates));
    }

    // default methods
    public void changeWeather() {
        this.conditionsChanged();
    }
}