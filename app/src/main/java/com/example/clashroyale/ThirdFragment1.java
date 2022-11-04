package com.example.clashroyale;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.bumptech.glide.Glide;
import com.example.clashroyale.databinding.FragmentThirdBinding;

public class ThirdFragment1 extends Fragment {

    private FragmentThirdBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentThirdBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle datos = getArguments();

        if(datos != null){
            Cards card = (Cards) datos.getSerializable("item");

            binding.txtDamage.setText(String.valueOf(card.getDamage()));
            binding.txtHp.setText(String.valueOf(card.getHp()));
            binding.txtSpeed.setText(String.valueOf(card.getSpeed()));
            Glide.with(getContext()).load(card.getImgD()).into(binding.ivCard);
            binding.txtData.setText(String.valueOf(card.getData()));
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}