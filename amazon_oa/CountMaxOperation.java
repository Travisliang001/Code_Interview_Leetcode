package amazon_oa;
import java.io.*;
import java.util.*;
// import stat ;

class CountMaxOperation {

  public static void main(String[] args) {
    System.out.println(countMaxOperation("abacbc", "bca"));
  }
  //how many times are you able to get the substring of target from source.
  public static int countMaxOperation(String source, String target){
    int res = Integer.MAX_VALUE;
    HashMap<Character, Integer> srcMap = new HashMap<>();
    HashMap<Character, Integer> tgtMap = new HashMap<>();

    for(Character chr : source.toCharArray()){
      srcMap.put(chr, srcMap.getOrDefault(chr, 0) + 1);

    }

    for(Character chr : target.toCharArray()){
      tgtMap.put(chr, tgtMap.getOrDefault(chr, 0 ) + 1);
    }

    for(Character chr : target.toCharArray()){
      int targetFreq = tgtMap.get(chr);
      int sourceFreq = srcMap.get(chr);
      int count = sourceFreq / targetFreq;
      res = Math.min(res, count);
    }
    return res;
  }
}