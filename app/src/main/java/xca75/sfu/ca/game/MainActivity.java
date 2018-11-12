package xca75.sfu.ca.game;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button mShuffle;
    private Button mPlay;
    private TextView mTest1;
    private TextView mTest2;
    private TextView mTest3;
    private TextView mTest4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final CardList testCard = new CardList();
        int a = testCard.getCardSuit(1);
        int b = testCard.getCardNumber(3);

        mTest1 = findViewById(R.id.card_1);
        mTest2 = findViewById(R.id.card_2);
        mTest3 = findViewById(R.id.card_3);
        mTest4 = findViewById(R.id.card_4);

        mShuffle = findViewById(R.id.shuffle);
        mShuffle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                testCard.shuffle();
                mTest1.setText("number: " + testCard.getCardNumber(0) + "Suit: " +testCard.getCardSuit(0));
                mTest2.setText("number: " + testCard.getCardNumber(1) + "Suit: " +testCard.getCardSuit(1));
                mTest3.setText("number: " + testCard.getCardNumber(2) + "Suit: " +testCard.getCardSuit(2));
                mTest4.setText("number: " + testCard.getCardNumber(3) + "Suit: " +testCard.getCardSuit(3));
            }
        });

        mPlay = findViewById(R.id.play);
        mPlay.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent startTableActivity = new Intent(MainActivity.this, TableActivity.class);
                startActivity(startTableActivity);
            }
        });


    }
}
