package mbortnic.Aircrafts;

import mborntic.Interface.Flyable;
import mborntic.Weather.WeatherTower;
import mbortnic.Tower.Tower;

public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {

    }

    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
        String write = "Tower says: #Helicopter" + this.name + "(" + this.id + ") registered to weather tower.\n";
        this.weatherTower = weatherTower;
        weatherTower.writeToFile("write", write);
    }

}