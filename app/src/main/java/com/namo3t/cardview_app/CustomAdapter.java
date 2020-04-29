package com.namo3t.cardview_app;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomHolder> {
    private Context mContext;
    private ArrayList<CustomItem> mItems;
    private Bitmap mBitmap;
    private RoundedBitmapDrawable mRoundedBitmap;

    public CustomAdapter(Context context, ArrayList<CustomItem> items)
    {
        mContext = context;
        mItems = items;
    }

    public interface OnItemClickListener
    {
        void onItemClick(View item, int position);
    }

    private OnItemClickListener mListener;

    public void setOnClickListener(OnItemClickListener listener)
    {
        mListener = listener;
    }

   // @NonNull

    @Override
    public CustomHolder onCreateViewHolder(ViewGroup parent, final int viewType) {
        final LayoutInflater inflater  = LayoutInflater.from(mContext);
        final View v = inflater.inflate(R.layout.custom_layout, parent, false);
        final CustomHolder vHolder = new CustomHolder(v);
        return vHolder;
    }

    @Override
    public void onBindViewHolder(final CustomHolder vHolder, int position) {
        CustomItem item = mItems.get(position);
        vHolder.textViewTitle.setText(item.title);
        mBitmap = BitmapFactory.decodeResource(mContext.getResources(), item.imgId);
        mRoundedBitmap = RoundedBitmapDrawableFactory.create(mContext.getResources(), mBitmap);
        mRoundedBitmap.setCornerRadius(150.0f);
        mRoundedBitmap.setAntiAlias(true);
        vHolder.imgContent.setImageDrawable(mRoundedBitmap);
        vHolder.textViewContent.setText(item.content);
        vHolder.img3dots.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {
                int pos = vHolder.getAdapterPosition();
                if (pos != RecyclerView.NO_POSITION)
                {
                    PopupMenu popup = new PopupMenu(mContext, v);
                    MenuInflater menuInflater = popup.getMenuInflater();
                    popup.show();

                    popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            int id = item.getItemId();
                            String str = item.getTitle().toString();
                            Toast.makeText(mContext, str, Toast.LENGTH_SHORT).show();

                            return true;
                        }
                    });
                }
            }

        });
    }



    @Override
    public int getItemCount() {
        return mItems.size();
    }


}
