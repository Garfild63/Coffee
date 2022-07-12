package com.garfild63.coffee;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
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

public class LoginFragment extends Fragment {

    private static final String BASE_URL = "http://185.244.172.108:8080/";

=======
=======
>>>>>>> 5b2d7d6d53763c8eeac1c4a0eebed2804287acd7
=======
>>>>>>> 5b2d7d6d53763c8eeac1c4a0eebed2804287acd7

import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

public class LoginFragment extends Fragment {

<<<<<<< HEAD
<<<<<<< HEAD
>>>>>>> 5b2d7d6d53763c8eeac1c4a0eebed2804287acd7
=======
>>>>>>> 5b2d7d6d53763c8eeac1c4a0eebed2804287acd7
=======
>>>>>>> 5b2d7d6d53763c8eeac1c4a0eebed2804287acd7
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, container, false);
<<<<<<< HEAD
<<<<<<< HEAD
<<<<<<< HEAD
        EditText editTextEmail = (EditText) v.findViewById(R.id.editTextEmail);
        EditText editTextPassword = (EditText) v.findViewById(R.id.editTextPassword);
        Button button = (Button) v.findViewById(R.id.buttonLogin);
        button.setOnClickListener(view -> {
            String email = editTextEmail.getText().toString();
            String password = editTextPassword.getText().toString();
            /* Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            UserService service = retrofit.create(UserService.class);
            Call<User> call = service.loginUser(new User(email, password));
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
                            case 404:
                                Toast.makeText(getActivity(), "Пользователь не существует", Toast.LENGTH_SHORT).show();
                                break;
                        }
                    }
                }

                @Override
                public void onFailure(@NonNull Call<User> call, @NonNull Throwable t) {
                    Toast.makeText(getActivity(), t.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }); */
            Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_listFragment);
        });
=======
        Button button = (Button) v.findViewById(R.id.buttonLogin);
        button.setOnClickListener(view -> Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_listFragment));
>>>>>>> 5b2d7d6d53763c8eeac1c4a0eebed2804287acd7
=======
        Button button = (Button) v.findViewById(R.id.buttonLogin);
        button.setOnClickListener(view -> Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_listFragment));
>>>>>>> 5b2d7d6d53763c8eeac1c4a0eebed2804287acd7
=======
        Button button = (Button) v.findViewById(R.id.buttonLogin);
        button.setOnClickListener(view -> Navigation.findNavController(view).navigate(R.id.action_loginFragment_to_listFragment));
>>>>>>> 5b2d7d6d53763c8eeac1c4a0eebed2804287acd7
        return v;
    }
}