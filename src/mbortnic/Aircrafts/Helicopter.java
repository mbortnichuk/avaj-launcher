package mbortnic.Aircrafts;

import mbortnic.Interface.Flyable;
import mbortnic.Weather.WeatherTower;
import mbortnic.Tower.Tower;

public class Helicopter extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weatherTmp = weatherTower.getWeather(this.coordinates);
        String wToFile = "";
        String wToFileUnreg = "";
        String tmp = "Helicopter#" + this.name + "(" + this.id + "): ";

        switch (weatherTmp) {
            case "RAIN":
                coordinates = new Coordinates(coordinates.getLongitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
                wToFile = tmp + "It's raining. Better watch out for lightnings. (Long +5)\n";
                break;
            case "SUN":
                coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), coordinates.getHeight() + 2);
                wToFile = tmp + "Some sun light, lets take some pictures. (Long +10 H +2)\n";
                break;
            case "FOG":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
                wToFile = tmp + "I can't see anything! (H -3)\n";
                break;
            case "SNOW":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 12);
                wToFile = tmp + "It's snowing out here. (H -12)\n";
                break;
        }

        weatherTower.writeToFile("write", wToFile);

        if (this.coordinates.getHeight() <= 0) {
            wToFileUnreg = "Tower says: Helicopter#" + this.name + "(" + this.id + ") unregistered from weather tower.\n";
            weatherTower.writeToFile("write", wToFileUnreg);
            weatherTower.unregister(this);
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
        String write = "Tower says: Helicopter#" + this.name + "(" + this.id + ") registered to weather tower.\n";
        this.weatherTower = weatherTower;
        weatherTower.writeToFile("write", write);
    }

}