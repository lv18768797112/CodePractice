package 动态规划;

public class 零钱兑换 {
    public int moneyWays(int[] arr,int aim){
        return ways(arr,0,aim);
    }
    public int ways(int[] arr,int index,int aim){
        if(index==arr.length)
            return aim == 0 ? 1 : 0;
        int ways = 0;
        for(int zhang = 0;zhang * arr[index]<=aim ; zhang++){
            int used = zhang * arr[index];
            int res = aim - used;
            ways += ways(arr,index+1,res);
        }
        return ways;
    }

}
