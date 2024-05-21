package com.example.tictactoe;

public interface WinningStrategy {
    public void onMove(Move move);
    public Player getWinner();
    public void undo(Move move);
}
