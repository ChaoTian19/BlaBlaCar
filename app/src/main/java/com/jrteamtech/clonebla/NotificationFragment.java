package com.jrteamtech.clonebla;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class NotificationFragment extends Fragment {
    private RecyclerView rvNotification;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getArguments();
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_notification, viewGroup, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.rvNotification = (RecyclerView) view.findViewById(R.id.rv_notification);
        this.rvNotification.hasFixedSize();
        this.rvNotification.setLayoutManager(new LinearLayoutManager(getContext()));
        this.rvNotification.setAdapter(new NotificationAdapter(getContext()));
    }
}
