package leetcode;

class SubrectangleQueries {
    int[][] rectangle;
    public SubrectangleQueries(int[][] rectangle) {
        this.rectangle = rectangle;
    }

    public void updateSubrectangle(int row1, int col1, int row2, int col2, int newValue) {
        for(int i=row1; i<=row2; i++){
            for(int j=col1; j<=col2; j++){
                this.rectangle[i][j] = newValue;
            }
        }
    }

    public int getValue(int row, int col) {
        return this.rectangle[row][col];
    }
}

class Main{
    public static void main(String[] args) {
        /*
            ["SubrectangleQueries","getValue","updateSubrectangle","getValue","getValue","updateSubrectangle","getValue","getValue"]
            [[[[1,2,1],[4,3,4],[3,2,1],[1,1,1]]],[0,2],[0,0,3,2,5],[0,2],[3,1],[3,0,3,2,10],[3,1],[0,2]]
        */

        int[][] rectangle = {{1,2,1},{4,3,4},{3,2,1},{1,1,1}};
        int row1 = 0, col1=0, row2=3, col2=2, newValue=5;
        SubrectangleQueries obj = new SubrectangleQueries(rectangle);
        obj.updateSubrectangle(row1,col1,row2,col2,newValue);
        int param = obj.getValue(3,1);
        System.out.println("Updated value is: "+ param);
    }
}
