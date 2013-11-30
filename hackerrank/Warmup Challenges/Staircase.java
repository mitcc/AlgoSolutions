/*
 * Problem Statement

Your teacher has given you the task of drawing a staircase structure. Being an
expert programmer, you decided to make a program to draw it for you instead. 
Given the required height, can you print a staircase as shown in the example?

Input 
You are given an integer N depicting the height of the staircase.

Output 
Print a staircase of height N that consists of # symbols and spaces. For 
example for N=6, here's a staircase of that height:

     #
    ##
   ###
  ####
 #####
######
Note: The last line has 0 spaces before it.
 */
public class Staircase {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (j >= n - 1 - i) {
                    sb.append("#");
                } else {
                    sb.append(" ");
                }
            }
            sb.append('\n');
        }
        System.out.println(sb.toString());
    }

}
