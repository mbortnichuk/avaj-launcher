package mbortnic.Tower;

import mbortnic.Interface.Flyable;
import java.util.ArrayList;
import java.io.*;
import java.util.*;

/*
** To observe all aircrafts registries and deregistries.
*/

public class Tower {

    // private properties
    private ArrayList<Flyable> observers = new ArrayList<>();
    private ArrayList<Flyable> unreg = new ArrayList<>();

    private FileWriter writer;
    private File file;

    // public File getFile() {
    //     return this.file;
    // }

    // public methods
    public void register(Flyable flyable) {
        // try {
        //     observers.add(flyable);
        // } catch (Exception exception) {
        //     System.out.println("Failed to register and Aircraft.");
        // }

        if (observers.contains(flyable))
            return;
        observers.add(flyable);
    }

    public void unregister(Flyable flyable) {
        // try {
        //     observers.remove(flyable);
        // } catch (Exception exception) {
        //     System.out.println("Failed to unregister an Aircraft.");
        // }

        if (unreg.contains(flyable))
            return;
        unreg.add(flyable);
    }

    public void conditionsChanged() {
        for (Flyable flyable : observers)
            flyable.updateConditions();
        observers.removeAll(unreg);
    }

    public void writeToFile(String state, String text) {
        try {
            this.file = new File("simulation.txt");
            this.writer = new FileWriter(file, true);
            this.file.createNewFile();

            switch (state) {
                case "write":
                    try {
                        writer.write(text);
                        writer.flush();
                    } catch (Exception e) {
                        System.out.println((char)27 + "[31mCouldn't write to file." + (char)27 + "[0m");
                        }
                    break ;
            }
        } catch (Exception e) {
        }
    }

}