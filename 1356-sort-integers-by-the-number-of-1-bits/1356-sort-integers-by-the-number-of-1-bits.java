class Solution {
    public int[] sortByBits(int[] arr) {

        for(int i=0; i<arr.length; i++){
            for(int j=i+1; j<arr.length; j++){

                int count1 = Integer.bitCount(arr[i]);
                int count2 = Integer.bitCount(arr[j]);

                if(count1 > count2 || (count1 == count2 && arr[i] > arr[j])){

                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
            return arr;
    }
}