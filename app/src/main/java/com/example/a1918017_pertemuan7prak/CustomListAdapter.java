package com.example.a1918017_pertemuan7prak;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<Baju> Baju;
    public CustomListAdapter(Activity activity, List<Baju> Baju) {
        this.activity = activity;
        this.Baju = Baju;
    }
    @Override
    public int getCount() {
        return Baju.size();
    }
    @Override
    public Object getItem(int location) {
        return Baju.get(location);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list, null);
        TextView nama = (TextView)
                convertView.findViewById(R.id.text_nama);
        TextView kelas = (TextView)
                convertView.findViewById(R.id.text_harga);
        ImageView imageView = (ImageView)
                convertView.findViewById(R.id.iconid);
        Baju b = Baju.get(position);
        nama.setText("Nama Baju : "+ b.get_nama());
        kelas.setText("Harga Baju : "+ b.get_harga());
        return convertView;
    }
}

