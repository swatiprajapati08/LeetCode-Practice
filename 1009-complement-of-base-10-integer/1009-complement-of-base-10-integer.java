class Solution {
    public int bitwiseComplement(int n) {
        String s = Integer.toBinaryString(n);
        int comp[] = new int[s.length()];
        for(int i = s.length() - 1;i>=0;i--){
            if(s.charAt(i)=='1') comp[i] = 0;
            else comp[i] = 1;
        }
        StringBuffer sb = new StringBuffer();
        for(int i:comp)
            sb.append(i);
        return Integer.parseInt(sb.toString(), 2);
    }
}