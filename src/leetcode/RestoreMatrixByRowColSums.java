package leetcode;

public class RestoreMatrixByRowColSums {
    public static void main(String[] args) {
        // Problem number 1605

        int rowSum[] = {3,8};
        int colSum[] = {4,7};
        int[][] output = restoreMatrix(rowSum, colSum);
        for(int i=0; i<rowSum.length; i++){
            for(int j=0; j<colSum.length; j++){
                System.out.print(output[i][j]+", ");
            }
            System.out.println();
        }

    }
    public static int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int[][] output = new int [rowSum.length][colSum.length];
        for(int i=0; i<rowSum.length; i++){
            for(int j=0; j<colSum.length; j++){
                output[i][j] = Math.min(rowSum[i], colSum[j]);
                rowSum[i] -= output[i][j];
                colSum[j] -= output[i][j];
            }
        }
        return output;
    }
}
