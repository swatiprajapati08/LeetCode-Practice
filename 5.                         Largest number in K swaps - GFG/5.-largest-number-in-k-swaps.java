// { Driver Code Starts
import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int k = sc.nextInt();
                    String str = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.findMaximumNum(str, k));
                }
        }
}// } Driver Code Ends




class Solution
{
    //Function to find the largest number after k swaps.
    static String max;
    public static String findMaximumNum(String str, int k)
        {
         max=str;
          Helper(str.toCharArray(),k);  
          return max;
        }
        
        static void Helper(char[] str,int k){
	       
	       String s = new String(str);
	       if(max.compareTo(s) < 0){
	           max = s;
	           return;
	       }
	       
        if(k==0)return;
        
            for(int i = 0;i< str.length - 1; i++){
               for(int j = i + 1; j < str.length;j++){
                   if(str[i] < str[j]){
                      swap(str,i,j);
                       //System.out.println("Before "+str);
                       Helper(str,k-1);
                       swap(str,i,j);
                    // System.out.println("After:"+ str);
                   }
               }
           }
        }
        
       static void swap(char[] ch, int i, int j)
        {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        }
}