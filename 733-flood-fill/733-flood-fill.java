class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
     Helper(image,sr,sc,newColor,oldColor); 
        return image;
    }
    static void Helper(int[][] image, int sr, int sc, int newColor,int oldColor)
    {
        if(sr >= image.length || sr < 0 || sc >= image[0].length || sc < 0 || image[sr][sc] != oldColor|| image[sr][sc] == newColor)
            return;
        
        if(sr == image.length-1 && sc == image[0].length){
            return;
        }
        
        image[sr][sc] = newColor;
        Helper(image,sr + 1,sc,newColor,oldColor);
        Helper(image,sr - 1,sc,newColor,oldColor);
        Helper(image,sr,sc + 1,newColor,oldColor);
        Helper(image,sr,sc - 1,newColor,oldColor);
    }
}