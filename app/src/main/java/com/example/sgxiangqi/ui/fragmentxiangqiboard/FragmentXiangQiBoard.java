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

import com.example.sgxiangqi.Pieces.Piece;
import com.example.sgxiangqi.R;
import com.example.sgxiangqi.singletonBoard;

import java.util.ArrayList;

public class FragmentXiangQiBoard extends Fragment implements View.OnClickListener {

    private FragmentXiangQiBoardViewModel mViewModel;
    public static FragmentXiangQiBoard newInstance() {
        return new FragmentXiangQiBoard();
    }
    private Piece[][] board;
    private Button grid[][] = new Button[9][10];

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_xiang_qi_board_fragment, container, false);

        board = singletonBoard.getNewInstance().getBoard();

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                grid[i][j] = new Button(getContext());
                for (int k = 0; k < 90 ; k++) {
                    String buttonID = "bt" + k;
                    Log.i("BUTTONS", "id:" + buttonID);
                    int resID = getContext().getResources().getIdentifier(buttonID, "id",getContext().getPackageName());
                    grid[i][j] = root.findViewById(resID);
                    grid[i][j].setOnClickListener(this);
                }
            }
        }
        setBackgrounds();
            
        return root;
    }

    @Override
    public void onClick(View view) {

        String id_clicked = String.valueOf(view.getTag());
        String numberOnly = id_clicked.replaceAll("[^0-9]", "");

        String[] parts = numberOnly.split("");
        int y_pos = Integer.parseInt(parts[1]);
        int x_pos = Integer.parseInt(parts[0]);

        //Toast.makeText(getContext(), "X: "+x_pos+" Y: "+y_pos, Toast.LENGTH_SHORT).show();
        if(board[x_pos][y_pos] != null){
            Toast.makeText(getContext(), "OBJ X:" + board[x_pos][y_pos].getPosition().getX_pos() + " OBJ Y:"+board[x_pos][y_pos].getPosition().getY_pos(), Toast.LENGTH_SHORT).show();
            Toast.makeText(getContext(), "PIECE: "+ board[x_pos][y_pos].getLabel() , Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getContext(), "EMPTY CELL", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(FragmentXiangQiBoardViewModel.class);
        // TODO: Use the ViewModel
    }

    public void setBackgrounds(){
        for(int k = 0; k < grid.length; k++){
            for(int l = 0; l < grid[k].length; l++){
                grid[k][l].setBackgroundResource(R.drawable.ic_black_bingzu);
            }
        }

        /*

        for(int i = 0; i < grid.length;i++){
            Log.i("GRIDX", "LENGHT X:"+grid.length);
            Log.i("VARX", "setBackgrounds X: "+ i);
            for (int j = 0; j < grid[i].length; j++){
                Log.i("GRIDY", "LENGHT Y:"+grid[i].length);
                Log.i("VARY", "setBackgrounds Y: "+ j);
                grid[i][j].setBackgroundResource(R.drawable.ic_black_bingzu);
                Log.i("CURBACK", "VAR X: " + i + " VAR Y: " +  j);

                if(board[i][j] != null && j < 5){
                    if(board[i][j].getLabel() == "BingZu") {
                        grid[i][j].setBackgroundResource(R.drawable.ic_black_bingzu);
                    }
                } else if (board[i][j] != null && j > 5){
                    if(board[i][j].getLabel() == "BingZu") {
                        grid[i][j].setBackgroundResource(R.drawable.ic_red_bingzu);
                    }
                }

            }
        }

        */
    }

}