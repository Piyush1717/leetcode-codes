class Solution {
    public int[] findDiagonalOrder(int A[][]) {
        int n=Math.max(A.length,A[0].length);
        int numOfDiag=2*n-1;
        ArrayList<Integer> [] res=new ArrayList[numOfDiag];
        int num=0;
        
        for(int i=0;i<numOfDiag;i++)
        {
            res[i]=new ArrayList<>();
        }
        
        
        for(int i=0;i<A.length;i++)
        {
            for(int j=0;j<A[0].length;j++)
            {
                res[i+j].add(A[i][j]);
                num++;
            }
        }
       
        int [] ans=new int[num];
        int count=0;
        
        for(int i=0;i<numOfDiag;i++)
        {
            ArrayList<Integer> temp=res[i];
            if(i%2==1)
            {
            for(int j=0;j<temp.size();j++)
            {
                ans[count]=temp.get(j);
                count++;
            }      
            }
            else
            { 
            for(int j=temp.size()-1;j>=0;j--)
            {
                ans[count]=temp.get(j);
                count++;
            }   
                
            }
        }
        
        return ans;
        
    }
}