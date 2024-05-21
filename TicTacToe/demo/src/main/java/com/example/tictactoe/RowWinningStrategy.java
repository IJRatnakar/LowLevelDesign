package com.example.tictactoe;

import java.util.Arrays;

public class RowWinningStrategy implements WinningStrategy {
    private int[][] rowCandidates;

    private int boardSize;
    private Player winner;
    RowWinningStrategy(int boardSize) {
        this.boardSize = boardSize;
        rowCandidates = new int[boardSize][boardSize - 1];
        for(int i =0;i<rowCandidates.length;i++)
        Arrays.fill(rowCandidates[i], 0);
    }

    @Override
    public void onMove(Move move) {
        int playerId = move.getPlayer().getId();
        int rowFromMove = move.getCell().getRow();
        rowCandidates[rowFromMove][playerId]++;
        if(rowCandidates[rowFromMove][playerId] == boardSize) {
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
        rowCandidates[move.getCell().getRow()][playerId]--;
    }
}
