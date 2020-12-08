public class JZ_04 {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int rows = matrix.length, columns = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }


    /***
     * 从二维数组的右上角开始查找。如果当前元素等于目标值，则返回 true。
     * 如果当前元素大于目标值，则移到左边一列。
     * 如果当前元素小于目标值，则移到下边一行。
     *
     * if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
     *             return false;
     *         }
     *         int rows = matrix.length, columns = matrix[0].length;
     *         int row = 0, column = columns - 1;
     *         while (row < rows && column >= 0) {
     *             int num = matrix[row][column];
     *             if (num == target) {
     *                 return true;
     *             } else if (num > target) {
     *                 column--;
     *             } else {
     *                 row++;
     *             }
     *         }
     *         return false;
     *     }
     *
     * @param args
     */

    public static void main(String[] args) {
        JZ_04 tester = new JZ_04();
        int[][] test =
        {{1, 2, 3, 4, 5},
        {6, 7, 8, 9, 10},
        {11,12,13,14,15},
        {16,17,18,19,20},
        {21,22,23,24,25},
        {26,27,28,29,30}};

        boolean result = tester.findNumberIn2DArray(test,30);
        System.out.println(result);
        int [][] test1 = {{}};
        System.out.println(test1[0].length);
    }
}
