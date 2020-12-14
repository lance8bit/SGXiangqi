package com.example.sgxiangqi.ui.fragmentplayers;

import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.sgxiangqi.R;
import com.example.sgxiangqi.ui.fragmentxiangqiboard.FragmentXiangQiBoard;

public class FragmentPlayers extends Fragment {

    private FragmentPlayersViewModel mViewModel;
    private Button btColor1, btColor2, btContinue;

    public static FragmentPlayers newInstance() {
        return new FragmentPlayers();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_players, container, false);

        btColor1 = root.findViewById(R.id.buttonPlayer1);
        btColor2 = root.findViewById(R.id.buttonPlayer2);
        btContinue = root.findViewById(R.id.buttonContinue);

        btContinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentXiangQiBoard xiangQiBoard = new FragmentXiangQiBoard();
                Bundle args = new Bundle();

                /*args.putInt(xiangQiBoard.ARG_POSITION, position);
                newFragment.setArguments(args);*/

                FragmentTransaction transaction = getParentFragmentManager().beginTransaction();

                transaction.replace(R.id.container, xiangQiBoard);
                transaction.addToBackStack(null);

                transaction.commit();
            }
        });

        btColor1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Selecciona el color");
                builder.setMessage("Indica el color que quieres jugar");
                builder.setPositiveButton("Rojo", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        btColor1.setText("Rojo");
                        btColor2.setText("Negro");

                        btColor1.setBackgroundColor(Color.parseColor("#FF0000"));
                        btColor2.setBackgroundColor(Color.parseColor("#000000"));

                        btColor1.setTextColor(Color.parseColor("#FFFFFF"));
                        btColor2.setTextColor(Color.parseColor("#FFFFFF"));
                    }
                });
                builder.setNegativeButton("Negro", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        btColor1.setText("Negro");
                        btColor2.setText("Rojo");

                        btColor2.setBackgroundColor(Color.parseColor("#FF0000"));
                        btColor1.setBackgroundColor(Color.parseColor("#000000"));

                        btColor1.setTextColor(Color.parseColor("#FFFFFF"));
                        btColor2.setTextColor(Color.parseColor("#FFFFFF"));
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        btColor2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
                builder.setTitle("Selecciona el color");
                builder.setMessage("Indica el color que quieres jugar");
                builder.setPositiveButton("Rojo", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        btColor1.setText("Negro");
                        btColor2.setText("Rojo");

                        btColor1.setBackgroundColor(Color.parseColor("#000000"));
                        btColor2.setBackgroundColor(Color.parseColor("#FF0000"));

                        btColor1.setTextColor(Color.parseColor("#FFFFFF"));
                        btColor2.setTextColor(Color.parseColor("#FFFFFF"));
                    }
                });
                builder.setNegativeButton("Negro", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        btColor1.setText("Rojo");
                        btColor2.setText("Negro");

                        btColor2.setBackgroundColor(Color.parseColor("#000000"));
                        btColor1.setBackgroundColor(Color.parseColor("#FF0000"));

                        btColor1.setTextColor(Color.parseColor("#FFFFFF"));
                        btColor2.setTextColor(Color.parseColor("#FFFFFF"));
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });

        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(FragmentPlayersViewModel.class);
        // TODO: Use the ViewModel
    }

}