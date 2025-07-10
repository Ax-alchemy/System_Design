package LLD.TicTacToe.Model;

/**
 * @author parachau
 **/
public class Board {
    public int size;
    public Piece[][] board;
    public Board(int n){
        size = n;
        board = new Piece[n][n];
    }

    public Piece[][] getBoard() {
        return board;
    }

    public void setBoard(Piece[][] board) {
        this.board = board;
    }


    public boolean makeMove(Player p, int x,int y){
        if(x<1 || x>size || y<1 || y>size){
            System.out.println("Invalid move. Please enter again.");
            return false;
        }
        if(board[x-1][y-1]!=null){
            System.out.println("This cell is occupied. Please enter again.");
            return false;
        }
        board[x-1][y-1] = p.getPiece();
        return true;
    }



    public void printBoard(){
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                System.out.print("| ");
                if(board[i][j]!=null){
                    System.out.print(board[i][j].getPieceType()+" ");
                }
                else{
                    System.out.print("  ");
                }
            }
            System.out.println();
        }
    }

    public boolean freeSpaces(){
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(board[i][j]==null){
                    return true;
                }
            }
        }
        return false;
    }
}
