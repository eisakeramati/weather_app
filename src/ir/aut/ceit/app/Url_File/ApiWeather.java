package ir.aut.ceit.app.Url_File;

/**
 * Created by lenovo pc on 4/10/2017.
 */

/**
 * the apiweather class is designed to create the correct api form of the openweathermap site and return it
 * accordingg to the kind that the user wants the number of days and etc are given latter by the scanner
 * class there are 6 different methods in the class
 */
public class ApiWeather {
    public ApiWeather() {
    }

    /**
     * this method is used for the normal current weahter status by having the city's name
     * @param string is the name of the city given by the user by the scanner class
     * @return the correct api form of currentweather status of the city
     */
    public String CurrentApiMaker(String string) {
        return "http://api.openweathermap.org/data/2.5/weather?q=" + string + "&appid=d2e7fe3e669b2d293c9ab512ab7e5550";
    }

    /**
     * this method is used for the normal forecasted weahter status by having the city's name
     * @param string is the name of the city given by the user by the scanner class
     * @param num is the number of days user want to be forecasted scanner class
     * @return the correct api form of forecastedweather status of the city
     */
    public String ForecastApiMaker(String string, int num) {
        return "http://api.openweathermap.org/data/2.5/forecast?q=" + string + "&cnt=" + Integer.toString(num) + "&appid=d2e7fe3e669b2d293c9ab512ab7e5550";
    }

    /**
     * this method is used for the normal current weahter status by having the city's name
     * @param FirstNum is the number of lat of the coordinat given by the user scanner class
     * @param SecondNum  is the number of lon of the coordinat given by the user scanner class
     * @return the correct api form of currentweather status of the city
     */
    public String CurrentApiMakerCoordinates(Double FirstNum, Double SecondNum) {
        return "http://api.openweathermap.org/data/2.5/weather?lat=" + Double.toString(FirstNum) + "&lon=" + Double.toString(SecondNum) + "&appid=d2e7fe3e669b2d293c9ab512ab7e5550";
    }

    /**
     * this method is used for the normal current weahter status by having the city's id
     * @param CityId is the city's id given by the user scanner class
     * @return the correct api form of currentweather status of the city
     */
    public String CurrentApiMakerCityId(int CityId) {
        return "http://api.openweathermap.org/data/2.5/weather?id=" + Integer.toString(CityId) + "&appid=d2e7fe3e669b2d293c9ab512ab7e5550";
    }

    /**
     * this method is used to for creating the forecastedweather api with the city's coordinates
     * @param FirstNum is the number of lat of the coordinat given by the user scanner class
     * @param SecondNum is the number of lon of the coordinat given by the user scanner class
     * @param num is the number of days user want to be forecasted scanner class
     * @return the correct api form of forecastedweather status of the city
     */
    public String ForecastApiMakerCoordinates(Double FirstNum, Double SecondNum, int num) {
        return "http://api.openweathermap.org/data/2.5/forecast/daily?lat=" + Double.toString(FirstNum) + "&lon=" + Double.toString(SecondNum) + "&cnt=" + Integer.toString(num) + "&appid=d2e7fe3e669b2d293c9ab512ab7e5550";
    }

    /**
     * this method is used to for creating the forecastedweather api with the city's id
     * @param CityId is the city's id given by the user scanner class
     * @param num is the number of days user want to be forecasted scanner class
     * @return the correct api form of forecastedweather status of the city
     */
    public String ForecastApiMakerCityId(int CityId, int num) {
        return "http://api.openweathermap.org/data/2.5/forecast/daily?id=" + Integer.toString(CityId) + "&cnt=" + Integer.toString(num) + "&appid=d2e7fe3e669b2d293c9ab512ab7e5550";
    }


}
