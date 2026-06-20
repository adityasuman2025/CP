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
    jobSequencing(deadline, profit) {
        const n = deadline.length;

        const arr = profit.map((item, idx) => ([item, deadline[idx]]));
        arr.sort((a, b) => b[0] - a[0]);
        const slot = new Array(n).fill(false);

        let c = 0, sum = 0;
        for (let i = 0; i < n; i++) {
            const [currProfit, currDeadline] = arr[i];

            for (let j = Math.min(currDeadline, n) - 1; j >= 0; j--) {
                if (!slot[j]) {
                    slot[j] = true;
                    sum += currProfit;
                    c++;

                    break;
                }
            }
        }

        return [c, sum];
    }
}
