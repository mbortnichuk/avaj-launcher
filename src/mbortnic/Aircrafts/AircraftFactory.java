package mbortnic.Aircrafts;

import mbortnic.Interface.Flyable;

/*
** To handle aircraft factory.
*/

public class AircraftFactory {

    // public methods
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Coordinates coords = new Coordinates(longitude, latitude, height);
        Helicopter helicopter;
        JetPlane jetPlane;
        Baloon baloon;

        switch (type) {
            case "Helicopter":
                helicopter = new Helicopter(name, coords);
                return helicopter;
            case "Baloon":
                baloon = new Baloon(name, coords);
                return baloon;
            case "JetPlane":
                jetPlane = new JetPlane(name, coords);
                return jetPlane;
            default:
                System.out.println((char)27 + "[33mInvalid Aircraft Type." + (char)27 + "[0m");
                return null;
        }
    }

}