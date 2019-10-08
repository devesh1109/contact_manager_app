package com.example.devesh1.contact_dir;

import android.widget.Filter;

import java.util.ArrayList;

/**
 * Created by Devesh 1 on 17-11-2016.
 */
public class CustomFilter extends Filter{
    MyAdapter adapter;
    ArrayList<myDataSet> filterList;
    public CustomFilter(ArrayList<myDataSet> filterList,MyAdapter adapter)
    {
        this.adapter=adapter;
        this.filterList=filterList;
    }
    //FILTERING OCURS
    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results=new FilterResults();
        //CHECK CONSTRAINT VALIDITY
        if(constraint != null && constraint.length() > 0)
        {
            //CHANGE TO UPPER
            constraint=constraint.toString().toUpperCase();
            //STORE OUR FILTERED PLAYERS
            ArrayList<myDataSet> filteredPlayers=new ArrayList<>();
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
    protected void publishResults(CharSequence constraint, Filter.FilterResults results) {
        adapter.players= (ArrayList<myDataSet>) results.values;
        //REFRESH
        adapter.notifyDataSetChanged();
    }
}
