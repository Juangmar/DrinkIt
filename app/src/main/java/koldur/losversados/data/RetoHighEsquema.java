package koldur.losversados.data;

import android.provider.BaseColumns;

/**
 * Created by Juan on 26/03/2017.
 */

public class RetoHighEsquema {
    public static abstract class RetoHighEntry implements BaseColumns{
        public static final String TABLE_NAME="RetoHigh";

        public static final String ID = "id";
        public static final String NOMBRE = "nombre";
        public static final String DESCRIPCION = "desc4";
    }
}
