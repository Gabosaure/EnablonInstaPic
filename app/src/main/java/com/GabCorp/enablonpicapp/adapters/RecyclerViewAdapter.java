package com.GabCorp.enablonpicapp.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.GabCorp.enablonpicapp.R;
import com.GabCorp.enablonpicapp.models.InstaPic;

import java.util.List;

/**
 * Adapter for the RecyclerView
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<InstaPic> mInstaPics;
    private Context mContext;

    public RecyclerViewAdapter(List<InstaPic> mInstaPics, Context mContext) {
        this.mInstaPics = mInstaPics;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.uneimage, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        // Setting the image
        RequestOptions defaultOptions = new RequestOptions().error(R.drawable.ic_launcher_background);
        Glide.with(mContext)
                .setDefaultRequestOptions(defaultOptions)
                .load(mInstaPics.get(i).getImage())
                .into(((ViewHolder)viewHolder).mImage);

        // Setting the Textviews
        ((ViewHolder) viewHolder).mDate.setText(mInstaPics.get(i).getDate());
        ((ViewHolder) viewHolder).mTitle.setText(mInstaPics.get(i).getTitle());
        ((ViewHolder) viewHolder).mLikes.setText(mInstaPics.get(i).getLikes());
    }

    @Override
    public int getItemCount() {
        if (mInstaPics != null)
            return mInstaPics.size();
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImage;
        private TextView mTitle;
        private TextView mDate;
        private TextView mLikes;

        public ViewHolder(View view) {
            super(view);
            mImage = view.findViewById(R.id.imageView);
            mTitle = view.findViewById(R.id.title);
            mDate = view.findViewById(R.id.date);
            mLikes = view.findViewById(R.id.likes);
        }
    }
}
