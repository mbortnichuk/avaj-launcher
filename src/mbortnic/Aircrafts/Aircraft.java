package mbortnic.Aircrafts;

/*
** To handle the whole simulation - aircrafts and weather.
*/

public class Aircraft {
    protected long id = 0l;
    protected String name;
    protected Coordinates coordinates;
    private static long idCounter = 0l;

    protected Aircraft(String name, Coordinates coordinates) {
        this.id = nextId();
        this.name = name;
        this.coordinates = coordinates;
    }

    protected Aircraft() {
        return ;
    }

    private long nextId() {
        this.idCounter += 1;
        return (this.idCounter);
        // return (++this.idCounter);
    }
}