package ejleone.githinji.cryptocon.Model;

/**
 * Created by Ej on 10/23/17.
 */

public class Crypto {

    String Id;
    String name;
    String Imgurl;
    String Symbol;
    String Coinname;

    public Crypto(String id, String name, String imgurl, String symbol, String coinname) {
        Id = id;
        this.name = name;
        Imgurl = imgurl;
        Symbol = symbol;
        Coinname = coinname;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgurl() {
        return Imgurl;
    }

    public void setImgurl(String imgurl) {
        Imgurl = imgurl;
    }

    public String getSymbol() {
        return Symbol;
    }

    public void setSymbol(String symbol) {
        Symbol = symbol;
    }

    public String getCoinname() {
        return Coinname;
    }

    public void setCoinname(String coinname) {
        Coinname = coinname;
    }
}
