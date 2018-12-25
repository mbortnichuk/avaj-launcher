package mbortnic.Aircrafts;

import mbortnic.Interface.Flyable;

public class AircraftFactory {

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
                System.out.println("Invalid Aircraft Type.");
                return null;
        }
    }

}