
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.*;
public class hash_chaining {

    // store all strings in one list
    // for hash function
    static int bucketCount;
    static int query_count;
    static int prime = 1000000007;
    static int multiplier = 263;

    public static void main(String[] args) throws IOException {
        Scanner sc=new Scanner(System.in);
        bucketCount=sc.nextInt();
        ArrayList<ArrayList<String>> elems=new ArrayList<ArrayList<String>>(bucketCount);
        
        for(int i=0;i<bucketCount;i++)
        	elems.add(i,new ArrayList<String>());
        query_count=sc.nextInt();
        while(query_count>=0){
        	String query=sc.next();
        	switch(query){
        	case "add":
        		String word =sc.next();
        		ArrayList<String> list_a=elems.get(hashFunc(word));
        		if(!list_a.contains(word))
        		list_a.add(word);
        		//System.out.println(hashFunc(word));
        		break;
        	case "del":
        		String del_word=sc.next();
        		ArrayList list_d=elems.get(hashFunc(del_word));
        		//System.out.println(hashFunc(del_word)+1);
        		list_d.remove(del_word);
        		break;
        	case "find":
        		String find_word =sc.next();
        		ArrayList list_f=elems.get(hashFunc(find_word));

        		if(list_f ==null)
        			{
        			System.out.println();
            		System.out.flush();
        			}
        		
        		else{
        			if(list_f.contains(find_word))
        				System.out.println("yes");
        			else{
        				System.out.println("no");
        			}
        		}
        		System.out.flush();
        		break;
        	case "check":
        		ArrayList<String> list_c=elems.get(sc.nextInt());
        		if(list_c!=null)
        		for(int j=list_c.size();j>0;j--)
        		System.out.print(list_c.get(j-1)+" ");
        		System.out.print("\n");
        		System.out.flush();
        		break;
        		
        	default:
        			System.out.println("error");
        	}
        	query_count--;
        }

    }

    static int hashFunc(String s) {
        long hash = 0;
        for (int i = s.length() - 1; i >= 0; --i)
            hash = (hash * multiplier + s.charAt(i)) % prime;
        return (int)hash % bucketCount;
    }  
}
