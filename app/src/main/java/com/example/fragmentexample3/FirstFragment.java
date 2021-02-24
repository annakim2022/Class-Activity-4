package com.example.fragmentexample3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.squareup.picasso.Picasso;

public class FirstFragment extends Fragment {

    View view;
    private static final String villager_url = "https://dodo.ac/np/images/thumb/2/26/Henry_NH.png/300px-Henry_NH.png";
    private static final String house_url = "https://animalcrossingworld.com/wp-content/uploads/2020/05/animal-crossing-new-horizons-guide-villager-house-exterior-henry-trim.png";
    private ImageView imageView_villager;
    private ImageView imageView_house;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_first, container, false);

        imageView_villager = view.findViewById(R.id.imageView_villager);
        imageView_house = view.findViewById(R.id.imageView_house);

        Picasso.get().load(villager_url).into(imageView_villager);
        Picasso.get().load(house_url).into(imageView_house);
        return view;
    }
}
