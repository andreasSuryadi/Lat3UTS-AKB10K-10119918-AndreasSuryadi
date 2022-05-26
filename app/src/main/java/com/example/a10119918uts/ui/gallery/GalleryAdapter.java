package com.example.a10119918uts.ui.gallery;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a10119918uts.R;
import com.example.a10119918uts.model.GalleryModel;

import java.util.List;

/**
 *
 * NIM                  : 10119918
 * Nama                 : Andreas Suryadi
 * Kelas                : IF-10K
 * Tanggal Pengerjaan   : 26 Mei 2022
 *
 */

public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.GalleryViewHolder> {
    private List<GalleryModel> galleries;
    private GalleryAdapter.OnCallbackListener listener;
    private final Context context;

    public GalleryAdapter(List<GalleryModel> galleries, Context context) {
        this.galleries = galleries;
        this.context = context;
    }

    @NonNull
    @Override
    public GalleryAdapter.GalleryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new GalleryAdapter.GalleryViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_gallery, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryAdapter.GalleryViewHolder holder, int position) {
        GalleryModel gallery = galleries.get(position);
        holder.imageViewGallery.setImageDrawable(context.getResources().getDrawable(getDrawableByName(this.galleries.get(position).imagename)));
    }

    @Override
    public int getItemCount() {
        return galleries.size();
    }

    public void setOnCallbackListener(GalleryAdapter.OnCallbackListener listener) {
        this.listener = listener;
    }

    private int getDrawableByName(String name){
        Resources res = context.getResources();
        final int resId = res.getIdentifier(name,"drawable",context.getPackageName());
        return resId;
    }

    class GalleryViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView imageViewGallery;

        public GalleryViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            imageViewGallery = itemView.findViewById(R.id.activity_recycle_image);
        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.onClick(galleries.get(getAdapterPosition()));
            }
        }
    }

    public interface OnCallbackListener {
        void onClick(GalleryModel gallery);
    }
}
