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

import com.example.sgxiangqi.Pieces.BingZu;
import com.example.sgxiangqi.Pieces.Piece;
import com.example.sgxiangqi.Position;
import com.example.sgxiangqi.R;
import com.example.sgxiangqi.singletonBoard;

import java.util.ArrayList;

public class FragmentXiangQiBoard extends Fragment implements View.OnClickListener {

    private FragmentXiangQiBoardViewModel mViewModel;
    public static FragmentXiangQiBoard newInstance() {
        return new FragmentXiangQiBoard();
    }
    private Piece[][] board;
    private ArrayList<Button> grid;
    private int count = 0, x_sel, y_sel;
    private boolean move;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_xiang_qi_board_fragment, container, false);

        grid = new ArrayList<Button>();
        board = singletonBoard.getNewInstance().getBoard();

        for (int i = 0; i < 90; i++) {
            grid.add(i, new Button(getContext()));
            String buttonID = "bt" + i;
            int resID = getContext().getResources().getIdentifier(buttonID, "id",getContext().getPackageName());
            grid.set(i, (Button) root.findViewById(resID));
            grid.get(i).setOnClickListener(this);
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

        if(board[x_pos][y_pos] != null){
            //Toast.makeText(getContext(), "OBJ X:" + board[x_pos][y_pos].getPosition().getX_pos() + " OBJ Y:"+board[x_pos][y_pos].getPosition().getY_pos(), Toast.LENGTH_SHORT).show();
            Toast.makeText(getContext(), "PIECE: "+ board[x_pos][y_pos].getLabel() , Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getContext(), "EMPTY CELL", Toast.LENGTH_SHORT).show();
        }

        pos(x_pos, y_pos);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(FragmentXiangQiBoardViewModel.class);
        // TODO: Use the ViewModel
    }

    public void setBackgrounds(){

        for (int i = 0; i < grid.size(); i++) {
            grid.get(i).getTag();
            Log.i("TAGBTCLI", ": "+grid.get(i).getTag());

            String numberOnly = grid.get(i).getTag().toString();

            String[] parts = numberOnly.split("");
            int y_pos = Integer.parseInt(parts[1]);
            int x_pos = Integer.parseInt(parts[0]);

            Log.i("PIECES", "X: "+x_pos);
            Log.i("PIECES", "Y: "+y_pos);

            if(board[x_pos][y_pos] != null){

                if(board[x_pos][y_pos].getSide() == true){
                    switch (board[x_pos][y_pos].getLabel()){
                        case "BingZu":
                            grid.get(i).setBackgroundResource(R.drawable.ic_black_bingzu);
                            break;
                        case "Pao":
                            grid.get(i).setBackgroundResource(R.drawable.ic_black_pao);
                            break;
                        case "JiangShuai":
                            grid.get(i).setBackgroundResource(R.drawable.ic_black_jiang_shuai);
                            break;
                        case "Shi":
                            grid.get(i).setBackgroundResource(R.drawable.ic_black_shi);
                            break;
                        case "Xiang":
                            grid.get(i).setBackgroundResource(R.drawable.ic_black_xiang);
                            break;
                        case "Ma":
                            grid.get(i).setBackgroundResource(R.drawable.ic_black_ma);
                            break;
                        case "Che":
                            grid.get(i).setBackgroundResource(R.drawable.ic_black_che);
                            break;
                    }
                } else {
                    switch (board[x_pos][y_pos].getLabel()){
                        case "BingZu":
                            grid.get(i).setBackgroundResource(R.drawable.ic_red_bingzu);
                            break;
                        case "Pao":
                            grid.get(i).setBackgroundResource(R.drawable.ic_red_pao);
                            break;
                        case "JiangShuai":
                            grid.get(i).setBackgroundResource(R.drawable.ic_red_jianq_shuai);
                            break;
                        case "Shi":
                            grid.get(i).setBackgroundResource(R.drawable.ic_red_shi);
                            break;
                        case "Xiang":
                            grid.get(i).setBackgroundResource(R.drawable.ic_red_xiang);
                            break;
                        case "Ma":
                            grid.get(i).setBackgroundResource(R.drawable.ic_red_ma);
                            break;
                        case "Che":
                            grid.get(i).setBackgroundResource(R.drawable.ic_red_che);
                            break;
                    }
                }

                Log.i("TRYGETLABEL", "setBackgrounds: "+board[x_pos][y_pos].getLabel());
            } else {
                grid.get(i).setBackgroundResource(R.drawable.transparent_button);
            }
        }
    }

    public void pos(int xs, int ys){
        if(move){
            board[xs][ys] = board[x_sel][y_sel];
            board[x_sel][y_sel] = null;
            setBackgrounds();
            move = false;
        } else {
            x_sel = xs;
            y_sel = ys;
            move = true;
        }
    }
}