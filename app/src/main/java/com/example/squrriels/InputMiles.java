package com.example.squrriels;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;

public class InputMiles extends Fragment {
    DataReadIn data = new DataReadIn(this.getActivity());
    ArrayList<Car> cars = data.readCarData();
    double gallons = 0;


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

        view.findViewById(R.id.btn_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //NavHostFragment.findNavController(InputMiles.this)
                        //.navigate(R.id.action_logInPage_to_homePage);

                EditText txtCarBrand = getActivity().findViewById(R.id.txt_car_brand);
                EditText txtCarModel = getActivity().findViewById(R.id.txt_car_model);
                EditText txtMiles = getActivity().findViewById(R.id.txt_miles);

                String brand = txtCarBrand.getEditableText().toString();
                String model = txtCarModel.getEditableText().toString();
                String miles = txtMiles.getEditableText().toString();
                double mile = 0;
                if(!miles.equals("")){
                    mile = Double.parseDouble(miles);
                }

                for(int i = 0; i <= cars.size(); i++){
                    Car currentCar = cars.get(i);
                    if(brand.equals(currentCar.brand) && model.equals(currentCar.maker)){
                        gallons = mile / currentCar.emission;
                    }
                }

            }
        });
    }
}