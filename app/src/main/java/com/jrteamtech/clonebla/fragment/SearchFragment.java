package com.jrteamtech.clonebla.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.jrteamtech.clonebla.utility.Global;
import com.jrteamtech.clonebla.R;
import com.jrteamtech.clonebla.activity.ChooseDateActivity;
import com.jrteamtech.clonebla.activity.NoRideFindActivity;
import com.jrteamtech.clonebla.activity.SearchActivity;

import static com.jrteamtech.clonebla.utility.Global.result_time;


/**
 * A simple {@link Fragment} subclass.
 */
public class SearchFragment extends Fragment implements View.OnClickListener {
    private TextView tvGoingTo;
    private TextView tvLeavingFrom;

    private TextView Calendardate;

    private Button tvSearch;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_search, viewGroup, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        tvLeavingFrom = (TextView) view.findViewById(R.id.tv_leaving_from);
        tvGoingTo = (TextView) view.findViewById(R.id.tv_going_to);
        Calendardate = (TextView) view.findViewById(R.id.calendardate);
        tvSearch = (Button) view.findViewById(R.id.tv_search);

        tvLeavingFrom.setOnClickListener(this);
        tvGoingTo.setOnClickListener(this);
        tvSearch.setOnClickListener(this);
        Calendardate.setOnClickListener(this);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.tv_going_to) {
            startActivity(new Intent(getContext(), SearchActivity.class));
        } else if (id == R.id.tv_leaving_from) {
            startActivity(new Intent(getContext(), SearchActivity.class));
        } else if (id == R.id.calendardate) {
         //   startActivity(new Intent(getContext(), NoRideFindActivity.class));
             startActivity(new Intent(getContext(), ChooseDateActivity.class));
        } else if (id == R.id.tv_search)
        {
            startActivity(new Intent(getContext(), NoRideFindActivity.class));
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (Global.getSelected_time() != null){
         //   Calendardate.setText("ddd");
            Calendardate.setText(result_time);
        }
    }
}
