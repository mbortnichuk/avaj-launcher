package mbortnic.Simulator;

import mbortnic.Interface.Flyable;
import mbortnic.Aircrafts.AircraftFactory;
import mbortnic.Weather.WeatherTower;

import java.util.*;
import java.io.*;

public class Simulator {

    private static WeatherTower weatherTower;
    private static List<Flyable> flyableList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        try {
            File file = new File("mbortnic/avaj/src/scenario.txt");

            BufferedReader reader = new BufferedReader(args[0]);
            String str = reader.readLine();

            if (str != null) {
                weatherTower = new WeatherTower();
                int simulation = Integer.parseInt(str.split(" ") [0]);

                if (simulation < 0) {
                    System.out.println("Simulation counter can't be 0 or less than 0.");
                    System.exit(1);
                }

                while ((str = reader.readLine()) != null) {
                    String[] array = str.split(" ");
                    
                    if (array.length == 5) {
                        Flyable flyable = AircraftFactory.newAircraft(str.split(" ")[0], str.split(" ")[1], Integer.parseInt(str.split(" ")[2]), 
                            Integer.parseInt(str.split(" ")[3]), Integer.parseInt(str.split(" ")[4]));
                        flyableList.add(flyable);
                    } else {
                        System.out.println("Invalid file format.");
                    }
                }

                for (Flyable flyable : flyableList) {
                    flyable.registerTower(weatherTower);
                }

                for (int i = 1; i <= simulation; i++) {
                    String simulationWrite = "Simulation: " + i + "\n";
                    weatherTower.writeToFile("write", simulationWrite);
                    weatherTower.changeWeather();
                }
            }
        } catch (FileNotFoundException exception) {
            System.out.println("File not found " + args[0]);
        } catch (IOException exception) {
            System.out.println("Error while reading file" + args[0]);
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println("File specification error.");
        } catch (Exception exception) {
            System.out.println("Unknown symbols in file" + e);
        }

        // mbortnic.Aircrafts.Coordinates coords = new mbortnic.Aircrafts.Coordinates(16, 17, 50);


    }

}
