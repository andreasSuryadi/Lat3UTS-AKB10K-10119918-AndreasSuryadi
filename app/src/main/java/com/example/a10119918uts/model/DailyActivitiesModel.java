package com.example.a10119918uts.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 *
 * NIM                  : 10119918
 * Nama                 : Andreas Suryadi
 * Kelas                : IF-10K
 * Tanggal Pengerjaan   : 24 Mei 2022
 *
 */

@Entity
public class DailyActivitiesModel {
    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name ="aktivitas")
    public String aktivitas;

    @ColumnInfo(name ="imagename")
    public String imagename;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAktivitas() {
        return aktivitas;
    }

    public void setAktivitas(String aktivitas) {
        this.aktivitas = aktivitas;
    }

    public String getImagename() {
        return imagename;
    }

    public void setImagename(String imagename) {
        this.imagename = imagename;
    }
}
