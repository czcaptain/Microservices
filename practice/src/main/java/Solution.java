import java.util.ArrayDeque;
import java.util.HashSet;

public class Solution {

    //private static char [][] board = {{'a','b'},{'a','c'}};
    public int[] plusOne(int[] digits) {

        int f = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] += f;
            if (digits[i] == 10) {
                digits[i] = 0;
                f = 1;
            } else {
                f = 0;
            }
        }
        if (f == 1) {
            int[] res = new int[digits.length + 1];
            res[0] = f;
            for (int i = 1; i < res.length; i++) {
                res[i] = digits[i - 1];
            }
        }
        return digits;
    }

    //是否是有效数组
    public boolean isValidSudoku(char[][] board) {

//        char cell [][] = new char[board.length][board.length];
        int length = board.length;
        for (int i = 0; i < length; i++) {
            HashSet<Character> charactersRow = new HashSet<>();
            HashSet<Character> charactersColumn = new HashSet<>();
            HashSet<Character> charactersCell = new HashSet<>();
            for (int j = 0; j < length; j++) {
                if (board[i][j] != '.' && !charactersRow.add(board[i][j])) {
                    return false;
                }
                if (board[j][i] != '.' && !charactersColumn.add(board[j][i])) {
                    return false;
                }
                //第几个九宫格  1 3 => 2 0; 0 3
                int k = (i/3)*3 + j/3;
                int l = (i%3)*3 + j%3;
                if (board[k][l] != '.' &&!charactersCell.add(board[k][l])) {
                    return false;
                }
            }

        }
        return true;
    }

    public boolean isValidSudoku1(char board[][]) {
        int length = board.length;
        //二维数组line表示的是对应的行中是否有对应的数字，比如line[0][3]
        //表示的是第0行（实际上是第1行，因为数组的下标是从0开始的）是否有数字3
        int line[][] = new int[length][length];
        int column[][] = new int[length][length];
        int cell[][] = new int[length][length];
        for (int i = 0; i < length; ++i)
            for (int j = 0; j < length; ++j) {
                //如果还没有填数字，直接跳过
                if (board[i][j] == '.')
                    continue;
                //num是当前格子的数字
                int num = board[i][j] - '0' - 1;
                //k是第几个单元格，9宫格数独横着和竖着都是3个单元格
                int k = i / 3 * 3 + j / 3;
                //如果当前数字对应的行和列以及单元格，只要一个由数字，说明冲突了，直接返回false。
                //举个例子，如果line[i][num]不等于0，说明第i（i从0开始）行有num这个数字。
                if (line[i][num] != 0 || column[j][num] != 0 || cell[k][num] != 0)
                    return false;
                //表示第i行有num这个数字，第j列有num这个数字，对应的单元格内也有num这个数字
                line[i][num] = column[j][num] = cell[k][num] = 1;
            }
        return true;
    }

    public static void main(String[] args) {
        char a = '7';
        System.out.println(a-'0'-1);
    }


    //数组逆序输出  {1 , 2 , 3 , 4}
    public void reverseString(char[] s) {
        int k = 0;
        char temp = ' ';
        for (int i = s.length - 1; i >= k; i--) {
                temp = s[k];
                s[k++] = s[i];
                s[i] = temp;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums) {



        return null;
    }

    public int maxDepth(TreeNode root) {

        if(root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left),maxDepth(root.right)) + 1;
    }

}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

//private boolean isValidrow()


