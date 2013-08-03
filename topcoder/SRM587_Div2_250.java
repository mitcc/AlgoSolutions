package info.mitcc.topcoder;

public class SRM587_Div2_250 {
	public String canTransform(String init, String goal) {
		String str = "";
		for(int i = 0; i < goal.length(); i++)
			if(goal.charAt(i) != 'z')
				str += goal.charAt(i);
		return str.equals(init) ? "Yes" : "No";
	}
}
