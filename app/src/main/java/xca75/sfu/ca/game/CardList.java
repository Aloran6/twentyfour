package xca75.sfu.ca.game;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class CardList implements Serializable {

    private ArrayList<Cards> mCardList = new ArrayList<>();
    private Context mContext;

    public CardList(){
        addNewCard(pickRandomNumber(),pickRandomsuit());
        addNewCard(pickRandomNumber(),pickRandomsuit());
        addNewCard(pickRandomNumber(),pickRandomsuit());
        addNewCard(pickRandomNumber(),pickRandomsuit());
    }

    public int pickRandomNumber(){
        int random = ThreadLocalRandom.current().nextInt(1,10+1);
        return random;
    }

    public int pickRandomsuit(){
        int random = ThreadLocalRandom.current().nextInt(0,3+1);
        return random;
    }

    public void addNewCard(int number, int suit){
        mCardList.add(mCardList.size(), new Cards(number, suit));
    }

    public int getCardNumber(int index){
        return mCardList.get(index).getNumber();
    }

    public int getCardSuit(int index){
        return mCardList.get(index).getSuit();
    }

    public void setCardNumber(int index, int newNumber){
        mCardList.get(index).setNumber(newNumber);
    }

    public void setCardSuit(int index, int newsuit){
        mCardList.get(index).setSuit(newsuit);
    }

    public void shuffle(){
        for(int i = 0; i < mCardList.size(); i++){
            mCardList.get(i).setNumber(pickRandomNumber());
            mCardList.get(i).setSuit(pickRandomsuit());
        }
    }
}
