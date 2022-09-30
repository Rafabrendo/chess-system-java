package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece{

	public King(Board board, Color color) {
		super(board, color);
		
	}

	@Override
	public String toString() {
		return "K";
	}
	
	private boolean canMove(Position position) {
		//metodo vai me dizer se o rei pode mover para determinada posição
		ChessPiece p = (ChessPiece)getBoard().piece(position); //vai pegar a peça p que estiver na posição
		//tem q verificar se a peça p é nulo(vazio) ou se é uma peça adversaria
		return p == null || p.getColor() != getColor(); //p é diferente de nulo e p.cor é diferente da cor do rei
		
	}
	
	@Override
	public boolean[][] possibleMoves() {
		boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
		
		Position p = new Position(0, 0); //criando uma posição auxiliar
		
		//above
		p.setValues(position.getRow()-1, position.getColumn());
		if (getBoard().positionExists(p) && canMove(p)) {
			//significa, se true, que o rei pode mover para essa posição p(pra cima)
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//below
		p.setValues(position.getRow()+1, position.getColumn());
		if (getBoard().positionExists(p) && canMove(p)) {
			//significa, se true, que o rei pode mover para essa posição p (abaixo)
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//left
		p.setValues(position.getRow(), position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			//significa, se true, que o rei pode mover para essa posição p (esquerda)
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//right
		p.setValues(position.getRow(), position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			//significa, se true, que o rei pode mover para essa posição p (direita)
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//nw (noroeste)
		p.setValues(position.getRow() - 1, position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			//significa, se true, que o rei pode mover para essa posição p (noroeste)
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//ne (nordeste)
		p.setValues(position.getRow() - 1, position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			//significa, se true, que o rei pode mover para essa posição p (nordeste)
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//sw (sudoeste)
		p.setValues(position.getRow() + 1, position.getColumn() - 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			//significa, se true, que o rei pode mover para essa posição p (sudoeste)
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		//se (sudeste)
		p.setValues(position.getRow() + 1, position.getColumn() + 1);
		if (getBoard().positionExists(p) && canMove(p)) {
			//significa, se true, que o rei pode mover para essa posição p (sudeste)
			mat[p.getRow()][p.getColumn()] = true;
		}
		
		
		return mat;
	}
}
