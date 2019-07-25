import java.util.HashSet;
import java.util.Set;

public class Leetcode36 {


    // fixme 这个是照着网上一个解题思路来的 可是这个方法运行时间好长
    public boolean isValidSudoku(char[][] board) {
        // use (4)7 to denote 4 in 7th row
        // use 7(4) to denote 4 in 7th column
        // use 0(4)2 to denote 4 in the top-right block
        Set<String> seen = new HashSet<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]!='.'){
                    String s = "("+board[i][j]+")";
                    if(!seen.add(i+s) || !seen.add(s+j) || !seen.add(i/3+s+j/3))
                        return false;
                }
            }
        }
        return true;
    }
}
