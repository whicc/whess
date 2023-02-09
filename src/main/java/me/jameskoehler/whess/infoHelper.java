package me.jameskoehler.whess;

public class infoHelper {

    /**
     * Returns a byte with bits 0-2 set to the corresponding piece type.
     * It takes in a piece type using the deprecated PieceInfo enum.
     * When these bits are read, the following values represent the piece type:<br>
     * 0 - Rook<br>
     * 1 - Knight<br>
     * 2 - Bishop<br>
     * 3 - King<br>
     * 4 - Queen<br>
     * 5 - Pawn<br>
     * <p>
     * If the value passed is not a valid piece type, bit 5 will be set.
     * In the modern version of the code this represents an error,
     * but when used with legacy code it represents PieceInfo.EMPTY.
     *
     * @param type the type of the piece (i.e. pawn, rook, etc.)
     * @return     a byte where bits 0-2 are set to correspond to the piece type and bit 5 is an error flag
     */
    @Deprecated
    public static byte generateTypeByte(PieceInfo type){

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
    /**
     * Returns a byte with bits 0-2 set to the corresponding piece type.
     * It takes in a piece type using a String.
     * When these bits are read, the following values represent the piece type:<br>
     * 0 - Rook<br>
     * 1 - Knight<br>
     * 2 - Bishop<br>
     * 3 - King<br>
     * 4 - Queen<br>
     * 5 - Pawn<br>
     * If the value passed is not a valid piece type, bit 5 will be set.
     * In the modern version of the code this represents an error,
     * but when used with legacy code it represents PieceInfo.EMPTY.
     *
     * @param type the type of the piece (i.e. pawn, rook, etc.)
     * @return     a byte where bits 0-2 are set to correspond to the piece type and bit 5 is an error flag
     */
    public static byte generateTypeByte(String type){
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

    /**
     * Returns a byte with byte 3 representing the color of the piece.
     * When set to 0 the piece is white, and when set to 1 the piece is black.
     * This method uses the deprecated PieceInfo enum to pass the color in.
     * <p>
     * If the value passed is not a valid piece type, bit 6 will be set.
     * In the modern version of the code this represents an error, but when used with legacy code it represents PieceInfo.EMPTY.
     *
     * @param color the color of the piece
     * @return      a byte where bit 3 is the color and bit 6 is an error flag
     */
    @Deprecated
    public static byte generateColorByte(PieceInfo color){

        if(color == PieceInfo.WHITE) return 0;
        else if(color == PieceInfo.BLACK) return (byte)(1 << 3);

        return (byte)(1 << 6);
    }
    /**
     * Returns a byte with byte 3 representing the color of the piece.
     * When set to 0 the piece is white, and when set to 1 the piece is black.
     * This method uses a String to pass the color in.
     * <p>
     * If the value passed is not a valid piece type, bit 6 will be set.
     * In the modern version of the code this represents an error, but when used with legacy code it represents PieceInfo.EMPTY.
     *
     * @param color the color of the piece
     * @return      a byte where bit 3 is the color and bit 6 is an error flag
     */
    public static byte generateColorByte(String color){

        if(color == "white") return 0;
        else if (color == "black") return (byte)(1 << 3);

        return (byte)(1 << 6);
    }

    /**
     * Returns a byte with bit 4 representing if the piece has moved since the start of the match.
     * When set to 1 the piece has moved, and when set to 0 it has not.
     *
     * @param hasMoved if the piece has moved or not
     * @return         a byte where bit 4 is set if the piece has moved
     */
    public static byte generateMoveByte(boolean hasMoved){

        if(hasMoved){
            return (byte)(1<<4);
        }

        return 0;
    }
}
