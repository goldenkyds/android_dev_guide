package com.goldenkyds.androidGuide.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.goldenkyds.androidGuide.R;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.basic_list)
    ListView basicList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.inject(this);

        basicList.setAdapter(new SampleList());
    }

    private class SampleList extends BaseAdapter{

        private String[] samples = getResources().getStringArray(R.array.sample_list);

        @Override
        public int getCount() {
            return samples.length;
        }

        @Override
        public String getItem(int position) {
            return samples[position];
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view;
            if(convertView == null){
                view = LayoutInflater.from(getBaseContext()).inflate(R.layout.sample_row,parent,false);
                convertView = view;
                convertView.setTag(view);
            }else{
                view = (View)convertView.getTag();
            }
            ((TextView)view.findViewById(R.id.sample_text)).setText(samples[position]);
            return view;
        }
    }

}
