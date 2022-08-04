import java.io.*;
import java.util.*;
// import stat ;

class FinalDataLocations {

  public static void main(String[] args) {
    for(int num : finalDataLocations(new int []{1,7,6,8}, new int [] {1,7,2}, new int [] {2,9,5})){
      System.out.println(num);
    }
  }

  public static int [] finalDataLocations(int [] locations, int [] movedFrom, int [] movedTo){
    // purpose: using set to store 
    Set<Integer> resSet = new HashSet<>();
    for (int loc : locations){
      resSet.add(loc);
    }

    //moveFrom and MoveTO operation
    for(int i=0; i<movedFrom.length; i++){
      resSet.remove(movedFrom[i]);
      resSet.add(movedTo[i]);
    }

    //final result;
    int[] newLocs = new int[resSet.size()];
    int i = 0;
    for(int loc : resSet){
      newLocs[i] = loc;
      i++;
    }
    Arrays.sort(newLocs);
    return newLocs;
  }

}