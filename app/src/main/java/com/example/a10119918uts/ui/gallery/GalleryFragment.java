package com.example.a10119918uts.ui.gallery;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatDialog;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a10119918uts.databinding.FragmentGalleryBinding;
import com.example.a10119918uts.model.GalleryModel;
import com.example.a10119918uts.presenter.GalleryPresenter;
import com.example.a10119918uts.presenter.GalleryPresenterImpl;
import com.example.a10119918uts.view.GalleryView;

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

public class GalleryFragment extends Fragment implements GalleryView {

    private FragmentGalleryBinding binding;
    private RecyclerView recyclerView;
    private GalleryAdapter adapter;
    private List<GalleryModel> galleries = new ArrayList<>();
    private AppCompatDialog dialog;
    private GalleryPresenter presenter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        initRecycle();

        presenter = new GalleryPresenterImpl(this);

        presenter.load();

        return root;
    }

    private void initRecycle() {
        RecyclerView recyclerView = binding.galleryRecyclerView;
        recyclerView.setLayoutManager(new GridLayoutManager(binding.getRoot().getContext(), 2));

        adapter = new GalleryAdapter(galleries, binding.getRoot().getContext());
        recyclerView.setAdapter((adapter));
    }

    @Override
    public void onLoad(List<GalleryModel> galleryModels) {
        galleries.clear();
        galleries.addAll(galleryModels);

        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}