package com.jrteamtech.clonebla;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.PopupMenu;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.widget.PopupMenu.OnMenuItemClickListener;
import com.google.android.material.tabs.TabLayout;

public class ProfileFragment extends Fragment implements View.OnClickListener {
    private FrameLayout frameAddProfile;
    private ImageView imageMenu;
    private TabLayout tabLayout;
    private TextView tvUserName;
    private TextView tvUserStatus;
    private ViewPager viewPager;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getArguments();
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_profile, viewGroup, false);
    }

    public void onViewCreated(@NonNull View view, @Nullable Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.frameAddProfile = (FrameLayout) view.findViewById(R.id.frame_add_profile);
        this.tvUserName = (TextView) view.findViewById(R.id.tv_user_name);
        this.tvUserStatus = (TextView) view.findViewById(R.id.tv_user_status);
        this.tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        this.viewPager = (ViewPager) view.findViewById(R.id.pager);
        this.imageMenu = (ImageView) view.findViewById(R.id.image_menu);
        setupViewPager(this.viewPager);
        this.tabLayout.setupWithViewPager(this.viewPager);
        this.imageMenu.setOnClickListener(this);
    }

    private void setupViewPager(ViewPager viewPager2) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        viewPagerAdapter.addFragment(new DetailFragment(), getResources().getString(R.string.label_detail));
        viewPagerAdapter.addFragment(new AccountFragment(), getResources().getString(R.string.label_account));
        viewPager2.setAdapter(viewPagerAdapter);
    }

    private void getPopUpMenu() {
        PopupMenu popupMenu = new PopupMenu(getActivity(), this.imageMenu);
        popupMenu.getMenuInflater().inflate(R.menu.profile_menu, popupMenu.getMenu());
        popupMenu.setOnMenuItemClickListener(new OnMenuItemClickListener() {
            public boolean onMenuItemClick(MenuItem menuItem) {
                int itemId = menuItem.getItemId();
                if (itemId == R.id.action_edit_my_details) {
                    Toast.makeText(ProfileFragment.this.getContext(), ProfileFragment.this.getResources().getString(R.string.action_edit_my_details), Toast.LENGTH_LONG).show();
                } else if (itemId == R.id.action_edit_my_photo) {
                    Toast.makeText(ProfileFragment.this.getContext(), ProfileFragment.this.getResources().getString(R.string.action_edit_my_photo), Toast.LENGTH_LONG ).show();
                }
                return false;
            }
        });
        popupMenu.show();
    }

    public void onClick(View view) {
        if (view.getId() == R.id.image_menu) {
            getPopUpMenu();
        }
    }
}

