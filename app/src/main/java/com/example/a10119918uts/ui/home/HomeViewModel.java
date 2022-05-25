package com.example.a10119918uts.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 *
 * NIM                  : 10119918
 * Nama                 : Andreas Suryadi
 * Kelas                : IF-10K
 * Tanggal Pengerjaan   : 22 Mei 2022
 *
 */

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public HomeViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is home fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}