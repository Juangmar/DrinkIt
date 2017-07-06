package koldur.losversados.requests;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by Juan on 06/07/2017.
 */

public class ServerRequest extends StringRequest {
    private Map<String, String> params;
    private static final String SERVER_REQUEST_URL = "ftp://drinkitapp.esy.es/public_html/db/serverrequest.php";
    public ServerRequest(int id, Response.Listener<String> listener){
        super(Method.POST, SERVER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("ID",Integer.toString(id));
    }
    public Map<String,String> getParams(){return params;}
}
