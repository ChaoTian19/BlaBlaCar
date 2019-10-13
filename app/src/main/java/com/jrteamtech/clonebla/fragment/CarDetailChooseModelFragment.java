package com.jrteamtech.clonebla.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.jrteamtech.clonebla.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarDetailChooseModelFragment extends Fragment {

    private TextView question_view, popular_title_view;
    private ListView popular_listview;

    private List<String> popular_makes = new ArrayList<>();
    private List<String> volk_models = new ArrayList<>();
    private List<String> ford_models = new ArrayList<>();
    private List<String> bmw_models = new ArrayList<>();
    private List<String> vaux_models = new ArrayList<>();
    private List<String> audi_models = new ArrayList<>();
    private List<List<String>> models = new ArrayList<>();

    private String flag = "makes";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_car_detail_choose_model, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        question_view = view.findViewById(R.id.question_view);
        popular_title_view = view.findViewById(R.id.popular_title_view);

        popular_makes = Arrays.asList(getResources().getStringArray(R.array.popular_makes));
        volk_models = Arrays.asList(getResources().getStringArray(R.array.VOLKSWAGEN));
        ford_models = Arrays.asList(getResources().getStringArray(R.array.FORD));
        bmw_models = Arrays.asList(getResources().getStringArray(R.array.BMW));
        vaux_models = Arrays.asList(getResources().getStringArray(R.array.VAUXHALL));
        audi_models = Arrays.asList(getResources().getStringArray(R.array.AUDI));

        models.add(volk_models);
        models.add(ford_models);
        models.add(bmw_models);
        models.add(vaux_models);
        models.add(audi_models);

        popular_listview = view.findViewById(R.id.popular_listview);
        PopularListAdapter adapter = new PopularListAdapter(getContext(), 0, popular_makes);
        popular_listview.setAdapter(adapter);
    }

    class PopularListAdapter extends ArrayAdapter<String> {

        private Context mContext;

        PopularListAdapter(Context context, int res, List<String> data) {
            super(context, res, data);
            this.mContext = context;
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

            if(convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(mContext);
                convertView = inflater.inflate(R.layout.popular_list_item, null);
            }

            String item = getItem(position);
            TextView item_view = convertView.findViewById(R.id.popular_item_view);
            item_view.setText(item);

            item_view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(flag.equals("model")){
                        CarDetailChooseTypeFragment typeFragment = new CarDetailChooseTypeFragment();
                        getActivity().getSupportFragmentManager().beginTransaction()
                                .replace(R.id.add_car_detail_frame, typeFragment)
                                .commit();
                    } else {
                        flag = "model";
                        question_view.setText("What model?");
                        popular_title_view.setText("Popular models");
                        List<String> model = models.get(position);
                        PopularListAdapter adapter = new PopularListAdapter(mContext, 0, model);
                        popular_listview.setAdapter(adapter);
                        notifyDataSetChanged();
                    }
                }
            });

            return convertView;
        }
    }
}