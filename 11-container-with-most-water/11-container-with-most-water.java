class Solution {
    public int maxArea(int[] height) {
        int i=0;
        int j=height.length-1;
        int water=0;
        int width=0;
        int h=0;
        
        while(i<j)
        {
            width=j-i;
            h=Math.min(height[i],height[j]);
            
            int tempW=h*width;
            
            if(tempW>water)
            {
                water=tempW;
            }
            
            if(height[i]<height[j])
            {
                i++;
            }
            else
            {
                j--;
            }
            
        }
        return water;
        
    }
}