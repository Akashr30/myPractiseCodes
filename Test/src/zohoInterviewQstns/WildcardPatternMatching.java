package zohoInterviewQstns;

public class WildcardPatternMatching 
{ 

//Function that matches input text 
//with given wildcard pattern 
static boolean strmatch(char txt[], char pat[], 
						int n, int m) 
{ 
	// empty pattern can only 
	// match with empty string. 
	// Base Case : 
	if (m == 0) 
		return (n == 0); 

	// step-1 : 
	// initailze markers : 
	int i = 0, j = 0, index_txt = -1, 
					index_pat = -1; 

	while (i < n) 
	{ 

		// For step - (2, 5) 
		if (j < m && txt[i] == pat[j]) 
		{ 
			i++; 
			j++; 
		} 

		// For step - (3) 
		else if (j < m && pat[j] == '?') 
		{ 
			i++; 
			j++; 
		} 

		// For step - (4) 
		else if (j < m && pat[j] == '*') 
		{ 
			index_txt = i; 
			index_pat = j; 
			j++; 
		} 

		// For step - (5) 
		else if (index_pat != -1) 
		{ 
			j = index_pat + 1; 
			i = index_txt + 1; 
			index_txt++; 
		} 

		// For step - (6) 
		else
		{ 
			return false; 
		} 
	} 

	// For step - (7) 
	while (j < m && pat[j] == '*') 
	{ 
		j++; 
	} 

	// Final Check 
	if (j == m) 
	{ 
		return true; 
	} 

	return false; 
} 

//Driver code 
public static void main(String[] args) 
{ 
	char str[] = "baaabab".toCharArray(); 
	char pattern[] = "*****a*****ab".toCharArray(); 
	// char pattern[] = "ba*****ab"; 
	// char pattern[] = "ba*ab"; 
	// char pattern[] = "a*ab"; 

	if (strmatch(str, pattern, str.length, 
						pattern.length)) 
		System.out.println("Yes"); 
	else
		System.out.println("No"); 

	char pattern2[] = "a*****ab".toCharArray(); 
	if (strmatch(str, pattern2, str.length, 
						pattern2.length)) 
		System.out.println("Yes"); 
	else
		System.out.println("No"); 

} 
} 

