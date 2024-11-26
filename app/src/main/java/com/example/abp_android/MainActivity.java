package com.example.abp_android;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorListenerAdapter;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;



public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private TextView textView;
    private boolean status = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Hooks
        imageView = findViewById(R.id.imageView2);
        textView = findViewById(R.id.textView);


        startAnimationAndTransition();


    }
    private void startAnimationAndTransition() {
        // Cargar animación combinada desde XML
        Animator combinedAnimation = AnimatorInflater.loadAnimator(this, R.animator.frontanimator);

        // Establecer objetivo para la imagen
        combinedAnimation.setTarget(imageView);

        // Añadir un listener para manejar el fin de la animación
        combinedAnimation.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                // Transición al fragmento de inicio de sesión
                transitionToLoginFragment();
            }
        });

        // Iniciar la animación combinada
        combinedAnimation.start();
    }

    public void transitionToLoginFragment() {
        // Ocultar elementos de la pantalla inicial
        imageView.setVisibility(View.GONE);
        textView.setVisibility(View.GONE);

        // Reemplazar el contenedor con el fragmento de inicio de sesión
        Fragment loginFragment = new com.example.abp_android.fragments.LoginFragment();
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                .replace(R.id.fragment_container, loginFragment)
                .addToBackStack(null)
                .commit();
    }


    public void navigateToRegisterFragment(){
        Fragment RegisterFrag = new com.example.abp_android.fragments.RegisterFragment();
        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(android.R.anim.fade_in, android.R.anim.fade_out)
                .replace(R.id.fragment_container, RegisterFrag)
                .commit();
    }


    /*
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Comprobar si ya hay un fragmento cargado
        if (savedInstanceState == null) {
            // Cargar el fragmento en el contenedor
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, new ActividadFragment())
                    .commit();
        }
    }

     */
}