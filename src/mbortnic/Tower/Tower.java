package mbortnic.Tower;

import mbortnic.Interface.Flyable;
import java.util.ArrayList;
import java.io.*;
import java.util.*;

/*
** To observe all aircrafts registries and deregistries.
*/

public class Tower {

    private ArrayList<Flyable> observers = new ArrayList<>();
    private ArrayList<Flyable> unreg = new ArrayList<>();

    private File file;
    private FileWriter writer;

    public void register(Flyable flyable) {
        if (observers.contains(flyable))
            return ;
        observers.add(flyable);
    }

    public void unregiser(Flyable flyable) {
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
                    } catch (Exception exception) {System.out.println("Couldn't write to file");}
                    break ;
            }
        } catch (Exception e)
        {}
    }

}