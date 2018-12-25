package mbortnic.Aircrafts;

import mbortnic.Interface.Flyable;
import mbortnic.Weather.WeatherTower;

public class JetPlane extends Aircraft implements Flyable {

    private WeatherTower weatherTower;

    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    public void updateConditions() {
        String weatherTmp = weatherTower.getWeather(this.coordinates);
        String wToFile = "";
        String wToFileUnreg = "";
        String tmp = "JetPlane#" + this.name + "(" + this.id + "): ";

        switch (weatherTmp) {
            case "RAIN":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 5, coordinates.getHeight());
                wToFile = tmp + "It's raining. Better watch out for lightnings.\n";
                break;
            case "SUN":
                coordinates = new Coordinates(coordinates.getLongitude() + 10, coordinates.getLatitude(), coordinates.getHeight() + 2);
                wToFile = tmp + "Some sun light, lets take some pictures.\n";
                break;
            case "FOG":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude() + 1, coordinates.getHeight());
                wToFile = tmp + "I can't see anything!\n";
                break;
            case "SNOW":
                coordinates = new Coordinates(coordinates.getLongitude(), coordinates.getLatitude(), coordinates.getHeight() - 7);
                wToFile = tmp + "It's snowing out here.\n";
                break;
        }

        weatherTower.writeToFile("write", wToFile);

        if (this.coordinates.getHeight() <= 0) {
            wToFileUnreg = "Tower says: JetPlane#" + this.name + "(" + this.id + ") unregistered from weather tower.\n";
            weatherTower.writeToFile("write", wToFileUnreg);
            weatherTower.unregister(this);
        }
    }

    public void registerTower(WeatherTower weatherTower) {
        weatherTower.register(this);
        String write = "Tower says: JetPlane#" + this.name + "(" + this.id + ") registered to weather tower.\n";
        this.weatherTower = weatherTower;
        weatherTower.writeToFile("write", write);
    }

}