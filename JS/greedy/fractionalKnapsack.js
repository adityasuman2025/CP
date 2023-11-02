/*
https://practice.geeksforgeeks.org/problems/fractional-knapsack-1587115620/1


Fractional Knapsack


Given weights and values of N items, we need to put these items in a knapsack of capacity W to get the maximum total value in the knapsack.
Note: Unlike 0/1 knapsack, you are allowed to break the item. 

 

Example 1:

Input:
N = 3, W = 50
values[] = {60,100,120}
weight[] = {10,20,30}
Output:
240.00
Explanation:Total maximum value of item
we can have is 240.00 from the given
capacity of sack. 
Example 2:

Input:
N = 2, W = 50
values[] = {60,100}
weight[] = {10,20}
Output:
160.00
Explanation:
Total maximum value of item
we can have is 160.00 from the given
capacity of sack.
 

Your Task :
Complete the function fractionalKnapsack() that receives maximum capacity , array of structure/class and size n and returns a double value representing the maximum value in knapsack.
Note: The details of structure/class is defined in the comments above the given function.
*/



/*
class Item{
    constructor(value, weight){
        this.value = value;
        this.weight = weight;
    }
}
*/

class Solution {
    fractionalKnapsack(maxWeight, arr, n) {
        // sorting array by its value/weight ratio, so that we can pick element with highest value for a given weight first
        arr.sort((a, b) => b.value / b.weight - a.value / a.weight);

        let leftWeight = maxWeight;
        let i = 0, totalVal = 0;
        while (leftWeight > 0 && i < n) {
            const { value: thisVal, weight: thisWeight } = arr[i];

            // checking if complete weight can be picked or only fraction of weight is possible
            if (thisWeight <= leftWeight) {
                totalVal += thisVal;

                leftWeight -= thisWeight;
            } else { // only a fraction of weight can be picked
                let possiblePercent = leftWeight / thisWeight; // percentage of weight that can be picked from this knapsack
                let possibleValue = thisVal * possiblePercent; // value associated with that percentage

                totalVal += possibleValue;

                // we are at the situation of fraction picking because weight of the this bag become greater than weights left to pick 
                // so after picking the fraction weight our left weight will become 0
                leftWeight = 0;
            }

            i++;
        }

        return totalVal;
    }
}