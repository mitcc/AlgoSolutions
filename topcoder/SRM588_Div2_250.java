package info.mitcc.topcoder;

public class SRM588_Div2_250 {
  public int countDoors(int[] doorR, int[] doorG, int[] keys) {
//		int lenR = doorR.length;
//		int lenG = doorG.length;
//		int lenKey = keys.length;
//		if(lenR != lenG || lenR > 50 || lenR < 1 || lenKey != 3)
//			return 0;
//		for(int i = 0; i < lenR; i++)
//			if(doorR[i] > 100 || doorR[i] < 0 || doorG[i] > 100 || doorG[i] < 0)
//				return 0;
//		for(int i = 0; i < 3; i++)
//			if(keys[i] > 100 || keys[i] < 0)
//				return 0;
		int count = 0;
		for(int i = 0; i < doorR.length; i++) {
			int diffR = (keys[0] - doorR[i] >= 0) ? 0 : (keys[0] - doorR[i]);
			int diffG = (keys[1] - doorG[i] >= 0) ? 0 : (keys[1] - doorG[i]);
			if(keys[2] >= 0 - diffR - diffG)
				count++;
		}
		return count;
	}
	
	public static void main(String[] args) {
		int[] doorR = {2, 0, 5, 3};
		int[] doorG = {1, 4, 0, 2};
		int[] keys = {2, 3, 1};
		System.out.println(new SRM588_Div2_250().countDoors(doorR, doorG, keys));
	}
}
