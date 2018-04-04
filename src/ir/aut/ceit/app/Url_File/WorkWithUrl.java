package ir.aut.ceit.app.Url_File;

import com.sun.org.apache.xerces.internal.util.URI;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by lenovo pc on 4/11/2017.
 */

/**
 * this class is created to deal with the issues of internet streams and data reading from
 * those streams
 */
public class WorkWithUrl {
    public WorkWithUrl() {
    }

    /**
     * this is the only method of the class which doeas the job of reading from the internet streams
     * so it catches an api address and does the resr of the job
     * @param api is the address given to it
     * @return the string which is actually in JSON format at first
     */
    public String GetFromUrl(String api) {
        String result = "";
        try {
            URL urlWeather = new URL(api);
            HttpURLConnection httpURLConnection = (HttpURLConnection) urlWeather.openConnection();

            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {

                InputStreamReader inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String lineRead = null;
                while ((lineRead = bufferedReader.readLine()) != null) {
                    result += lineRead;
                }
                bufferedReader.close();


            } else {
                System.out.println("Error in the network");
            }

        } catch (MalformedURLException ex)

        {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return result;


    }
}
