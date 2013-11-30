/*
259. Printed PR

time limit per test: 0.25 sec.
memory limit per test: 65536 KB
input: standard
output: standard



Small PR-agency got an order to print a very big lot of agitational materials. 
Agency should print and deliver N leaflets. Agency is very small and has only 
one printer, but it can print any leaflet. Leaflets can be different, so it is 
possible that times of printing of leaflets will differ. To print i-th leaflet 
the printer needs Ti minutes. When leaflet is printed, it should be immediately 
delivered to its addressee. The agency has unlimited number of couriers, so the 
courier gets the leaflet as soon as it printed and goes to the addressee. It 
takes Li minutes to deliver i-th leaflet. You were hired by agency to calculate 
the minimal time required to finish the job (this is an interval of time from 
the beginning of printing to the moment when the last leaflet is delivered), 
considering that the leaflets can be printed in any order.

Input
The first line contains a number of leaflets - integer number N (1 <= N <= 100). 
The second line contains N integer numbers Ti (1 <= i <= N). Third line contains 
N integer numbers Li (1 <= i <= N). You can assume that 1 <= Ti, Li <= 1000.

Output
You should output only one number - the answer for the problem.

Sample test(s)

Input
2 
2 1 
2 1

Output
4
 * 
 */
import java.util.*;

public class P259 {
    public static int calculate(int[] p, int[] d) {
        for(int i = 1; i <= d.length - 1; i++) { // insertion sort
            for(int j = i - 1; j >= 0 && d[j] < d[j + 1]; j--) {
                int temp = d[j];
                d[j] = d[j + 1];
                d[j + 1] = temp;
                temp = p[j];
                p[j] = p[j + 1];
                p[j + 1] = temp;
            }
        }
        int timeCost = 0;
        int curLatest = 0;
        for(int i = 0; i < d.length; i++) {
            timeCost += p[i];
            curLatest = Math.max(curLatest, timeCost + d[i]);
        }
        return curLatest;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int[] p = new int[len];
        int[] d = new int[len];
        for(int i = 0; i < len; i++)
            p[i] = in.nextInt();
        for(int i = 0; i < len; i++)
            d[i] = in.nextInt(); 
        System.out.print(calculate(p, d));
    }
}
