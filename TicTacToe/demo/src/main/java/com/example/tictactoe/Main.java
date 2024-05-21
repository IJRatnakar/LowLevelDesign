package com.example.tictactoe;

public class Main {
    public static void main(String[] args) {
        GameController gameController = new GameController();
        gameController.addPlayer(new Player(0, "Indrajeet"));
        gameController.addPlayer(new Player(1, "Player2"));
        //gameController.addPlayer(new Player(3, "Creature"));
    
        int boardSize = gameController.getBoardSize();
        gameController.addWinningStrategies(new DiagonalWinningStrategy(boardSize));
        gameController.addWinningStrategies(new RowWinningStrategy(boardSize));
        gameController.addWinningStrategies(new ColumnWinningStrategy(boardSize));
        gameController.initGame();
    }
}