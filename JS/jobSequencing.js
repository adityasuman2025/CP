/*
https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1

Job Sequencing Problem
Given a set of N jobs where each jobi has a deadline and profit associated with it.

Each job takes 1 unit of time to complete and only one job can be scheduled at a time. We earn the profit associated with job if and only if the job is completed by its deadline.

Find the number of jobs done and the maximum profit.

Note: Jobs will be given in the form (Jobid, Deadline, Profit) associated with that Job.


Example 1:

Input:
N = 4
Jobs = {(1,4,20),(2,1,10),(3,1,40),(4,1,30)}
Output:
2 60
Explanation:
Job1 and Job3 can be done with
maximum profit of 60 (20+40).
Example 2:

Input:
N = 5
Jobs = {(1,2,100),(2,1,19),(3,2,27),
        (4,1,25),(5,1,15)}
Output:
2 127
Explanation:
2 jobs can be done with
maximum profit of 127 (100+27).
*/

class Solution {
    JobScheduling(arr, n) {
        arr.sort((a, b) => b.profit - a.profit); // descending order // bara se chota
        
        let slot = Array(arr.length).fill(false);
        
        let jobCount = 0;
        let totalProfit = 0
        
        for (let i=0; i<n; i++) {
            for (let j = Math.min(n, arr[i].dead) - 1; j>=0; j--) {
                if (!slot[j]) {
                    slot[j] = true;
                    jobCount++;
                    totalProfit += arr[i].profit;
                    break;
                }
            }
        }
        
        return [ jobCount, totalProfit ]
    }
}