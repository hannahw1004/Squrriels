package com.example.squrriels;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class InputMiles extends Fragment {
    double gallons = 0;
    double carbonDioxide = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_input_miles, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        DataReadIn data = new DataReadIn(this.getContext());
        ArrayList<Car> cars = data.readCarData();

        view.findViewById(R.id.btn_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText txtCarBrand = getActivity().findViewById(R.id.txt_car_brand);
                EditText txtCarModel = getActivity().findViewById(R.id.txt_car_model);
                EditText txtMiles = getActivity().findViewById(R.id.txt_miles);
                EditText txtDate = getActivity().findViewById(R.id.txt_year);

                String brand = txtCarBrand.getEditableText().toString();
                String model = txtCarModel.getEditableText().toString();
                String miles = txtMiles.getEditableText().toString();

                double mile = 0;
                if(!miles.equals("")){
                    mile = Double.parseDouble(miles);
                }

                for(int i = 0; i < cars.size(); i++){
                    Car currentCar = cars.get(i);
                    String car = currentCar.brand;
                    String maker = currentCar.maker;
                    if(brand.equalsIgnoreCase(car) && model.equalsIgnoreCase(maker)){
                        gallons = mile / currentCar.emission;
                    }else{

                    }
                }

                carbonDioxide = gallons * 8.8887;

                if(carbonDioxide <= 20){
                    NavHostFragment.findNavController(InputMiles.this)
                           .navigate(R.id.action_inputMiles_to_resultHappy);
                }else if(carbonDioxide < 50){
                    NavHostFragment.findNavController(InputMiles.this)
                            .navigate(R.id.action_inputMiles_to_resultMad);
                }else if (carbonDioxide >= 50){
                    NavHostFragment.findNavController(InputMiles.this)
                            .navigate(R.id.action_inputMiles_to_resultDead);
                }

                txtCarBrand.setText("");
                txtCarModel.setText("");
                txtMiles.setText("");
                txtDate.setText("");


//                    NavHostFragment.findNavController(InputMiles.this)
//                            .navigate(R.id.action_inputMiles_to_resultHappy);


            }
        });
    }
}