package LLD.TicTacToe;

import LLD.TicTacToe.Model.*;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

/**
 * @author parachau
 **/
public class TicTacToeGame {

    Deque<Player> players;
    Board gameBoard;

    TicTacToeGame(){
        initializeGame();
    }

    void initializeGame(){
        players = new ArrayDeque<>();
        Piece x = new PieceX();
        Piece o = new PieceO();
        players.add(new Player("Rohit",x));
        players.add(new Player("Virat",o));
        gameBoard = new Board(3);
    }

    public String startGame(){
        boolean winner = false;
        Scanner sc = new Scanner(System.in);
        while (!winner){
            Player currentPlayer = players.pollFirst();
            gameBoard.printBoard();
            boolean freeSpaces = gameBoard.freeSpaces();
            if(!freeSpaces){
                winner = true;
                continue;
            }


            System.out.println("Player " + currentPlayer.getName() + " please enter your move. Like 1,1");
            String location = sc.nextLine();
            String[] locations = location.split(",");
            int x = Integer.parseInt(locations[0].trim());
            int y = Integer.parseInt(locations[1].trim());

            boolean move = gameBoard.makeMove(currentPlayer, x, y);

            while(!move){
                location = sc.nextLine();
                locations = location.split(",");
                x = Integer.parseInt(locations[0].trim());
                y = Integer.parseInt(locations[1].trim());
                move = gameBoard.makeMove(currentPlayer, x, y);
            }

            players.addLast(currentPlayer);
            winner = checkWinner(x-1,y-1,currentPlayer.getPiece());
            if(winner){
                gameBoard.printBoard();
                return currentPlayer.getName();
            }
        }
        return "tie";
    }

    boolean checkWinner(int x,int y,Piece piece){
        boolean row = true;
        boolean col = true;
        boolean diagonal = true;
        boolean diagonal2 = true;
        //row
        for(int i=0;i<gameBoard.size;i++){
            if(gameBoard.board[x][i]!=piece){
                row = false;
                break;
            }
        }
        for(int i=0;i<gameBoard.size;i++){
            if(gameBoard.board[i][y]!=piece){
                col = false;
                break;
            }
        }
        for(int i=0;i<gameBoard.size;i++){
            if(gameBoard.board[i][i]!=piece){
                diagonal = false;
                break;
            }
        }
        for(int i=0,j=gameBoard.size-1;i<gameBoard.size;i++,j--){
            if(gameBoard.board[i][j]!=piece){
                diagonal2 = false;
                break;
            }
        }
        return row || col || diagonal || diagonal2;

    }


}
