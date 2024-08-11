/*
 *  Q) Job Sequencing Problem
        Given a set of n jobs where each jobi has a deadline and profit associated with it.
        Each job takes 1 unit of time to complete and only one job can be scheduled at a time. We earn the profit associated with a job if and only if the job is completed by its deadline.
        Find the number of jobs done and the maximum profit.
        Note: Jobs will be given in the form (Jobid, Deadline, Profit) associated with that Job. Deadline of the job is the time on or before which job needs to be completed to earn the profit.

    Example : 1
        Input: Jobs = [[1,4,20],[2,1,1],[3,1,40],[4,1,30]]
        Output: 2 60
        Explanation: Job1 and Job3 can be done with maximum profit of 60 (20+40).
        
    Example : 2
        Input: Jobs = [[1,2,100],[2,1,19],[3,2,27],[4,1,25],[5,1,15]]
        Output: 2 127
        Explanation: 2 jobs can be done with maximum profit of 127 (100+27).
        
    Expected Time Complexity: O(nlogn)
    Expected Auxilliary Space: O(n)

    Constraints:
        1 <= n <= 10^5
        1 <= Deadline,id <= n
        1 <= Profit <= 500
 */
import java.io.*;
// import java.util.ArrayList;
// import java.util.Arrays;
import java.util.HashMap;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

 public class _11_08_24 {
    static int[] JobScheduling(Job arr[], int n) {
        // Your code here
        
        for(int i=0; i<arr.length-1; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i].profit < arr[j].profit) {
                    Job temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
                else if(arr[i].profit == arr[j].profit) {
                    if(arr[i].deadline > arr[j].deadline) {
                        Job temp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }

        int count = 0, maxProfit = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<n; i++) {
            if(map.get(arr[i].deadline) == null) {
                map.put(arr[i].deadline, arr[i].profit);
                maxProfit += arr[i].profit;
                count++;
            }
            else {
                int temp = arr[i].deadline - 1;

                while (temp != 0) {
                    if(map.get(temp) == null) {
                        map.put(temp, arr[i].profit);
                        maxProfit += arr[i].profit;
                        count++;
                        break;
                    }
                }
            }
        }

        int[] a = new int[2];
        a[0] = count;
        a[1] = maxProfit;
        return a;

    /* 
        Arrays.sort(arr,(x,y)->y.profit-x.profit);
        int maxDeadline=0;
        for(Job j:arr) maxDeadline=Math.max(maxDeadline,j.deadline);
        int deadlines[]=new int[maxDeadline+1];
        Arrays.fill(deadlines,-1);
        int maxProfit=0,totalJobs=0;
        for(Job j:arr){
            for(int i=j.deadline;i>0;i--){
                if(deadlines[i]==-1){
                    deadlines[i]=j.profit;
                    maxProfit+=j.profit;
                    totalJobs++;
                    break;
                }
            }
        }
        return new int[]{totalJobs,maxProfit};
    */

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            
            //function call
            int[] res = JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
    }
 }