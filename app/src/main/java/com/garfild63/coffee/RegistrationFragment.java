package com.garfild63.coffee;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class RegistrationFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_registration, container, false);
        Button button = (Button) v.findViewById(R.id.buttonRegistration);
        button.setOnClickListener(view -> Navigation.findNavController(view).navigate(R.id.action_registrationFragment_to_loginFragment));
        return v;
    }
}