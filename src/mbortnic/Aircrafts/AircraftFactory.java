package mbortnic.Aircrafts;

import mbortnic.Interface.Flyable;

/*
** To handle aircraft factory.
*/

public class AircraftFactory {

    // public methods
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Coordinates coords = new Coordinates(longitude, latitude, height);

        switch (type) {
            case "Helicopter":
                return new Helicopter(name, coords);
            case "Baloon":
                return new Baloon(name, coords);
            case "JetPlane":
                return new JetPlane(name, coords);
            default:
                System.out.println((char)27 + "[33mError: Invalid Aircraft Type." + (char)27 + "[0m");
                System.exit(1);
                return null;
        }
    }

}