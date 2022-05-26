package com.example.a10119918uts.presenter;

import com.example.a10119918uts.model.GalleryModel;
import com.example.a10119918uts.model.MusicModel;
import com.example.a10119918uts.view.GalleryView;
import com.example.a10119918uts.view.MusicView;

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

public class MusicPresenterImpl implements MusicPresenter {
    private MusicView view;
    private List<MusicModel> musics = new ArrayList<>();
    private int no = 5;

    public MusicPresenterImpl(MusicView view) {
        this.view = view;
        setData();
    }

    @Override
    public void load() {
        view.onLoad(musics);
    }

    public void setData() {
        MusicModel music1 = new MusicModel();
        music1.setId(1);
        music1.setMusic("You'll Never Walk Alone");
        music1.setImagename("music_ynwa");
        musics.add(music1);

        MusicModel music2 = new MusicModel();
        music2.setId(2);
        music2.setMusic("Chiki Chiki Bam Bam");
        music2.setImagename("music_paripi_koumei");
        musics.add(music2);

        MusicModel music3 = new MusicModel();
        music3.setId(3);
        music3.setMusic("Crossing Field");
        music3.setImagename("music_crossing_field");
        musics.add(music3);

        MusicModel music4 = new MusicModel();
        music4.setId(4);
        music4.setMusic("Silhouette");
        music4.setImagename("music_silhouette");
        musics.add(music4);
    }
}
