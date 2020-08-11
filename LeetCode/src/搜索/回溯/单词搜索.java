package 搜索.回溯;
//给定一个二维网格和一个单词，找出该单词是否存在于网格中。
//
//    单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
//    同一个单元格内的字母不允许被重复使用。
//    示例:
//    board =
//    [
//    ['A','B','C','E'],
//    ['S','F','C','S'],
//    ['A','D','E','E']
//    ]
//    给定 word = "ABCCED", 返回 true
//    给定 word = "SEE", 返回 true
//    给定 word = "ABCB", 返回 false
//
//    提示：
//    board 和 word 中只包含大写和小写英文字母。
//    1 <= board.length <= 200
//    1 <= board[i].length <= 200
//    1 <= word.length <= 10^3

public class 单词搜索 {
    public boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(board[i][j]==word.charAt(0)){   //把这层判断去了更快，为什么？
                    if(dfs(board,i,j,0,word,visited)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public boolean dfs(char[][] board,int i,int j,int index,String word,boolean[][] visited){
        int row = board.length;
        int col = board[0].length;
        if(i<0||i>=row||j<0||j>=col||visited[i][j]||board[i][j]!=word.charAt(index))
            return false;
        if(index==word.length()-1)   //容易把正确的返回给忘了
            return true;
        visited[i][j]=true;
        boolean res = dfs(board,i,j-1,index+1,word,visited)||
                      dfs(board,i,j+1,index+1,word,visited)||
                      dfs(board,i-1,j,index+1,word,visited)||
                      dfs(board,i+1,j,index+1,word,visited);
        visited[i][j]=false;
        return res;
    }
}
