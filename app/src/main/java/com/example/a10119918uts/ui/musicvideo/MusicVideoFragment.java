package com.example.a10119918uts.ui.musicvideo;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a10119918uts.databinding.FragmentDailyActivityBinding;
import com.example.a10119918uts.databinding.FragmentMusicVideoBinding;
import com.example.a10119918uts.model.DailyActivitiesModel;
import com.example.a10119918uts.model.MusicModel;
import com.example.a10119918uts.presenter.DailyActivitiesPresenter;
import com.example.a10119918uts.presenter.DailyActivitiesPresenterImpl;
import com.example.a10119918uts.presenter.MusicPresenter;
import com.example.a10119918uts.presenter.MusicPresenterImpl;
import com.example.a10119918uts.ui.dailyactivity.DailyActivityListAdapter;
import com.example.a10119918uts.view.MusicView;
import com.example.a10119918uts.R;

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

public class MusicVideoFragment extends Fragment implements MusicView {
    private FragmentMusicVideoBinding binding;
    private RecyclerView recyclerView;
    private MusicVideoAdapter adapter;
    private List<MusicModel> musicList = new ArrayList<>();
    private AppCompatDialog dialog;
    private MusicPresenter presenter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentMusicVideoBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        initRecycle();

        presenter = new MusicPresenterImpl(this);

        presenter.load();
        return root;
    }

    private void initRecycle() {
        RecyclerView recyclerView = binding.musicVideoRecyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(binding.getRoot().getContext(),
                LinearLayoutManager.VERTICAL,false));

        adapter = new MusicVideoAdapter(musicList, binding.getRoot().getContext());
        recyclerView.setAdapter((adapter));
    }

    @Override
    public void onLoad(List<MusicModel> musics) {
        musicList.clear();
        musicList.addAll(musics);

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
