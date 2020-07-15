import java.util.*;
/*
Zero Matrix: Write an algorithm such that if an element in an MxN matrix is 0, its entire row and
column are set to 0. 

*/

public class ZeroMatrix{
    public static void zeroFill(int [] [] matrix){
        HashSet<int[]> set = new HashSet<int []>();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                if(matrix[i][j] == 0){
                    int [] temp = new int [] {i,j};
                    set.add(temp);
                }
            }
        }
        for(int [] i : set){
            SetRowCol(matrix, i[0], i[1]);
        }
    }

    public static void SetRowCol(int [] [] matrix, int row, int col){
        for(int i = 0; i < matrix[0].length; i++){
            matrix[row][i] = 0;
        }
        for(int i = 0; i < matrix.length; i++){
            matrix[i][col] = 0;
        }
    }

    public static void print(int [] [] m){
        for(int i = 0; i < m.length; i++){
            for(int j = 0; j < m[i].length; j++){
                System.out.print("[" + m[i][j] + "]");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main (String [] args){
        int [][] testMatrix = new int [][]{{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        zeroFill(testMatrix);
    }
}