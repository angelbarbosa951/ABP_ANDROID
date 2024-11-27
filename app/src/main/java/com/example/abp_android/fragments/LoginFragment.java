package com.example.abp_android.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.abp_android.MainActivity;
import com.example.abp_android.NavigationActivity;
import com.example.abp_android.R;
import com.example.abp_android.utils.Rol;

import com.example.abp_android.adapters.LoginAdaptar;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LoginFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LoginFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LoginFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LoginFragment newInstance(String param1, String param2) {
        LoginFragment fragment = new LoginFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_login, container, false);

        Button loginButton = view.findViewById(R.id.buttonLogin);
        TextView RegisterText = view.findViewById(R.id.textView5);
        EditText inputEmail = view.findViewById(R.id.inputEmail);
        EditText inputPassword = view.findViewById(R.id.inputPassword);

        LoginAdaptar loginHandler = new LoginAdaptar();
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = inputEmail.getText().toString().trim();
                String password = inputPassword.getText().toString().trim();

                if(username.isEmpty()&&password.isEmpty()){
                    Toast.makeText(getActivity(), "Por favor, completa todos los campos", Toast.LENGTH_SHORT).show();
                }else{
                    String rol = loginHandler.autenticar(username,password);
                    if(rol!=null){
                        Toast.makeText(getActivity(), "Inicio de sesión exitoso. Rol: " + rol, Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(requireContext(), NavigationActivity.class);
                        startActivity(intent);

                    }else{
                        Toast.makeText(getActivity(), "Usuario no existe", Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
        RegisterText.setOnClickListener(v -> {
            MainActivity activity = (MainActivity) getActivity();
            if(activity!=null){
                activity.navigateToRegisterFragment();
            }
        });
        return view;
    }
}