package com.jrteamtech.clonebla;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class AccountFragment extends Fragment {
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
    }
}

