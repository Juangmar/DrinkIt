package koldur.losversados;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import android.widget.Button;

/**
 * Created by Juan on 22/6/17.
 */

public class ConfigurationActivity extends AppCompatActivity {
    private HashMap<String, Boolean> conf = new HashMap<>();
    Button save;
     protected void onCreate(Bundle savedInstanceState) {
         procesarConfig(conf);

         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_configuration);

         final CheckBox rHigh = (CheckBox) findViewById(R.id.RHigh);
         rHigh.setChecked(conf.get("rhigh"));
         final CheckBox vHigh = (CheckBox) findViewById(R.id.VHigh);
         vHigh.setChecked(conf.get("vhigh"));
         final CheckBox rMed = (CheckBox) findViewById(R.id.RMed);
         rMed.setChecked(conf.get("rmed"));
         final CheckBox vMed = (CheckBox) findViewById(R.id.VMed);
         vMed.setChecked(conf.get("vmed"));
         final CheckBox rLow = (CheckBox) findViewById(R.id.RLow);
         rLow.setChecked(conf.get("rlow"));
         final CheckBox vLow = (CheckBox) findViewById(R.id.VLow);
         vLow.setChecked(conf.get("vlow"));
         save = (Button) findViewById(R.id.UpdateConfig);
         save.setOnClickListener(new View.OnClickListener(){
             @Override
             public void onClick(View v) {
                if(rHigh.isChecked()||vHigh.isChecked()||rMed.isChecked()||vMed.isChecked()||rLow.isChecked()||vLow.isChecked()){
                    conf = new HashMap<String, Boolean>();
                    conf.put("rhigh",rHigh.isChecked());
                    conf.put("vhigh",vHigh.isChecked());
                    conf.put("rmed",rMed.isChecked());
                    conf.put("vmed",vMed.isChecked());
                    conf.put("rlow",rLow.isChecked());
                    conf.put("vlow",vLow.isChecked());
                    updateConfig(conf);
                }
                else{

                }
             }
         });

     }
     private void updateConfig(HashMap<String, Boolean> conf){
         OutputStreamWriter outputStreamWriter;
             try {

                 outputStreamWriter = new OutputStreamWriter(this.openFileOutput("config.txt", this.MODE_PRIVATE));
                 outputStreamWriter.write("rhigh="+conf.get("rhigh"));
                 outputStreamWriter.write("rhigh="+conf.get("rhigh"));
                 outputStreamWriter.write("rhigh="+conf.get("rhigh"));
                 outputStreamWriter.close();
             }
             catch (IOException e) {
                //No se ha podido abrir el archivo
             }
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
