package mbortnic.Aircrafts;

/*
** To handle the whole simulation - aircrafts and weather.
*/

public class Aircraft {

    // protected properties
    protected long id = 0l;
    protected String name;
    protected Coordinates coordinates;

    // private properties
    private static long idCounter = 0l;

    // public constructors
    protected Aircraft(String name, Coordinates coordinates) {
        this.name = name;
        this.coordinates = coordinates;
        this.id = nextId();
    }

    // protected constructors
    // protected Aircraft() {
    //     return ;
    // }

    // private methods
    private long nextId() {
        this.idCounter += 1;
        return (this.idCounter);
    }

}