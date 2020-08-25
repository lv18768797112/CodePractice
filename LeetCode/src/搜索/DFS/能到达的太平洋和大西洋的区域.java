package 搜索.DFS;

import java.sql.Struct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。“太平洋”处于大陆的左边界和上边界，
 * 而“大西洋”处于大陆的右边界和下边界。
 * 规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。
 * 请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。
 * 提示：
 * 输出坐标的顺序不重要
 * m 和 n 都小于150
 * 示例：
 * 给定下面的 5x5 矩阵:
 *   太平洋 ~   ~   ~   ~   ~
 *        ~  1   2   2   3  (5) *
 *        ~  3   2   3  (4) (4) *
 *        ~  2   4  (5)  3   1  *
 *        ~ (6) (7)  1   4   5  *
 *        ~ (5)  1   1   2   4  *
 *           *   *   *   *   * 大西洋
 * 返回:
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).
 */
public class 能到达的太平洋和大西洋的区域 {
    private List<List<Integer>> list;
    private int[][] directions = new int[][]{{0,-1},{0,1},{-1,0},{1,0}};
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        list = new ArrayList<>();
        if(matrix==null||matrix.length==0)
            return list;
        int row = matrix.length;
        int col = matrix[0].length;
        boolean[][] T = new boolean[row][col];
        boolean[][] D = new boolean[row][col];
        for(int i=0;i<row;i++){
            dfs(matrix,i,0,T);
            dfs(matrix,i,col-1,D);
        }
        for(int i=0;i<col;i++){
            dfs(matrix,0,i,T);
            dfs(matrix,row-1,i,D);
        }
        for (int i = 0; i <row ; i++) {
            for (int j = 0; j <col ; j++) {
                if(T[i][j]&&D[i][j]){
                    list.add(Arrays.asList(i,j));
                }
            }
        }
        return list;
    }
    public void dfs(int[][] matrix,int i,int j,boolean[][] canReach){
        if(canReach[i][j])
            return;
        canReach[i][j]=true;
        for (int[] dire:directions) {
            int x = i+dire[0];
            int y = j+dire[1];
            if(i<0||i>=matrix.length||j<0||j>=matrix[0].length||matrix[i][j]>matrix[x][y])
                continue;
            dfs(matrix,x,y,canReach);
        }
    }
}
/**错误的答案 ：是想着递归到某一元素时，如果从该元素从左和上能达到太平洋并且从右和下能到达大西洋就算该元素是锁查找元素
 * 但其实方向是每个元素在上下左右四个方向都可以递归
 *class Solution {
 *     private List<List<Integer>> list;
 *     public List<List<Integer>> pacificAtlantic(int[][] matrix) {
 *         list = new ArrayList<>();
 *         if(matrix==null||matrix.length==0)
 *             return list;
 *         int row=matrix.length;
 *         int col=matrix[0].length;
 *         for(int i=0;i<row;i++){
 *             for(int j=0;j<col;j++){
 *                 if(dfsT(matrix,i,j)&&dfsD(matrix,i,j))
 *                     list.add(Arrays.asList(i,j));
 *             }
 *         }
 *         return list;
 *     }
 *     public boolean dfsT(int[][] matrix,int i,int j){
 *         if(i==0||j==0)
 *             return true;
 *         boolean resL=false,resU=false;
 *         if(matrix[i][j-1]<=matrix[i][j])
 *             resL=dfsT(matrix,i,j-1);
 *         if(matrix[i-1][j]<=matrix[i][j])
 *             resU=dfsT(matrix,i-1,j);
 *         return resU||resL;
 *     }
 *     public boolean dfsD(int[][] matrix,int i,int j){
 *         if(i==(matrix.length-1)||j==(matrix[0].length-1))
 *             return true;
 *         boolean resR=false,resD=false;
 *         if(matrix[i][j+1]<=matrix[i][j])
 *             resR = dfsD(matrix,i,j+1);
 *         if(matrix[i+1][j]<=matrix[i][j])
 *             resD = dfsD(matrix,i+1,j);
 *         return resR||resD;
 *     }
 * }
 */