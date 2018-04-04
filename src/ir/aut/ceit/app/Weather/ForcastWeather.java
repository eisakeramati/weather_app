package ir.aut.ceit.app.Weather;

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * Created by lenovo pc on 4/10/2017.
 */

/**
 * the class extends from the baseweather class which was introduced before and has only
 * one method that takes the JSON format code decodes it to what we want and are
 * looking for and then after managing it returns the normal string
 */
public class ForcastWeather extends BaseWeather {

    public ForcastWeather() {
    }

    /**
     * this method decodes the JSONformat and takes all the information needed manages them
     * then puts the parts in the right places but this method only does the job for
     * the forecasted weather apis cause the current and others have different format
     * @param JsonNotChangedYet is the not-yet-decoded string in JSON format given
     * by the data streams
     * @return the correct managed decoded normal string format of what we need
     */
    public String GetForecastInfoByName(String JsonNotChangedYet) {
        JSONObject jsonObject = new JSONObject(JsonNotChangedYet);
        int cnt = jsonObject.getInt("cnt");
        int temp = cnt;
        String result = "";
        JSONArray jsonArrayWeather = jsonObject.getJSONArray("list");
        if (jsonArrayWeather.length() > 0) {
            while (temp > 0) {

                JSONObject jsonObjectWeather = jsonArrayWeather.getJSONObject(temp - 1);
                JSONObject jsonObject1 = jsonObjectWeather.getJSONObject("main");
                Double humidity = jsonObject1.getDouble("humidity");
                JSONArray jsonArray = jsonObjectWeather.getJSONArray("weather");
                String description = null;
                if (jsonArray.length() > 0) {
                    JSONObject jsonObjectWeather1 = jsonArray.getJSONObject(0);
                    description = jsonObjectWeather1.getString("description");
                }
                JSONObject jsonObject2 = jsonObjectWeather.getJSONObject("wind");
                Double resultSpeed = jsonObject2.getDouble("speed");
                Double resultDeg = jsonObject2.getDouble("deg");
                String wind = "speed: " + resultSpeed + "\tdeg: " + resultDeg;

                JSONObject jsonObject3 = jsonObject.getJSONObject("city");
                String name = jsonObject3.getString("name");
                JSONObject jsonObject4 = jsonObject3.getJSONObject("coord");
                Double Lon = jsonObject4.getDouble("lon");
                Double Lat = jsonObject4.getDouble("lat");

                result += name + "        " + humidity + "       " + description + "      " + wind + "         " + "lat:" + Lat + "\t" + "lon:" + Lon
                        + "\n" + "==================================================================================================================" + "\n";
                temp--;

            }
        }
        return result;

    }

    public String GetForecastInfoById_Coord(String JsonNotChangedYet)
    {
        JSONObject jsonObject = new JSONObject(JsonNotChangedYet);
        JSONObject jsonObjectcity =jsonObject.getJSONObject("city");
        JSONObject jsonObjectcoord = jsonObjectcity.getJSONObject("coord");
        double lat = jsonObjectcoord.getDouble("lat");
        double lon = jsonObjectcoord.getDouble("lon");
        String city = jsonObjectcity.getString("name");
        int cnt = jsonObject.getInt("cnt");
        int temp = cnt;
        String result = "";
        JSONArray jsonArrayWeather = jsonObject.getJSONArray("list");
        if (jsonArrayWeather.length() > 0)
        {
            while (temp>0)
            {
                JSONObject jsonObjectWeather = jsonArrayWeather.getJSONObject(temp - 1);
                Double speed = jsonObjectWeather.getDouble("speed");
                Double degree = jsonObjectWeather.getDouble("deg");
                Double humidity = jsonObjectWeather.getDouble("humidity");
                JSONObject jsonObjectTemp = jsonObjectWeather.getJSONObject("temp");
                double maxTemp = jsonObjectTemp.getDouble("max");
                double minTemp = jsonObjectTemp.getDouble("min");
                JSONArray jsonArray = jsonObjectWeather.getJSONArray("weather");
                String description = null;
                if (jsonArray.length() > 0) {
                    JSONObject jsonObjectWeather1 = jsonArray.getJSONObject(0);
                    description = jsonObjectWeather1.getString("description");
                }

                result += city + "        " + humidity + "       " + description + "      " + "speed :"+speed+"  "+"degree :"+degree + "         " + "lat:" + lat + "\t" + "lon:" + lon
                        + "\n" + "==================================================================================================================" + "\n";
                temp--;
            }

        }

        return result;


    }

}
