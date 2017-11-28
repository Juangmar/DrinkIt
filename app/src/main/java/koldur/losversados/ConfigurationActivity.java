package koldur.losversados;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import java.util.HashMap;
import android.widget.Button;
import android.widget.Toast;

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
         final CheckBox vhe = (CheckBox) findViewById(R.id.VHE);
         vhe.setChecked(conf.get("rhighexpl"));

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
                    conf.put("rhighexpl",vhe.isChecked());
                    updateConfig(conf);

                    Context context = getApplicationContext();
                    Toast toast = Toast.makeText(context, "Se ha guardado correctamente", Toast.LENGTH_SHORT);
                    toast.show();
                    finish();
                }
                else{
                    Context context = getApplicationContext();
                    Toast toast = Toast.makeText(context, "Debe al menos haber una casilla marcada en la sección 'El Dedo Acusador'. ", Toast.LENGTH_SHORT);
                    toast.show();

                }
             }
         });

     }
     private void updateConfig(HashMap<String, Boolean> conf){
         SharedPreferences sharedPref = this.getSharedPreferences(getString(R.string.DA_COnfiguration_file), Context.MODE_PRIVATE);
         SharedPreferences.Editor editor = sharedPref.edit();
         editor.putBoolean("rhigh",conf.get("rhigh"));
         editor.putBoolean("vhigh",conf.get("vhigh"));
         editor.putBoolean("rmed",conf.get("rmed"));
         editor.putBoolean("vmed",conf.get("vmed"));
         editor.putBoolean("rlow",conf.get("rlow"));
         editor.putBoolean("vlow",conf.get("vlow"));
         editor.putBoolean("rhighexpl",conf.get("rhighexpl"));
         editor.commit();
     }


     private void procesarConfig(HashMap<String, Boolean> conf){
         SharedPreferences sh = getSharedPreferences(getString(R.string.DA_COnfiguration_file), Context.MODE_PRIVATE);
         conf.put("rhigh",sh.getBoolean("rhigh",false));
         conf.put("vhigh",sh.getBoolean("vhigh",false));
         conf.put("rmed",sh.getBoolean("rmed",false));
         conf.put("vmed",sh.getBoolean("vmed",false));
         conf.put("rlow",sh.getBoolean("rlow",false));
         conf.put("vlow",sh.getBoolean("vlow",false));
         conf.put("rhighexpl",sh.getBoolean("rhighexpl",false));
     }
}
