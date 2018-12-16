package mbortnic.Aircrafts;

import mbortnic.Interface.Flyable;

public class AircraftFactory {

    public static flyable newAircraft(String type, String name, int longitude, int latitude, int height) {
        Coordinates coords = new Coordinated(longitude, latitude, height);
        Helicopter helicopter;
        JetPlane jetPlane;
        Baloon baloon;

        switch (type) {
            case "Helicopter":
                helicopter = new Helicopter(name, coords);
                return helicopter;
            case "Ballon":
                baloon = new Baloon(name, coords);
                return baloon;
            case "JetPlane":
                jetPlane = new JetPlane(name, coords);
                return jetPlane;
            default:
                return null;
        }
    }

}