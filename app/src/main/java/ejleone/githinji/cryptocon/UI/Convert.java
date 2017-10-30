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
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import ejleone.githinji.cryptocon.Adapter.CryptoAdapter;
import ejleone.githinji.cryptocon.Model.Crypto;
import ejleone.githinji.cryptocon.R;

public class Convert extends AppCompatActivity {

    @BindView(R.id.tery_view)
    TextView des;


    @BindView(R.id.input_conveditext)
    TextInputEditText dftg ;

    @BindView(R.id.currency_chosen)
    AppCompatSpinner deswq ;

    String B ;
    String A ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_convert);
        ButterKnife.bind(this);

        Bundle swaq = getIntent().getBundleExtra("bun");

        Bundle sqaaz  = getIntent().getBundleExtra("conversions");



        String name  = swaq.getString("name");
        String Id  = swaq.getString("id");
        String Cname  = swaq.getString("cname");
        String Symbol  = swaq.getString("symbol");
        String usdprice  = swaq.getString("usdprice");


        String p1 = sqaaz.getString(CryptoAdapter.Australiandollar);
        String p2 = sqaaz.getString(CryptoAdapter.britishpound);
        String p3 = sqaaz.getString(CryptoAdapter.CentralAfricanCFAfranc);
        String p4 = sqaaz.getString(CryptoAdapter.ChineseYuan);
        String p5 = sqaaz.getString(CryptoAdapter.Danishkrone);
        String p6 = sqaaz.getString(CryptoAdapter.EgyptianPound);
        String p7 = sqaaz.getString(CryptoAdapter.Ethiopianbirr);
        String p8 = sqaaz.getString(CryptoAdapter.Euro);
        String p9 = sqaaz.getString(CryptoAdapter.IndianRupee);
        String p10 = sqaaz.getString(CryptoAdapter.Iranianrial);
        String p11 = sqaaz.getString(CryptoAdapter.Jamaicandollar);
        String p12 = sqaaz.getString(CryptoAdapter.Japaneseyen);
        String p13 = sqaaz.getString(CryptoAdapter.KenyanShilling);
        String p14 = sqaaz.getString(CryptoAdapter.Malaysianringgit);
        String p15 = sqaaz.getString(CryptoAdapter.NigerianNaira);
        String p16 = sqaaz.getString(CryptoAdapter.Norwegiankrone);
        String p17 = sqaaz.getString(CryptoAdapter.Pakistanirupee);
        String p18 = sqaaz.getString(CryptoAdapter.RussianRubble);
        String p19 = sqaaz.getString(CryptoAdapter.UAEdirham);
        String p20 = sqaaz.getString(CryptoAdapter.UgandanShilling);


        Log.e("Destoy",name + Id + Cname  + Symbol + "usdprice" + usdprice);

        des.setText("Enter the amount of "+name +" you wish to convert");



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
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    public float Convert (Float a  ,Float b){
        float ans =  a * b ;

        return  ans;
    }


}
