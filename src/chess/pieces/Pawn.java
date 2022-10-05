package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Pawn extends ChessPiece{

	public Pawn(Board board, Color color) {
		super(board, color);
		
	}

	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		//Uma matriz auxiliar 
		Position p = new Position(0,0); //Uma posi��o auxiliar
		
		if (getColor() == Color.WHITE) {
			p.setValues(position.getRow() - 1, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)) {
				//significa que o pe�o pode ir para essa posi��o, que � uma linha para frente
				mat[p.getRow()][p.getColumn()] = true;
			}
			p.setValues(position.getRow() - 2, position.getColumn());
			Position p2 = new Position(position.getRow() - 1, position.getColumn());
			if (getBoard().positionExists(p) && !getBoard().thereIsAPiece(p)&& getBoard().positionExists(p2) && !getBoard().thereIsAPiece(p2) && getMoveCount() == 0) {
				//Posi��o p((que � a linha  -2)testa se existe, testa se est� vazia)
				//Posi��o p2((que � a linha -1 ) testa se existe e testa se est� vazia)
				//tbm testa se a quantidade de movimentos do pe�o(Pawn) � zero
				//se tudo isso for verdade, ele pode mover tbm para l�.
				//a condi��o vai testar se n�o tem pe�a na frente
				//significa que o pe�o pode ir para essa posi��o, duas casas a frente
				mat[p.getRow()][p.getColumn()] = true;
			}
			p.setValues(position.getRow() - 1, position.getColumn() - 1);
			//vai testar a diagonal superior esquerda
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				//se a posi��o existe e tem uma pe�a adversaria p, eu marco a posi��o como verdadeira.
				mat[p.getRow()][p.getColumn()] = true;
			}
			p.setValues(position.getRow() - 1, position.getColumn() + 1);
			//vai testar a diagonal superior direito
			if (getBoard().positionExists(p) && isThereOpponentPiece(p)) {
				//se a posi��o existe e tem uma pe�a adversaria p, eu marco a posi��o como verdadeira.
				mat[p.getRow()][p.getColumn()] = true;
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
			
		}
		
		
		return mat;
	}
	
	@Override
	public String toString() {
		return "P";
	}

}
