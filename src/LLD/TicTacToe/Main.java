package LLD.TicTacToe;

import LLD.TicTacToe.Model.*;

/**
 * @author parachau
 **/
public class Main {
    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame();
        System.out.println("Game won by: " + game.startGame());
    }
}
