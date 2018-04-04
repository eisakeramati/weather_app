package ir.aut.ceit.app;

import ir.aut.ceit.app.Url_File.ApiWeather;
import ir.aut.ceit.app.Url_File.WorkWithUrl;
import ir.aut.ceit.app.Url_File.WriteToFile;
import ir.aut.ceit.app.Weather.BaseWeather;
import ir.aut.ceit.app.Weather.CurrentWeather;
import ir.aut.ceit.app.Weather.ForcastWeather;


import java.util.Date;
import java.util.Scanner;


public class Main {


    /**
     * this is the main method creates a menu for the user and a guide to get the info the user wants by
     * respoding by the scanner class has the ability to forecast and give the current weather in
     * different types of arguments and can save the info in separate directories
     * @param args
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ApiWeather apiWeather = new ApiWeather();
        CurrentWeather currentWeather = new CurrentWeather();
        BaseWeather baseWeather = new BaseWeather();
        ForcastWeather forcastWeather = new ForcastWeather();
        WriteToFile writeToFile = new WriteToFile();
        WorkWithUrl url = new WorkWithUrl();
        String st = "";
        String cityName = "";
        int cityId = 0;
        Double lat = 0.00;
        Double lon = 0.00;
        int day = 0;
        String forSave = "";
        while (!st.equals("stop")) {

            System.out.println("Enter one of the numbers according to your demand :     (1):current weather by city name   (2):current weather by city ID   (3):current weather by city's coordination   (4):forecasted weather by city name   (5):forecasted weather by city ID   (6):forecasted weather by city's coordination ");
            int temp = scanner.nextInt();
            scanner.nextLine();
            if (temp == 1) {
                System.out.println("Enter the name of the city :");
                cityName = scanner.nextLine();
                System.out.println(baseWeather.GeneralForm());
                System.out.println(currentWeather.GetCurrentInfo(url.GetFromUrl(apiWeather.CurrentApiMaker(cityName))));
                //System.out.println(baseWeather.Line());
                forSave = currentWeather.GetCurrentInfo(url.GetFromUrl(apiWeather.CurrentApiMaker(cityName)));
            } else if (temp == 2) {
                System.out.println("Enter the ID of the city :");
                cityId = scanner.nextInt();
                scanner.nextLine();
                System.out.println(baseWeather.GeneralForm());
                System.out.println(currentWeather.GetCurrentInfo(url.GetFromUrl(apiWeather.CurrentApiMakerCityId(cityId))));
               // System.out.println(baseWeather.Line());
                forSave = currentWeather.GetCurrentInfo(url.GetFromUrl(apiWeather.CurrentApiMakerCityId(cityId)));
            } else if (temp == 3) {
                System.out.println("Enter the coordinates of the city (first lat second lon):");
                lat = scanner.nextDouble();
                scanner.nextLine();
                lon = scanner.nextDouble();
                scanner.nextLine();
                System.out.println(baseWeather.GeneralForm());
                System.out.println(currentWeather.GetCurrentInfo(url.GetFromUrl(apiWeather.CurrentApiMakerCoordinates(lat, lon))));
               // System.out.println(baseWeather.Line());
                forSave = currentWeather.GetCurrentInfo(url.GetFromUrl(apiWeather.CurrentApiMakerCoordinates(lat, lon)));
            } else if (temp == 4) {
                System.out.println("Enter the city name :");
                cityName = scanner.nextLine();
                System.out.println("Enter the number of days you want to be forecasted :");
                day = scanner.nextInt();
                if (day < 5)
                    day = 5;
                if (day > 16)
                    day = 16;
                scanner.nextLine();
                System.out.println(baseWeather.GeneralForm());

                System.out.println(forcastWeather.GetForecastInfoByName(url.GetFromUrl(apiWeather.ForecastApiMaker(cityName, day))));
                forSave = forcastWeather.GetForecastInfoByName(url.GetFromUrl(apiWeather.ForecastApiMaker(cityName, day)));
            } else if (temp == 5) {
                System.out.println("Enter the city ID :");
                cityId = scanner.nextInt();
                System.out.println("Enter the number of days you want to be forecasted :");
                day = scanner.nextInt();
                if (day < 5)
                    day = 5;
                if (day > 16)
                    day = 16;
                scanner.nextLine();
                System.out.println(baseWeather.GeneralForm());
                System.out.println(forcastWeather.GetForecastInfoById_Coord(url.GetFromUrl(apiWeather.ForecastApiMakerCityId(cityId, day))));
                forSave = forcastWeather.GetForecastInfoById_Coord(url.GetFromUrl(apiWeather.ForecastApiMakerCityId(cityId, day)));
            } else if (temp == 6) {
                System.out.println("Enter the city coordinations (first lat , second lon):");
                lat = scanner.nextDouble();
                lon = scanner.nextDouble();
                System.out.println("Enter the number of days you want to be forecasted :");
                day = scanner.nextInt();
                if (day < 5)
                    day = 5;
                if (day > 16)
                    day = 16;
                scanner.nextLine();
                System.out.println(baseWeather.GeneralForm());
                System.out.println(forcastWeather.GetForecastInfoById_Coord(url.GetFromUrl(apiWeather.ForecastApiMakerCoordinates(lat, lon, day))));
                forSave = forcastWeather.GetForecastInfoById_Coord(url.GetFromUrl(apiWeather.ForecastApiMakerCoordinates(lat, lon, day)));
            }


            char makeSure;
            System.out.println("Do you want to save the current weather information ? (Y/N) ");
            makeSure = scanner.next().charAt(0);
            scanner.nextLine();
            Date date= new Date();
            String fileName= date.toString();
            fileName = fileName.replace(":",".");
            if (makeSure == 'Y' || makeSure == 'y') {
                if (temp == 1 || temp == 2 || temp == 3)
                    writeToFile.FileWriting(forSave, "C:\\WeatherApp\\Current\\" +fileName+ ".txt");
                else
                    writeToFile.FileWriting(forSave, "C:\\WeatherApp\\Forecast\\" + fileName + ".txt");
            }


            System.out.println("If you want to proceed type 'proceed' if not type 'stop' :");
            st = scanner.nextLine();


        }

    }
}
