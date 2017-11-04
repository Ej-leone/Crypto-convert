package ejleone.githinji.cryptocon.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.AuthFailureError;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.StringRequest;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import ejleone.githinji.cryptocon.Model.Crypto;
import ejleone.githinji.cryptocon.R;
import ejleone.githinji.cryptocon.UI.Convert;
import ejleone.githinji.cryptocon.Util.NetworkConstants;
import ejleone.githinji.cryptocon.Util.VolleySingleton;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Ej on 10/23/17.
 */

public class CryptoAdapter extends  RecyclerView.Adapter<CryptoAdapter.viewholder>
{
  public static   String   usdollar = "USD" ,
            ChineseYuan =  "CNY",
            Euro = "EUR" ,
            britishpound = "GBP",
            Japaneseyen="JP"  ,
            southkoreanWon= "KRW"   ,
            IndianRupee= "INR"   ,
            NigerianNaira   =  "NGN"  ,
            KenyanShilling = "KES"   ,
            UgandanShilling= "UGX"   ,
            UAEdirham   ="AED"   ,
            RussianRubble ="RUB"   ,

            CentralAfricanCFAfranc =  "XAF" 	,
            Danishkrone  = "DKK"   ,
            EgyptianPound = "EGP"   ,
            Ethiopianbirr    = "ETB"    ,
            Malaysianringgit = "MYR"   ,
            Australiandollar=   "AUD"    ,
            Norwegiankrone ="NOK"  ,
            Pakistanirupee="PKR"   ,
            Jamaicandollar="JMD"    ,
            Iranianrial = "IRR"    ;

    private ArrayList<Crypto>  cryptolist =new ArrayList<>();
    private LayoutInflater layoutInflater;
    private ImageLoader imageLoader;
    VolleySingleton volleySingleton;
    public Context ctx;
    public Bundle  budles = new Bundle();

    public CryptoAdapter(Context ctx) {
        layoutInflater= LayoutInflater.from(ctx);
        volleySingleton = VolleySingleton.getInstancia(ctx);
        imageLoader=volleySingleton.getImageLoader();
        this.ctx = ctx;
    }

    public void SetData (ArrayList<Crypto>  ds)
    {
        this.cryptolist =ds;
        notifyDataSetChanged();
    }


    public void removeAt(int position) {
        cryptolist.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, cryptolist.size());
    }

    @Override
    public viewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View  vie = layoutInflater.inflate(R.layout.crypto_card,parent,false);
        return new viewholder(vie);
    }

    @Override
    public void onBindViewHolder(final viewholder holder, int position) {
        YoYo.with(Techniques.FadeIn)
                .duration(700)
                .playOn(holder.itemView);


        final Crypto  fcrypto  = cryptolist.get(position);

        fcrypto.setCoinname("...");


                holder.title.setText(fcrypto.getName());

        String img_url = NetworkConstants.main_url + fcrypto.getImgurl();


        imageLoader.get(img_url, new ImageLoader.ImageListener() {
            @Override
            public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate)
            {
                holder.img.setImageBitmap(response.getBitmap());
            }

            @Override
            public void onErrorResponse(VolleyError error)
            {
                holder.img.setImageResource(android.R.drawable.stat_notify_error);
            }
        });





        OkHttpClient  teken =  new OkHttpClient();
        HttpUrl.Builder urlBuilder = HttpUrl.parse(NetworkConstants.price_coin_list).newBuilder();
        urlBuilder.addQueryParameter("fsym",fcrypto.getSymbol());
        urlBuilder.addQueryParameter("tsyms",usdollar +","+britishpound+","+CentralAfricanCFAfranc+","+ChineseYuan+","+Danishkrone+","+EgyptianPound+","+Ethiopianbirr+","+Euro+","+Jamaicandollar+","+Japaneseyen+","+Malaysianringgit+","+NigerianNaira+","+Norwegiankrone+","+Pakistanirupee+","+UAEdirham+","+UgandanShilling+","+southkoreanWon+","+IndianRupee+","+Iranianrial+","+KenyanShilling+","+RussianRubble+","+Australiandollar);

        String url = urlBuilder.build().toString();

        Request request = new Request.Builder()
                .url(url)
                .build();

        Log.e("Urrl",url);
        teken.newCall(request).enqueue(new Callback()
        {
            @Override
            public void onFailure(Call call, IOException e)
            {
                e.printStackTrace();
                call.cancel();
                Log.e("Error",e.getLocalizedMessage());
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException
            {
                if (!response.isSuccessful())
                {
                    Log.e("Error",response.protocol().toString());
                    throw new IOException("Unexpected code " + response);

                } else
                    {
                    // do something wih the result
                        Log.e("Response",response.body().toString());


                            try
                            {
                            String dddr =response.body().string();
                           JSONObject dd = new JSONObject(dddr);
                           String price = dd.getString("USD");
                                String p1 = dd.getString(Australiandollar);
                                String p2 = dd.getString(CentralAfricanCFAfranc);
                                String p3 = dd.getString(ChineseYuan);
                                String p4 = dd.getString(Danishkrone);
                                String p5 = dd.getString(EgyptianPound);
                                String p6 = dd.getString(Ethiopianbirr);
                                String p7 = dd.getString(Euro);
                                String p8 = dd.getString(IndianRupee);
                                String p9 = dd.getString(Iranianrial);
                                String p10 = dd.getString(Jamaicandollar);
                                String p11 = "0.01";
                                String p12 = dd.getString(KenyanShilling);
                                String p13 = dd.getString(Malaysianringgit);
                                String p14 = dd.getString(NigerianNaira);
                                String p15 = dd.getString(UAEdirham);
                                String p16 = dd.getString(southkoreanWon);
                                String p17 = dd.getString(Pakistanirupee);
                                String p18 = dd.getString(UgandanShilling);
                                String p19 = dd.getString(RussianRubble);
                                String p20 = dd.getString(britishpound);

                                budles.putString(usdollar,price);
                                budles.putString(Australiandollar,p1);
                                budles.putString(CentralAfricanCFAfranc,p2);
                                budles.putString(ChineseYuan,p3);
                                budles.putString(Danishkrone,p4);
                                budles.putString(EgyptianPound,p5);
                                budles.putString(Ethiopianbirr,p6);
                                budles.putString(Euro,p7);
                                budles.putString(IndianRupee,p8);
                                budles.putString(Iranianrial,p9);
                                budles.putString(Jamaicandollar,p10);
                                budles.putString(Japaneseyen,p11);
                                budles.putString(KenyanShilling,p12);
                                budles.putString(Malaysianringgit,p13);
                                budles.putString(NigerianNaira,p14);
                                budles.putString(UAEdirham,p15);
                                budles.putString(southkoreanWon,p16);
                                budles.putString(Pakistanirupee,p17);
                                budles.putString(UgandanShilling,p18);
                                budles.putString(RussianRubble,p19);
                                budles.putString(britishpound,p20);


                                fcrypto.setCoinname(price);

                               // Log.e("Trying to set adapter",price);
                         //  holder.subtitle.setText("123333");
                         //  holder.subtitle.setText(price);
                        }
                        catch (Exception kl){
                            kl.printStackTrace();
                        }
                }
            }
        } );

        holder.subtitle.setText(fcrypto.getCoinname());
        holder.cardclick.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent dwe = new Intent(ctx, Convert.class);
               // TOdo:Create a transition to the next activity
                Bundle aq = new Bundle();
                aq.putString("name",fcrypto.getName());
                aq.putString("id",fcrypto.getId());
                aq.putString("cname",fcrypto.getCoinname());
                aq.putString("symbol",fcrypto.getSymbol());
                aq.putString("usdprice",holder.subtitle.getText().toString());
                dwe.putExtra("bun",aq);
                dwe.putExtra("conversions",budles);
                ctx.startActivity(dwe);
                //Todo:test



            }
        });

    }

    @Override
    public int getItemCount() {
        return cryptolist.size();
    }

    static class viewholder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        ImageView img;
        TextView title;
        TextView subtitle;
        private CardView cardclick;


        public viewholder(View itemView) {
            super(itemView);

            cardclick = (CardView)itemView.findViewById(R.id.card_view);
            img = (ImageView) itemView.findViewById(R.id.img_view);
            title= (TextView) itemView.findViewById(R.id.crypto_name);
            subtitle=(TextView)itemView.findViewById(R.id.txt_price);




        }



        @Override
        public void onClick(View view) {

        }
    }



}
