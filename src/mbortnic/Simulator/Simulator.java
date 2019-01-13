package mbortnic.Simulator;

import mbortnic.Interface.Flyable;
import mbortnic.Aircrafts.AircraftFactory;
import mbortnic.Weather.WeatherTower;

import java.util.*;
import java.io.*;

public class Simulator {

    // private properties
    private static WeatherTower weatherTower;
    private static List<Flyable> aircraftList = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        
        try {
            // File file = new File("mbortnic/avaj/src/scenario.txt");

            if (args.length > 1) {
                System.out.println((char)27 + "[31mUse only one scenario file as program agrument." + (char)27 + "[0m");
                System.exit(1);
            }

            BufferedReader reader = new BufferedReader(new FileReader(args[0]));
            String str = reader.readLine();

            if (str != null) {
                weatherTower = new WeatherTower();
                int sim = Integer.parseInt(str.split(" ")[0]);

                if (sim <= 0) {
                    System.out.println((char)27 + "[33mSimulation counter can't be 0 or less than 0." + (char)27 + "[0m");
                    System.exit(1);
                }

                while ((str = reader.readLine()) != null) {
                    String[] params = str.split(" ");
                    
                    if (params.length == 5) {
                        Flyable flyable = AircraftFactory.newAircraft(
                            str.split(" ")[0], 
                            str.split(" ")[1], 
                            Integer.parseInt(str.split(" ")[2]), 
                            Integer.parseInt(str.split(" ")[3]), 
                            Integer.parseInt(str.split(" ")[4]));
                        aircraftList.add(flyable);
                    } else {
                        System.out.println((char)27 + "[33mEach line of the file, except the first one, should look like this:\n[TYPE NAME LONGITUDE LATITUDE HEIGHT]" + (char)27 + "[0m");
                        System.exit(1);
                    }
                }

                for (Flyable flyable : aircraftList) {
                    flyable.registerTower(weatherTower);
                }

                for (int i = 1; i <= sim; i++) {
                    String simToWrite = "\nSimulation: " + i + "\n";
                    weatherTower.writeToFile("write", simToWrite);
                    weatherTower.changeWeather();
                }
                reader.close();
            }
        } catch (FileNotFoundException exception) {
            System.out.println((char)27 + "[31mFile not found " + "<" + args[0] + ">" + (char)27 + "[0m");
        } catch (IOException exception) {
            System.out.println((char)27 + "[31mError while reading file " + args[0] + (char)27 + "[0m");
        } catch (ArrayIndexOutOfBoundsException exception) {
            System.out.println((char)27 + "[31mSpecify scenario file." + (char)27 + "[0m");
            System.out.println((char)27 + "[33mUsage: java mbortnic.Simulator.Simulator [filename]" + (char)27 + "[0m");
        } catch (Exception exception) {
            System.out.println((char)27 + "[31mUnknown symbols in file " + "<" + exception + ">" + (char)27 + "[0m");
        }
       
        // mbortnic.Aircrafts.Coordinates coords = new mbortnic.Aircrafts.Coordinates(16, 17, 50);
        // mbortnic.Aircrafts.Helicopter.Aircraft craft = new mborntic.Aircrafts.Helicopter.Aircraft("Heli", coords);

    }

}
