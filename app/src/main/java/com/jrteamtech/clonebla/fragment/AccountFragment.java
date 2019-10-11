package com.jrteamtech.clonebla.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import com.jrteamtech.clonebla.R;
import com.jrteamtech.clonebla.activity.HelpActivity;
import com.jrteamtech.clonebla.activity.LincesActivity;
import com.jrteamtech.clonebla.activity.PrivatePolicyActivity;
import com.jrteamtech.clonebla.activity.TermsConditionsActivity;

public class AccountFragment extends Fragment implements View.OnClickListener {
    private CardView cardAbout;
    private CardView cardLogout;
    private CardView cardMoney;
    private CardView cardPreference;
    private CardView cardYourStatus;
    private TextView tvAvailableFunds;
    private TextView tvBankDetails;
    private TextView tvChangePasword;
    private TextView tvHelp;
    private TextView tvLicenses;
    private TextView tvLogout;
    private TextView tvNotificationAndCommunication;
    private TextView tvPastTransfer;
    private TextView tvPayment;
    private TextView tvPostalAddress;
    private TextView tvPrivacyPolicy;
    private TextView tvRatingYouLeft;
    private TextView tvTermsAndCondition;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getArguments();
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_account, viewGroup, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.cardYourStatus = (CardView) view.findViewById(R.id.card_your_status);
        this.cardPreference = (CardView) view.findViewById(R.id.card_preference);
        this.cardMoney = (CardView) view.findViewById(R.id.card_money);
        this.cardAbout = (CardView) view.findViewById(R.id.card_about);
        this.cardLogout = (CardView) view.findViewById(R.id.card_logout);
        this.tvRatingYouLeft = (TextView) view.findViewById(R.id.tv_see_rating_you_left);
        this.tvNotificationAndCommunication = (TextView) view.findViewById(R.id.tv_notification_and_communication);
        this.tvChangePasword = (TextView) view.findViewById(R.id.tv_change_password);
        this.tvPostalAddress = (TextView) view.findViewById(R.id.tv_postal_address);
        this.tvAvailableFunds = (TextView) view.findViewById(R.id.tv_available_funds);
        this.tvPayment = (TextView) view.findViewById(R.id.tv_payment);
        this.tvBankDetails = (TextView) view.findViewById(R.id.tv_back_details);
        this.tvPastTransfer = (TextView) view.findViewById(R.id.tv_past_transfers);
        this.tvHelp = (TextView) view.findViewById(R.id.tv_help);
        this.tvTermsAndCondition = (TextView) view.findViewById(R.id.tv_terms_conditions);
        this.tvPrivacyPolicy = (TextView) view.findViewById(R.id.tv_privacy_policy);
        this.tvLicenses = (TextView) view.findViewById(R.id.tv_licenses);
        this.tvLogout = (TextView) view.findViewById(R.id.tv_logout);


        this.tvLogout.setOnClickListener(this);
        this.tvLicenses.setOnClickListener(this);
        this.tvPrivacyPolicy.setOnClickListener(this);
        this.tvTermsAndCondition.setOnClickListener(this);
        this.tvHelp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_logout  :
                logOut();
                return;
            case R.id.tv_licenses :
                lincenses();
                return;
            case R.id.tv_privacy_policy :
                privatepolicy();
                return;
            case R.id.tv_terms_conditions :
                termsconditions();
                return;
            case R.id.tv_help  :
                help();
                return;

                default:
                    return;
        }
    }

    private void logOut(){
        CurrentFragment CurrentFragment = new CurrentFragment();
        FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.replace(R.id.frame_container, CurrentFragment);
        beginTransaction.disallowAddToBackStack();
        beginTransaction.commit();
    }
    private void lincenses(){
        startActivity(new Intent(getContext(), LincesActivity.class));
    }
    private void privatepolicy(){
        startActivity(new Intent(getContext(), PrivatePolicyActivity.class));
    }
    private void termsconditions(){
        startActivity(new Intent(getContext(), TermsConditionsActivity.class));
    }
    private void help(){
        startActivity(new Intent(getContext(),  HelpActivity.class));
    }
}

