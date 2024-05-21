package com.example.tictactoe;

public class Board {
    private int size;
    private Cell[][] cells;
    Board(int size) {
        this.size = size;
        cells = new Cell[size][size];
        for(int i =0 ;i< size;i++) {
            for(int j=0; j< size; j++) {
                cells[i][j] = new Cell(i,j);
            }
        }
    }
    public void displayBoard() {
        for(int i =0 ;i< size;i++) {
            for(int j=0; j< size; j++) {
                if(cells[i][j].getCellState() != CellState.EMPTY)
                System.out.print(cells[i][j].getPlayer().getId() + " ");
                else
                System.out.print("X" + " ");
            }
            System.out.println();
        }
    }

    public Cell getCell(int i, int j){
        return cells[i][j];
    }

    public int getGridSize(){
        return size;
    }
}
