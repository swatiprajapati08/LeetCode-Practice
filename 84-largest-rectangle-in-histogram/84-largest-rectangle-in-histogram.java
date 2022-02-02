class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        //next smaller to left
        int nsl[] = new int[n];
        int nsr[] = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n;i++){
            //pop 
            while(!st.isEmpty() && heights[i] <= heights[st.peek()])
                st.pop();
            
             // make ans
            if(st.size() > 0)
                nsl[i] = st.peek();
            else nsl[i] = -1;
            // push yourself
            
            st.push(i);
        }
        // for(int i:nsl)
        //     System.out.print(i+" ");
        //next smaller to right
         st = new Stack<>();
        for(int i = n - 1; i >= 0;i--){
            //pop 
            while(!st.isEmpty() && heights[i] <= heights[st.peek()])
                st.pop();
            
             // make ans
            if(st.size() > 0)
                nsr[i] = st.peek();
            else nsr[i] = n;
            // push yourself
            
            st.push(i);
        }
        
//         for(int i:nsr)
//             System.out.print(i+" ");
        
        int max = 0;
        //for each element nsr - nsl - 1 * nums[i]
        
        for(int i =0;i<n;i++){
            int val = (nsr[i] - nsl[i] - 1) * heights[i];
            max = Math.max(val,max);
         }
        return max;
    }
}