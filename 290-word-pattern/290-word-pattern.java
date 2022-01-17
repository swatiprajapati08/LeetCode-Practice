class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String> hm = new HashMap<Character,String>();
        String strArr[] = s.split(" ");
        if(pattern.length() != strArr.length)
            return false;
        
        for(int i = 0; i < pattern.length();i++)
        {
            char ch = pattern.charAt(i);
            if(hm.containsKey(ch) && hm.get(ch).equals(strArr[i])) continue;
            else if(hm.containsKey(ch) && hm.get(ch).equals(strArr[i]) == false)
                return false;
            else{
                if(hm.containsValue(strArr[i]))
                    return false;
                else
                    hm.put(ch,strArr[i]);
            }
        }
        return true;
    }
}