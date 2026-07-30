class Solution {
    public boolean canPartition(int[] nums) {

        int n = nums.length;

        int total = 0;

        for(int num : nums)
        total += num;

        if(total % 2 != 0)
        return false;

        int sum = total / 2;

        boolean[][] t = new boolean[n+1][sum+1];

        for(int i =0; i<= n; i++){
            for(int j = 0; j<= sum; j++){

                if(i == 0)
                t[i][j]= false;

                if(j == 0)
                t[i][j]= true;
            }
        }
        for(int i =1; i <= n; i++){
            for(int j =1; j<= sum; j++){

                if(nums[i-1] <= j){

                    t[i][j] = t[i-1][j-nums[i-1]] || t[i-1][j];

                }else{

                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][sum];
        
    }
}