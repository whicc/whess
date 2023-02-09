package me.jameskoehler.whess;

public class Board {

    Piece[] pieces;

    public Board(){

        pieces = new Piece[]{
                new Piece(1, 1, "rook", "white", false),
                new Piece(2, 1, "knight", "white", false),
                new Piece(3, 1, "bishop", "white", false),
                new Piece(4, 1, "king", "white", false),
                new Piece(5, 1, "queen", "white", false),
                new Piece(6, 1, "bishop", "white", false),
                new Piece(7, 1, "knight", "white", false),
                new Piece(8, 1, "rook", "white", false),
                new Piece(1, 2, "pawn", "white", false),
                new Piece(2, 2, "pawn", "white", false),
                new Piece(3, 2, "pawn", "white", false),
                new Piece(4, 2, "pawn", "white", false),
                new Piece(5, 2, "pawn", "white", false),
                new Piece(6, 2, "pawn", "white", false),
                new Piece(7, 2, "pawn", "white", false),
                new Piece(8, 2, "pawn", "white", false),
                new Piece(1, 8, "rook", "black", false),
                new Piece(2, 8, "knight", "black", false),
                new Piece(3, 8, "bishop", "black", false),
                new Piece(4, 8, "king", "black", false),
                new Piece(5, 8, "queen", "black", false),
                new Piece(6, 8, "bishop", "black", false),
                new Piece(7, 8, "knight", "black", false),
                new Piece(8, 8, "rook", "black", false),
                new Piece(1, 7, "pawn", "black", false),
                new Piece(2, 7, "pawn", "black", false),
                new Piece(3, 7, "pawn", "black", false),
                new Piece(4, 7, "pawn", "black", false),
                new Piece(5, 7, "pawn", "black", false),
                new Piece(6, 7, "pawn", "black", false),
                new Piece(7, 7, "pawn", "black", false),
                new Piece(8, 7, "pawn", "black", false)};
    }
}
