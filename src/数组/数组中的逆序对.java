package 数组;
/*
在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
示例 1:
输入: [7,5,6,4]
输出: 5

限制：
0 <= 数组长度 <= 50000

思路：就是利用归并排序，在归并的时候统计左边数组和右边数组中存在的逆序对
      归并排序时间复杂度：O(N*logN)  空间复杂度：O(N)
      分治思想求时间复杂度用master公式求解
 */
public class 数组中的逆序对 {
    private int ans;
    public int reversePairs(int[] nums) {
        if (nums==null||nums.length<=1)
            return 0;
        int L=0,R=nums.length-1;
        mergeSort(nums,L,R);
        return ans;
    }
    public void mergeSort(int[] arr,int L,int R){
        if(L==R)   //这里判断不能少  否则会栈溢出   StackOverflow
            return;
        int Mid = (L+R)>>>1;
        mergeSort(arr,L,Mid);
        mergeSort(arr,Mid+1,R);
        merge(arr,L,Mid,R);
    }
    public void merge(int[] arr,int L,int Mid,int R){
        int[] temp = new int[R-L+1];
        int i=L;
        int j=Mid+1;
        int index=0;
        while(i<=Mid&&j<=R){
            if(arr[i]<=arr[j]){
                temp[index++] = arr[i++];
            }else{
                temp[index++] = arr[j++];
                ans+=Mid-i+1; //合并的时候如果左边当前i位置的数大于右边j位置的数，说明左边从i到Mid位置的数都大于当前j位置的数
            }
        }
        while(i<=Mid){
            temp[index++] = arr[i++];
        }
        while(j<=R){
            temp[index++] = arr[j++];
        }
        System.arraycopy(temp,0,arr,L,temp.length); //将排序好的辅助数组中的数复制到对应的原数组中去
    }
}
