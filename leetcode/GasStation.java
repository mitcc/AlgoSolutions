/*
 * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].

 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i 
 * to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

 * Return the starting gas station's index if you can travel around the circuit once, otherwise 
 * return -1.

 * Note:
 * The solution is guaranteed to be unique.
 */
public class GasStation {
    public int canCompleteCirCuit(int[] gas, int[] cost) {
        int i = 0;
        int total = 0;
        while(i < gas.length) {
            for(int j = i; j < gas.length; j++) {
                total += gas[j];
                int remain = total - cost[j];
                if(remain < 0)
                    return -1;
                else 
                    total = remain;
            }
            i++;
        }
    }
}
