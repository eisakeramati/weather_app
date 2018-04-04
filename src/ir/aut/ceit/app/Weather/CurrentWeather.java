package ir.aut.ceit.app.Weather;


import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by lenovo pc on 4/10/2017.
 */

/**
 * the class contains the methods used to decode the JSONformat that is given by the internet
 * streams and then the decoded part is organised and given out by the methods
 */
public class CurrentWeather extends BaseWeather {

    public CurrentWeather() {
    }

    /**
     * this method decodes the JSONformat and takes all the information needed manages them
     * then puts the parts in the right places but this method only does the job for
     * the current weather apis cause the forcasted and others have different format
     * @param JsonNotChangedYet is the not-yet-decoded string in JSON format given
     * by the data streams
     * @return the correct managed decoded normal string format of what we need
     */
    public String GetCurrentInfo(String JsonNotChangedYet) {
        JSONObject jsonObject = new JSONObject(JsonNotChangedYet);

        JSONObject jsonObjectCoordination = jsonObject.getJSONObject("coord");
        Double Lon = jsonObjectCoordination.getDouble("lon");
        Double Lat = jsonObjectCoordination.getDouble("lat");

        JSONArray jsonArrayWeather = jsonObject.getJSONArray("weather");
        String description;
        if (jsonArrayWeather.length() > 0) {
            JSONObject jsonObjectWeather = jsonArrayWeather.getJSONObject(0);
            description = jsonObjectWeather.getString("description");
        } else {
            description = "empty";
        }

        JSONObject jsonObjectMain = jsonObject.getJSONObject("main");
        Double humidity = jsonObjectMain.getDouble("humidity");

        JSONObject jsonObjectWind = jsonObject.getJSONObject("wind");
        Double resultSpeed = jsonObjectWind.getDouble("speed");
        Double resultDeg = jsonObjectWind.getDouble("deg");
        String wind = "speed: " + resultSpeed + "\tdeg: " + resultDeg;

        String name = jsonObject.getString("name");

        return name + "        " + humidity + "       " + description + "      " + wind + "         " + "lat:" + Lat + "\t" + "lon:" + Lon
                + "\n"+"==================================================================================================================";


    }
}
