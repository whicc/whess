package me.jameskoehler.whess;

public class Piece {

    private int m_x;
    private int m_y;

    private byte m_info;
    // bits 0 - 2 are type
    // bit 3 is color (0 for white 1 for black)
    // bit 4 is if the piece has moved or not (0 has not moved 1 has moved)
    // bit 5 is type error
    // bit 6 is color error

    /**
     * This creates a piece with an invalid location and its info byte set to 0.
     */
    public Piece(){

        m_x = -1;
        m_y = -1;

        m_info = 0;
    }

    /**
     * This creates a piece with an invalid location, but its info byte is filled based on the parameters passed to it.
     * @param type     the type of the piece (i.e. pawn, rook, etc.)
     * @param color    the color of the piece
     * @param hasMoved if the piece has moved or not
     */
    public Piece(String type, String color, boolean hasMoved){

        m_x = -1;
        m_y = -1;

        m_info = (byte) (infoHelper.generateTypeByte(type) | infoHelper.generateColorByte(color) | infoHelper.generateMoveByte(hasMoved));
    }

    /**
     * This created a piece based on the passed location, and information.
     * @param x        the x coordinate of the piece
     * @param y        the y coordinate of the piece
     * @param type     the type of the piece (i.e. pawn, rook, etc.)
     * @param color    the color of the piece
     * @param hasMoved if the piece has moved or not
     */
    public Piece(int x, int y, String type, String color, boolean hasMoved){

        m_x = x;
        m_y = y;

        m_info = (byte) (infoHelper.generateTypeByte(type) | infoHelper.generateColorByte(color) | infoHelper.generateMoveByte(hasMoved));
    }

    /**
     * This creates a piece based on the passed location, and a preset information byte.
     * @param x    the x coordinate of the piece
     * @param y    the y coordinate of the piece
     * @param info a byte containing type, color, and move status of the piece
     */
    public Piece(int x, int y, byte info){

        m_x = x;
        m_y = y;

        m_info = info;
    }

    /**
     * This creates a piece with an invalid location, but its info byte is filled based on the parameters passed to it.
     * @param type     the type of the piece (i.e. pawn, rook, etc.)
     * @param color    the color of the piece
     * @param hasMoved if the piece has moved or not
     */
    @Deprecated
    public Piece(PieceInfo type, PieceInfo color, boolean hasMoved){

        m_x = -1;
        m_y = -1;

        m_info = (byte) (infoHelper.generateTypeByte(type) | infoHelper.generateColorByte(color) | infoHelper.generateMoveByte(hasMoved));
    }

    /**
     * This created a piece based on the passed location, and information.
     * @param x        the x coordinate of the piece
     * @param y        the y coordinate of the piece
     * @param type     the type of the piece (i.e. pawn, rook, etc.)
     * @param color    the color of the piece
     * @param hasMoved if the piece has moved or not
     */
    @Deprecated
    public Piece(int x, int y, PieceInfo type, PieceInfo color, boolean hasMoved){

        m_x = x;
        m_y = y;

        m_info = (byte) (infoHelper.generateTypeByte(type) | infoHelper.generateColorByte(color) | infoHelper.generateMoveByte(hasMoved));
    }

    /**
     * Returns the type of the piece as a PieceInfo enum.
     * @return the type of the piece (i.e. pawn, rook, etc.)
     */
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

    /**
     * Returns the type of the piece as a String.
     * @return the type of the piece (i.e. pawn, rook, etc.)
     */
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

    /**
     * @return if the type flag bit (5) is set
     */
    public boolean isTypeFlagSet(){

        return ((m_info & 32) == 32);
    }

    /**
     * Sets the type of the piece using the PieceInfo enum.
     * @param type the type of the piece (i.e. pawn, rook, etc.)
     */
    @Deprecated
    public void setType(PieceInfo type){

        m_info >>= 3;
        m_info <<= 3;

        m_info |= infoHelper.generateTypeByte(type);
    }

    /**
     * Sets the type of the piece using a String.
     * @param type the type of the piece (i.e. pawn, rook, etc.)
     */
    public void setType(String type){

        m_info >>= 3;
        m_info <<= 3;

        m_info |= infoHelper.generateTypeByte(type);
    }

    /**
     * Returns the color of the piece as a PieceInfo enum.
     * @return the color of the piece
     */
    @Deprecated
    public PieceInfo getColor(){

        if((m_info & 64) == 64) return PieceInfo.EMPTY;

        if((m_info & 8) == 8) return PieceInfo.BLACK;
        return PieceInfo.WHITE;
    }

    /**
     * Returns the color of the piece as a PieceInfo enum.
     * @return the color of the piece
     */
    @Deprecated
    public PieceInfo getAffiliation(){

        if((m_info & 64) == 64) return PieceInfo.EMPTY;

        if((m_info & 8) == 8) return PieceInfo.BLACK;
        return PieceInfo.WHITE;
    }

    /**
     * Returns the color of the piece as a String.
     * @return the color of the piece
     */
    public String getColorString(){

        if((m_info & 64) == 64) return "error";

        if((m_info & 8) == 8) return "black";
        return "white";
    }

    /**
     * Returns if the piece is white or not.
     * @return is the piece white
     */
    public boolean isWhite(){

        return ((m_info & 8) == 0);
    }

    /**
     * @return if the color flag bit (6) is set
     */
    public boolean isColorFlagSet(){

        return ((m_info & 64) == 64);
    }

    /**
     * Sets the color of the piece using the PieceInfo enum.
     * @param color the color of the piece
     */
    @Deprecated
    public void setColor(PieceInfo color){

        m_info &= infoHelper.generateColorByte(color);
    }

    /**
     * Sets the color of the piece using the PieceInfo enum.
     * @param color the color of the piece
     */
    @Deprecated
    public void setAffiliation(PieceInfo color){

        m_info &= infoHelper.generateColorByte(color);
    }

    /**
     * Sets the color of the piece using a String.
     * @param color the color of the piece
     */
    public void setColor(String color){

        m_info &= infoHelper.generateColorByte(color);
    }

    /**
     * Returns if the piece has moved or not.
     * @return if the piece has moved
     */
    public boolean getHasMoved(){

        return ((m_info & 16) == 16);
    }

    /**
     * Sets if the piece has moved
     * @param hasMoved if the piece has moved
     */
    public void setHasMoved(boolean hasMoved){

        m_info &= infoHelper.generateMoveByte(hasMoved);
    }

    /**
     *
     * @return the x coordinate of the piece
     */
    public int getX(){

        return m_x;
    }

    /**
     *
     * @param x the new x coordinate of the piece
     */
    public void setX(int x){

        m_x = x;
    }

    /**
     *
     * @return the y coordinate of the piece
     */
    public int getY(){

        return m_y;
    }

    /**
     *
     * @param y the new y coordinate of the piece
     */
    public void setY(int y){

        m_y = y;
    }

    /**
     *
     * @return the info byte of the piece
     */
    public byte getInfo(){

        return m_info;
    }

    /**
     *
     * @param info the new info byte of the piece
     */
    public void setInfo(byte info){

        m_info = info;
    }

    @Override
    public String toString(){

        String stringForm = getColorString() + " " + getTypeString() + " at ";
        stringForm += (char)(m_x + 64); // this converts the numbers 1-8 to the letters a-h
        stringForm += ", " + m_y;

        return stringForm;
    }
}
