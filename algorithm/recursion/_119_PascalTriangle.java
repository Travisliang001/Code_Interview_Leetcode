package algorithm.recursion;

import java.util.ArrayList;
import java.util.List;


// row0 = 1
// row1 = (row0[0]), (row1[1] + row0[0]) = 1, 1
// row2 = (row0[0]), (row1[1] + row1[0]), (row2[2] + row1[1]) = 1, 2, 1
// row3 = (row0[0]), (row2[1] + row2[0]), (row2[2] + row2[1]). (row3[3] + row2[2]) = 1, 3, 3, 1
public class _119_PascalTriangle {
    public List<Integer> result = new ArrayList<>();
    public List<Integer> getRow(int rowIndex) {
        //numOfElement = rowIndex + 1
        result.add(1);
        for(int i=1; i<=rowIndex;i++){
            for(int j=i-1; j>=1; j--){
                //f(i,j) = f(i-1,j) + f(i-1, j-1);
                //generating old row and build on top of that.
                int tmp = result.get(j-1) + result.get(j);
                result.set(j, tmp);
            }
            result.add(1);//last element
        }
        return result;
    }
}
