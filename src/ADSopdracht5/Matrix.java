/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ADSopdracht5;

/**
 *
 * @author John
 */
public class Matrix {
    int columns, rows, numSquares;

    int[][] matrix;

    Matrix(int numSquares, int columns, int rows) {
        this.columns = columns;
        this.rows = rows;
        this.numSquares = numSquares;
        matrix = new int[numSquares][numSquares];
        for (int i = 0; i < numSquares; i++) {
            for (int j = 0; j < numSquares; j++) {
                matrix[i][j] = 0;
            }
        }
        for (int i = 0; i < numSquares; i++) {//jumping
            jump(i);
        }
    }

    public void jump(int z) {//vertaal method
        int colum, row;//x = kolm y = rij
        colum = z / columns; // rekent kolm uit 
        row = z - colum * columns;//  rekent rij uit 
        setVisited(z, checkPossible(colum - 1, row - 2)); // mogelijk paard sprong 
        setVisited(z, checkPossible(colum - 1, row + 2));
        setVisited(z, checkPossible(colum + 1, row - 2));
        setVisited(z, checkPossible(colum + 1, row + 2));
        setVisited(z, checkPossible(colum - 2, row - 1));
        setVisited(z, checkPossible(colum - 2, row + 1));
        setVisited(z, checkPossible(colum + 2, row - 1));
        setVisited(z, checkPossible(colum + 2, row + 1));
    }

    public int checkPossible(int x, int y) {//
        if (x < 0 || x >= columns || y < 0 || y >= rows) {// blijf op het schakboard 
            return -1;
        }
        return x * rows + y;
    }

    public void setVisited(int z1, int z2) {// vullt het matrix
        if (z1 >= 0 && z2 >= 0) {
            matrix[z1][z2] = 1;
        }

    }

    public void printMatrix() {//print de matrix
        System.out.println("The adjacency-matrix : ");
        for (int i = 0; i < numSquares; i++) {
            for (int j = 0; j < numSquares; j++) {                
             System.out.print(matrix[i][j] + "  ");
            }
            System.out.println(" ");
        }
    }
    public int size() {
        return numSquares;
    }

    public int isNeighbour(int z1, int z2) {
        return matrix[z1][z2];
    }
}
