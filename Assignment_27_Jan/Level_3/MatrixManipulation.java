import java.util.*;
 public class MatrixManipulation {
 	public static int[][] generateRandomMatrix(int row, int col) {
     	Random rand = new Random();
     	int[][] matrix = new int[row][col];
     	for (int i = 0; i < row; i++) {
         	for (int j = 0; j < col; j++) {
             	matrix[i][j] = rand.nextInt(10);
         	}
     	}
     	return matrix;
 	}

 	public static int[][] addMatrices(int[][] matrix1, int[][] matrix2) {
     	int row = matrix1.length;
     	int col = matrix1[0].length;
     	int[][] res = new int[row][col];
     	for (int i = 0; i < row; i++) {
         	for (int j = 0; j < col; j++) {
             	res[i][j] = matrix1[i][j] + matrix2[i][j];
         	}
     	}
     	return res;
 	}

 	public static int[][] subtractMatrices(int[][] matrix1, int[][] matrix2) {
     	int row = matrix1.length;
     	int col = matrix1[0].length;
     	int[][] res = new int[row][col];
     	for (int i = 0; i < row; i++) {
         	for (int j = 0; j < col; j++) {
             	res[i][j] = matrix1[i][j] - matrix2[i][j];
         	}
     	}
     	return res;
 	}

 	public static int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
     	int row = matrix1.length;
     	int col = matrix2[0].length;
     	int common = matrix1[0].length;
     	int[][] res = new int[row][col];
     	for (int i = 0; i < row; i++) {
         	for (int j = 0; j < col; j++) {
             	for (int k = 0; k < common; k++) {
                 	res[i][j] += matrix1[i][k] * matrix2[k][j];
             	}
         	}
     	}
     	return res;
 	}

 	public static int[][] transposeMatrix(int[][] matrix) {
     	int row = matrix.length;
     	int col = matrix[0].length;
     	int[][] transpose = new int[col][row];
     	for (int i = 0; i < row; i++) {
         	for (int j = 0; j < col; j++) {
             	transpose[j][i] = matrix[i][j];
         	}
     	}
     	return transpose;
 	}

 	public static int determinant2x2(int[][] matrix) {
     	return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
 	}

 	public static int determinant3x3(int[][] matrix) {
     	return matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1])
          	- matrix[0][1] * (matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0])
          	+ matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]);
 	}

 	public static double[][] inverse2x2(int[][] matrix) {
     	int det = determinant2x2(matrix);
     	if (det == 0) {
         	throw new ArithmeticException("Matrix is not invertible.");
     	}

     	double[][] inverse = new double[2][2];
     	inverse[0][0] = matrix[1][1] / (double) det;
     	inverse[0][1] = -matrix[0][1] / (double) det;
     	inverse[1][0] = -matrix[1][0] / (double) det;
     	inverse[1][1] = matrix[0][0] / (double) det;

     	return inverse;
 	}

 	public static double[][] inverse3x3(int[][] matrix) {
     	int det = determinant3x3(matrix);
     	if (det == 0) {
         	throw new ArithmeticException("Matrix is not invertible.");
     	}

     	double[][] inverse = new double[3][3];
     	for (int i = 0; i < 3; i++) {
         	for (int j = 0; j < 3; j++) {
             	int[][] minor = getMinor(matrix, i, j);
             	int sign = (i + j) % 2 == 0 ? 1 : -1;
             	inverse[j][i] = sign * determinant2x2(minor) / (double) det;
         	}
     	}
     	return inverse;
 	}

 	private static int[][] getMinor(int[][] matrix, int row, int col) {
     	int[][] minor = new int[2][2];
     	int r = 0;
     	for (int i = 0; i < 3; i++) {
         	if (i == row) continue;
        	 int c = 0;
         	for (int j = 0; j < 3; j++) {
             	if (j == col) continue;
             	minor[r][c++] = matrix[i][j];
         	}
         	r++;
     	}
     	return minor;
 	}

 	public static void displayMatrix(int[][] matrix) {
     	for (int[] row : matrix) {
         	for (int element : row) {
             	System.out.print(element + " ");
         	}
         	System.out.println();
     	}
 	}

 	public static void displayMatrix(double[][] matrix) {
     	for (double[] row : matrix) {
         	for (double element : row) {
             	System.out.printf("%.2f ", element);
         	}
         	System.out.println();
     	}
 	}

 	public static void main(String[] args) {
     	Scanner sc = new Scanner(System.in);
     	System.out.println("Enter the number of rows and columns for the matrices:");
     	int row = sc.nextInt();
     	int col = sc.nextInt();

     	int[][] matrix1 = generateRandomMatrix(row, col);
     	int[][] matrix2 = generateRandomMatrix(row, col);

     	System.out.println("Matrix 1:");
     	displayMatrix(matrix1);
     	System.out.println("Matrix 2:");
     	displayMatrix(matrix2);

     	System.out.println("Addition of Matrices:");
     	displayMatrix(addMatrices(matrix1, matrix2));

     	System.out.println("Subtraction of Matrices:");
         displayMatrix(subtractMatrices(matrix1, matrix2));

     	if (row == col) {
         	System.out.println("Transpose of Matrix 1:");
      	   displayMatrix(transposeMatrix(matrix1));
         	if (row == 2) {
             	System.out.println("Determinant of Matrix 1: " + determinant2x2(matrix1));
             	System.out.println("Inverse of Matrix 1:");
             	displayMatrix(inverse2x2(matrix1));
         	}
     	else if (row == 3) {
             	System.out.println("Determinant of Matrix 1: " + determinant3x3(matrix1));
             	System.out.println("Inverse of Matrix 1:");
                 displayMatrix(inverse3x3(matrix1));
         	}
     	}
 	else {
         	System.out.println("Transpose, determinant, and inverse are not applicable for non-square matrices.");
     	}
 	}
 }
