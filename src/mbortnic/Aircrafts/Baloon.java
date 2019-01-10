package mbortnic.Aircrafts;

import mbortnic.Interface.Flyable;
import mbortnic.Weather.WeatherTower;
import java.util.Random;

/*
** To handle Baloon aircraft.
*/

public class Baloon extends Aircraft implements Flyable {

    // private properties
    private WeatherTower weatherTower;

    // private variables
    Baloon(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    // public mehods
    public void updateConditions() {
        String weatherType = weatherTower.getWeather(this.coordinates);
        String toFile = "";
        String toFileUnreg = "";
        String tmp = "Baloon#" + this.name + "(" + this.id + "): ";

        switch (weatherType) {
            case "RAIN":
                coordinates = new Coordinates(
                    coordinates.getLongitude(), 
                    coordinates.getLatitude(), 
                    coordinates.getHeight() - 5);
                toFile = tmp + "It's rain! It messed up my baloon!\n";
                break;
            case "SUN":
                coordinates = new Coordinates(
                    coordinates.getLongitude() + 2, 
                    coordinates.getLatitude(), 
                    coordinates.getHeight() + 4);
                toFile = tmp + "There is some sun, let's enjoy good weather!\n";
                break;
            case "FOG":
                coordinates = new Coordinates(
                    coordinates.getLongitude(), 
                    coordinates.getLatitude(), 
                    coordinates.getHeight() - 3);
                toFile = tmp + "I hate fog, I cannot see anything at all!\n";
                break;
            case "SNOW":
                coordinates = new Coordinates(
                    coordinates.getLongitude(), 
                    coordinates.getLatitude(), 
                    coordinates.getHeight() - 15);
                toFile = tmp + "It's snowing! We should be more careful!\n";
                break;
        }

        weatherTower.writeToFile("write", toFile);

        if (this.coordinates.getHeight() <= 0) {
            toFileUnreg = "Tower says: Baloon#" + this.name + "(" + this.id + ") unregistered from weather tower.\n";
            weatherTower.writeToFile("write", toFileUnreg);
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