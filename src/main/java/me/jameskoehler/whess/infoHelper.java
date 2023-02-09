package me.jameskoehler.whess;

public class infoHelper {

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

    @Deprecated
    public static byte generateColorByte(PieceInfo color){

        if(color == PieceInfo.WHITE) return 0;
        else if(color == PieceInfo.BLACK) return (byte)(1 << 3);

        return (byte)(1 << 6);
    }
    public static byte generateColorByte(String color){

        if(color == "white") return 0;
        else if (color == "black") return (byte)(1 << 3);

        return (byte)(1 << 6);
    }

    public static byte generateMoveByte(boolean hasMoved){

        if(hasMoved){
            return (byte)(1<<4);
        }

        return 0;
    }
}
