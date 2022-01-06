class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
        if(s1.length() > s2.length()) return false;
        
        int arr[] = new int[26];
        int arr2[] = new int[26];
        for(int i = 0;i<s1.length();i++){
            arr[s1.charAt(i)-'a']++;
            arr2[s2.charAt(i)-'a']++;
        }
        if(check(arr,arr2)==true)
            return true;
        int k = s1.length();
        for(int i = k;i<s2.length();i++){
            arr2[s2.charAt(i - k) - 'a']--;
            arr2[s2.charAt(i) - 'a']++;
         
             if(check(arr,arr2)==true)
                  return true;
        }
        return false;
    }
    
    boolean check(int arr[],int arr2[]){
        for(int i=0;i<26;i++){
            if(arr[i] != arr2[i])
                return false;
        }
        return true;
    }
}