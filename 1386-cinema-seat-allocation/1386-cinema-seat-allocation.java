import java.util.*;

class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        
        Map<Integer, Set<Integer>> map = new HashMap<>();

     
        for (int[] seat : reservedSeats) {
            int row = seat[0];
            int col = seat[1];

            map.putIfAbsent(row, new HashSet<>());
            map.get(row).add(col);
        }

        int answer = (n - map.size()) * 2;

        
        for (int row : map.keySet()) {

            Set<Integer> seats = map.get(row);

            boolean left = true;   
            boolean middle = true;  
            boolean right = true;  

       
            for (int seat = 2; seat <= 5; seat++) {
                if (seats.contains(seat)) {
                    left = false;
                    break;
                }
            }

            
            for (int seat = 4; seat <= 7; seat++) {
                if (seats.contains(seat)) {
                    middle = false;
                    break;
                }
            }

          
            for (int seat = 6; seat <= 9; seat++) {
                if (seats.contains(seat)) {
                    right = false;
                    break;
                }
            }

          
            if (left && right) {
                answer += 2;
            }
            
            else if (left || middle || right) {
                answer += 1;
            }
        }

        return answer;
    }
}