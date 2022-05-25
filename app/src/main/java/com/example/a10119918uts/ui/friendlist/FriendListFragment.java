package com.example.a10119918uts.ui.friendlist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a10119918uts.databinding.FragmentFriendListBinding;
import com.example.a10119918uts.model.FriendListModel;
import com.example.a10119918uts.presenter.FriendListPresenter;
import com.example.a10119918uts.presenter.FriendListPresenterImpl;
import com.example.a10119918uts.ui.dailyactivity.DailyActivityListAdapter;
import com.example.a10119918uts.view.FriendListView;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * NIM                  : 10119918
 * Nama                 : Andreas Suryadi
 * Kelas                : IF-10K
 * Tanggal Pengerjaan   : 25 Mei 2022
 *
 */

public class FriendListFragment extends Fragment implements FriendListView {
    private FragmentFriendListBinding binding;
    private RecyclerView recyclerView;
    private FriendListAdapter adapter;
    private List<FriendListModel> friendLists = new ArrayList<>();
    private AppCompatDialog dialog;
    private FriendListPresenter presenter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentFriendListBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        initRecycle();

        presenter = new FriendListPresenterImpl(this);

        presenter.load();
        return root;
    }

    private void initRecycle() {
        RecyclerView recyclerView = binding.friendListRecyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext(),
                LinearLayoutManager.HORIZONTAL,false));

        adapter = new FriendListAdapter(friendLists, binding.getRoot().getContext());
        recyclerView.setAdapter((adapter));
    }

    @Override
    public void onLoad(List<FriendListModel> friendListModels) {
        friendLists.clear();
        friendLists.addAll(friendListModels);

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
