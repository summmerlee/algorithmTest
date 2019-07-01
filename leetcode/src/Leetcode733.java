public class Leetcode733 {
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image==null || image.length==0) return image;
        int num = image[sr][sc];
        int[][] v = new int[image.length][image[0].length]; // fixme 如果忘了这个就会导致stackoverflow 循环了
        change(image,sr,sc,newColor,num,v);
        return image;
    }
    private static void change(int[][] image, int sr, int sc, int newColor, int num, int[][] v){
        if(sr>=0 && sc>=0 && sr<image.length && sc<image[0].length && image[sr][sc]==num && v[sr][sc]==0){
            image[sr][sc]=newColor;
            v[sr][sc]=1;  // fixme 如果忘了这个就会导致stackoverflow 循环了
            change(image,sr-1,sc,newColor,num,v);
            change(image,sr+1,sc,newColor,num,v);
            change(image,sr,sc-1,newColor,num,v);
            change(image,sr,sc+1,newColor,num,v);
        }
    }
    public static void main(String[] args){
        int[][] image = {{0,0,0},{0,1,1}};
        int[][] res= floodFill(image,1,1,1);
    }
}
