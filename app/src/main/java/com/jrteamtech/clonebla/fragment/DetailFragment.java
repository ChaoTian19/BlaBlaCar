package com.jrteamtech.clonebla.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.PopupMenu;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.jrteamtech.clonebla.R;
import com.jrteamtech.clonebla.activity.AddCarActivity;
import com.jrteamtech.clonebla.activity.AddPreferenceActivity;
import com.jrteamtech.clonebla.activity.EditProfileActivity;
import com.jrteamtech.clonebla.activity.VerifyMyIdActivity;

public class DetailFragment extends Fragment implements View.OnClickListener {
    private CardView cardAboutYou;
    private CardView cardCar;
    private CardView cardSeePublicProfile;
    private CardView cardVerification;
    private ImageView imageVerification;
    private TextView tvAddCar;
    private TextView tvAddPhone;
    private TextView tvAddPreference;
    private TextView tvMiniBio;
    private TextView tvSeePublicProfile;
    private TextView tvVerifyEmail;
    private TextView tvVerifyID;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getArguments();
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_detail, viewGroup, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.cardAboutYou = (CardView) view.findViewById(R.id.card_about_you);
        this.cardVerification = (CardView) view.findViewById(R.id.card_verification);
        this.cardCar = (CardView) view.findViewById(R.id.card_car);
        this.cardSeePublicProfile = (CardView) view.findViewById(R.id.card_see_public_profile);
        this.tvMiniBio = (TextView) view.findViewById(R.id.tv_mini_bio);
        this.tvAddPreference = (TextView) view.findViewById(R.id.tv_add_preference);
        this.tvVerifyID = (TextView) view.findViewById(R.id.tv_verify_id);
        this.tvAddPhone = (TextView) view.findViewById(R.id.tv_add_phone);
        this.tvVerifyEmail = (TextView) view.findViewById(R.id.tv_verify_email);
        this.tvAddCar = (TextView) view.findViewById(R.id.tv_add_car);
        this.tvSeePublicProfile = (TextView) view.findViewById(R.id.tv_see_public_profile);
        this.imageVerification = (ImageView) view.findViewById(R.id.image_verification);
        this.tvMiniBio.setOnClickListener(this);
        this.tvAddPreference.setOnClickListener(this);
        this.tvVerifyID.setOnClickListener(this);
        this.tvAddPhone.setOnClickListener(this);
        this.tvVerifyEmail.setOnClickListener(this);
        this.tvAddCar.setOnClickListener(this);
        this.tvSeePublicProfile.setOnClickListener(this);
        this.imageVerification.setOnClickListener(this);
    }

    private void getPopUpMenu() {
        PopupMenu popupMenu = new PopupMenu(getActivity(), this.imageVerification);
        popupMenu.getMenuInflater().inflate(R.menu.verification_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.action_edit_my_email) {
                    Toast.makeText(DetailFragment.this.getContext(), DetailFragment.this.getResources().getString(R.string.action_edit_my_email), Toast.LENGTH_LONG).show();
                }
                return false;
            }
        });
        popupMenu.show();
    }

    private void addUserBio() {
        startActivity(new Intent(getContext(), EditProfileActivity.class));
    }

    private void addpreference(){
        startActivity(new Intent(getContext(), AddPreferenceActivity.class));
    }

    private void addACar() {
        startActivity(new Intent(getContext(), AddCarActivity.class));
    }

    private void addverifymyid(){
        startActivity(new Intent(getContext(), VerifyMyIdActivity.class));
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.image_verification /*2131230905*/:
                getPopUpMenu();
                return;
            case R.id.tv_add_car /*2131231072*/:
                addACar();
                return;
            case R.id.tv_mini_bio /*2131231092*/:
                addUserBio();
                return;
            case R.id.tv_add_preference         :
                 addpreference();
                 return;
            case  R.id.tv_verify_id:
                  addverifymyid();
                  return;
            default:
                return;
        }
    }
}
