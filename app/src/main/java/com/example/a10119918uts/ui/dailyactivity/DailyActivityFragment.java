package com.example.a10119918uts.ui.dailyactivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialog;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a10119918uts.R;
import com.example.a10119918uts.databinding.FragmentDailyActivityBinding;
import com.example.a10119918uts.model.DailyActivitiesModel;
import com.example.a10119918uts.presenter.DailyActivitiesPresenter;
import com.example.a10119918uts.presenter.DailyActivitiesPresenterImpl;
import com.example.a10119918uts.view.DailyActivitiesView;

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

public class DailyActivityFragment extends Fragment implements DailyActivitiesView {
    private FragmentDailyActivityBinding binding;
    private RecyclerView recyclerView;
    private DailyActivityListAdapter adapter;
    private List<DailyActivitiesModel> dailyActivityList = new ArrayList<>();
    private AppCompatDialog dialog;
    private DailyActivitiesPresenter presenter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentDailyActivityBinding.inflate(inflater, container, false);
        View root = binding.getRoot();


        initRecycle();

        presenter = new DailyActivitiesPresenterImpl(this);

        presenter.load();
        return root;
    }

    private void initRecycle() {
        RecyclerView recyclerView = binding.dailyRecyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext(),
                LinearLayoutManager.VERTICAL,false));

        adapter = new DailyActivityListAdapter(dailyActivityList, binding.getRoot().getContext());
        recyclerView.setAdapter((adapter));
    }

    @Override
    public void onLoad(List<DailyActivitiesModel> dailyActivities) {
        dailyActivityList.clear();
        dailyActivityList.addAll(dailyActivities);

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
