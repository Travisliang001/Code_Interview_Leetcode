package algorithm.recursion;

public class _779_KthSysbolInGrammar {
// Row1	        			  0
// 						  /       \
// Row2					0          1
// 					   /   \      /    \
// Row3				  0     1     1      0
// 					 / \    / \   / \   / \
// Row4				0  1   1   0  1  0  0  1

// Index(for Row 4)->  1  2   3   4  5  6  7  8

//The key point is finding the relationship between even and odd numbers that we are using to determine the values.

    public int kthGrammar(int N, int K) {
        
        // return helper(N, K);
        //base case: if the N == 1, then return 0
        if(N == 1){
            return 0;
        }
        //if K is even number, it parent is (N-1) row, K/2
        //if K is odd number, its parent is (N-1) row, (K+1)/2
        if(K%2 == 0){
            if(kthGrammar(N-1, K/2)==1){
                return 0;
            } else{
                return 1; 
            } 
        } else{
            if(kthGrammar(N-1, (K+1)/2)==1){
                return 1;
            } else{
                return 0;
            }
        }
        
    }
