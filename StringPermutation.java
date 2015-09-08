//Determines whether one string is a permutaion of the other or not

public class StringPermutation {

	public static void main(String[] args) {
		String s1 = "abccd";
		String s2 = "dcbba";
		System.out.println(stringPermuations(s1, s2));
	}
	
	public static boolean stringPermuations(String s1, String s2) {
		if(s1.length()!=s2.length()) {
			return false;
		}
		if(s1.isEmpty() && s2.isEmpty()) {
			return true;
		}
		
		for(int i=0; i<=s1.length()-1; i++) {
				if(s2.indexOf(s1.charAt(i))==-1) {
					return false;
				}
				else {
					StringBuilder stringBuilder = new StringBuilder(s2);
					stringBuilder.deleteCharAt(s2.indexOf(s1.charAt(i)));
					s2 = stringBuilder.toString();
				}
		}
		if(s2.isEmpty()) {
			return true;
		}
		else {
			return false;
		}
	}
}
