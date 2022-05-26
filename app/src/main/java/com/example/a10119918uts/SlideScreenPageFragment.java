package com.example.a10119918uts;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

/**
 *
 * NIM                  : 10119918
 * Nama                 : Andreas Suryadi
 * Kelas                : IF-10K
 * Tanggal Pengerjaan   : 26 Mei 2022
 *
 */

public class SlideScreenPageFragment extends Fragment {
    private ViewGroup vGroup;
    private Button mButton;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        vGroup = (ViewGroup) inflater.inflate(
                R.layout.fragment_slide_screen_page, container, false);

        mButton = vGroup.findViewById(R.id.starthere);
        mButton.setOnClickListener(view -> {
            startActivity(new Intent(getActivity(),MainActivity.class));
        });

        return vGroup;
    }
}
