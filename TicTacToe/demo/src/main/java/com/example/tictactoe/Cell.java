package com.example.tictactoe;

//use lombok annotation for auto complete getter and setters

public class Cell {
    private int r;
    private int c;
    private CellState cellState;
    private Player player;

    Cell(int r , int c){
        this.r = r;
        this.c = c;
        this.cellState = CellState.EMPTY;
    }

    public int getRow() {
        return r;
    }

    public int getColumn() {
        return c;
    }

    public void setRow(int r) {
        this.r = r;
    }

    public void setColumn(int c) {
        this.c = c;
    }

    public void setCellState(CellState cellState) {
        this.cellState = cellState;
    }

    public CellState getCellState() {
        return cellState;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }
}
