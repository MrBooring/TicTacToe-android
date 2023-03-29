package com.example.tictactoe_android;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.tictactoe_android.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
private final List<int[]> combinationList = new ArrayList<>();
private int[]boxpositions= {0,0,0,0,0,0,0,0,0};
private int playerTurn =1;
private int totalSelectedBox =1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        binding= ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        combinationList.add(new int[]{0,1,2});
        combinationList.add(new int[]{3,4,5});
        combinationList.add(new int[]{6,7,8});
        combinationList.add(new int[]{0,3,6});
        combinationList.add(new int[]{1,4,7});
        combinationList.add(new int[]{2,5,8});
        combinationList.add(new int[]{2,4,6});
        combinationList.add(new int[]{0,4,8});

        String getPlayerOneName = getIntent().getStringExtra("playerOne");
        String getPlayerTwoName = getIntent().getStringExtra("playerTwo");
        Log.d(TAG, "p1 = "+ getPlayerOneName + "\n p2 = " +getPlayerTwoName);
        binding.playerOneName.setText(getPlayerOneName);
        binding.playerTwoName.setText(getPlayerTwoName);


        binding.image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(0)){
                    performAction((ImageView)view ,0);
                }
            }
        });
        binding.image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(1)){
                    performAction((ImageView)view ,1);
                }
            }
        });
        binding.image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(2)){
                    performAction((ImageView)view ,2);
                }
            }
        });
        binding.image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(3)){
                    performAction((ImageView)view ,3);
                }
            }
        });
        binding.image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(4)){
                    performAction((ImageView)view ,4);
                }
            }
        });
        binding.image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(5)){
                    performAction((ImageView)view ,5);
                }
            }
        });
        binding.image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(6)){
                    performAction((ImageView)view ,6);
                }
            }
        });
        binding.image8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(7)){
                    performAction((ImageView)view ,7);
                }
            }
        });
        binding.image9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(8)){
                    performAction((ImageView)view ,8);
                }
            }
        });


    }
    private void performAction(ImageView imageView , int selectedBoxPosition){
        boxpositions[selectedBoxPosition]= playerTurn;
        if(playerTurn ==1 ){
            imageView.setImageResource(R.drawable.ximage);
             if(checkResults()){
                 ResultsDialog resultsDialog = new ResultsDialog(MainActivity.this, binding.playerOneName.getText().toString()+"is a Winner!", MainActivity.this);
               resultsDialog.setCancelable(false);
               resultsDialog.show();

             }else if (totalSelectedBox==9 ){
                 ResultsDialog resultsDialog = new ResultsDialog(MainActivity.this,"Match Draw",MainActivity.this);
                resultsDialog.setCancelable(false);
                resultsDialog.show();
             }
             else {
                 changePlayerTurn(2);
                 totalSelectedBox++;

            }
        }else {
            imageView.setImageResource(R.drawable.oimage);
            if(checkResults()){
                ResultsDialog resultsDialog = new ResultsDialog(MainActivity.this, binding.playerTwoName.getText().toString()+"is a Winner!", MainActivity.this);
                resultsDialog.setCancelable(false);
                resultsDialog.show();

            }else if (totalSelectedBox==9 ){
                ResultsDialog resultsDialog = new ResultsDialog(MainActivity.this,"Match Draw",MainActivity.this);
                resultsDialog.setCancelable(false);
                resultsDialog.show();
            }
            else {
                changePlayerTurn(1);
                totalSelectedBox++;

            }

        }
    }
    private void changePlayerTurn(int currentPlayerTurn){
        playerTurn = currentPlayerTurn;
        if(playerTurn ==1){
            binding.playerOneLayout.setBackgroundResource(R.drawable.black_border);
            binding.playerTwoLayout.setBackgroundResource(R.drawable.white_box);

        }else {
            binding.playerTwoLayout.setBackgroundResource(R.drawable.black_border);
            binding.playerOneLayout.setBackgroundResource(R.drawable.white_box);
        }

    }
    private boolean checkResults(){
        boolean response = false;
        for(int i = 0;i<combinationList.size();i++){
            final int[] combination = combinationList.get(i);
            if(     boxpositions[combination[0]]== playerTurn &&
                    boxpositions[combination[1]]==playerTurn &&
                    boxpositions[combination[2]]==playerTurn ){
                response = true;

            }

        }
        return response;
    }

    private boolean isBoxSelectable(int boxPosition){
        boolean response = false;
        if(boxpositions[boxPosition]== 0){
            response = true;
        }
        return response;
    }
    public void restartMatch(){
        boxpositions = new int[]{0,0,0,0,0,0,0,0,0};
         playerTurn =1 ;
         totalSelectedBox = 1;
            binding.image1.setImageResource(R.drawable.white_box);
            binding.image2.setImageResource(R.drawable.white_box);
            binding.image3.setImageResource(R.drawable.white_box);
            binding.image4.setImageResource(R.drawable.white_box);
            binding.image5.setImageResource(R.drawable.white_box);
            binding.image6.setImageResource(R.drawable.white_box);
            binding.image7.setImageResource(R.drawable.white_box);
            binding.image8.setImageResource(R.drawable.white_box);
            binding.image9.setImageResource(R.drawable.white_box);



    }
}
























