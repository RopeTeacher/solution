package Series.Greedy;

/**
 * @Author rope
 * @Date 2020/9/7 22:30
 * @Version 1.0
 */
/*
* 134.加油站
*
* 保证油箱里最后有油(或者刚好用完)
* 能开到下一地点(一直有油)
* */
public class Test134 {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int run = 0;int rest = 0;int start = 0;
        for(int i = 0;i < gas.length;i++){
            run += (gas[i] - cost[i]);
            rest += (gas[i] - cost[i]);
            if(run < 0){
                start = i+1;
                run = 0;
            }
        }
        return (rest >= 0) ? start : -1;
    }
}
