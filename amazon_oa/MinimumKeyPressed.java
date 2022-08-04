import java.io.*;
import java.util.*;
// import stat ;

class MinimumKeyPressed {

  public static void main(String[] args) {
    System.out.println(minKeyPressed("hello"));
  }
  //1. get the freq for each character.
  //2. using priorityQueue to sort the characters based on their freq. high freq high priority to place in the first place of the button.
  //3. understand that there are total 9characters that can be placed in the first place, 9 characters can be placed in the second place. 8 characters can be place third place.
  //4. (count / 9 + 1) => will show you how many times do you need to press for this button.
  public static int minKeyPressed(String input) {
    int res = 0;
    Map<Character, Integer> freq = new HashMap<>();
    int defaultFreq = 0;
    for (Character ch : input.toCharArray()) {
      freq.put(ch, freq.getOrDefault(ch, defaultFreq) + 1);
    }
    // System.out.println(freq);

    // max heap to get the largest frequency:
    PriorityQueue<Character> queue = new PriorityQueue<>((Character a, Character b) -> freq.get(b) - freq.get(a));
    //get unique character in the queue
    for (Character ch : freq.keySet()) {
      queue.add(ch);
    }
    // System.out.println(queue);
    // Ideally you want all the high freq letter located in the first letter of each
    // button.
    // count will keep track of each unique number
    // we don't need to care about the order that users enter those character on the
    // phone.
    
    int count = 0;
    while (!queue.isEmpty()) {
      Character curChar = queue.poll();
      res += (count / 9 + 1) * freq.get(curChar); // ( count / 9 + 1) will be the position in a btn: abc (a pressed 1 time, b pressed 2 time, c prssed 3 times.)
      count++;
    }

    return res;
  }
}