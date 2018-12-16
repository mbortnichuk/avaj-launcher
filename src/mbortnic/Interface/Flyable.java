package mbortnic.Interface;

import mborntic.Weather.WeatherTower;

/*
** To handle all the coordanates.
*/

public interface Flyable {
    public void updateConditions();

    public void registerTower(WeatherTower weatherTower);
}
