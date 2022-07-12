package com.garfild63.coffee;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
import android.widget.EditText;
import android.widget.Toast;

import java.util.Objects;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RegistrationFragment extends Fragment {

    private static final String BASE_URL = "http://185.244.172.108:8080/";

=======
=======
>>>>>>> 5b2d7d6d53763c8eeac1c4a0eebed2804287acd7
=======
>>>>>>> 5b2d7d6d53763c8eeac1c4a0eebed2804287acd7
=======
>>>>>>> 5b2d7d6d53763c8eeac1c4a0eebed2804287acd7

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class RegistrationFragment extends Fragment {

<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 5b2d7d6d53763c8eeac1c4a0eebed2804287acd7
=======
>>>>>>> 5b2d7d6d53763c8eeac1c4a0eebed2804287acd7
=======
>>>>>>> 5b2d7d6d53763c8eeac1c4a0eebed2804287acd7
=======
>>>>>>> 5b2d7d6d53763c8eeac1c4a0eebed2804287acd7
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_registration, container, false);
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        EditText editTextEmail = (EditText) v.findViewById(R.id.editTextEmail);
        EditText editTextPassword = (EditText) v.findViewById(R.id.editTextPassword);
        EditText editTextRepeatPassword = (EditText) v.findViewById(R.id.editTextRepeatPassword);
        Button button = (Button) v.findViewById(R.id.buttonRegistration);
        button.setOnClickListener(view -> {
            String email = editTextEmail.getText().toString();
            String password = editTextPassword.getText().toString();
            String repeatPassword = editTextRepeatPassword.getText().toString();
            if (password.equals(repeatPassword)) {
                /* Retrofit retrofit = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                UserService service = retrofit.create(UserService.class);
                Call<User> call = service.registerUser(new User(email, password));
                call.enqueue(new Callback<User>() {
                    @Override
                    public void onResponse(@NonNull Call<User> call, @NonNull Response<User> response) {
                        if (response.isSuccessful()) {
                            Toast.makeText(getActivity(), Objects.requireNonNull(response.body()).getToken(), Toast.LENGTH_SHORT).show();
                        } else {
                            switch (response.code()) {
                                case 400:
                                    Toast.makeText(getActivity(), "Ошибка в запросе", Toast.LENGTH_SHORT).show();
                                    break;
                                case 406:
                                    Toast.makeText(getActivity(), "Такой логин уже используется", Toast.LENGTH_SHORT).show();
                                    break;
                            }
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<User> call, @NonNull Throwable t) {
                        Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }); */
                Navigation.findNavController(view).navigate(R.id.action_registrationFragment_to_loginFragment);
            } else {
                Toast.makeText(getActivity(), "Пароли не совпадают!", Toast.LENGTH_SHORT).show();
            }
        });
=======
        Button button = (Button) v.findViewById(R.id.buttonRegistration);
        button.setOnClickListener(view -> Navigation.findNavController(view).navigate(R.id.action_registrationFragment_to_loginFragment));
>>>>>>> 5b2d7d6d53763c8eeac1c4a0eebed2804287acd7
=======
        Button button = (Button) v.findViewById(R.id.buttonRegistration);
        button.setOnClickListener(view -> Navigation.findNavController(view).navigate(R.id.action_registrationFragment_to_loginFragment));
>>>>>>> 5b2d7d6d53763c8eeac1c4a0eebed2804287acd7
=======
        Button button = (Button) v.findViewById(R.id.buttonRegistration);
        button.setOnClickListener(view -> Navigation.findNavController(view).navigate(R.id.action_registrationFragment_to_loginFragment));
>>>>>>> 5b2d7d6d53763c8eeac1c4a0eebed2804287acd7
=======
        Button button = (Button) v.findViewById(R.id.buttonRegistration);
        button.setOnClickListener(view -> Navigation.findNavController(view).navigate(R.id.action_registrationFragment_to_loginFragment));
>>>>>>> 5b2d7d6d53763c8eeac1c4a0eebed2804287acd7
        return v;
    }
}