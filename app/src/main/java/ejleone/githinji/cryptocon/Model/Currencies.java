package ejleone.githinji.cryptocon.Model;

/**
 * Created by Ej on 10/24/17.
 */

public class Currencies
{
    private String name;
    private String code;


    public Currencies(String name, String code) {
        this.name = name;
        this.code = code;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
