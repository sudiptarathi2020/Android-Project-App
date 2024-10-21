package com.example.myapplication.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.myapplication.Login;
import com.example.myapplication.R;
import com.example.myapplication.databinding.FragmentHomeBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeFragment extends Fragment {
    FirebaseAuth auth;
    Button button;
    TextView textView;
    FirebaseUser firebaseUser;
    private FragmentHomeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel =
                new ViewModelProvider(this).get(HomeViewModel.class);

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();
        auth = FirebaseAuth.getInstance();
        button= root.findViewById(R.id.logout);
        textView=root.findViewById(R.id.user_details);
        firebaseUser= auth.getCurrentUser();
        if(firebaseUser==null){
            Intent intent= new Intent(getActivity(), Login.class);
            startActivity(intent);
            requireActivity().finish();
        }
        button.setOnClickListener(view -> {
            FirebaseAuth.getInstance().signOut();
            Intent intent= new Intent(getActivity(),Login.class);
            startActivity(intent);
            requireActivity().finish();
        });
        final TextView textView = binding.textHome;
        homeViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}