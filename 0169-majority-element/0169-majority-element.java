class Solution {
    public int majorityElement(int[] num) {
        int maj = num[0];
        int count = 1;

        for(int i=1; i< num.length; i++){
            if(count == 0){
                count++;
                maj = num[i];
            }else if(maj == num[i]){
                count++;
            }else
            count--;
        }
        return maj;
        
    }
}