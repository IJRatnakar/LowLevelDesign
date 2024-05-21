package com.example.tictactoe;

//better use Cell instance instead of seperate r and c
public class Move {
    private Cell cell;
    private Player player;
    Move(Cell cell, Player player) {
        this.cell = cell;
        this.player = player;
    }

    public Player getPlayer() {
        return player;
    }

    public Cell getCell() {
        return cell;
    }
}
