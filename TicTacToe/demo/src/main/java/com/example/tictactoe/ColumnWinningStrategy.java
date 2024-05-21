package com.example.tictactoe;

import java.util.Arrays;

public class ColumnWinningStrategy implements WinningStrategy {
    private int[][] colCandidates;

    private int boardSize;
    private Player winner;
    ColumnWinningStrategy(int boardSize) {
        this.boardSize = boardSize;
        colCandidates = new int[boardSize][boardSize - 1];
        for(int i =0;i<colCandidates.length;i++)
        Arrays.fill(colCandidates[i], 0);
    }

    @Override
    public void onMove(Move move) {
        int playerId = move.getPlayer().getId();
        int colFromMove = move.getCell().getColumn();
        colCandidates[colFromMove][playerId]++;
        if(colCandidates[colFromMove][playerId] == boardSize) {
            winner = move.getPlayer();
        }
    }

    @Override
    public Player getWinner() {
        return winner;
    }

    @Override
    public void undo(Move move) {
        int playerId = move.getPlayer().getId();
        colCandidates[move.getCell().getColumn()][playerId]--;
    }
}
