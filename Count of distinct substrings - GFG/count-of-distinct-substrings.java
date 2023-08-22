//{ Driver Code Starts
import java.util.*;

class suffix
{
     int index;  
    int rank[] = new int[2];
}

class UniqueSubStr
{
    public static void main (String[] args) {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String st = sc.next();
            GfG g = new GfG();
            System.out.println(g.countDistinctSubstring(st));
        }
    }
}
// } Driver Code Ends


/*You are required to complete this method */
class GfG
{
    
    static class Node{
        Node [] links=new Node[26];
        
        public Node(){
            
        }
        
        boolean containsKey(char ch)
        {
            return (links[ch-'a']!=null);
        }
        
        Node get(char ch)
        {
            return links[ch-'a'];
        }
        
        void put(char ch , Node node)
        {
            links[ch-'a']=node;
        }
        
        
    }
    
    
   public static int countDistinctSubstring(String st)
   {
       //your code here
       
       int count=0;
       Node root=new Node();
       
       for(int i=0;i<st.length();i++)
       {
           Node node=root;
           
           for(int j=i;j<st.length();j++)
           {
               char ch=st.charAt(j);
               if(node.containsKey(ch)==false)
               {
                   count++;
                   node.put(ch,new Node());
               }
               node=node.get(ch);
           }
           
       }
       
       return count+1;
       
   }
}