package com.example.tictactoe;

public class Player {
    private int id;
    private String name;
    private PlayerType playerType;
    Player(int id, String name) {
        this.id = id;
        this.name = name;
        this.playerType = PlayerType.HUMAN;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }
}
