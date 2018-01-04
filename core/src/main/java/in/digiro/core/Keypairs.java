package in.digiro.core;

/**
 * Created by corechain on 04/01/18.
 */
import android.util.Log;

import org.bitcoinj.core.Address;
import org.bitcoinj.core.ECKey;
import org.bitcoinj.core.NetworkParameters;

import java.math.BigInteger;

public class Keypairs {
    private String pub_key;
    private String priv_key;

    String getPubKey (){
        return pub_key;
    }

    String getPrivateKey (){
        return priv_key;
    }

    public Keypairs(String privateKey,String pubKey){
        this.priv_key = privateKey;
        this.pub_key = pubKey;
    }

    public Keypairs(){
        ECKey _eckey = new ECKey();
        this.priv_key = _eckey.getPrivateKeyAsHex();
        Address _address = _eckey.toAddress(NetworkParameters.prodNet());
        this.pub_key = _address.toString();
        Log.i("CORE", String.format("Generate new keypairs %s:%s", getPrivateKey(),getPubKey()));
    }

    public String toWIF(){
        return "";
    }

    public static Keypairs fromWIF(String WIF){
        return new Keypairs("","");
    }

    public static Keypairs fromHex(String hex){
        ECKey _eckey = ECKey.fromPrivate(new BigInteger(hex, 16));
        return new Keypairs(_eckey.getPrivateKeyAsHex(),
                _eckey.toAddress(NetworkParameters.prodNet()).toString());
    }
}
