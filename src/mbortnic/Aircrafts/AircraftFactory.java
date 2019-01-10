package mbortnic.Aircrafts;

import mbortnic.Interface.Flyable;

/*
** To handle aircraft factory.
*/

public class AircraftFactory {

    // public methods
    public static Flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Coordinates coords = new Coordinates(longitude, latitude, height);
        // Helicopter helicopter;
        // JetPlane jetPlane;
        // Baloon baloon;

        switch (type) {
            case "Helicopter":
                return new Helicopter(name, coords);

                // helicopter = new Helicopter(name, coords);
                // return helicopter;
            case "Baloon":
                return new Baloon(name, coords);

                // baloon = new Baloon(name, coords);
                // return baloon;
            case "JetPlane":
                return new JetPlane(name, coords);

                // jetPlane = new JetPlane(name, coords);
                // return jetPlane;
            default:
                System.out.println((char)27 + "[33mInvalid Aircraft Type." + (char)27 + "[0m");
                System.exit(1);
                return null;
        }
    }

}