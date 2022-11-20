package algorithm.recursion;

import java.util.*;

public class _84_LargestRectangleInHistogram {
    //Divide and conquer method: 
    public int largestRectangleArea(int[] heights) {
        //return helper(heights, 0, heights.length - 1);

        //stack solution:
        return  stackSln(heights);
        
    }
    
    private int stackSln(int[] heights) {
        int n = heights.length;
        Stack<Integer> stack = new Stack();
        int maxArea = 0; 
        for(int i=0; i<=n; i++){
            int h= i == n ? 0 : heights[i];

            //only cur height is less than the previous bar's height, will we consider below logic.
            //check if it breaks the monotonically increasing 
            while(!stack.isEmpty() && h < heights[stack.peek()]){
                //When enter this logic, it will count the area for poped out bar. 
                int curHeight = heights[stack.pop()];
                int prevIndex = stack.isEmpty() ? -1 : stack.peek();
                //Since we maintain a monotonically increasing trend in stack,
                //we use the pop bar's height to calculate the area.
                //assuming all the previous bars should have the same prevIndex's height, the width will be (i - prevIndex -1)
                int area = curHeight * (i - prevIndex -1);
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }
        return maxArea;
    }

    public int helper(int[] heights, int start, int end){
        // if the range is out of bound
        if(start > end){
            return 0;
        }
        // check if there is only one element in the area.
        if(start == end){
            return heights[end];
        }
        //minIdx is the divider that yields three scenarios
        //1. val(minIdx) * length = area
        //2. leftArea = recursion(start, minIdx-1) 
        //3. rightArea = recursion(minIdx+1, end) 
        int minIdx = getMinIdx(heights, start, end);
        
        int leftArea = helper(heights, start, minIdx -1);
        int rightArea = helper(heights, minIdx + 1, end);
        int max = Math.max(leftArea, rightArea);
        
        return Math.max(max, heights[minIdx] * (end - start + 1));
    }
    
    public int getMinIdx(int [] heights, int start, int end){
        int min = Integer.MAX_VALUE;
        int index = 0;
        for(int i=start; i<=end; i++){
            if(min>heights[i]){
                min = heights[i];
                index = i;
            }
        }
        return index;
    }
}
