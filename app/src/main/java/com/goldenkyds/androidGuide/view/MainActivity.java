package com.goldenkyds.androidGuide.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.goldenkyds.androidGuide.R;

import butterknife.ButterKnife;
import butterknife.InjectView;


public class MainActivity extends AppCompatActivity {

    @InjectView(R.id.basic_list)
    GridView basicList;

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
            ViewHolder view;
            if(convertView == null){
                view = new ViewHolder();
                convertView = LayoutInflater.from(getBaseContext()).inflate(R.layout.sample_row,parent,false);
                view.sampleText = (TextView)convertView.findViewById(R.id.sample_text);
                convertView.setTag(view);
            }else{
                view = (ViewHolder)convertView.getTag();
            }
            view.sampleText.setText(samples[position]);
            return convertView;
        }

        private class ViewHolder{
            ImageView sampleImage;
            TextView sampleText;
        }
    }

}
