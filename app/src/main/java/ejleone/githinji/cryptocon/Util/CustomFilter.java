package ejleone.githinji.cryptocon.Util;

import android.widget.Filter;

import java.util.ArrayList;

import ejleone.githinji.cryptocon.Adapter.DialogAdapter;
import ejleone.githinji.cryptocon.Model.Crypto;

/**
 * Created by Ej on 3/17/2016.
 */
public class CustomFilter extends Filter{

    DialogAdapter adapter;
    ArrayList<Crypto> filterList;


    public CustomFilter(ArrayList<Crypto> filterList,DialogAdapter adapter)
    {
        this.adapter=adapter;
        this.filterList=filterList;

    }

    //FILTERING OCCURS
    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results=new FilterResults();

        //CHECK CONSTRAINT VALIDITY
        if(constraint != null && constraint.length() > 0)
        {
            //CHANGE TO UPPER
            constraint=constraint.toString().toUpperCase();
            //STORE OUR FILTERED PLAYERS
            ArrayList<Crypto> filteredPlayers=new ArrayList<>();

            for (int i=0;i<filterList.size();i++)
            {
                //CHECK
                if(filterList.get(i).getName().toUpperCase().contains(constraint))
                {
                    //ADD PLAYER TO FILTERED PLAYERS
                    filteredPlayers.add(filterList.get(i));
                }
            }

            results.count=filteredPlayers.size();
            results.values=filteredPlayers;
        }else
        {
            results.count=filterList.size();
            results.values=filterList;

        }


        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {

       adapter.dester= (ArrayList<Crypto>) results.values;

        //REFRESH
        adapter.notifyDataSetChanged();
    }
}
