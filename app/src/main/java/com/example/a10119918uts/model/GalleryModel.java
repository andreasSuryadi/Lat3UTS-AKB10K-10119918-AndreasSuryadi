package com.example.a10119918uts.model;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

/**
 *
 * NIM                  : 10119918
 * Nama                 : Andreas Suryadi
 * Kelas                : IF-10K
 * Tanggal Pengerjaan   : 25 Mei 2022
 *
 */

public class GalleryModel {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name ="imagename")
    public String imagename;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImagename() {
        return imagename;
    }

    public void setImagename(String imagename) {
        this.imagename = imagename;
    }
}
