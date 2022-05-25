package com.example.a10119918uts.ui.profile;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

/**
 *
 * NIM                  : 10119918
 * Nama                 : Andreas Suryadi
 * Kelas                : IF-10K
 * Tanggal Pengerjaan   : 25 Mei 2022
 *
 */

public class ProfileViewModel extends ViewModel {
    private final MutableLiveData<String> mText;

    public ProfileViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is profile fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}
