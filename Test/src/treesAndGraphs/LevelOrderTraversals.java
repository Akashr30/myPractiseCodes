package treesAndGraphs;

//{ Driver Code Starts
//Initial Template for Java

import java.util.LinkedList; 
import java.util.Queue; 
import java.io.*;
import java.util.*;

class Node{
 int data;
 Node left;
 Node right;
 Node(int data){
     this.data = data;
     left=null;
     right=null;
 }
}

class LevelOrderTraversals {
 
 static Node buildTree(String str){
     
     if(str.length()==0 || str.charAt(0)=='N'){
         return null;
     }
     
     String ip[] = str.split(" ");
     // Create the root of the tree
     Node root = new Node(Integer.parseInt(ip[0]));
     // Push the root to the queue
     
     Queue<Node> queue = new LinkedList<>(); 
     
     queue.add(root);
     // Starting from the second element
     
     int i = 1;
     while(queue.size()>0 && i < ip.length) {
         
         // Get and remove the front of the queue
         Node currNode = queue.peek();
         queue.remove();
             
         // Get the current node's value from the string
         String currVal = ip[i];
             
         // If the left child is not null
         if(!currVal.equals("N")) {
                 
             // Create the left child for the current node
             currNode.left = new Node(Integer.parseInt(currVal));
             // Push it to the queue
             queue.add(currNode.left);
         }
             
         // For the right child
         i++;
         if(i >= ip.length)
             break;
             
         currVal = ip[i];
             
         // If the right child is not null
         if(!currVal.equals("N")) {
                 
             // Create the right child for the current node
             currNode.right = new Node(Integer.parseInt(currVal));
                 
             // Push it to the queue
             queue.add(currNode.right);
         }
         i++;
     }
     
     return root;
 }
 static void printInorder(Node root)
 {
     if(root == null)
         return;
         
     printInorder(root.left);
     System.out.print(root.data+" ");
     
     printInorder(root.right);
 }
 
	public static void main (String[] args) throws IOException{
	        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	        
	        int t=Integer.parseInt(br.readLine());
 
	        while(t > 0){
	            String s = br.readLine();
 	    	Node root = buildTree(s);
     	    Level_order_traversal g = new Level_order_traversal();
             g.levelOrder(root);
 			System.out.println();
             t--;
         
     }
 }

}

//} Driver Code Ends
//User function Template for Java

/*
class Node
{
 int data;
 Node left, right;

 Node(int item)
 {
     data = item;
     left = right = null;
 }
}
*/
class Level_order_traversal
{
	static List<List<Integer>> al = new ArrayList<>();
	static List<Integer> temp = new ArrayList<>();;
 //You are required to complete this method
 static void levelOrder(Node root) 
 { 
	 
	 
	Queue<Node> q = new LinkedList<>();
	q.add(root);
	Queue<Node> q1 = new LinkedList<>();
	
	while (!q.isEmpty()) {
	    
		Node node = q.peek();
	    if (node != null)
	        temp.add(node.data);
	    
	    if (node != null && node.left != null) {
	        q1.add(node.left);
	        
	    }
	    if (node != null && node.right != null) {
	        q1.add(node.right);
	    }
	    
	    q.poll();
	    
	    if (q.isEmpty()) {
	        q = q1;
	        al.add(temp);
	        temp = new ArrayList<>();
	        q1 = new LinkedList<>();
	    }
	    
	}
	Collections.reverse(al);

}
}


