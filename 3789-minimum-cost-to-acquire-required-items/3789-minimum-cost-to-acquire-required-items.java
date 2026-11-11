class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
          
        if( need1 == 0 && need2 == 0)
            return 0;

        long costComb1 = (long) costBoth * Math.max(need1,need2);
        long costComb2 = (long) cost1 * need1 + (long) cost2 * need2;
        long costComb3 = Long.MAX_VALUE;
        if(need1 > need2){
            costComb3 = (long) need2 * costBoth + (long) (need1 - need2) * cost1;
        }else {
            costComb3 = (long) need1 * costBoth + (long) (need2 - need1) * cost2;
        }
        return Math.min(costComb1,Math.min(costComb2,costComb3));
    }
    }
