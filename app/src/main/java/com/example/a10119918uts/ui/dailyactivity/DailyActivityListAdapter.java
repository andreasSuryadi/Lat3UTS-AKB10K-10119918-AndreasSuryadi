package com.example.a10119918uts.ui.dailyactivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a10119918uts.R;
import com.example.a10119918uts.model.DailyActivitiesModel;

import java.util.List;

/**
 *
 * NIM                  : 10119918
 * Nama                 : Andreas Suryadi
 * Kelas                : IF-10K
 * Tanggal Pengerjaan   : 25 Mei 2022
 *
 */

public class DailyActivityListAdapter extends RecyclerView.Adapter<DailyActivityListAdapter.ActivityViewHolder> {
    private List<DailyActivitiesModel> dailyActivities;
    private OnCallbackListener listener;
    private final Context context;

    public DailyActivityListAdapter(List<DailyActivitiesModel> dailyActivities, Context context) {
        this.dailyActivities = dailyActivities;
        this.context = context;
    }

    @NonNull
    @Override
    public ActivityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ActivityViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_daily_activities, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ActivityViewHolder holder, int position) {
        DailyActivitiesModel dailyActivity = dailyActivities.get(position);
        holder.textViewAktivitas.setText(dailyActivity.getAktivitas());
        holder.imageViewAktivitas.setImageDrawable(context.getResources().getDrawable(getDrawableByName(this.dailyActivities.get(position).imagename)));
    }

    @Override
    public int getItemCount() {
        return dailyActivities.size();
    }

    public void setOnCallbackListener(OnCallbackListener listener) {
        this.listener = listener;
    }

    private int getDrawableByName(String name){
        Resources res = context.getResources();
        final int resId = res.getIdentifier(name,"drawable",context.getPackageName());
        return resId;
    }

    class ActivityViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textViewAktivitas;
        ImageView imageViewAktivitas;

        public ActivityViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            textViewAktivitas = itemView.findViewById(R.id.activity_recycle_activityname);
            imageViewAktivitas = itemView.findViewById(R.id.activity_recycle_image);
        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.onClick(dailyActivities.get(getAdapterPosition()));
            }
        }
    }

    public interface OnCallbackListener {
        void onClick(DailyActivitiesModel dailyActivity);
    }
}
