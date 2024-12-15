package com.example.centralacademy;

import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.card.MaterialCardView;

public class HomeFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Get screen width
        int screenWidth = Resources.getSystem().getDisplayMetrics().widthPixels;

        // Find your MaterialCardViews and set their width
        MaterialCardView cardView1 = view.findViewById(R.id.cardView1);
        MaterialCardView cardView2 = view.findViewById(R.id.cardView2);

        if (cardView1 != null) {
            ViewGroup.LayoutParams params1 = cardView1.getLayoutParams();
            params1.width = screenWidth;
            cardView1.setLayoutParams(params1);
        }

        if (cardView2 != null) {
            ViewGroup.LayoutParams params2 = cardView2.getLayoutParams();
            params2.width = screenWidth;
            cardView2.setLayoutParams(params2);
        }
    }

}