import java.util.Arrays;
class Main {
  public static void main(String[] args) {
    String[] cards = "S1R0,S1R1,S1R3,S1R2,S1R7,S1R4".split(",");
    print(checkStraightFlush(cards));

     String[] cards1 = "S0R7,S2R0,S0R1,S1R1,S1R3,S2R2,S1R7,S1R4,S2R1,S2R3,S2R4,S2R5".split(",");
    print(checkStraightFlush(cards1));
   
  }

  static boolean sameSuite(String card0, String card1) {
    boolean same =  card0.charAt(0) == card1.charAt(0) && 
           card0.charAt(1) == card1.charAt(1);
    
    return same;
  }

  static int  rank(String card) {
    if (card.length() == 4) {
      return Integer.parseInt(card.substring(3,4));
    }
    if (card.length() == 5) {
      return Integer.parseInt(card.substring(3,5));
    }
    throw new IllegalArgumentException();
  }
  static String  checkStraightFlush(String[] hand) {
    Arrays.sort(hand);
  
    int count = 1;
    for(int i = hand.length-1; i > 0; i--) {
      if(sameSuite(hand[i-1], hand[i]) && rank(hand[i-1])+1 == rank(hand[i])) {
        count++;
      }
      else {
        count = 1;
      }
      if (count == 5) {
         return hand[i-1]+ "-" + hand[i+3];
      }
    }
    return "";
  }

static void print(String s) {
  System.out.println(s);
}
}
