package poker;
/**
 * This class represents one player's hand of cards.
 * 
 * @author Top Malasri
 * @version Feb. 10, 2014
 */
public class Hand
{
    private Card[] cardsInHand = new Card[5];   // this array holds the Card objects currently in the hand
    private int numCardsInHand = 0;             // tracks how many cards have been added to the hand so far

    // This method adds the specified Card object to the hand.  Takes no
    //  action if the hand is already full.
    public void addCard(Card c)
    {
        if (numCardsInHand < cardsInHand.length) {
            cardsInHand[numCardsInHand] = c;
            numCardsInHand++;
        }
    }

    // This method determines what type of poker hand we have.  Returns an
    //  int value, as follows:
    // 8 - straight flush (five cards of consecutive rank, all of the same suit)
    // 7 - four of a kind (four cards of one rank)
    // 6 - full house (three cards of one rank, plus two of another rank)
    // 5 - flush (five cards of the same suit)
    // 4 - straight (five cards of consecutive rank)
    // 3 - three of a kind (three cards of one rank)
    // 2 - two pairs (two cards of one rank, plus two more of another rank)
    // 1 - two of a kind / one pair (two cards of one rank)
    // 0 - none of the above
    //
    public int evaluate()
    {
        // set up the "rankCount" array, which stores how many cards of each rank
        //  we have present in this hand.
        // index 0 = how many 2's
        // index 1 = how many 3's
        // index 2 = how many 4's
        // ... etc.
        // index 11 = how many kings
        // index 12 = how many aces
        int[] rankCount = new int[13];
        for (int i = 0; i < cardsInHand.length; i++) {  //stores how many cards of each rank
            // the following line is equivalent to saying this:
            // int rank = cardsInHand[i].getRank();
            // if (rank == 2)
            //    rankCount[0]++;
            // else if (rank == 3)
            //    rankCount[1]++;
            // else if (rank == 4)
            //    rankCount[2]++;
            // ... etc.
            rankCount[cardsInHand[i].getRank() - 2]++;
        }

        // check for 4, 3, or 2 of a kind
        boolean fourOfAKind = false;
        boolean threeOfAKind = false;
        boolean twoOfAKind = false;
        
        for (int i = 0; i < rankCount.length; i++) {
            if (rankCount[i] == 4)
                fourOfAKind = true;
            if (rankCount[i] == 3)
                threeOfAKind = true;
            if (rankCount[i] == 2)
                twoOfAKind = true;
        }
        
        // check for a straight (five cards of consecutive rank)
        // A straight will show up in the rankCount array as five consecutive 1's
        // J Q K A 2, or Q K A 2 3, or K A 2 3 4 doesn't count as a straight
        boolean isStraight = false;
        for (int i = 0; i <= 8; i++) {      //i<=8 for the if statement(right corner) below bc 8+4=12. notices 8 is a card rank 10
            if (rankCount[i] == 1 && rankCount[i+1] == 1 && rankCount[i+2] == 1 && rankCount[i+3] == 1 && rankCount[i+4] == 1) {
                isStraight = true;
                break;
            }
        }
        
        // special case of an aces-low straight (A-2-3-4-5) -- here we have four consecutive 1's on the
        //  low indices of the array, plus one more 1 at index 12
        if (rankCount[0] == 1 && rankCount[1] == 1 && rankCount[2] == 1 && rankCount[3] == 1 && rankCount[12] == 1)
            isStraight = true;
        
        // check for a flush (all cards being the same suit)
        boolean isFlush = true;
        for (int i = 1; i < cardsInHand.length; i++) {
            if (cardsInHand[i].getSuit() != cardsInHand[0].getSuit()) {
                isFlush = false;
                break;
            }
        }
        
        // check for two pairs -- we can do this by counting the number of 2's
        //  that show up in the rankCount array
        boolean twoPairs = false;
        int numPairs = 0;
        for (int i = 0; i < rankCount.length; i++) {
            if (rankCount[i] == 2)
                numPairs++;
        }
        if (numPairs == 2)
            twoPairs = true;
        
        // now figure out what to return, based on what we've found from above
        if (isStraight && isFlush)
            return 8;
        else if (fourOfAKind)
            return 7;
        else if (threeOfAKind && twoOfAKind)
            return 6;
        else if (isFlush)
            return 5;
        else if (isStraight)
            return 4;
        else if (threeOfAKind)
            return 3;
        else if (twoPairs)
            return 2;
        else if (twoOfAKind)
            return 1;
        else
            return 0;
    }

    public String toString()
    {
        String r = "";
        for (int i = 0; i < cardsInHand.length; i++) {
            r += cardsInHand[i] + "\n";
        }
        return r;
    }
}
