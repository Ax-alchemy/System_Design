package LLD.TicTacToe.Model;

/**
 * @author parachau
 **/
public class Piece {
    private PieceType pieceType;
    Piece(PieceType pieceType) {
        this.pieceType = pieceType;
    }

    public PieceType getPieceType() {
        return pieceType;
    }

    public void setPieceType(PieceType pieceType) {
        this.pieceType = pieceType;
    }
}
