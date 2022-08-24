package leetcode;

import java.io.*;
import java.util.*;
class _3_LengthOfLongestSubstring {

    public static void main(String[] args) {
      //dvdfer
      //adcder
      //abccef
      //https://leetcode.com/problems/longest-substring-without-repeating-characters/discuss/1729/11-line-simple-Java-solution-O(n)-with-explanation
      System.out.println(lengthOfLongestSubstringSolution1("abba"));
      System.out.println(lengthOfLongestSubstringSolution2("abba"));
    }
    //Knowledge Points: 
    //1. Substring -> two pointers
    //2. figure out how to update two pointers.
    //3. data structure: Map and Array. which one can you store 
    

    //Specific points: 
    //1. left update: two cases: one is dupIndx falls into the window size; other is dupIndx doesn't fall into window size.
    //          a,b,c,b     vs     a,b,b,a
    //2. seen[right] => give you the last appearance of the character + 1 => where left index begins: 
    public static int lengthOfLongestSubstringSolution1(String input){
      int max = 0, left=0, right=0;
      Map<Character, Integer> subStrTrackMap = new HashMap<>();

      while(right < input.length()){
        Character curChar = input.charAt(right);
        //if it is not in the 
        if(!subStrTrackMap.containsKey(curChar)){
          max = Math.max(max, right - left +1);
          
        } else{
          //2. when the dupliate char is outside of the window. we don't consider that character in our case. 
          //abcba
          if(subStrTrackMap.get(curChar) < left){
            max = Math.max(max, right - left + 1);
          } else{
            //1. when the duplicate char in the window size, increment the left by one
            //abcb => index of c
            left = subStrTrackMap.get(curChar) + 1;
          }
        }
        subStrTrackMap.put(curChar, right++);
         
      }

      return max;
    }

    public static int lengthOfLongestSubstringSolution2(String input){
      int max = 0, left = 0, right = 0;
      int [] seen = new int [256];

      while(right < input.length()){
        Character curChar = input.charAt(right);
        if(seen[curChar] > 0){
          left = Math.max(left, seen[curChar]);
        }
        max = Math.max(max, right - left + 1);
        seen[curChar] = right + 1; //
        right ++;

      }

      return max;
    }

  }