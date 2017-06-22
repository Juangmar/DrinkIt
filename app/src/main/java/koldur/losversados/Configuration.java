package koldur.losversados;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

/**
 * Created by Juan on 22/6/17.
 */

public class Configuration extends AppCompatActivity {
    private HashMap<String, Boolean> conf = new HashMap<>();
     protected void onCreate(Bundle savedInstanceState) {
         procesarConfig(conf);

         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_configuration);

         CheckBox rHigh = (CheckBox) findViewById(R.id.RHigh);
         rHigh.setChecked(conf.get("rhigh"));
         CheckBox vHigh = (CheckBox) findViewById(R.id.VHigh);
         vHigh.setChecked(conf.get("vhigh"));
         CheckBox rMed = (CheckBox) findViewById(R.id.RMed);
         rMed.setChecked(conf.get("rmed"));
         CheckBox vMed = (CheckBox) findViewById(R.id.VMed);
         vMed.setChecked(conf.get("vmed"));
         CheckBox rLow = (CheckBox) findViewById(R.id.RLow);
         rLow.setChecked(conf.get("rlow"));
         CheckBox vLow = (CheckBox) findViewById(R.id.VLow);
         vLow.setChecked(conf.get("vlow"));
     }

     private void procesarConfig(HashMap<String, Boolean> conf){
         InputStream inputStream = null;
         String text;
         String[] lines;
         try{
             inputStream = this.getResources().openRawResource(R.raw.config);
             text = btoString(inputStream);
             lines = text.split("\n");
             for (int i = 0; i < lines.length; i++){
                 String linea[] = lines[i].split("=");
                 conf.put(linea[0],Boolean.parseBoolean(linea[1]));
             }
         }catch (IOException e){
             // FALTA POR DECLARAR QUÉ PASA SI NO SE PUEDE LEER
         } finally{
             try{
                 inputStream.close();
             }catch(IOException e){
                 // FALTA POR DECLARAR QUÉ PASA SI NO SE PUEDE LEER
             }
         }
     }
    public String btoString( InputStream inputStream ) throws IOException
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
