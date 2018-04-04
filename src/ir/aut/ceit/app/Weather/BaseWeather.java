package ir.aut.ceit.app.Weather;

/**
 * Created by lenovo pc on 4/10/2017.
 */

/**
 * this class does not have much until this point but it was created to have all the similar and common featueres
 * of the two other classes so that they could extend form this one
 */
public class BaseWeather {
    public BaseWeather() {
    }

    /**
     * this method returns the general form of the part that should be presented to the user
     * @return the general form string
     */
    public String GeneralForm() {
        return "==================================================================================================================" + "\n" +
                "city       humidity       description               wind                   coordination" + "\n" +
                "==================================================================================================================";

    }

    /**
     * this method returns the general form of the part that should be presented to the user
     * @return the general form string
     */
    public String Line() {
        return "==================================================================================================================";
    }


    /**
     * this method returns the general form of the part that should be presented to the user
     * @return the general form string
     */
    public String topGeneral() {
        return "city       humidity       description               wind                   coordination" + "\n";
    }

    /**
     * this method returns the general form of the part that should be presented to the user
     * @return the general form string
     */
    public String GeneralFormForId_Coord() {
        return "==================================================================================================================" + "\n" +
                "city       humidity       description               temprature                   coordination" + "\n" +
                "==================================================================================================================";

    }

}
