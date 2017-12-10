package koldur.losversados.dao;

import android.content.res.Resources;

import java.util.HashMap;

/**
 * Created by Juan on 10/12/17.
 */

public abstract class DAOContent {

    public abstract HashMap<Integer,String> getAllYoNunca(Resources androidResources);

    public abstract HashMap<Integer,String> getHighDare(Resources androidResources, Boolean getExplicit);

    public abstract void addHighDare(Resources resources, HashMap<Integer,String> list, Integer length, Boolean getExplicit);

    public abstract HashMap<Integer,String> getHighTruth(Resources androidResources);

    public abstract void addHighTruth(Resources androidResources, HashMap<Integer,String> list, Integer length);

}
