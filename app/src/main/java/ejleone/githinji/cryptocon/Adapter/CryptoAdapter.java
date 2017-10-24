package ejleone.githinji.cryptocon.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.ArrayList;

import ejleone.githinji.cryptocon.Model.Crypto;
import ejleone.githinji.cryptocon.R;
import ejleone.githinji.cryptocon.UI.Convert;
import ejleone.githinji.cryptocon.Util.NetworkConstants;
import ejleone.githinji.cryptocon.Util.VolleySingleton;

/**
 * Created by Ej on 10/23/17.
 */

public class CryptoAdapter extends  RecyclerView.Adapter<CryptoAdapter.viewholder>
{


    private ArrayList<Crypto>  cryptolist =new ArrayList<>();
    private LayoutInflater layoutInflater;
    private ImageLoader imageLoader;
    public Context ctx;


    public CryptoAdapter(Context ctx) {
        layoutInflater= LayoutInflater.from(ctx);
        VolleySingleton volleySingleton= VolleySingleton.getInstancia(ctx);
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
        YoYo.with(Techniques.Tada)
                .duration(700)
                .playOn(holder.itemView);


        final Crypto  fcrypto  = cryptolist.get(position);

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


        holder.cardclick.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent dwe = new Intent(ctx, Convert.class);
                Bundle aq = new Bundle();
                aq.putString("name",fcrypto.getName());
                aq.putString("id",fcrypto.getId());
                aq.putString("cname",fcrypto.getCoinname());
                aq.putString("symbol",fcrypto.getSymbol());
                dwe.putExtra("bun",aq);
                ctx.startActivity(dwe);

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
            img = (ImageView) itemView.findViewById(R.id.imgcasa);
            title= (TextView) itemView.findViewById(R.id.crypto_name);
            subtitle=(TextView)itemView.findViewById(R.id.txt_price);
        }


        @Override
        public void onClick(View view) {

        }
    }
}
