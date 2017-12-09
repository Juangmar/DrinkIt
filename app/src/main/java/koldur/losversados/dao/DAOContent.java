package koldur.losversados.dao;

import android.content.res.Resources;

import java.util.HashMap;

/**
 * Created by Juan on 10/12/17.
 */

public abstract class DAOContent {

    public abstract HashMap<Integer,String> getAllYoNunca(Resources androidResources);

    public abstract void addAllYoNunca(Resources androidResources, HashMap<Integer,String> list, Integer length);


}
