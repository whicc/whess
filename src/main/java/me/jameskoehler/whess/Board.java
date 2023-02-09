package me.jameskoehler.whess;

public class Board {

    Piece[] pieces;

    /**
     * This creates a chess board set up for the start of a match, with white at the bottom and black at the top.
     */
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

    /**
     * This creates a chess board based on the board state passed in.
     * The new system no longer uses board states, so this is somewhat slow.
     * @param boardState
     */
    @Deprecated
    public Board(Piece[][] boardState){

        Piece[] tempPieces = new Piece[boardState.length * boardState[0].length];

        int index = 0;

        for(int x = 0; x < boardState.length; x++){ // this loop iterates through the pieces in the boardState

            for(int y = 0; y < boardState[x].length; y++){

                if(boardState[x][y].isTypeFlagSet() || boardState[x][y].isColorFlagSet())
                    continue; // we no longer store empty slots on the board

                // we now have to make sure the pieces know their own coordinates
                boardState[x][y].setX(x + 1);
                boardState[x][y].setY(y + 1);

                // we now save this valid piece to the tempPieces array, and move the index forward once
                tempPieces[index] = boardState[x][y];
                index++;
            }
        }

        // resize pieces array to the amount of valid pieces saved
        pieces = new Piece[index + 1];

        // fill only the valid pieces into the pieces array
        for(int i = 0; i < pieces.length; i++)
            pieces[i] = tempPieces[i];
    }
}
