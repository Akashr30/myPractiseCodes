package leetcode;

import java.util.Arrays;

public class NextGreaterElementIII {
	
	public int nextGreaterElement(int n) {
        char[] ch = ("" + n).toCharArray();
        int index = ch.length - 2;
        while(index >= 0 && ch[index] >= ch[index + 1])
            index--;
   
        if(index == -1)
            return -1;
        
        int index2 = ch.length - 1;
        while(index2 >= index && ch[index2] <= ch[index])
            index2--;
        
        swap(ch, index, index2);
        reverse(ch, index + 1);
        // Handle all case when number cross Integer.MAX_VALUE // 1999999999
        try {
            return Integer.parseInt(new String(ch));
        } catch (Exception e) {
            return -1;
        }
    }
    
    private void reverse(char[] ch, int start) {
        int l = start, r = ch.length - 1;
        while(l < r) {
            swap(ch, l, r);
            l++;
            r--;
        }
    }
    
    private void swap(char[] ch, int i, int j) {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }

	public static void main(String[] args) {
		
		int n = 5469852;
		System.out.println(new NextGreaterElementIII().nextGreaterElement(n));

	}

}
