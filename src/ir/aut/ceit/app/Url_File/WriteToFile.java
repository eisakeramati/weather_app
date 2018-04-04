package ir.aut.ceit.app.Url_File;

import java.io.*;
import java.util.List;

/**
 * Created by lenovo pc on 4/11/2017.
 */

/**
 * this class is made dor the job of writing in file , as a unmandatory option the user
 * can write the shown information in a file and this class is the only place having
 * all the means to that
 */
public class WriteToFile {
    public WriteToFile() {
    }

    /**
     * this method is made for writing in file
     *
     * @param string   is the corrected decoded JSON format which is ready to be written
     * @param location is the adress of the place to be written in
     */
    public void FileWriting(String string, String location) {
        try {

            String time = location;
            PrintWriter printWriter = new PrintWriter(time);
            BufferedWriter bufferedWriter = new BufferedWriter(printWriter);
            bufferedWriter.write("==================================================================================================================");
            bufferedWriter.write("\r\n");
            bufferedWriter.write("city       humidity       description               wind                   coordination");
            bufferedWriter.write("\r\n");
            bufferedWriter.write("==================================================================================================================");
            bufferedWriter.write("\r\n");
            String pure = string;
            int temp = pure.length() - pure.replace("\n", "").length();
            while (temp >= 0) {
                String ans = "";
                for (int i = 0; i < pure.indexOf("\n") + 1; i++) {
                    ans += pure.charAt(i);
                }
                bufferedWriter.write(ans);
                bufferedWriter.write("\r\n");
                pure = pure.replaceFirst(ans, "");
                temp--;
            }

            bufferedWriter.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

}
