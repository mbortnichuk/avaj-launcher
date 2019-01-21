package mbortnic.Aircrafts;

/*
** To handle all coordinates.
*/

public class Coordinates {
    
    // private properties
    private int height;
    private int latitude;
    private int longitude;

    // default constructor
    Coordinates(int longitude, int latitude, int height) {
        if (height > 100)
            this.height = 100;
        else if (height < 0)
            this.height = 0;
        else
            this.height = height;
        
        if (latitude < 0)
            latitude = 0;
        
        if (longitude < 0)
            longitude = 0;

        this.longitude = longitude;
        this.latitude = latitude;
        return ;
    }

    // getters
    public int getHeight() {
        return this.height;
    }

    public int getLatitude() {
        return this.latitude;
    }

    public int getLongitude() {
        return this.longitude;
    }

}
