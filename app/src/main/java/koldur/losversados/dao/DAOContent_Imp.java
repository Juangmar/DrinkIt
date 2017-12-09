package koldur.losversados.dao;

import android.content.res.Resources;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import koldur.losversados.R;

/**
 * Created by Juan on 10/12/17.
 */

public class DAOContent_Imp extends DAOContent {
    @Override
    public HashMap<Integer, String> getAllYoNunca(Resources resources) {
        HashMap<Integer, String> list = new HashMap<>(); // Resoult list is created
        InputStream inputStream = null; //Input stream is created
        String text; //Raw text variable is created
        String[] lines; //Subdivision for the text is created
        int last = 0; //Last line read (used for error control)

        try{
            inputStream = resources.openRawResource(R.raw.yonuncafile); //Input stream instanced for raw file that contains all the data
            text = byteToString(inputStream); //Internal function that reads all the file and returns it in string format
            lines = text.split("\n"); //Plain string divided by lines, represented by the regular expression "\n"

            for (int i = 0; i < lines.length; i++){ //loop to process every line of raw data
                last = i; //Update the line we are currently reading. If an error occurs, the troubling line is saved.
                String linea[] = lines[i].split(";"); //The raw line is formatted between ';' chars
                list.put(i,linea[1]); //Currently, the only important part of the line is the second one
            }

        }catch (IOException e){
            System.err.println("last " + last); //Just for debug. If an error occurs, the problematic line is shown in the console.
        } finally{
            try{
                inputStream.close(); //Either an error occurs or not, the inputStream must be closed
            }catch(IOException e){
                System.err.println("Error al cerrar"); //The closing exceptions must be controlled
            }
        }
        return list; //Finally, the list is returned (with as much entries as the system could load)
    }

    @Override
    public void addAllYoNunca(Resources resources, HashMap<Integer, String> list, Integer length) {

    }

    public String byteToString( InputStream inputStream ) throws IOException
    {
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        byte[] bytes = new byte[4096];
        int len = 0;
        while ( (len=inputStream.read(bytes))>0 )
        {
            b.write(bytes,0,len);
        }
        return new String( b.toByteArray(),"UTF8");
    }
}
