package com.alexforprog.spareparts.Unregistered.unregistered_Fragments;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.alexforprog.spareparts.R;
import com.alexforprog.spareparts.Unregistered.unregistered_Adapters.GridAdapter;

import java.util.ArrayList;

/**
 * Created by Z on 12/7/2015.
 */
public class unregistered_Brands_Grid extends Fragment{
    public static ArrayList arraylist;
    Resources res;
    View Brands_Grid_View;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Brands_Grid_View = inflater.inflate(R.layout.unregistered_register, container, false);
        initVals();
        return Brands_Grid_View;
    }

    private void initVals() {
//        res = getResources();
//        arraylist = new ArrayList();
//
//        arraylist.add(res);
//        arraylist.add(res);
//        arraylist.add(res);
//        arraylist.add(res);
//        arraylist.add(res);
//        arraylist.add(res);
//        arraylist.add(res);
//        arraylist.add(res);
//        arraylist.add(res);
//
//        if (arraylist.toArray().length % 2 == 1)
//            arraylist.add(res);
//
//        GridView gvBrands = (GridView) Brands_Grid_View.findViewById(R.id.gvBrands);
//        gvBrands.setAdapter(new GridAdapter(getActivity(), R.layout.grideview_content, arraylist, res));

    }

}
