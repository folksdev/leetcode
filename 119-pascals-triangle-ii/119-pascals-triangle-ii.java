class Solution {
    public List<Integer> getRow(int rowIndex) {
        return generate(rowIndex + 1).get(rowIndex);
    }
    
    public List<List<Integer>> generate(int numRows) {

        if (numRows == 1) {
            return List.of(List.of(1));
        }
        if (numRows == 2) {
            return List.of(List.of(1),List.of(1,1));
        }
        List<List<Integer>> result = new ArrayList<>();
        result.add(List.of(1));
        result.add(List.of(1,1));
        List<Integer> prev = result.get(1);
        for (int i = 2; i < numRows; i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(1);
            for (int j = 0; j < prev.size() - 1; j++) {
                temp.add(prev.get(j) + prev.get(j + 1));
            }
            temp.add(1);
            prev = temp;
            result.add(temp);
        }

        return result;
    }
}