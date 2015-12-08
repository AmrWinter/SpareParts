package com.alexforprog.spareparts.Unregistered.unregistered_Adapters;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.alexforprog.spareparts.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Z on 12/7/2015.
 */
public class GridAdapter extends ArrayAdapter<String> {

    View row;
    private Activity activity;
    private ArrayList data;
    LayoutInflater inflater;
//    dbUser tempValues=null;
    public Resources res;


    public GridAdapter(Activity context,
                                   int LayoutResID,
                                   ArrayList objects,
                                   Resources resLocal){
        super(context,LayoutResID ,  objects);
        data = objects;
        activity = context;
        res = resLocal;
        /***********  Layout inflator to call external xml layout () **********************/
        inflater = (LayoutInflater)activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    class MyViewHolder {
        ImageView ivBrand;
        MyViewHolder(View v) {
            ivBrand = (ImageView) v.findViewById(R.id.ivBrand);
        }
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        row = convertView;
        MyViewHolder holder = null;
        if (row == null){
            row = inflater.inflate(R.layout.grideview_content, parent, false);
            holder = new MyViewHolder(row);
            row.setTag(holder);
            Log.d("A4P:", "creating a new row");
        }else {
            holder = (MyViewHolder) row.getTag();
            Log.d("A4P:", "Recycling stuff");
        }
//        holder.tempValues = tempValues;


        return row;
    }

    @Override
    public int getCount() {
        return data.toArray().length;
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

}
