package xca75.sfu.ca.game;

public class Cards {

    private Integer mNumber;
    private Integer mSuit; /*0 = spades, 1 = hearts, 2 = clubs, 3 = diamonds*/

    public Cards(int number, int suit){
        this.mNumber = number;
        this.mSuit = suit;
    }

    public Integer getNumber(){
        return mNumber;
    }

    public Integer getSuit(){
        return mSuit;
    }

    public void setNumber(int number){
        this.mNumber = number;
    }

    public void setSuit(int suit){
        this.mSuit = suit;
    }

}
