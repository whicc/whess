package me.jameskoehler.whess;

public class Board {

    private Piece[] m_pieces;

    private String m_portableGameNotation;

    /**
     * This creates a chess board set up for the start of a match, with white at the bottom and black at the top.
     */
    public Board(){

        m_pieces = new Piece[]{
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

        m_portableGameNotation = "";
    }

    /**
     * This creates a chess board based on the board state passed in.
     * The new system no longer uses board states, so this is somewhat slow.
     * @param boardState the boardState to initialize with
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
        m_pieces = new Piece[index + 1];

        // fill only the valid pieces into the pieces array
        for(int i = 0; i < m_pieces.length; i++)
            m_pieces[i] = tempPieces[i];

        m_portableGameNotation = "";
    }

    /**
     * This creates board with the passed pieces array
     * @param pieces the Piece array to initialize with
     */
    public Board(Piece[] pieces){

        m_pieces = pieces;

        m_portableGameNotation = "";
    }

    /**
     * This takes in a chess game's history using portable game notation.
     * @param portableGameNotation the game history to initialize the board with
     */
    public Board(String portableGameNotation){

        m_portableGameNotation = portableGameNotation;

        // TODO: PGN Parsing
    }

    /**
     * This method adds the movement of a piece to the portableGameNotation String.
     * @param piece the piece that moved
     * @param x     the x position of where it moved
     * @param y     the y position of where it moved
     */
    public void generatePGNForMove(Piece piece, int x, int y){

        // Step 1: get move number
        // Step 2: if white, move number ++
        // Add notation for piece and spot moved to

        boolean readingNum = false;
        String numRead = "";
        int moveNumber;

        /*
        Here we iterate through the string backwards to find the latest number.
        Once we find a move number, we record it to a String and then break out of the loop.
        The String is then parsed into an int to get us the move number.
         */
        for(int i = m_portableGameNotation.length() - 1; i > -1; i--){

            if(!readingNum){

                if(m_portableGameNotation.charAt(i) == '.')
                    readingNum = true;
            }else{

                if(m_portableGameNotation.charAt(i) == ' ')
                    break;

                numRead = m_portableGameNotation.charAt(i) + numRead;
            }
        }

        moveNumber = Integer.parseInt(numRead);

        if(piece.getColorString() == "white") { // this means we need to notate a new move has started

            moveNumber++;

            m_portableGameNotation += moveNumber + ". ";
        }

        m_portableGameNotation += switch(piece.getTypeString()){
            case "rook" -> "R";
            case "knight" -> "N";
            case "bishop" -> "B";
            case "king" -> "K";
            case "queen" -> "Q";
            default -> "";
        }; // piece type

        m_portableGameNotation += (char)(piece.getX() + 64);          // the x position
        m_portableGameNotation += piece.getY();                       // the y position
    }

    /**
     * This version of the movePiece method uses the old system of piece description.
     * This returns an int return code with the following meanings:
     * 0 - the move was made
     * 1 - the move failed
     * 2 - white has won
     * 3 - black has won
     *
     * @param oldX the x coordinate of the piece to move
     * @param oldY the y coordinate of the piece to move
     * @param newX the x coordinate of the destination
     * @param newY the y coordinate of the destination
     * @return the status of the move
     */
    @Deprecated
    public int movePiece(int oldX, int oldY, int newX, int newY){

        // TODO: implement piece moving

        return 0;
    }

    /**
     * This version of the movePiece method uses the new system of piece description.
     * This returns an int return code with the following meanings:
     * 0 - the move was made
     * 1 - the move failed
     * 2 - white has won
     * 3 - black has won
     *
     * @param piece the piece being moved
     * @param x the x coordinate of the destination
     * @param y the y coordinate of the destination
     * @return the status of the move
     */
    public int movePiece(Piece piece, int x, int y){

        return 0;
    }

    /**
     * Checks if a move is legal. This uses the old system of piece description
     * @param oldX the x coordinate of the piece to move
     * @param oldY the y coordinate of the piece to move
     * @param newX the x coordinate of the destination
     * @param newY the y coordinate of the destination
     * @return if the move is legal
     */
    @Deprecated
    public boolean isMoveValid(int oldX, int oldY, int newX, int newY){

        return true;
    }

    /**
     * Checks if a move is legal. This uses the new system of piece description
     * @param piece the piece to move
     * @param x the x coordinate of the destination
     * @param y the y coordinate of the destination
     * @return if the move is legal
     */
    public boolean isMoveValid(Piece piece, int x, int y){

        return true;
    }
}
