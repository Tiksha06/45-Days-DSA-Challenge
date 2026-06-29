class Solution {
    public String reverseWords(String s) {
        if(s==null || s.length()==0) return "";
        StringBuilder result=new StringBuilder();
        int n=s.length();
        int i=n-1;

        while(i>=0){
            while(i>=0 && s.charAt(i)==' '){
                i--;
            }
            if(i < 0) break;
            int j=i;
            while(i>=0 && s.charAt(i)!=' '){
                i--;
            }
            if(result.length()==0){
                result.append(s.substring(i+1,j+1));
            }else result.append(" ").append(s.substring(i+1,j+1));
        }
        return result.toString();
    }
}
