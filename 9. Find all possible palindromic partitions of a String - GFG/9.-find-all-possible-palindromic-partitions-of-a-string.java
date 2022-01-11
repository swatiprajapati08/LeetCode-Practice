// { Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> allPart = ob.allPalindromicPerms(S);
            
            for (int i=0; i<allPart.size(); i++)  
            { 
                for (int j=0; j<allPart.get(i).size(); j++) 
                { 
                    System.out.print(allPart.get(i).get(j) + " "); 
                } 
                System.out.println(); 
            } 
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static ArrayList<ArrayList<String>> ans;
    static ArrayList<ArrayList<String>> allPalindromicPerms(String S) {
        // code here
        ans = new ArrayList<>();
        ArrayList<String> temp = new ArrayList<>();
        generatePalin(S,temp);
        return ans;
        
    }
    
    static void generatePalin(String S,ArrayList<String> temp){
        
        if(S.length() == 0){
            ans.add(new ArrayList<String>(temp));
            return;
        }
        
        for(int i = 0; i < S.length();i++){
            //generate palindromic prefix 
            String ss = S.substring(0,i+1);
            //System.out.println(ss);
            if(isPalin(ss)){
                
                temp.add(ss);
                generatePalin(S.substring(i+1),temp);
                //bactrack
                temp.remove(temp.size()-1);
            }
        }
    }
    
    static boolean isPalin(String s){
        if(s.length() == 1)
        return true;
        int l = 0, r = s.length() - 1;
        char ch[] = s.toCharArray();
        while(l <= r){
            if(ch[l] != ch[r])
            return false;
            l++;
            r--;
        }
        return true;
    }
};