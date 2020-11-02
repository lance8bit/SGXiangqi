package com.example.sgxiangqi.ui.fragmentxiangqiboard;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.sgxiangqi.Pieces.BingZu;
import com.example.sgxiangqi.Pieces.Piece;
import com.example.sgxiangqi.R;
import com.example.sgxiangqi.singletonBoard;

import java.util.ArrayList;

public class FragmentXiangQiBoard extends Fragment {

    private FragmentXiangQiBoardViewModel mViewModel;
    private Button button30, button32, button34, button36, button38, button60, button62, button64, button66, button68;

    public static FragmentXiangQiBoard newInstance() {
        return new FragmentXiangQiBoard();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_xiang_qi_board_fragment, container, false);

        button30 = root.findViewById(R.id.col30);
        button32 = root.findViewById(R.id.col32);
        button34 = root.findViewById(R.id.col34);
        button36 = root.findViewById(R.id.col36);
        button38 = root.findViewById(R.id.col38);

        button60 = root.findViewById(R.id.col60);
        button62 = root.findViewById(R.id.col62);
        button64 = root.findViewById(R.id.col64);
        button66 = root.findViewById(R.id.col66);
        button68 = root.findViewById(R.id.col68);

        button30.setBackgroundResource(R.drawable.ic_black_bingzu);
        button32.setBackgroundResource(R.drawable.ic_black_bingzu);
        button34.setBackgroundResource(R.drawable.ic_black_bingzu);
        button36.setBackgroundResource(R.drawable.ic_black_bingzu);
        button38.setBackgroundResource(R.drawable.ic_black_bingzu);

        button60.setBackgroundResource(R.drawable.ic_red_bingzu);
        button62.setBackgroundResource(R.drawable.ic_red_bingzu);
        button64.setBackgroundResource(R.drawable.ic_red_bingzu);
        button66.setBackgroundResource(R.drawable.ic_red_bingzu);
        button68.setBackgroundResource(R.drawable.ic_red_bingzu);
        button30.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean isBingzu;

                Piece[][] curr = singletonBoard.getNewInstance().getBoard();
                String id_clicked = getResources().getResourceName(view.getId());
                String numberOnly = id_clicked.replaceAll("[^0-9]", "");

                String[] parts = numberOnly.split("");
                int y_pos = Integer.parseInt(parts[0]);
                int x_pos = Integer.parseInt(parts[1]);


            }

        });
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(FragmentXiangQiBoardViewModel.class);
        // TODO: Use the ViewModel
    }

}