package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class Knight extends ChessPiece {
	
	public Knight(Board board, Color color) {
		super(board, color);
	}

	@Override
	public String toString() {
		return "N";
	}
	
	private boolean canMove(Position position) {
		//metodo auxiliar
		//metodo vai me dizer se o rei pode mover para determinada posi��o
		ChessPiece p = (ChessPiece)getBoard().piece(position); //vai pegar a pe�a p que estiver na posi��o
		//tem q verificar se a pe�a p � nulo(vazio) ou se � uma pe�a adversaria
		return p == null || p.getColor() != getColor(); //p � diferente de nulo e p.cor � diferente da cor do rei
		
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0, 0); //criando uma posi��o auxiliar
		
		
		p.setValues(position.getRow()-1, position.getColumn() - 2);
		if (getBoard().positionExists(p) && canMove(p)) {
			//significa, se true, que o rei pode mover para essa posi��o p(pra cima)
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		
		p.setValues(position.getRow()-2, position.getColumn() -1);
		if (getBoard().positionExists(p) && canMove(p)) {
			//significa, se true, que o rei pode mover para essa posi��o p (abaixo)
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		
		p.setValues(position.getRow() - 2, position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			//significa, se true, que o rei pode mover para essa posi��o p (esquerda)
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		
		p.setValues(position.getRow() - 1, position.getColumn() + 2);
		if (getBoard().positionExists(p) && canMove(p)) {
			//significa, se true, que o rei pode mover para essa posi��o p (direita)
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		
		p.setValues(position.getRow() + 1, position.getColumn() + 2);
		if (getBoard().positionExists(p) && canMove(p)) {
			//significa, se true, que o rei pode mover para essa posi��o p (noroeste)
			mat[p.getRow()][p.getColumn()] = true;
		}
		
	
		p.setValues(position.getRow() + 2, position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			//significa, se true, que o rei pode mover para essa posi��o p (nordeste)
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		
		p.setValues(position.getRow() + 2, position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			//significa, se true, que o rei pode mover para essa posi��o p (sudoeste)
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		p.setValues(position.getRow() + 1, position.getColumn() - 2);
		if (getBoard().positionExists(p) && canMove(p)) {
			//significa, se true, que o rei pode mover para essa posi��o p (sudeste)
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		
		return mat;
	}

}
