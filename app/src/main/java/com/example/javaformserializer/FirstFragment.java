package com.example.javaformserializer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;


public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        GrowthStage[] stages = GrowthStage.values();
        String[] stagesStrings = new String[(stages.length + 1)];
        stagesStrings[0] = " ";
        for(int i=1;i<stagesStrings.length;i++){
            stagesStrings[i] = stages[i-1].getName();
        }

        Spinner stagesOptions = view.findViewById(R.id.stageOptions);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity().getApplicationContext(),
                android.R.layout.simple_spinner_dropdown_item ,
                stagesStrings);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        stagesOptions.setAdapter(adapter);

        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });
    }
}