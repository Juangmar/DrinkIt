package koldur.losversados.dao;

/**
 * Created by Juan on 10/12/17.
 */

public class DAO_Factory {

    private static DAOContent instance;

    public static DAOContent getInstance(){
        if (instance == null){
            instance = new DAOContent_Imp();
        }
        return instance;
    }
}
