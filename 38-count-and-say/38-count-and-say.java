class Solution {
    public String countAndSay(int n) {
        if(n == 1)
            return "1";
        String s = countAndSay(n - 1);
        // make your ans
        int i = 0;
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while(i < s.length()){
            char ch = s.charAt(i);
            while(i < s.length() && ch == s.charAt(i)){
                count++;
                i++;
            }
            sb.append(count);
            sb.append(ch);
            count = 0;
        }
        return sb.toString();
    }
}