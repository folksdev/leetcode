class Solution {
    public List<Integer> spiralOrder(int[][] arr) {
        //Time Complexity: O(M*N). To traverse the matrix O(M*M) time is required.
        //Auxiliary Space: O(1). No extra space is required.
        //T = Top corner, B = bottom corner, L = Left corner, R = right corner, dir = direction
        int T = 0, B =  arr.length-1, L = 0, R = arr[0].length -1, dir = 0;
        List<Integer> result = new ArrayList<>();
        while (T <= B && L <= R) {
            if (dir == 0) { //Traverse left to right
                for (int i = L; i <= R; i++) {
                    result.add(arr[T][i]);
                }
                T++;
            } else if (dir == 1) { //Traverse right to bottom
                for (int i = T; i <= B; i++) {
                    result.add(arr[i][R]);
                }
                R--;
            } else if (dir == 2) { // right to left
                for (int i = R; i >= L; i--){
                    result.add(arr[B][i]);
                }
                B--;
            } else if (dir == 3) { //bottom to top
                for (int i = B; i >= T; i--) {
                    result.add(arr[i][L]);
                }
                L++;
            }
            dir = (dir + 1) % 4; //1 = next direction, 4 = direction count
        }
        return result;
    }
}