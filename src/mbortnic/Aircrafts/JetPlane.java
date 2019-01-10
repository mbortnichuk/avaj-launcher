package mbortnic.Aircrafts;

import mbortnic.Interface.Flyable;
import mbortnic.Weather.WeatherTower;

/*
** To handle JetPlane aircraft.
*/

public class JetPlane extends Aircraft implements Flyable {

    // private properties
    private WeatherTower weatherTower;

    // private variables
    JetPlane(String name, Coordinates coordinates) {
        super(name, coordinates);
    }

    // public methods
    public void updateConditions() {
        String weatherType = weatherTower.getWeather(this.coordinates);
        String toFile = "";
        String toFileUnreg = "";
        String tmp = "JetPlane#" + this.name + "(" + this.id + "): ";

        switch (weatherType) {
            case "RAIN":
                coordinates = new Coordinates(
                    coordinates.getLongitude(), 
                    coordinates.getLatitude() + 5, 
                    coordinates.getHeight());
                toFile = tmp + "Watch out for lightnings!\n";
                break;
            case "SUN":
                coordinates = new Coordinates(
                    coordinates.getLongitude() + 10, 
                    coordinates.getLatitude(), 
                    coordinates.getHeight() + 2);
                toFile = tmp + "This sun is getting to my eyes!\n";
                break;
            case "FOG":
                coordinates = new Coordinates(
                    coordinates.getLongitude(), 
                    coordinates.getLatitude() + 1, 
                    coordinates.getHeight());
                toFile = tmp + "Gamn fog!\n";
                break;
            case "SNOW":
                coordinates = new Coordinates(
                    coordinates.getLongitude(), 
                    coordinates.getLatitude(), 
                    coordinates.getHeight() - 7);
                toFile = tmp + "We are going to freeze!\n";
                break;
        }

        weatherTower.writeToFile("write", toFile);

        if (this.coordinates.getHeight() <= 0) {
            toFileUnreg = "Tower says: JetPlane#" + this.name + "(" + this.id + ") unregistered from weather tower.\n";
            weatherTower.writeToFile("write", toFileUnreg);
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