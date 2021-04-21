package com.example.droidcafe;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class FirstFragment extends Fragment {

    private String mOrderMessage;

    ImageView imgDonut;
    ImageView imgIceCream;
    ImageView imgFroyo;

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

        imgDonut = view.findViewById(R.id.donut);
        imgIceCream = view.findViewById(R.id.ice_cream);
        imgFroyo = view.findViewById(R.id.froyo);

        imgDonut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDonutOrder(v);
            }
        });

        imgIceCream.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showIceCreamOrder(v);
            }
        });

        imgFroyo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showFroyoOrder(v);
            }
        });
    }

    public void displayToast(String message) {
        Toast.makeText(getActivity(), message,
                Toast.LENGTH_SHORT).show();
    }

    /**
     * Shows a message that the donut image was clicked.
     */
    public void showDonutOrder(View view) {
        mOrderMessage = getString(R.string.donut_order_message);
        displayToast(mOrderMessage);
        message(mOrderMessage);
    }

    /**
     * Shows a message that the ice cream sandwich image was clicked.
     */
    public void showIceCreamOrder(View view) {
        mOrderMessage = getString(R.string.ice_cream_order_message);
        displayToast(mOrderMessage);
        message(mOrderMessage);
    }

    /**
     * Shows a message that the froyo image was clicked.
     */
    public void showFroyoOrder(View view) {
        mOrderMessage = getString(R.string.froyo_order_message);
        displayToast(mOrderMessage);
        message(mOrderMessage);
    }

    public void message (String mOrderMessage) {
        Intent intent = new Intent(FirstFragment.this.getActivity(), MainActivity.class);
        intent.putExtra("message", mOrderMessage);
        startActivity(intent);
    }

}