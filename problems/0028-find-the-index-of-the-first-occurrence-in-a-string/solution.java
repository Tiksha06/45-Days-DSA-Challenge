class Solution {
    public int strStr(String haystack, String needle) {
        int n =haystack.length();
        int m =needle.length();
        if (m>n) return -1;

        int PRIME=101;
        int needleHash=0;
        int haystackHash=0;
        int maxPower=1;

        for (int i=0; i<m-1;i++) {
            maxPower = maxPower*PRIME;
        }
        for(int i=0;i<m;i++){
            needleHash = needleHash * PRIME + needle.charAt(i);
            haystackHash = haystackHash * PRIME + haystack.charAt(i);
        }
        for(int i=0;i<=n-m;i++){
            if(needleHash==haystackHash){
                if(haystack.substring(i,i+m).equals(needle)){
                    return i;
                }
            }
            if (i< n-m) {
                haystackHash=(haystackHash-haystack.charAt(i)*maxPower)*PRIME +haystack.charAt(i+m);
            }
        }
        return -1;
    }
}
