class Solution {
    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder(a);
        int count = 1;
        
        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }
        
        if (rabinKarp(sb.toString(), b)) return count;
        
        sb.append(a);
        if (rabinKarp(sb.toString(), b)) return count + 1;
        
        return -1;
    }
    
    private boolean rabinKarp(String source, String target) {
        int n =source.length();
        int m =target.length();
        if(m>n) return false;
        
        long PRIME=101;
        long MOD=1000000007;
        long targetHash=0;
        long sourceHash=0;
        long maxPower=1;
        
        for(int i=0;i<m-1;i++){
            maxPower = (maxPower * PRIME) % MOD;
        }
        for(int i=0;i<m;i++){
            targetHash = (targetHash*PRIME+target.charAt(i)) % MOD;
            sourceHash = (sourceHash*PRIME+source.charAt(i)) % MOD;
        }
        for(int i=0;i<=n-m; i++){
            if(targetHash == sourceHash){
                if(source.substring(i, i + m).equals(target)){
                    return true;
                }
            }
            if(i<n-m){
                sourceHash = (sourceHash-source.charAt(i)*maxPower) % MOD;
                sourceHash = (sourceHash*PRIME + source.charAt(i+m)) % MOD;
                if(sourceHash<0){
                    sourceHash+=MOD;
                }
            }
        }
        return false;
    }
}
