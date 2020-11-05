package com.example.sgxiangqi.ui.fragmentxiangqiboard;

import androidx.lifecycle.ViewModelProviders;

import android.content.res.Resources;
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

import com.example.sgxiangqi.R;

public class FragmentXiangQiBoard extends Fragment implements View.OnClickListener {

    private FragmentXiangQiBoardViewModel mViewModel;
    public static FragmentXiangQiBoard newInstance() {
        return new FragmentXiangQiBoard();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_xiang_qi_board_fragment, container, false);

        Button grid[][] = new Button[8][9];
            for(int i = 0; i < grid.length; i++){
                for(int j = 0; j < grid[i].length; j++){
                    grid[i][j] = new Button(getContext());
                    for (int k = 0; k <= 89 ; k++) {
                        String buttonID = "bt" + k;
                        int resID = getContext().getResources().getIdentifier(buttonID, "id",getContext().getPackageName());

                        grid[i][j] = root.findViewById(resID);
                        grid[i][j].setOnClickListener(this);

                    }
                }
            }
            
        return root;
    }

    @Override
    public void onClick(View view) {
        boolean isBingzu;
        //Piece[][] curr = singletonBoard.getNewInstance().getBoard();
        String id_clicked = String.valueOf(view.getTag());
        String numberOnly = id_clicked.replaceAll("[^0-9]", "");

        String[] parts = numberOnly.split("");
        int y_pos = Integer.parseInt(parts[1]);
        int x_pos = Integer.parseInt(parts[0]);

        Toast.makeText(getContext(), "X: "+x_pos+" Y: "+y_pos, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(FragmentXiangQiBoardViewModel.class);
        // TODO: Use the ViewModel
    }

}