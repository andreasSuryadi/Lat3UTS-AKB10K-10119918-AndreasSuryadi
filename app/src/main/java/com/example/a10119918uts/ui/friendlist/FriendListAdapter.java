package com.example.a10119918uts.ui.friendlist;

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
import com.example.a10119918uts.model.FriendListModel;

import java.util.List;

/**
 *
 * NIM                  : 10119918
 * Nama                 : Andreas Suryadi
 * Kelas                : IF-10K
 * Tanggal Pengerjaan   : 25 Mei 2022
 *
 */

public class FriendListAdapter extends RecyclerView.Adapter<FriendListAdapter.FriendListViewHolder> {
    private List<FriendListModel> friendLists;
    private FriendListAdapter.OnCallbackListener listener;
    private final Context context;

    public FriendListAdapter(List<FriendListModel> friendLists, Context context) {
        this.friendLists = friendLists;
        this.context = context;
    }

    @NonNull
    @Override
    public FriendListAdapter.FriendListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FriendListAdapter.FriendListViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_friend_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull FriendListAdapter.FriendListViewHolder holder, int position) {
        FriendListModel friendList = friendLists.get(position);
        holder.textViewNama.setText(friendList.getNama());
        holder.imageViewFriend.setImageDrawable(context.getResources().getDrawable(getDrawableByName(this.friendLists.get(position).imagename)));
    }

    @Override
    public int getItemCount() {
        return friendLists.size();
    }

    public void setOnCallbackListener(FriendListAdapter.OnCallbackListener listener) {
        this.listener = listener;
    }

    private int getDrawableByName(String name){
        Resources res = context.getResources();
        final int resId = res.getIdentifier(name,"drawable",context.getPackageName());
        return resId;
    }

    class FriendListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textViewNama;
        ImageView imageViewFriend;

        public FriendListViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            textViewNama = itemView.findViewById(R.id.activity_recycle_activityname);
            imageViewFriend = itemView.findViewById(R.id.activity_recycle_image);
        }

        @Override
        public void onClick(View v) {
            if (listener != null) {
                listener.onClick(friendLists.get(getAdapterPosition()));
            }
        }
    }

    public interface OnCallbackListener {
        void onClick(FriendListModel friendList);
    }
}
