package 数组;
/*地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，
 * 因为3+5+3+8=19。请问该机器人能够到达多少个格子？

输入：m = 2, n = 3, k = 1
输出：3

输入：m = 3, n = 1, k = 0
输出：1
提示：

1 <= n,m <= 100
0 <= k <= 20


方法一：深度优先遍历 DFS
深度优先搜索： 可以理解为暴力法模拟机器人在矩阵中的所有路径。DFS 通过递归，先朝一个方向搜到底，再回溯至上个节点，沿另一个方向搜索，以此类推。
剪枝： 在搜索中，遇到数位和超出目标值、此元素已访问，则应立即返回，称之为 可行性剪枝 。

BFS/DFS ： 两者目标都是遍历整个矩阵，不同点在于搜索顺序不同。DFS 是朝一个方向走到底，再回退，以此类推；BFS 则是按照“平推”的方式向前搜索。
BFS 实现： 通常利用队列实现广度优先遍历。

 */
//思路1：深度搜索dfs
//思路2：宽度搜索bfs
//为什么要维护全局变量  这样可以减少方法中的参数
public class 机器人的运动范围DFS {
    private boolean[][] visited;
    public int movingCount(int m, int n, int k) {
        visited = new boolean[m][n];
        return dfs(m,n,0,0,k);
    }
    public int dfs(int m,int n,int i,int j,int k){
        //basease
        if(i>m-1||j>n-1||visited[i][j]||digit(i,j)>k)
            return 0;
        visited[i][j] = true;
        return dfs(m,n,i+1,j,k)+dfs(m,n,i,j+1,k)+1;
    }
    public int digit(int i,int j){
        int sum=0;
        while(i>0){
            sum+=i%10;
            i=i/10;
        }
        while(j>0){
            sum+=j%10;
            j/=10;
        }
        return sum;
    }
}
