package 搜索.DFS;
//给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
//    找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
//    示例:
//    X X X X
//    X O O X
//    X X O X
//    X O X X
//    运行你的函数后，矩阵变为：
//    X X X X
//    X X X X
//    X X X X
//    X O X X
//    解释:
//    被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，
//    或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
public class 被围绕的区域 {
    public void solve(char[][] board) {
        if(board==null||board.length==0)
            return;
        int row=board.length;
        int col=board[0].length;
        for(int i=0;i<row;i++){
            dfs(board,i,0);
            dfs(board,i,col-1);
        }
        for(int j=0;j<col;j++){
            dfs(board,0,j);
            dfs(board,row-1,j);
        }
        for(int i=0;i<row;i++){
            for (int j = 0; j <col ; j++) {
                if(board[i][j]=='O')
                    board[i][j]='X';
                else if(board[i][j]=='#')
                    board[i][j]='O';
            }
        }
    }
    public void dfs(char[][] borad,int i,int j){
//        if(i<0||i>=borad.length||j<0||j>=borad[0].length||borad[i][j]=='X')
//                                                        注意这里不能写=='X'  会栈溢出
//                                因为如果元素为[[O,O],[O,O]]第一次递归就全改为#了，如果写不等于X的话会一直重复在这里赋值
        if(i<0||i>=borad.length||j<0||j>=borad[0].length||borad[i][j]!='O')
            return;
        borad[i][j]='#';
        dfs(borad,i,j-1);
        dfs(borad,i,j+1);
        dfs(borad,i-1,j);
        dfs(borad,i+1,j);
    }
}
