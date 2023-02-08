package me.jameskoehler.whess;

public class Piece {

    int m_x;
    int m_y;

    byte m_info;
    // bits 0 - 2 are type
    // bit 3 is color (0 for white 1 for black)
    // bit 4 is if the piece has moved or not (0 has not moved 1 has moved)
    // bit 5 is type error
    // bit 6 is color error

    public Piece(){

        m_x = 0;
        m_y = 0;

        m_info = (byte)(infoHelper_generateTypeByte(PieceInfo.ROOK) | infoHelper_generateColorByte(PieceInfo.BLACK));
    }

    @Deprecated
    public Piece(PieceInfo type, PieceInfo color, boolean hasMoved){

        m_x = -1;
        m_y = -1;

        m_info = (byte) (infoHelper_generateTypeByte(type) | infoHelper_generateColorByte(color) | infoHelper_generateMoveByte(hasMoved));
    }

    public Piece(int x, int y, PieceInfo type, PieceInfo color, boolean hasMoved){

        m_x = x;
        m_y = y;

        m_info = (byte) (infoHelper_generateTypeByte(type) | infoHelper_generateColorByte(color) | infoHelper_generateMoveByte(hasMoved));
    }

    public byte infoHelper_generateTypeByte(PieceInfo type){

        return switch (type) {
            case ROOK -> 0;
            case KNIGHT -> 1;
            case BISHOP -> 2;
            case KING -> 3;
            case QUEEN -> 4;
            case PAWN -> 5;
            default -> (byte)(1 << 5);
        };
    }
    public byte infoHelper_generateTypeByte(String type){
        return switch (type) {
            case "rook" -> 0;
            case "knight" -> 1;
            case "bishop" -> 2;
            case "king" -> 3;
            case "queen" -> 4;
            case "pawn" -> 5;
            default -> (byte) (1 << 5);
        };
    }
    public byte infoHelper_generateColorByte(PieceInfo color){

        if(color == PieceInfo.WHITE){
            return 0;
        }else if(color == PieceInfo.BLACK){
            return (byte)(1 << 3);
        }

        return (byte)(1<<6);
    }
    public byte infoHelper_generateMoveByte(boolean hasMoved){

        if(hasMoved){
            return (byte)(1<<4);
        }

        return 0;
    }
}
