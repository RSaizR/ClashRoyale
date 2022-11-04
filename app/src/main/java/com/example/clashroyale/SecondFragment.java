package com.example.clashroyale;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;
import com.example.clashroyale.databinding.FragmentSecondBinding;
import java.util.ArrayList;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private CardsAdapter adapter;
    private ArrayList<Cards> items;
    private CardsViewModel viewModel;
    boolean error = false;
    boolean error2 = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        setHasOptionsMenu(true);
        return binding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {

        items = new ArrayList<>();
        adapter = new CardsAdapter(
                getContext(),
                R.layout.lv_cards_raw,
                R.id.txtcard,
                items
        );

        binding.lvCards.setAdapter(adapter);
        binding.lvCards.setOnItemClickListener(((adapterView, view1, i, l) -> {

            Cards item = (Cards) adapterView.getItemAtPosition(i);
            Bundle datos = new Bundle();

            datos.putSerializable("item", item);
            if (esTablet()){
                NavHostFragment.findNavController(this).navigate(R.id.action_SecondFragment_to_thirdFragment1, datos);
            }else {

                if(error == false){
                    NavHostFragment.findNavController(this).navigate(R.id.action_personajesVista4_self2, datos);
                    binding.buttonSecond.setVisibility(View.VISIBLE);
                }else{

                    error = false;
                    if(error2 = false) {
                        NavHostFragment.findNavController(this).navigate(R.id.action_personajesVista4_self2, datos);
                        Toast.makeText(getContext(), "Pulsa en una carta para ver el resultado", Toast.LENGTH_LONG).show();
                        error2 = true;
                    }else {
                        NavHostFragment.findNavController(this).navigate(R.id.action_firstFragment_to_personajesVista4, datos);
                        binding.buttonSecond.setVisibility(View.VISIBLE);
                    }
                }
            }
        }
        ));

        viewModel = new ViewModelProvider(getActivity()).get(CardsViewModel.class);
        viewModel.getCards().observe(getActivity(), cards -> {
            adapter.clear();
            adapter.addAll(cards);
        });

        viewModel.refresh();

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (esTablet()){
                    NavHostFragment.findNavController(SecondFragment.this)
                            .navigate(R.id.action_SecondFragment_to_FirstFragment);
                }else {
                    NavHostFragment.findNavController(SecondFragment.this).navigate(R.id.action_personajesVista4_to_firstFragment);
                    binding.buttonSecond.setVisibility(View.INVISIBLE);
                    error = true;
                    error2 = true;
                }
            }
        });
        super.onViewCreated(view, savedInstanceState);
    }

    boolean esTablet() {
        return getResources().getBoolean(R.bool.tablet);
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.refresh) {
            Toast.makeText(getContext(), "Refrescando", Toast.LENGTH_LONG).show();
            viewModel.refresh();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    /*public String ordenar(){
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity().getApplicationContext());
        String tipo = preferences.getString("ORDER BY", "");
        return "hp";
    }*/

}

