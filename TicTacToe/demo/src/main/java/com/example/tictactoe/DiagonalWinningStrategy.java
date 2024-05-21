package com.example.tictactoe;

import java.util.Arrays;

public class DiagonalWinningStrategy implements WinningStrategy {

    private int[][] diagonalCandidates;
    private int boardSize;
    private Player winner;

    DiagonalWinningStrategy(int boardSize) {
        this.boardSize = boardSize;
        diagonalCandidates = new int[2][boardSize - 1];
        for(int i =0;i<2;i++)
        Arrays.fill(diagonalCandidates[i], 0);
    }
    private boolean isMoveOnDiagonalCell2(Move move) {
        Cell cell = move.getCell();
        if(cell.getRow() + cell.getColumn() == boardSize - 1) return true;
        return false;
    }

    private boolean isMoveOnDiagonalCell1(Move move) {
        Cell cell = move.getCell();
        if(cell.getRow() ==  cell.getColumn()) return true;
        return false;
    }
    @Override
    public void onMove(Move move) {
        int playerId = move.getPlayer().getId();
        if(isMoveOnDiagonalCell1(move)) {
            diagonalCandidates[0][playerId]++;
            if(diagonalCandidates[0][playerId] == boardSize) {
                winner = move.getPlayer();
            }
        }
        if(isMoveOnDiagonalCell2(move)) {
            diagonalCandidates[1][playerId]++;
            if(diagonalCandidates[1][playerId] == boardSize) {
                winner = move.getPlayer();
            }
        }
    }

    @Override
    public Player getWinner() {
        return winner;
    }

    @Override
    public void undo(Move move) {
        int playerId = move.getPlayer().getId();
        if(isMoveOnDiagonalCell1(move)) {
            diagonalCandidates[0][playerId]--;
        } else if(isMoveOnDiagonalCell2(move)) {
            diagonalCandidates[1][playerId]--;
        }
    }
}
