package info.mitcc.topcoder;

import java.util.*;

public class SRM586_Div2_250 {
	public static String simulate(int[] preference1, int[] preference2) {
		int length = preference1.length;
		int[] result = new int[length];
		List<Integer> reminder = new ArrayList<Integer>();
		for(int i = 0; i < length; i++)
			reminder.add(preference1[i]);
		int cur1 = 0, cur2 = 0;
		for(int i = 0; i < length; i++) {
			if(i % 2 == 0) {
				while(!reminder.contains(preference1[cur1]))
					cur1++;
				result[preference1[cur1] - 1] = 1;
				reminder.remove(reminder.indexOf(preference1[cur1]));
				cur1++;
			} else {
				while(!reminder.contains(preference2[cur2]))
					cur2++;
				result[preference2[cur2] - 1] = 2;
				reminder.remove(reminder.indexOf(preference2[cur2]));
				cur2++;
			}
		}
		String s = "";
		for(int i = 0; i < length; i++)
			s += result[i];
		return s;
	}
	
	
	public static void main(String[] args) {
		int[] p1 = {6, 1, 5, 2, 3, 4};
		int[] p2 = {1, 6, 3, 4, 5, 2};
		int[] p3 = {8, 7, 1, 2, 4, 5, 6, 3, 9};
		int[] p4 = {7, 2, 4, 8, 1, 5, 9, 6, 3};
		System.out.println(simulate(p1, p2));
		System.out.println(simulate(p3, p4));
	}
}
