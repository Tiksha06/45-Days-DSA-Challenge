class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st = new Stack<>();
        int maxArea=0;
        int n=heights.length;

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                int element=st.pop();
                int nse=i;
                int pse=st.isEmpty() ? -1 : st.peek();
                int area = heights[element]*(nse-pse-1);
                maxArea=Math.max(area,maxArea);
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int nse= n;
            int element= st.pop();
            int pse=st.isEmpty() ? -1 : st.peek();
            int area = heights[element]*(nse-pse-1);
            maxArea=Math.max(area,maxArea);
        }
        return maxArea;
    }
}