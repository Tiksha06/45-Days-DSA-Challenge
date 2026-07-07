class Solution {
    public int strStr(String haystack, String needle) {
        int n =haystack.length();
        int m =needle.length();
        
        if (m>n) return -1;
        
        String concat = needle+"$"+haystack;
        int len = concat.length();
        int[] Z = new int[len];
        int L=0,R=0;
        
        for(int i=1;i<len;i++){
            if(i<=R){
                Z[i] = Math.min(R-i+1,Z[i-L]);
            }
            while(i + Z[i] < len && concat.charAt(Z[i])==concat.charAt(i+Z[i])){
                Z[i]++;
            }
            if(i+Z[i]-1>R){
                L =i;
                R = i+Z[i]-1;
            }
        }
        for(int i=0;i<len;i++){
            if (Z[i]==m) {
                return i-m-1;
            }
        }
        return -1;
    }
}
