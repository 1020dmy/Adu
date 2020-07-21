package com.example.myapplication10.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication10.R;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    private ArrayList<String> stringArrayList;
    private LayoutInflater inflater1;
    private ViewGroup container1;
    private RecyclerView rv;
    private TextView tvv;
    private TextView tv;

    public BlankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_blank, container, false);

        return inflate;
    }
}
