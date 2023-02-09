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
}
