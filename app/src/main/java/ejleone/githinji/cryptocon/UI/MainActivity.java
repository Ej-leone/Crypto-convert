package ejleone.githinji.cryptocon.UI;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;

import butterknife.BindView;
import butterknife.ButterKnife;
import ejleone.githinji.cryptocon.Adapter.CryptoAdapter;
import ejleone.githinji.cryptocon.Adapter.DialogAdapter;
import ejleone.githinji.cryptocon.Model.Crypto;
import ejleone.githinji.cryptocon.R;
import ejleone.githinji.cryptocon.Util.NetworkConstants;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.recyclerview_crpt)
    RecyclerView des;

    CryptoAdapter assadpter;

    Context context;

    ArrayList<Crypto> All_cton = new ArrayList<>();
    ArrayList<Crypto> Chosen_cton = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        context = this;
        get_all();


        assadpter = new CryptoAdapter(this);
        des.setLayoutManager(new GridLayoutManager(this,2));
        des.setAdapter(assadpter);
        assadpter.SetData(Chosen_cton);



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                    dialog_sedo();

               // Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                 //       .setAction("Action", null).show();
            }
        });
    }


    public void get_all ()
    {
        JsonObjectRequest uui = new JsonObjectRequest(Request.Method.GET, NetworkConstants.coin_list, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.e("Response", response.toString());

                        try
                        {   String  success  = response.getString("Response");


                            if (success.contains("Success"))
                            {
                                JSONObject wesde = response.getJSONObject("Data");
                                Iterator<?> keys = wesde.keys();

                                while (keys.hasNext())
                                {
                                    String key = (String)keys.next();

                                    if(wesde.get(key) instanceof JSONObject)
                                    {
                                        Log.e("information", wesde.get(key).toString());

                                    }

                                }
                            }


                        }
                        catch (Exception ty)
                        {
                            ty.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error)
            {
                Log.e("Error",error.toString());

            }
        });

        RequestQueue dess= Volley.newRequestQueue(this);
        dess.add(uui);
    }


    public void dialog_sedo ()
    {
        Dialog dialog = new Dialog(context, R.style.DialogSlideAnim);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setContentView(R.layout.dialog_layout);
        dialog.setCanceledOnTouchOutside(true);
        dialog.setCancelable(false);
        dialog.show();


        TextInputEditText seedtext = dialog.findViewById(R.id.search_edittext);


        RecyclerView rvTest = (RecyclerView) dialog.findViewById(R.id.dialog_recycler);
        rvTest.setHasFixedSize(true);
        rvTest.setLayoutManager(new LinearLayoutManager(context));

        //Todo:add item decorator later
        //rvTest.addItemDecoration(new  (context, android.R.drawable.divider_horizontal_dark));
        final DialogAdapter desttt = new DialogAdapter( All_cton,context, new DialogAdapter.OnItemCheckListener()
        {
            @Override
            public void onchecked(Crypto item)
            {
             //Todo:Check if Exist the add to   Arraylist
                Chosen_cton.add(item);

            }

            @Override
            public void onunchecked(Crypto item)
            {
             Boolean des =   Chosen_cton.remove(item);
             Log.e(item.getCoinname()+"has been removed?:", des.toString());

            }
        });
        rvTest.setAdapter(desttt);

        seedtext.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable)
            {
                String des = editable.toString();

                desttt.getFilter().filter(des);

            }
        });
    }

}
