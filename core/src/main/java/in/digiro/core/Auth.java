package in.digiro.core;

/**
 * Created by corechain on 04/01/18.
 */

public class Auth {

    private static Auth _instance = null;

    private Auth(Keypairs keypairs){

    }

    public static Auth getInstance(Keypairs keypairs){
        if(_instance==null){
            _instance = new Auth(keypairs);
        }
        return _instance;
    }



}
