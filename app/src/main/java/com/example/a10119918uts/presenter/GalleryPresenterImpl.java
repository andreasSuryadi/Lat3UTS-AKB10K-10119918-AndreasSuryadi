package com.example.a10119918uts.presenter;

import com.example.a10119918uts.model.GalleryModel;
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

public class GalleryPresenterImpl implements GalleryPresenter {
    private GalleryView view;
    private List<GalleryModel> galleries = new ArrayList<>();
    private int no = 5;

    public GalleryPresenterImpl(GalleryView view) {
        this.view = view;
        setData();
    }

    @Override
    public void load() {
        view.onLoad(galleries);
    }

    public void setData() {
        GalleryModel gallery1 = new GalleryModel();
        gallery1.setId(1);
        gallery1.setImagename("gallery_liverpool");
        galleries.add(gallery1);

        GalleryModel gallery2 = new GalleryModel();
        gallery2.setId(2);
        gallery2.setImagename("gallery_sword_art_online");
        galleries.add(gallery2);

        GalleryModel gallery3 = new GalleryModel();
        gallery3.setId(3);
        gallery3.setImagename("gallery_fifa");
        galleries.add(gallery3);

        GalleryModel gallery4 = new GalleryModel();
        gallery4.setId(4);
        gallery4.setImagename("gallery_spy_family");
        galleries.add(gallery4);
    }
}
