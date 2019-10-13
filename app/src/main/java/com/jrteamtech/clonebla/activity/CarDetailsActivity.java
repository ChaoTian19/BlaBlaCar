package com.jrteamtech.clonebla.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;
import androidx.appcompat.widget.Toolbar;

import com.jrteamtech.clonebla.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CarDetailsActivity extends AppCompatActivity {

    private Toolbar toolbar;
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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_details);

        question_view = findViewById(R.id.question_view);
        popular_title_view = findViewById(R.id.popular_title_view);

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

        popular_listview = findViewById(R.id.popular_listview);
        PopularListAdapter adapter = new PopularListAdapter(this, 0, popular_makes);
        popular_listview.setAdapter(adapter);
        setToolbar();

    }

    private void setToolbar(){
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setTitle("Your car details");
        toolbar.setTitleTextColor(getResources().getColor(android.R.color.white));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().show();

    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
            default:
                return  super.onOptionsItemSelected(item);
        }
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
