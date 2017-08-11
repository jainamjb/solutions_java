//solution to the problem stated at : http://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/
/*
Please note that it's Function problem i.e.
you need to write your solution in the form Function(s) only.
Driver Code to call/invoke your function would be added by GfG's Online Judge.*/


/* A binary tree node class
class Node
{
	int data;
	Node left,right;
	
	Node(int d)
	{
		data = d;
		left = right = null;		
	}
} */
class GfG
{
    public static int height(Node node){
        if(node==null)
        return 0;
        if( node.left==null && node.right == null)
        return 1;
        else return Math.max(height(node.left),height(node.right))+1;
    }
     /* This function should return tree if passed  tree 
     is balanced, else false.  Time complexity should
     be O(n) where n is number of nodes in tree */
    boolean isBalanced(Node node)
    {
	// Your code here
	    if(node==null || (node.left==null && node.right == null))
	    return true;
	    else{
	        if(Math.abs(height(node.left)-height(node.right)) > 1)
	        return false;
	        else return isBalanced(node.right) && isBalanced(node.left);
	    }
    }
}
