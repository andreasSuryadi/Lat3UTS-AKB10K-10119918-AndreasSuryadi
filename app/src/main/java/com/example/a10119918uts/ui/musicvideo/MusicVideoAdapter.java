package com.example.a10119918uts.ui.musicvideo;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a10119918uts.R;
import com.example.a10119918uts.databinding.FragmentDailyActivityBinding;
import com.example.a10119918uts.databinding.FragmentMusicVideoBinding;
import com.example.a10119918uts.model.DailyActivitiesModel;
import com.example.a10119918uts.model.MusicModel;
import com.example.a10119918uts.presenter.DailyActivitiesPresenter;
import com.example.a10119918uts.presenter.DailyActivitiesPresenterImpl;
import com.example.a10119918uts.presenter.MusicPresenter;
import com.example.a10119918uts.presenter.MusicPresenterImpl;
import com.example.a10119918uts.ui.dailyactivity.DailyActivityListAdapter;
import com.example.a10119918uts.ui.friendlist.FriendListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * NIM                  : 10119918
 * Nama                 : Andreas Suryadi
 * Kelas                : IF-10K
 * Tanggal Pengerjaan   : 26 Mei 2022
 *
 */

public class MusicVideoAdapter extends RecyclerView.Adapter<MusicVideoAdapter.MusicViewHolder> {
    private List<MusicModel> musics;
    private MusicVideoAdapter.OnCallbackListener listener;
    private final Context context;

    public MusicVideoAdapter(List<MusicModel> musics, Context context) {
        this.musics = musics;
        this.context = context;
    }

    @NonNull
    @Override
    public MusicVideoAdapter.MusicViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MusicVideoAdapter.MusicViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_music, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull MusicVideoAdapter.MusicViewHolder holder, int position) {
        MusicModel music = musics.get(position);
        holder.textViewMusic.setText(music.getMusic());
        holder.imageViewMusic.setImageDrawable(context.getResources().getDrawable(getDrawableByName(this.musics.get(position).imagename)));
    }

    @Override
    public int getItemCount() {
        return musics.size();
    }

    public void setOnCallbackListener(MusicVideoAdapter.OnCallbackListener listener) {
        this.listener = listener;
    }

    private int getDrawableByName(String name){
        Resources res = context.getResources();
        final int resId = res.getIdentifier(name,"drawable",context.getPackageName());
        return resId;
    }

    class MusicViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textViewMusic;
        ImageView imageViewMusic;

        public MusicViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            textViewMusic = itemView.findViewById(R.id.activity_recycle_music_name);
            imageViewMusic = itemView.findViewById(R.id.activity_recycle_image);
        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.onClick(musics.get(getAdapterPosition()));
            }
        }
    }

    public interface OnCallbackListener {
        void onClick(MusicModel dailyActivity);
    }
}
