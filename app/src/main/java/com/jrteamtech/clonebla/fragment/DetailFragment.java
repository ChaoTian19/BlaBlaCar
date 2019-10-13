package com.jrteamtech.clonebla.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.PopupMenu;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.jrteamtech.clonebla.R;
import com.jrteamtech.clonebla.activity.AddCarActivity;
import com.jrteamtech.clonebla.activity.AddPreferenceActivity;
import com.jrteamtech.clonebla.activity.EditProfileActivity;
import com.jrteamtech.clonebla.activity.SeePublicProfileActivity;
import com.jrteamtech.clonebla.activity.VerifyMyIdActivity;
import com.jrteamtech.clonebla.activity.VerifyPhoneNumberActivity;

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

    private LinearLayout preferences_view;

    private SharedPreferences sharedPreferences;

    private boolean isExistCarPreferences = false;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getArguments();
        sharedPreferences = getContext().getSharedPreferences("CarPrefs", Context.MODE_PRIVATE);
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_detail, viewGroup, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);

        this.preferences_view = view.findViewById(R.id.preferences_view);

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

        if(sharedPreferences.getBoolean("isExistCarPreferences", false)){
            isExistCarPreferences = true;
        } else {
            isExistCarPreferences = false;
        }

        this.tvMiniBio.setOnClickListener(this);
        this.tvAddPreference.setOnClickListener(this);
        this.preferences_view.setOnClickListener(this);
        this.tvVerifyID.setOnClickListener(this);
        this.tvAddPhone.setOnClickListener(this);
        this.tvVerifyEmail.setOnClickListener(this);
        this.tvAddCar.setOnClickListener(this);
        this.tvSeePublicProfile.setOnClickListener(this);
        this.imageVerification.setOnClickListener(this);

        showOrHidePreferences();
    }

    private void showOrHidePreferences() {
        if(isExistCarPreferences){
            preferences_view.setVisibility(View.VISIBLE);
            tvAddPreference.setVisibility(View.GONE);
            if(preferences_view.getChildCount() > 0) {
                preferences_view.removeAllViews();
            }

            int chat_resource = sharedPreferences.getInt("chat_resource", 0);
            int smoking_resource = sharedPreferences.getInt("smoking_resource", 0);
            int music_resource = sharedPreferences.getInt("music_resource", 0);
            int pet_resource = sharedPreferences.getInt("pet_resource", 0);
            preferences_view.addView(getImageView(chat_resource));
            preferences_view.addView(getImageView(smoking_resource));
            preferences_view.addView(getImageView(music_resource));
            preferences_view.addView(getImageView(pet_resource));
        } else {
            tvAddPreference.setVisibility(View.VISIBLE);
            preferences_view.setVisibility(View.GONE);
        }
    }

    private ImageView getImageView(int resource) {
        ImageView imageView = new ImageView(getContext());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(getResources().getDimensionPixelSize(R.dimen.car_preference_img_width), getResources().getDimensionPixelSize(R.dimen.car_preference_img_height));
        params.setMarginEnd(20);
        imageView.setLayoutParams(params);
        imageView.setImageResource(resource);
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        return imageView;
    }

    private void getPopUpMenu() {
        PopupMenu popupMenu = new PopupMenu(getActivity(), this.imageVerification);
        popupMenu.getMenuInflater().inflate(R.menu.verification_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem menuItem) {
                if (menuItem.getItemId() == R.id.action_edit_my_email) {
                    startActivity(new Intent(getContext(),EditProfileActivity.class));
                  //  Toast.makeText(DetailFragment.this.getContext(), DetailFragment.this.getResources().getString(R.string.action_edit_my_email), Toast.LENGTH_LONG).show();
                }
                else if(menuItem.getItemId() == R.id.action_edit_my_phone){
                  //  Toast.makeText(getContext(),"Edit my photo",Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getContext(),VerifyPhoneNumberActivity.class));
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

    private void addverifyphone(){
        startActivity(new Intent(getContext(), VerifyPhoneNumberActivity.class));
    }

    private void addverifyemail(){
        startActivity(new Intent(getContext(), EditProfileActivity.class));
    }
    private void seepublicprofile(){
        startActivity(new Intent(getContext(), SeePublicProfileActivity.class));

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
            case R.id.tv_add_preference:
                 addpreference();
                 return;
            case R.id.preferences_view:
                addpreference();
                return;
            case  R.id.tv_verify_id:
                  addverifymyid();
                  return;
            case  R.id.tv_add_phone:
                  addverifyphone();
                  return;
            case R.id.tv_verify_email:
                   addverifyemail();
                   return;
            case  R.id.tv_see_public_profile:
                    seepublicprofile();
                    return;
            default:
                return;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if(sharedPreferences.getBoolean("isExistCarPreferences", false)){
            isExistCarPreferences = true;
        } else {
            isExistCarPreferences = false;
        }
        showOrHidePreferences();
    }
}
