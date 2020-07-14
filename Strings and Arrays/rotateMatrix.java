/*
Rotate Matrix: Given an image represented by an NxN matrix, where each pixel in the image is 4
bytes, write a method to rotate the image by 90 degrees. Can you do this in place? 

think about how to apply this problem to an n*m matrix?
*/

public class rotateMatrix {
    public static void rotate(int [] [] matrix){
        transpose(matrix);
        printMatrix(matrix);
        for(int i = 0; i < matrix.length; i++){
            reverseArr(matrix[i]);
        }
        printMatrix(matrix);
    }


    public static void transpose(int [] [] matrix){ // flips matrix 180 degrees
        for(int i = 0; i < matrix.length; i++){
            for(int j = i + 1; j < matrix.length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public static void reverseArr(int [] m){ 
        int end = m.length - 1;
        for(int i = 0; i < m.length/2; i++){
            int temp = m[end];
            m[end] = m[i];
            m[i] = temp;
        }
    }
    public static void printMatrix(int [] [] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[i].length; j++){
                System.out.print("[" + matrix[i][j] + "]");
            }
            System.out.println();
        }
        System.out.println();
    }
    public static void main (String[] args){
        int [] [] test = new int [] [] {{1,2,3},{4,5,6},{7,8,9}};
        int [] [] test2 = new int [] [] {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        rotate(test);
        rotate(test2);
    }
}