package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece{
	
	private ChessMatch chessMatch;
	
	public Pawn(Board board, Color color, ChessMatch chessMatch) {
		//passei uma referencia a partida. Lá no ChessMatch eu tenho que dizer qual partida. Posso usar o this
		super(board, color);
		this.chessMatch = chessMatch;
		
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		//Uma matriz auxiliar 
		Position p = new Position(0,0); //Uma posição auxiliar
		
		if (getColor() == Color.WHITE) {
			p.setValues(position.getRow() - 1, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				//significa que o peão pode ir para essa posição, que é uma linha para frente
				mat[p.getRow()][p.getColumn()] = true;
			}
			p.setValues(position.getRow() - 2, position.getColumn());
			Position p2 = new Position(position.getRow() - 1, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)&& getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
				//Posição p((que é a linha  -2)testa se existe, testa se está vazia)
				//Posição p2((que é a linha -1 ) testa se existe e testa se está vazia)
				//tbm testa se a quantidade de movimentos do peão(Pawn) é zero
				//se tudo isso for verdade, ele pode mover tbm para lá.
				//a condição vai testar se não tem peça na frente
				//significa que o peão pode ir para essa posição, duas casas a frente
				mat[p.getRow()][p.getColumn()] = true;
			}
			p.setValues(position.getRow() - 1, position.getColumn() - 1);
			//vai testar a diagonal superior esquerda
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				//se a posição existe e tem uma peça adversaria p, eu marco a posição como verdadeira.
				mat[p.getRow()][p.getColumn()] = true;
			}
			p.setValues(position.getRow() - 1, position.getColumn() + 1);
			//vai testar a diagonal superior direito
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				//se a posição existe e tem uma peça adversaria p, eu marco a posição como verdadeira.
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			// #specialmove en passant WHITE
			if(position.getRow() == 3) {
				Position left = new Position(position.getRow(), position.getColumn() -1);
				if(getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
					mat[left.getRow() -1][left.getColumn()] = true;
				}
				Position right = new Position(position.getRow(), position.getColumn() +1);
				if(getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
					mat[right.getRow() -1][right.getColumn()] = true;
				}
				
			}
		}
		else {
			p.setValues(position.getRow() + 1, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			p.setValues(position.getRow() + 2, position.getColumn());
			Position p2 = new Position(position.getRow() + 1, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)&& getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			p.setValues(position.getRow() + 1, position.getColumn() + 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			p.setValues(position.getRow() + 1, position.getColumn() + 1);
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				mat[p.getRow()][p.getColumn()] = true;
			}
			
			// #specialmove en passant BLACK
			if(position.getRow() == 4) {
				Position left = new Position(position.getRow(), position.getColumn() -1);
				if(getBoard().positionExists(left) && isThereOpponentPiece(left) && getBoard().piece(left) == chessMatch.getEnPassantVulnerable()) {
					mat[left.getRow() +1][left.getColumn()] = true;
				}
				Position right = new Position(position.getRow(), position.getColumn() +1);
				if(getBoard().positionExists(right) && isThereOpponentPiece(right) && getBoard().piece(right) == chessMatch.getEnPassantVulnerable()) {
					mat[right.getRow() +1][right.getColumn()] = true;
				}
				
			}
			
		}
		
		
		return mat;
	}
	
	@Override
	public String toString() {
		return "P";
	}

}
