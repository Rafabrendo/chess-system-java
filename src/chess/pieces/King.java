package chess.pieces;

import boardgame.Board;
import boardgame.Position;
import chess.ChessMatch;
import chess.ChessPiece;
import chess.Color;

public class King extends ChessPiece{
	
	private ChessMatch chessMatch;

	public King(Board board, Color color, ChessMatch chessMatch) {
		//para associar a partida com o rei, eu inclui a referencia da partida, no construtor tbm
		//(ChessMatch chessMatch)
		super(board, color);
		this.chessMatch = chessMatch;
		
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
	
	private boolean testRookCastling(Position position) {
		//vai testar se, na posição que eu informar, existe uma torre e se ela está apta para o Rook
		ChessPiece p =(ChessPiece)getBoard().piece(position);
		return p != null && p instanceof Rook && p.getColor() == getColor() && p.getMoveCount() == 0;
				//instanceof -> é uma torre
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
		
		// #specialmove castling
		if (getMoveCount() == 0 && !chessMatch.getCheck()) {
			// #specialmove castling kingside rook
			Position posT1 = new Position(position.getRow(), position.getColumn()+3);
			if(testRookCastling(posT1)) {
				Position p1 = new Position(position.getRow(), position.getColumn()+1);
				Position p2 = new Position(position.getRow(), position.getColumn()+2);
				if(getBoard().piece(p1) == null && getBoard().piece(p2) == null) {
					//agr eu posso fazer o Rook porque todas as condições foram satisfeitas
					mat[position.getRow()][position.getColumn()+2] = true;
				}
			}
			// #specialmove castling queenside rook
			Position posT2 = new Position(position.getRow(), position.getColumn()-4);
			if(testRookCastling(posT2)) {
				Position p1 = new Position(position.getRow(), position.getColumn()-1);
				Position p2 = new Position(position.getRow(), position.getColumn()-2);
				Position p3 = new Position(position.getRow(), position.getColumn()-3);
				if(getBoard().piece(p1) == null && getBoard().piece(p2) == null && getBoard().piece(p3) == null) {
					//agr eu posso fazer o Rook porque todas as condições foram satisfeitas
					mat[position.getRow()][position.getColumn()-2] = true;
				}
			}
		}
		
		
		return mat;
	}
}
