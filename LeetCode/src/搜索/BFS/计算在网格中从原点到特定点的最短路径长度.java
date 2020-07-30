package 搜索.BFS;

import java.util.LinkedList;
import java.util.Queue;

//	在一个 N × N 的方形网格中，每个单元格有两种状态：空（0）或者阻塞（1）。
//
//	一条从左上角到右下角、长度为 k 的畅通路径，由满足下述条件的单元格 C_1, C_2, ..., C_k 组成：
//
//	相邻单元格 C_i 和 C_{i+1} 在八个方向之一上连通（此时，C_i 和 C_{i+1} 不同且共享边或角）
//	C_1 位于 (0, 0)（即，值为 grid[0][0]）
//	C_k 位于 (N-1, N-1)（即，值为 grid[N-1][N-1]）
//	如果 C_i 位于 (r, c)，则 grid[r][c] 为空（即，grid[r][c] == 0）
//	返回这条从左上角到右下角的最短畅通路径的长度。如果不存在这样的路径，返回 -1 。
//
//	提示：
//	1 <= grid.length == grid[0].length <= 100
//	grid[i][j] 为 0 或 1
public class 计算在网格中从原点到特定点的最短路径长度 {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid==null||grid.length==0||grid[0].length==0)
            return -1;
        if(grid[0][0]==1)
            return -1;
        int row=grid.length;
        int col=grid[0].length;
        int[][] direction = new int[][]{{-1,-1},{-1,0},{-1,1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        grid[0][0]=1;
        int path=1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0,0});
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size-->0){
                int[] cur = queue.poll();
                int x = cur[0];
                int y = cur[1];
                if(x==row-1&&y==col-1){
                    return path;
                }
                for(int[] dir:direction){
                    int x1 = x+dir[0];
                    int y1 = y+dir[1];
                    if(x1<0||x1>=row||y1<0||y1>=col||grid[x1][y1]==1)
                        continue;
                    queue.add(new int[]{x1,y1});
                    grid[x1][y1]=1;
                }
            }
            path++;
        }
        return -1;
    }
}
