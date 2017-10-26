package ejleone.githinji.cryptocon.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import java.util.ArrayList;

import ejleone.githinji.cryptocon.Model.Crypto;
import ejleone.githinji.cryptocon.R;
import ejleone.githinji.cryptocon.Util.CustomFilter;

/**
 * Created by Ej on 10/25/17.
 */

public class DialogAdapter extends RecyclerView.Adapter<DialogAdapter.viewholder> implements Filterable
{
    public ArrayList<Crypto> dester = new ArrayList<>();
    ArrayList<Crypto> filterList;
    public Context ctx;

    CustomFilter customfilter;

    private OnItemCheckListener onItemCheckListener;

    @Override
    public Filter getFilter()
    {
        if(customfilter==null)
        {
            customfilter=new CustomFilter(filterList,this);
        }

        return customfilter;

    }

    public interface OnItemCheckListener {
        void onchecked(Crypto item);

        void onunchecked(Crypto item);
      //void onasent( roll_call item);
    }

    public DialogAdapter(ArrayList<Crypto> dester, Context ctx, OnItemCheckListener onItemCheckListener) {
        this.dester = dester;
        this.filterList=dester;
        this.ctx = ctx;
        this.onItemCheckListener = onItemCheckListener;
    }

    @Override
    public viewholder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View  cdes  = LayoutInflater.from(ctx).inflate(R.layout.dialog_recycler,parent,false);

        return new viewholder(cdes);
    }

    @Override
    public void onBindViewHolder(final viewholder holder, int position)
    {
        final Crypto strbucks = dester.get(position);

        holder.textvww.setText(strbucks.getName());
        holder.cbb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                if(holder.cbb.isChecked())
                {
                    Log.e("unchecked",strbucks.getCoinname()+"has been checked add this");

                    //Todo:add check whether the  item is already
                    onItemCheckListener.onchecked(strbucks);



                }
                else if (!holder.cbb.isChecked())
                {
                    Log.e("unchecked",strbucks.getCoinname()+"has been unchecked has been unchecked remove");
                    onItemCheckListener.onunchecked(strbucks);
                }
            }
        });


    }

    @Override
    public int getItemCount() {
       // dester.size()== 0 ? return 0 : return dester.size();

        if (dester.size() == 0 )
        {
            return  0;
        }
        else
        {
            return dester.size();
        }
    }

    static class viewholder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        TextView textvww;
        CheckBox cbb ;

        public viewholder(View itemView) {
            super(itemView);

            textvww = itemView.findViewById(R.id.ctext_view);
            cbb = itemView.findViewById(R.id.dialog_cb);


        }


        @Override
        public void onClick(View view)
        {

        }
    }
}
