/*
 * There are N gas stations along a circular route, where the amount 
 * of gas at station i is gas[i].

You have a car with an unlimited gas tank and it costs cost[i] of gas 
to travel from station i to its next station (i+1). You begin the 
journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the 
circuit once, otherwise return -1.

Example
Given 4 gas stations with gas[i]=[1,1,3,1], and the cost[i]=[2,2,1,1]. 
The starting gas station's index is 2.

Note
The solution is guaranteed to be unique.

Challenge
O(n) time and O(1) extra space
 */
public class GasStation {

    /**
     * @param gas: an array of integers
     * @param cost: an array of integers
     * @return: an integer
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int result = 0;
        int margin = 0;
        for (int i = 0, remainder = 0; i < gas.length; ++i) {
            margin += gas[i] - cost[i];
            remainder += gas[i] - cost[i];
            if (remainder < 0) {
                remainder = 0;
                result = i + 1;
            }
        }
        return margin < 0 ? -1 : result;
    }

}
