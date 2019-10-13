package com.jrteamtech.clonebla.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.jrteamtech.clonebla.R;

import java.util.ArrayList;
import java.util.List;

public class CarDetailChooseTypeFragment extends Fragment {

    private ListView car_type_listview;
    private List<CarType> carTypes = new ArrayList<>();
    private int[] car_img_resources = {R.drawable.car_type_1, R.drawable.car_type_2, R.drawable.car_type_3, R.drawable.car_type_4, R.drawable.car_type_5, R.drawable.car_type_6, R.drawable.car_type_7,
                    R.drawable.car_type_8};
    private String[] car_img_lables = {"Hatchback", "Saloon", "Convertible", "Estate", "SUV", "Station wagon", "Minivan", "Van"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_car_detail_choose_type, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        car_type_listview = view.findViewById(R.id.car_type_listview);

        for (int i = 0; i < 8; i++){
            carTypes.add(new CarType(car_img_resources[i], car_img_lables[i]));
        }

        CarTypeListAdapter adapter = new CarTypeListAdapter(getContext(), 0, carTypes);
        car_type_listview.setAdapter(adapter);
    }

    class CarTypeListAdapter extends ArrayAdapter<CarType> {

        private Context mContext;

        CarTypeListAdapter(Context context, int resource, List<CarType> data) {
            super(context, resource, data);
            this.mContext = context;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            if(convertView == null){
                convertView = LayoutInflater.from(mContext).inflate(R.layout.car_type_item, parent, false);
            }

            CarType type = getItem(position);
            ImageView car_type_img = convertView.findViewById(R.id.car_type_img);
            TextView car_type_label = convertView.findViewById(R.id.car_type_label);
            RadioButton car_type_check_btn = convertView.findViewById(R.id.car_type_check_btn);

            assert type != null;
            car_type_img.setImageResource(type.image_resource);
            car_type_label.setText(type.type);

            convertView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    car_type_check_btn.setChecked(true);
                    CarDetailChooseColorFragment colorFragment = new CarDetailChooseColorFragment();
                    getActivity().getSupportFragmentManager().beginTransaction()
                            .replace(R.id.add_car_detail_frame, colorFragment)
                            .commit();
                }
            });

            return convertView;
        }
    }

    class CarType {
        int image_resource;
        String type;

        CarType(int image_resource, String type) {
            this.image_resource = image_resource;
            this.type = type;
        }
    }
}
