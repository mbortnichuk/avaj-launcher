package mbortnic.Aircrafts;

import mbortnic.Interface.Flyable;
import mbortnic.Weather.WeatherTower;
import java.util.Random;

public class Baloon extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {

    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        String write = "Tower says: Baloon#" + this.name + "(" + this.id + ") registered to weather tower.\n";
        weatherTower.writeToFile("write", write);
    }

}