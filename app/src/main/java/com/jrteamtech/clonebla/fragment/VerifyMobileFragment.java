package com.jrteamtech.clonebla.fragment;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;

import com.jrteamtech.clonebla.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class VerifyMobileFragment extends Fragment {


    public VerifyMobileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_verifymobile, container, false);
    }

}
