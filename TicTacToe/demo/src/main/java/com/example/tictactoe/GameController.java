package com.example.tictactoe;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameController {
    private Player currentPlayer;
    private int nextPlayerIndex = 0;
    private List<Player> players = new ArrayList<Player>();
    private List<WinningStrategy> winningStrategies = new ArrayList<>();;

    private Game game;
    private Board board;

    public void addPlayer(Player player) {
        players.add(player);
    }

    public void addWinningStrategies(WinningStrategy winningStrategy) {
        winningStrategies.add(winningStrategy);
    }

    public int getBoardSize() {
        return players.size() + 1;
    }

    public void initGame() {
        board = new Board(players.size() + 1);
        game = new Game(board, winningStrategies);
    
        Scanner scanner = new Scanner(System.in);
        while(game.getGameStatus() == GameStatus.IN_PROGRESS) {
            //System.out.println("Select option:\n1. make move\n2. ")
            currentPlayer = players.get(nextPlayerIndex);
            System.out.println("its turn of player \"" + currentPlayer.getName() + "\"");
            System.out.println("Enter row and column for move");
            int r = scanner.nextInt();
            int c = scanner.nextInt();
            int moveStatus = game.makeMove(new Move(new Cell(r,c), currentPlayer));
            System.out.println();

            if(moveStatus == -1) {
                System.out.println("Not a valid move..");
                game.displayBoard();
                continue;
            } else {
                if(game.getGameStatus() != GameStatus.IN_PROGRESS) break;
                System.out.println("Hey\"" + currentPlayer.getName() + "\"! .. do you want to undo this move?");
                System.out.println("Enter Y for yes, N for no");
                char ch = scanner.next().charAt(0);
                if(ch == 'Y' || ch == 'y') {
                    game.undo();
                    game.displayBoard();
                    continue;
                }
            }
            game.displayBoard();
            nextPlayerIndex  = (nextPlayerIndex + 1) % players.size();
        }
        game.displayBoard();
        if(game.getGameStatus() == GameStatus.ENDED) {
            System.out.println("Winner of this game is :" + game.getWinner().getName());
        } else {
            System.out.println("This game resulted in draw");
        }
        scanner.close();
    }
}
