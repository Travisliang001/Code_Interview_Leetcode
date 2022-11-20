package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/*
A. Analyze the what can we solve the problem:
    1. Binary search: there is no easy process to achieve. needs to do internal process and find the relationship between profits and start time.
    2. Greedy algorithm: its wrong if we always procced with the selection with great profit(big profits with long process time)
    3. dp: get the optimal solution from the previous build.
B. 


Let's follow the example above. All jobs are sorted by their end time.

We start with dp[0] which we initialize with profit of the first job 1-3. dp[0] = 20

Next we look at dp[1] which is max of dp[0] and current job 2-5's profit plus max profit up to the previous job in the timeline that doesn't overlap it. There are no such jobs. So, we evaluate max(dp[0], job 2-5's profit) => max(20, 20) => dp[1] = 20

dp[2] is max of dp[1] and the job 4-6's profit plus max profit up to a job before it that doesnt overlap it. One such job is 1-3. So we evaluate max(dp[1], max profit up to 1-3 + 4-6's profit) => max(20, 20+70) => 90

dp[3] - we do the same for 6-9: max(dp[2], max up to 4-6 which is the last job that does not overlap with 6-9 + 6-9's profit) => max(90, 90 + 60) => 150

dp[4] - we check job 3-10: we pick max(dp[3], max up to 1-2 which is the previous job that does not overlap with 3-10 + 3-10's profit) => max(150, 100 + 20) => 150
*/

class Job{
    int start, finish, profit;
    Job(int start, int finish, int profit){
        this.start = start;
        this.finish = finish;
        this.profit = profit;
    }
}
public class _1235_MaxProfitInJobScheduling {


    


    public static void main(String[] args) {
        System.out.println(solve(new int[] {1,2,3,3}, new int[] {3,4,5,6} , new int[] {50,10,40,70}));
    }

    private static int solve(int[] startArr, int[] finishArr, int[] profitArr) {
        int n = startArr.length;
        Job [] jobs = new Job[n];
        for(int index=0; index<n; index++){
            jobs[0] = new Job(startArr[index], finishArr[index], profitArr[index]);
        }
        return scheduleJob(jobs);
    }

    private static int scheduleJob(Job[] jobs) {
        //sort jobs according to finish time
        Arrays.sort(jobs, Comparator.comparing(a -> a.finish));
        // dp[i] stores the profit for jobs till jobs[i]
        int n = jobs.length;
        int [] dp = new int[n];
        dp[0] = jobs[0].profit;

        for(int i=1; i<n; i++){
            //profit including the current job
            int profit = jobs[i].profit;

            int l = search(jobs, i);//this will give you the 

            if( l != -1){
                profit += dp[l];
            }
            dp[i] = Math.max(profit, dp[i-1]);
        }

        return dp[n-1];
    }

    private static int search(Job[] jobs, int i) {
        int start = 0, end = i - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(jobs[mid].finish <= jobs[i].start){
                if(jobs[mid+1].finish <= jobs[i].start){
                    start = mid + 1;
                } else{
                    return mid;
                }
            } else{
                end = mid - 1;
            }
        }

        return -1;
    }

    //Easy understand version:
    private int jobScheduling(Job[] jobs){
        int length = jobs.length;
        int [] dp = new int[length];
        Arrays.sort(jobs, Comparator.comparing(a -> a.finish));
        for(int i=0; i<length; i++){
            if(i==0){
                dp[0] = jobs[0].profit;
                continue;
            }

            int f = 0; //find last non-overlapping job that ends before start of this current job and record max profit up to j, dp[j]
            for (int j=i-1; j>=0; j--){
                if(jobs[j].finish <= jobs[i].start){
                    f = dp[j];
                    break;
                }
            }

            dp[i] = Math.max(dp[i-1], //last max profit calculated from 0 to i-1
                            f+jobs[i].profit); // current profit and max profit up to last non-overlapping job.
        }
        return dp[length - 1];
    }
}
