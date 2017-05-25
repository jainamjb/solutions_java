import java.util.*;
import java.io.*;

public class tree_order {
    class FastScanner {
		StringTokenizer tok = new StringTokenizer("");
		BufferedReader in;

		FastScanner() {
			in = new BufferedReader(new InputStreamReader(System.in));
		}

		String next() throws IOException {
			while (!tok.hasMoreElements())
				tok = new StringTokenizer(in.readLine());
			return tok.nextToken();
		}
	
		int nextInt() throws IOException {
			return Integer.parseInt(next());
		}
	}

	public class TreeOrders {
		int n;
		int[] key, left, right;
		
		void read() throws IOException {
			FastScanner in = new FastScanner();
			n = in.nextInt();
			key = new int[n];
			left = new int[n];
			right = new int[n];
			for (int i = 0; i < n; i++) { 
				key[i] = in.nextInt();
				left[i] = in.nextInt();
				right[i] = in.nextInt();
			}
		}

		List<Integer> inOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
                        // Finish the implementation
                        // You may need to add a new recursive method to do that
			inorder_trav(0);
			return result;
		}
		
		void pre_trav(int x){
			if(x==-1)
				return;
			else{
				System.out.print(key[x]+" ");
				pre_trav(left[x]);
				pre_trav(right[x]);
			}
		}
		void post_trav(int x){
			if(x==-1)
				return;
			else{
				post_trav(left[x]);
				post_trav(right[x]);
				System.out.print(key[x]+" ");
			}
		}
		void inorder_trav(int x){
			if(x==-1)
				return;
			else{
				inorder_trav(left[x]);
				System.out.print(key[x]+" ");
				inorder_trav(right[x]);
			}
		}
		
		List<Integer> preOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
                        // Finish the implementation
                        // You may need to add a new recursive method to do that
            pre_trav(0);  
			return result;
		}

		List<Integer> postOrder() {
			ArrayList<Integer> result = new ArrayList<Integer>();
                        // Finish the implementation
                        // You may need to add a new recursive method to do that
            post_trav(0);            
			return result;
		}
	}

	static public void main(String[] args) throws IOException {
            new Thread(null, new Runnable() {
                    public void run() {
                        try {
                            new tree_order().run();
                        } catch (IOException e) {
                        }
                    }
                }, "1", 1 << 26).start();
	}

	public void print(List<Integer> x) {
		for (Integer a : x) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

	public void run() throws IOException {
		TreeOrders tree = new TreeOrders();
		tree.read();
		print(tree.inOrder());
		print(tree.preOrder());
		print(tree.postOrder());
	}
}
