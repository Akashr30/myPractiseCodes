package testOne;

public class CustomSortString {
	
	public static String customSortString(String S, String T) {
        int [] arr = new int [26];
        //count T characters
        for(char ch: T.toCharArray()){
            arr[ch-'a']++;
        }
        // append S  chars at the right order as many times as they appear in T
        StringBuilder sb = new StringBuilder();
        for(char ch: S.toCharArray()){
            while(arr[ch-'a']>0){
                sb.append(ch);
                arr[ch-'a']--;
            }
        }
        //append the rest of the T characters
        for(int i = 0; i<arr.length; i++){
            while(arr[i]>0){
                sb.append((char)(i+'a'));
                arr[i]--;
            }
        }
        
        return sb.toString();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String s = "cbafg";
//		String t = "abcd"; 
//		String s = "kqep";
//		String t = "pekeq";
		String s = "exv";
		String t = "xwvee"; 
		customSortString(s,t);
	}

}
