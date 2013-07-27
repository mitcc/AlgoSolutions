package info.mitcc.leetcode;

import java.util.ArrayList;
import java.util.Scanner;

public class PascalTriangleII {
	public ArrayList<Integer> getRow(int rowIndex) {
		if(rowIndex < 0)
			throw new IllegalArgumentException();
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		if(rowIndex == 0)
			return list;
		else {
			ArrayList<Integer> tempList = this.getRow(rowIndex - 1);
			for(int i = 1; i < rowIndex; i++)
				list.add(tempList.get(i - 1) + tempList.get(i));
			list.add(1);
			return list;
		}
    }
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println(new PascalTriangleII().getRow(in.nextInt()));
	}
}
