package com.example.tictactoe;

import java.util.List;

public class Game {
    private int totalMoves;
    private GameStatus gameStatus;
    private Player winner;
    private List<WinningStrategy> winningStrategies;
    private Move lastMove;
    Board board;

    Game(Board board, List<WinningStrategy> winningStrategies) {
        this.gameStatus = GameStatus.IN_PROGRESS;
        this.winningStrategies = winningStrategies;
        this.board = board;
        totalMoves = 0;
    }

    private boolean isValidMove(Move move) {
        Cell cellFromMove = move.getCell();
        if(cellFromMove.getRow() >= board.getGridSize() || cellFromMove.getRow() < 0) return false;
        if(cellFromMove.getColumn() >= board.getGridSize() || cellFromMove.getColumn() < 0) return false;
        Cell cellFromBoard = board.getCell(cellFromMove.getRow(), cellFromMove.getColumn());
        if(cellFromBoard.getCellState() != CellState.EMPTY) return false;
        return true;
    }

    public int makeMove(Move move) {
        if(!isValidMove(move)) return -1;
        //use getCell and modify the required fields
        Cell cellFromMove = move.getCell();
        Cell cell = board.getCell(cellFromMove.getRow(), cellFromMove.getColumn());
        cell.setCellState(CellState.FILLED);
        cell.setPlayer(move.getPlayer());

        for(WinningStrategy winningStrategy : winningStrategies) {
            winningStrategy.onMove(move);
            winner = winningStrategy.getWinner();
            if(winner != null) {
                gameStatus = GameStatus.ENDED;
                break;
            }
        }
        lastMove = move;
        totalMoves++;
        if(winner != null) return 0;
        if(totalMoves == board.getGridSize() * board.getGridSize()) {
            gameStatus = GameStatus.DRAW;
        }
        return 0;
    }

    public int undo() {
        if(lastMove == null) return -1;
        Cell cell = board.getCell(lastMove.getCell().getRow(), lastMove.getCell().getColumn());
        cell.setCellState(CellState.EMPTY);
        cell.setPlayer(null);

        for(WinningStrategy winningStrategy : winningStrategies) {
            winningStrategy.undo(lastMove);
        }
        lastMove = null;
        totalMoves--;
        return 0;
    }

    public GameStatus getGameStatus(){
        return gameStatus;
    }

    public Player getWinner() {
        return winner;
    }

    public void displayBoard() {
        board.displayBoard();
    }

}
