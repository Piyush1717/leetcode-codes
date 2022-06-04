// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().split(" ");

            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int[] ans = new Solve().findTwoElement(a, n);
            System.out.println(ans[0] + " " + ans[1]);
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solve {
    int[] findTwoElement(int arr[], int n) {
int [] ans=new int[2];


int missing;
int repeating;
boolean [] present=new boolean[n+1];

for(int i=0;i<n;i++)
{
if(present[arr[i]]==true)
{
    repeating=arr[i];
    ans[0]=arr[i];
}

present[arr[i]]=true;
}

for(int i=1;i<=n;i++)
{
if(present[i]==false)
{
    ans[1]=i;
}
}



return ans;

    }
}