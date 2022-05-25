package com.example.a10119918uts.ui.profile;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.a10119918uts.databinding.FragmentProfileBinding;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

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

public class ProfileFragment extends Fragment implements OnMapReadyCallback {
    private FragmentProfileBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ProfileViewModel profileViewModel = new ViewModelProvider(this).get(ProfileViewModel.class);

        binding = FragmentProfileBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        TextView igText = binding.profileInstagram;
        igText.setOnClickListener(view -> {
            Uri uri = Uri.parse("https://www.instagram.com/_u/andreas_suryadi/");
            Intent likeIng = new Intent(Intent.ACTION_VIEW, uri);

            likeIng.setPackage("com.instagram.android");

            try {
                startActivity(likeIng);
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://instagram.com/andreas_suryadi")));
            }
        });

        TextView emailText = binding.profileEmail;
        emailText.setOnClickListener(view -> {
            Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                    "mailto","andreas.suryadi02@gmail.com", null));
            startActivity(Intent.createChooser(intent, "Choose an Email client :"));
        });

        TextView waText = binding.profileWhatsapp;
        waText.setOnClickListener(view -> {
            String url = "https://api.whatsapp.com/send?phone=+6282115865981";
            Intent i = new Intent(Intent.ACTION_VIEW);
            i.setData(Uri.parse(url));
            startActivity(i);
        });

        return root;
    }

    @Override
    public void onMapReady(GoogleMap googleMap){
        LatLngBounds.Builder builder = new LatLngBounds.Builder();
        List<Marker> markers = new ArrayList<>();
        markers.add(googleMap.addMarker(new MarkerOptions()
                .position(new LatLng(-6.932876844601817, 107.602243268278))
                .title("Rumah")));
        for (Marker m: markers){
            builder.include(m.getPosition());
        }
        LatLngBounds bounds = builder.build();

        int padding = 0;
        CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(bounds,512,200,padding);

        googleMap.moveCamera(cu);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
