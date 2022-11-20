package algorithm.recursion;

public class _50_Pow_x_n {
    public double helper(double base, int n){
        
        int N = n;
        double x = base;;
        if(N == 0){
            return 1.0;
        } else if( N == 1){
            return x;
        }
        if(N < 0){
            N = -N;
            x = 1/x;
        }
        
        double res = helper(x, N/2);
        if(N % 2 == 0){
            res = res * res; //(N/2 + N/2) ==> one from myPow function.  combine them become N times operations
            //this will help reduce N/2 operation.
        } else{
            res = x * res * res;
        }
        return res;
    }
}
