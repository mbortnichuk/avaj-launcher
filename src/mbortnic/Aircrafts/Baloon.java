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
        String weatherTmp = weatherTower.getWeather(this.coordinates);
        String wToFile = "";
        String wToFileUnreg = "";
        String tmp = "Baloon#" + this.name + "(" + this.id + "): ";

        switch (weatherTmp) {
            case "RAIN":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
                wToFile = tmp + "It's raining. Better watch out for lightnings. (H -5)\n";
                break;
            case "SUN":
                coordinates = new Coordinates(coordinates.getLongitude() + 2, coordinates.getLatitude(), coordinates.getHeight() + 4);
                wToFile = tmp + "Some sun light, lets take some pictures. (Long +2 H +4)\n";
                break;
            case "FOG":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
                wToFile = tmp + "I can't see anything! (H -3)\n";
                break;
            case "SNOW":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
                wToFile = tmp + "It's snowing out here. (H -15)\n";
                break;
        }

        weatherTower.writeToFile("write", wToFile);

        if (this.coordinates.getHeight() <= 0) {
            wToFileUnreg = "Tower says: Baloon#" + this.name + "(" + this.id + ") unregistered from weather tower.\n";
            weatherTower.writeToFile("write", wToFileUnreg);
            weatherTower.unregister(this);
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        this.weatherTower = weatherTower;
        weatherTower.register(this);
        String write = "Tower says: Baloon#" + this.name + "(" + this.id + ") registered to weather tower.\n";
        weatherTower.writeToFile("write", write);
    }

}