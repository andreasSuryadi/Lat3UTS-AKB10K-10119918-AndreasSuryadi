package com.example.a10119918uts.presenter;

import com.example.a10119918uts.model.DailyActivitiesModel;
import com.example.a10119918uts.view.DailyActivitiesView;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * NIM                  : 10119918
 * Nama                 : Andreas Suryadi
 * Kelas                : IF-10K
 * Tanggal Pengerjaan   : 24 Mei 2022
 *
 */

public class DailyActivitiesPresenterImpl implements DailyActivitiesPresenter {
    private DailyActivitiesView view;

    private List<DailyActivitiesModel> dailyActivities = new ArrayList<>();
    private int no = 10;

    public DailyActivitiesPresenterImpl(DailyActivitiesView view) {
        this.view = view;
        setData();
    }

    @Override
    public void load() {
        view.onLoad(dailyActivities);
    }

    private void setData() {
        DailyActivitiesModel dailyActivity1 = new DailyActivitiesModel();
        dailyActivity1.setId(1);
        dailyActivity1.setAktivitas("07:00 | Bangun Tidur");
        dailyActivity1.setImagename("ic_wake_up");
        dailyActivities.add(dailyActivity1);

        DailyActivitiesModel dailyActivity2 = new DailyActivitiesModel();
        dailyActivity2.setId(2);
        dailyActivity2.setAktivitas("07:30 | Sarapan");
        dailyActivity2.setImagename("ic_breakfast");
        dailyActivities.add(dailyActivity2);

        DailyActivitiesModel dailyActivity3 = new DailyActivitiesModel();
        dailyActivity3.setId(3);
        dailyActivity3.setAktivitas("08:30 | Kerja");
        dailyActivity3.setImagename("ic_working");
        dailyActivities.add(dailyActivity3);

        DailyActivitiesModel dailyActivity4 = new DailyActivitiesModel();
        dailyActivity4.setId(4);
        dailyActivity4.setAktivitas("12:00 | Makan Siang");
        dailyActivity4.setImagename("ic_lunch");
        dailyActivities.add(dailyActivity4);

        DailyActivitiesModel dailyActivity5 = new DailyActivitiesModel();
        dailyActivity5.setId(5);
        dailyActivity5.setAktivitas("16:30 | Pulang Kerja");
        dailyActivity5.setImagename("ic_homepage");
        dailyActivities.add(dailyActivity5);

        DailyActivitiesModel dailyActivity6 = new DailyActivitiesModel();
        dailyActivity6.setId(6);
        dailyActivity6.setAktivitas("17:00 | Makan Malam");
        dailyActivity6.setImagename("ic_dinner");
        dailyActivities.add(dailyActivity6);

        DailyActivitiesModel dailyActivity7 = new DailyActivitiesModel();
        dailyActivity7.setId(7);
        dailyActivity7.setAktivitas("18:00 | Kuliah");
        dailyActivity7.setImagename("ic_college");
        dailyActivities.add(dailyActivity7);

        DailyActivitiesModel dailyActivity8 = new DailyActivitiesModel();
        dailyActivity8.setId(8);
        dailyActivity8.setAktivitas("21:00 | Gaming");
        dailyActivity8.setImagename("ic_game");
        dailyActivities.add(dailyActivity8);

        DailyActivitiesModel dailyActivity9 = new DailyActivitiesModel();
        dailyActivity9.setId(9);
        dailyActivity9.setAktivitas("22:00 | Tidur");
        dailyActivity9.setImagename("ic_sleep");
        dailyActivities.add(dailyActivity9);
    }
}
