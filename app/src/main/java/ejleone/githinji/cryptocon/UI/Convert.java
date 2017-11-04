package ejleone.githinji.cryptocon.UI;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.ScrollingTabContainerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ejleone.githinji.cryptocon.Adapter.CryptoAdapter;
import ejleone.githinji.cryptocon.Model.Crypto;
import ejleone.githinji.cryptocon.R;

public class Convert extends AppCompatActivity {

    @BindView(R.id.tery_view)
    TextView des;


    @BindView(R.id.textview_result)
    TextView result;

    @BindView(R.id.input_conveditext)
    TextInputEditText dftg ;

    @BindView(R.id.currency_chosen)
    AppCompatSpinner deswq ;

    String Cho_currency ;
    String Amount ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);
        ButterKnife.bind(this);

        Bundle swaq = getIntent().getBundleExtra("bun");

        Bundle sqaaz  = getIntent().getBundleExtra("conversions");

        Log.e("Bundles",sqaaz.toString()+ swaq.toString());

        String name  = swaq.getString("name");
        String Id  = swaq.getString("id");
        String Cname  = swaq.getString("cname");
        String Symbol  = swaq.getString("symbol");
        String usdprice  = swaq.getString("usdprice");



       final String p1;

        if(sqaaz.getString(CryptoAdapter.Australiandollar) !=null){
            p1 = sqaaz.getString(CryptoAdapter.Australiandollar);
        }
        else {
             p1 = "0.00";
        }
        final String p2 = sqaaz.getString(CryptoAdapter.britishpound);
        final String p3 = sqaaz.getString(CryptoAdapter.CentralAfricanCFAfranc);
        final String p4 = sqaaz.getString(CryptoAdapter.ChineseYuan);
        final String p5 = sqaaz.getString(CryptoAdapter.Danishkrone);
        final String p6 = sqaaz.getString(CryptoAdapter.EgyptianPound);
        final String p7 = sqaaz.getString(CryptoAdapter.Ethiopianbirr);
        final String p8 = sqaaz.getString(CryptoAdapter.Euro);
        final String p9 = sqaaz.getString(CryptoAdapter.IndianRupee);
        final String p10 = sqaaz.getString(CryptoAdapter.Iranianrial);
        final  String p11 = sqaaz.getString(CryptoAdapter.Jamaicandollar);
        final  String p12 = sqaaz.getString(CryptoAdapter.Japaneseyen);
        final String p13 = sqaaz.getString(CryptoAdapter.KenyanShilling);
        final String p14 = sqaaz.getString(CryptoAdapter.Malaysianringgit);
        final String p15 = sqaaz.getString(CryptoAdapter.NigerianNaira);
        final String p16 = sqaaz.getString(CryptoAdapter.Norwegiankrone);
        final String p17 = sqaaz.getString(CryptoAdapter.Pakistanirupee);
        final String p18 = sqaaz.getString(CryptoAdapter.RussianRubble);
        final String p19 = sqaaz.getString(CryptoAdapter.UAEdirham);
        final String p20 = sqaaz.getString(CryptoAdapter.UgandanShilling);

        String [] press = {CryptoAdapter.Australiandollar,CryptoAdapter.britishpound,CryptoAdapter.CentralAfricanCFAfranc,CryptoAdapter.CentralAfricanCFAfranc,CryptoAdapter.ChineseYuan,CryptoAdapter.Danishkrone,CryptoAdapter.EgyptianPound,CryptoAdapter.Ethiopianbirr,CryptoAdapter.Euro,CryptoAdapter.IndianRupee,CryptoAdapter.Iranianrial,CryptoAdapter.Jamaicandollar,CryptoAdapter.Japaneseyen,CryptoAdapter.KenyanShilling,CryptoAdapter.Malaysianringgit,CryptoAdapter.NigerianNaira,CryptoAdapter.Norwegiankrone,CryptoAdapter.Pakistanirupee,CryptoAdapter.RussianRubble,CryptoAdapter.UAEdirham,
                CryptoAdapter.UgandanShilling};
        Log.e("Destoy",name + Id + Cname  + Symbol + "usdprice" + usdprice);

        des.setText("Enter the amount of "+name +" you wish to convert");

        ArrayAdapter<String > dvvv = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,press);
        deswq.setAdapter(dvvv);

        dftg.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //Todo:Validation
                //change the number


            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

        deswq.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                int pos = adapterView.getSelectedItemPosition();
                switch (pos)
                {
                    case 0:
                        Cho_currency = p1;
                        break;
                    case 1:
                        Cho_currency = p2;
                        break;
                    case 2:
                        Cho_currency = p3;
                        break;
                    case 3:
                        Cho_currency = p4;
                        break;
                    case 4:
                        Cho_currency = p5;
                        break;
                        case 5:
                            Cho_currency = p6;
                    break;
                    case 6:
                        Cho_currency = p7;
                        break;
                    case 7:
                        Cho_currency = p8;
                        break;
                    case 8:
                        Cho_currency = p9;
                        break;
                    case 9:
                        Cho_currency = p10;
                        break;
                    case 10:
                        Cho_currency = p11;
                        break;
                    case 11:
                        Cho_currency = p12;
                        break;
                    case 12:
                        Cho_currency = p13;

                        break;
                    case 13:
                        Cho_currency = p14;
                        break;
                    case 14:
                        Cho_currency = p15;
                        break;

                    case 15:
                        Cho_currency = p16;
                        break;
                    case 16:
                        Cho_currency = p17;
                        break;
                    case 17:
                        Cho_currency = p18;
                        break;
                    case 18:
                        Cho_currency = p19;
                        break;
                    case 19:
                        Cho_currency = p20;
                        break;



                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    @OnClick(R.id.Converr)
    public void Convert (){
        String a = Cho_currency;
        String b = dftg.getText().toString();

        //Todo:Add Validation of the text
       //Convert to String
        float amount = Float.parseFloat(a);
        float curr = Float.parseFloat(b);

        Float e3w =  amount * curr;
        Log.e("Floaat", String.valueOf(e3w));

        //Set the Appropriate TextVIew

        result.setText(String.valueOf(e3w));
    }


}
