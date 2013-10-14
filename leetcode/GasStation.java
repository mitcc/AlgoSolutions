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
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if(gas == null || cost == null || gas.length != cost.length || gas.length == 0)
            return -1;
        int total = 0, remain = 0;
        int j = -1;
        for(int i = 0; i < gas.length; i++) {
            total += gas[i] - cost[i];
            remain += gas[i] - cost[i];
            if(remain < 0) {
                j = i;
                remain = 0;
            }
        }
        return total >= 0 ? j + 1 : -1;
    }
}
