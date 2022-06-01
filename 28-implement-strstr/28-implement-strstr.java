class Solution {
    public int strStr(String haystack, String needle) {
        int j = 0, i = 0;
        for(int k = 0; k < haystack.length();k++){
            // if character is matched
            i = k;
            if(haystack.charAt(i) == needle.charAt(j)){
                i++;
                j++;
                while(i < haystack.length() && j < needle.length() && 
                        haystack.charAt(i) == needle.charAt(j)){
                    i++;
                    j++;
                }
            }
            if(j == needle.length())
                return k;
            else
                j = 0;
        }
        return -1;
    }
}