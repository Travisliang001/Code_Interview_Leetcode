package amazon_oa;
import java.io.*;
import java.util.*;
// import stat ;

class SearchWord_ResultWord {

  public static void main(String[] args) {
    System.out.println(searchWordResultWord("armaz", "amazon"));
  }


  public static int searchWordResultWord (String searchWord, String resultWord){
    int res = 0;
    int p1 = 0; //searchWord
    int p2 = 0; //resultWord

    //Prove: searchWord is substring of resultWord.
    //Condition: when two pointer are still within in the range,
    //Action: compare them -> increment the index -> p2 will be the index we use to determine how many characters left that we need to match. 
    while (p1 < searchWord.length() && p2 < resultWord.length()){
      if(searchWord.charAt(p1) == resultWord.charAt(p2)) {
        p1++;
        p2++;
      }else{
        p1++;
      }
    }
    res = resultWord.length() - p2;
    return res;
  }
}