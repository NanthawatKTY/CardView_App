package com.namo3t.cardview_app;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

public class CustomHolder extends RecyclerView.ViewHolder {
    public TextView textViewTitle;
    public ImageView img3dots;
    public ImageView imgContent;
    public TextView textViewContent;

    public CustomHolder(View view)
    {
        super(view);
        textViewTitle = (TextView)view.findViewById(R.id.text_title);
        img3dots = (ImageView)view.findViewById(R.id.img_3dots);
        imgContent = (ImageView)view.findViewById(R.id.img_content);
        textViewContent = (TextView)view.findViewById(R.id.text_content);
    }
}
