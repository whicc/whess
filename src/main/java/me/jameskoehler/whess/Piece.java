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

        m_info = (byte)(infoHelper.generateTypeByte(PieceInfo.ROOK) | infoHelper.generateColorByte(PieceInfo.BLACK));
    }
    public Piece(String type, String color, boolean hasMoved){

        m_x = -1;
        m_y = -1;

        m_info = (byte) (infoHelper.generateTypeByte(type) | infoHelper.generateColorByte(color) | infoHelper.generateMoveByte(hasMoved));
    }
    public Piece(int x, int y, String type, String color, boolean hasMoved){

        m_x = x;
        m_y = y;

        m_info = (byte) (infoHelper.generateTypeByte(type) | infoHelper.generateColorByte(color) | infoHelper.generateMoveByte(hasMoved));
    }

    @Deprecated
    public Piece(PieceInfo type, PieceInfo color, boolean hasMoved){

        m_x = -1;
        m_y = -1;

        m_info = (byte) (infoHelper.generateTypeByte(type) | infoHelper.generateColorByte(color) | infoHelper.generateMoveByte(hasMoved));
    }
    @Deprecated
    public Piece(int x, int y, PieceInfo type, PieceInfo color, boolean hasMoved){

        m_x = x;
        m_y = y;

        m_info = (byte) (infoHelper.generateTypeByte(type) | infoHelper.generateColorByte(color) | infoHelper.generateMoveByte(hasMoved));
    }

    @Deprecated
    public PieceInfo getType(){

        if((m_info & 32) == 32) return PieceInfo.EMPTY;

        byte type = (byte) (m_info & 7);

        return switch(type){
            case 0 -> PieceInfo.ROOK;
            case 1 -> PieceInfo.KNIGHT;
            case 2 -> PieceInfo.BISHOP;
            case 3 -> PieceInfo.KING;
            case 4 -> PieceInfo.QUEEN;
            case 5 -> PieceInfo.PAWN;
            default -> PieceInfo.ERROR;
        };
    }
    public String getTypeString(){

        if((m_info & 32) == 32) return "error";

        byte type = (byte) (m_info & 7);

        return switch(type){
            case 0 -> "rook";
            case 1 -> "knight";
            case 2 -> "bishop";
            case 3 -> "king";
            case 4 -> "queen";
            case 5 -> "pawn";
            default -> "error";
        };
    }

    @Deprecated
    public void setType(PieceInfo type){

        m_info >>= 3;
        m_info <<= 3;

        m_info |= infoHelper.generateTypeByte(type);
    }
    public void setType(String type){

        m_info >>= 3;
        m_info <<= 3;

        m_info |= infoHelper.generateTypeByte(type);
    }

    @Deprecated
    public PieceInfo getColor(){

        if((m_info & 64) == 64) return PieceInfo.EMPTY;

        if((m_info & 8) == 8) return PieceInfo.BLACK;
        return PieceInfo.WHITE;
    }
    @Deprecated
    public PieceInfo getAffiliation(){

        if((m_info & 64) == 64) return PieceInfo.EMPTY;

        if((m_info & 8) == 8) return PieceInfo.BLACK;
        return PieceInfo.WHITE;
    }
    public String getColorString(){

        if((m_info & 64) == 64) return "error";

        if((m_info & 8) == 8) return "black";
        return "white";
    }
    public boolean isWhite(){

        return ((m_info & 8) == 0);
    }

    @Deprecated
    public void setColor(PieceInfo color){

        m_info &= infoHelper.generateColorByte(color);
    }
    @Deprecated
    public void setAffiliation(PieceInfo color){

        m_info &= infoHelper.generateColorByte(color);
    }
    public void setColor(String color){

        m_info &= infoHelper.generateColorByte(color);
    }

    public boolean getHasMoved(){

        return ((m_info & 16) == 16);
    }
    public void setHasMoved(boolean hasMoved){

        m_info &= infoHelper.generateMoveByte(hasMoved);
    }
}
