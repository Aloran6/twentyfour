package xca75.sfu.ca.game;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class TableActivity extends AppCompatActivity {

    private CardList mHand;
    private Button mRefresh;

//    CARD 1
    private ConstraintLayout mCard1;
    private TextView mCard1_TopNumber;
    private TextView mCard1_BottomNumber;
    private ImageView mCard1_TopSuit;
    private ImageView mCard1_MiddleSuit;
    private ImageView mCard1_BottomSuit;

//    CARD 2
    private ConstraintLayout mCard2;
    private TextView mCard2_TopNumber;
    private TextView mCard2_BottomNumber;
    private ImageView mCard2_TopSuit;
    private ImageView mCard2_MiddleSuit;
    private ImageView mCard2_BottomSuit;

//    CARD 3
    private ConstraintLayout mCard3;
    private TextView mCard3_TopNumber;
    private TextView mCard3_BottomNumber;
    private ImageView mCard3_TopSuit;
    private ImageView mCard3_MiddleSuit;
    private ImageView mCard3_BottomSuit;

//    CARD 4
    private ConstraintLayout mCard4;
    private TextView mCard4_TopNumber;
    private TextView mCard4_BottomNumber;
    private ImageView mCard4_TopSuit;
    private ImageView mCard4_MiddleSuit;
    private ImageView mCard4_BottomSuit;

//    OPERATORS
    private Button mPlus;
    private Button mMinus;
    private Button mMultiply;
    private Button mDivide;

    private Integer mResult1;
    private Integer mResult2;
    private Integer mResult3;
    private Integer mResult4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_table);

        mHand = new CardList();
        mRefresh = findViewById(R.id.refresh);

        mCard1 = findViewById(R.id.card_1);
        mCard1_TopNumber = findViewById(R.id.card_1_top_number);
        mCard1_BottomNumber = findViewById(R.id.card_1_bottom_number);
        mCard1_TopSuit = findViewById(R.id.card_1_top_suit);
        mCard1_MiddleSuit = findViewById(R.id.card_1_middle_suit);
        mCard1_BottomSuit = findViewById(R.id.card_1_bottom_suit);

        mCard2 = findViewById(R.id.card_2);
        mCard2_TopNumber = findViewById(R.id.card_2_top_number);
        mCard2_BottomNumber = findViewById(R.id.card_2_bottom_number);
        mCard2_TopSuit = findViewById(R.id.card_2_top_suit);
        mCard2_MiddleSuit = findViewById(R.id.card_2_middle_suit);
        mCard2_BottomSuit = findViewById(R.id.card_2_bottom_suit);

        mCard3 = findViewById(R.id.card_3);
        mCard3_TopNumber = findViewById(R.id.card_3_top_number);
        mCard3_BottomNumber = findViewById(R.id.card_3_bottom_number);
        mCard3_TopSuit = findViewById(R.id.card_3_top_suit);
        mCard3_MiddleSuit = findViewById(R.id.card_3_middle_suit);
        mCard3_BottomSuit = findViewById(R.id.card_3_bottom_suit);

        mCard4 = findViewById(R.id.card_4);
        mCard4_TopNumber = findViewById(R.id.card_4_top_number);
        mCard4_BottomNumber = findViewById(R.id.card_4_bottom_number);
        mCard4_TopSuit = findViewById(R.id.card_4_top_suit);
        mCard4_MiddleSuit = findViewById(R.id.card_4_middle_suit);
        mCard4_BottomSuit = findViewById(R.id.card_4_bottom_suit);

        mPlus = findViewById(R.id.plus);
        mMinus = findViewById(R.id.minus);
        mMultiply = findViewById(R.id.multiply);
        mDivide = findViewById(R.id.divide);

        updateEverything();

        mRefresh.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                resetHand();
                updateEverything();
            }
        });

    }

    public Drawable updateSuit(int cardIndex){
        Drawable spades = ContextCompat.getDrawable(this, R.drawable.spades);
        Drawable hearts = ContextCompat.getDrawable(this, R.drawable.hearts);
        Drawable clubs = ContextCompat.getDrawable(this, R.drawable.clubs);
        Drawable diamonds = ContextCompat.getDrawable(this, R.drawable.diamonds);
        if (mHand.getCardSuit(cardIndex) == 0){
            return spades;
        }
        else if (mHand.getCardSuit(cardIndex) == 1){
            return hearts;
        }
        else if (mHand.getCardSuit(cardIndex) == 2){
            return clubs;
        }
        else{
            return diamonds;
        }
    }

    public void updateAllSuits(){
        Drawable card1Suit = updateSuit(0);
        Drawable card2Suit = updateSuit(1);
        Drawable card3Suit = updateSuit(2);
        Drawable card4Suit = updateSuit(3);

        mCard1_TopSuit.setImageDrawable(card1Suit);
        mCard1_MiddleSuit.setImageDrawable(card1Suit);
        mCard1_BottomSuit.setImageDrawable(card1Suit);

        mCard2_TopSuit.setImageDrawable(card2Suit);
        mCard2_MiddleSuit.setImageDrawable(card2Suit);
        mCard2_BottomSuit.setImageDrawable(card2Suit);

        mCard3_TopSuit.setImageDrawable(card3Suit);
        mCard3_MiddleSuit.setImageDrawable(card3Suit);
        mCard3_BottomSuit.setImageDrawable(card3Suit);

        mCard4_TopSuit.setImageDrawable(card4Suit);
        mCard4_MiddleSuit.setImageDrawable(card4Suit);
        mCard4_BottomSuit.setImageDrawable(card4Suit);
    }

    public String updateNumberColor(int cardNumber){
        if(mHand.getCardSuit(cardNumber) %2 == 0){
            return "#FFFFFF";
        }
        else{
            return "#FF0000";
        }
    }

    public void updateAllNumbers(){
        int card1Number = mHand.getCardNumber(0);
        String card1Color = updateNumberColor(0);
        int card2Number = mHand.getCardNumber(1);
        String card2Color = updateNumberColor(1);
        int card3Number = mHand.getCardNumber(2);
        String card3Color = updateNumberColor(2);
        int card4Number = mHand.getCardNumber(3);
        String card4Color = updateNumberColor(3);

        mCard1_TopNumber.setText(String.valueOf(card1Number));
        mCard1_TopNumber.setTextColor(Color.parseColor(card1Color));
        mCard1_BottomNumber.setText(String.valueOf(card1Number));
        mCard1_BottomNumber.setTextColor(Color.parseColor(card1Color));

        mCard2_TopNumber.setText(String.valueOf(card2Number));
        mCard2_TopNumber.setTextColor(Color.parseColor(card2Color));
        mCard2_BottomNumber.setText(String.valueOf(card2Number));
        mCard2_BottomNumber.setTextColor(Color.parseColor(card2Color));

        mCard3_TopNumber.setText(String.valueOf(card3Number));
        mCard3_TopNumber.setTextColor(Color.parseColor(card3Color));
        mCard3_BottomNumber.setText(String.valueOf(card3Number));
        mCard3_BottomNumber.setTextColor(Color.parseColor(card3Color));

        mCard4_TopNumber.setText(String.valueOf(card4Number));
        mCard4_TopNumber.setTextColor(Color.parseColor(card4Color));
        mCard4_BottomNumber.setText(String.valueOf(card4Number));
        mCard4_BottomNumber.setTextColor(Color.parseColor(card4Color));

    }

    public void updateEverything(){
        updateAllSuits();
        updateAllNumbers();
    }

    public void resetHand(){
        int card1Number = mHand.pickRandomNumber();
        int card1Suit = mHand.pickRandomsuit();

        int card2Number = mHand.pickRandomNumber();
        int card2Suit = mHand.pickRandomsuit();

        int card3Number = mHand.pickRandomNumber();
        int card3Suit = mHand.pickRandomsuit();

        int card4Number = mHand.pickRandomNumber();
        int card4Suit = mHand.pickRandomsuit();

        mHand.setCardNumber(0,card1Number);
        mHand.setCardSuit(0, card1Suit);

        mHand.setCardNumber(1,card2Number);
        mHand.setCardSuit(1, card2Suit);

        mHand.setCardNumber(2,card3Number);
        mHand.setCardSuit(2, card3Suit);

        mHand.setCardNumber(3,card4Number);
        mHand.setCardSuit(3, card4Suit);
    }


}
