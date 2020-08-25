package 数组;
/*在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

现有矩阵 matrix 如下：
[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]
给定 target = 5，返回 true。
给定 target = 20，返回 false。

限制： 0 <= n <= 1000
 */

//二维数组的行数：matrix.length
//二位数组的列数：matrix[0].length
public class 二维数组中的查找 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix==null|| matrix.length==0)
            return false;
        int row = 0 ;
        int colum = matrix[0].length-1;
        while(row<matrix.length && colum>=0){
            if(target<matrix[row][colum])
                colum--;
            else if(target>matrix[row][colum])
                row++;
            else
                return true;
        }
        return false;
    }
}
/*注意下面这种写法是错误的  基础知识错误 if-else的错误
 * public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix==null||matrix.length==0||matrix[0].length==0)
            return false;
        int rows =0,columns = matrix[0].length-1;
		while(rows<matrix.length&&columns>=0) {
			if(target>matrix[rows][columns])
				rows++;
			if(target<matrix[rows][columns])
				columns--;
			return true;
		}
		return false;
    }
*/