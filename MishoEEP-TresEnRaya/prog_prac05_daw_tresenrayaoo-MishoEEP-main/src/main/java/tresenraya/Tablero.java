package tresenraya;

public class Tablero {
	/** String constant that constructs the gameplay table */ 
	private static final String VERT = "|";
	/** String constant that constructs the gameplay table */ 
	private static final String SEP = " ";
	/** String constant that constructs the gameplay table */ 
	private static final String HORT = "---";
	/** String constant that constructs the gameplay table */ 
	private static final String CRUZ = "+";
	/** String constant that separates two lines */ 
	protected static final String N = System.lineSeparator();
	
	/** */
	private Ficha[][] tablero;
	/**
	 * The constructor of the class Tablero, with a specific size.
	 * @param tam determins the size of the game board that will be made.
	 */
	public Tablero(int tam) {
		tablero = new Ficha[tam][tam];
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				tablero[i][j] = null;
			}
		}
	}
	/**
	 * Boolean method that puts the symbol of the Ficha in the table.
	 * @param f - symbol (X or O)
	 * @param x - row
	 * @param j - column
	 * @return returns true if the symbol has been correctly placed, and false if the "box" is occupied
	 */
	public boolean jugar(Ficha f, int x, int j) {
		if (tablero[x][j] == null) {
			tablero[x][j] = f;
			return true;
		} else {
			return false;
		}

	}
	/**
	 * Boolean method that checks if the gameplay table is full and has no more playable boxes.
	 * @return returns true if the table is full and false if it is not
	 */
	public boolean estaLleno() {
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				if (tablero[i][j] == null) {
					return false;
				}
			}
		}
		return true;
	}
	/**
	 * Boolean method that tells us the winner of the game.
	 * @param f symbol (X or O)
	 * @return returns true if a player has won and false if he hasn't
	 */
	public boolean gana(Ficha f) {
		return ganaHorizontal(f) || ganaVertical(f) || ganaDiagonalDirecta(f) || ganaDiagonalInversa(f);
	}
	/**
	 * Boolean method that checks for the possible horizontal winner (3 of the same symbols in a horizontal line).
	 * @param f symbol (X or O)
	 * @return returns true if there is a horizontal winner and false if there isn't
	 */
	protected boolean ganaHorizontal(Ficha f) {
		for (int i = 0; i < tablero.length; i++) {
			boolean filaGanador = true;
			for (int j = 0; j < tablero[i].length; j++) {
				if (tablero[i][j] != f) {
					filaGanador = false;
					break;
				}
			}
			if (filaGanador) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Boolean method that checks for the possible vertical winner (3 of the same symbols in a vertical line).
	 * @param f symbol (X or O)
	 * @return returns true if there is a vertical winner and false if there isn't
	 */
	protected boolean ganaVertical(Ficha f) {
		for (int i = 0; i < tablero.length; i++) {
			boolean columnaGanador = true;
			for (int j = 0; j < tablero[i].length; j++) {
				if (tablero[j][i] != f) {
					columnaGanador = false;
					break;
				}
			}
			if (columnaGanador) {
				return true;
			}
		}
		return false;
	}
	/**
	 * Boolean method that checks for the possible direct diagonal winner (3 of the same symbols in a direct diagonal line).
	 * @param f symbol(X or O)
	 * @return returns true if there is a direct diagonal winner and false if there isn't
	 */
	protected boolean ganaDiagonalDirecta(Ficha f) {
		boolean diagonalGanador1 = true;

		for (int i = 0; i < tablero.length; i++) {
			if (tablero[i][i] != f) {
				diagonalGanador1 = false;
			}
		}
		return diagonalGanador1;
	}
	/**
	 * Boolean method that checks for the possible inverse diagonal winner (3 of the same symbols in a inverse diagonal line).
	 * @param f symbol(X or O)
	 * @return returns true if there is a inverse diagonal winner and false if there isn't
	 */
	protected boolean ganaDiagonalInversa(Ficha f) {
		boolean diagonalGanador1 = true;

		for (int i = 0; i < tablero.length; i++) {
			if (tablero[i][tablero.length - 1 - i] != f) {
				diagonalGanador1 = false;
			}
		}
		return diagonalGanador1;
	}
	/**
	 * The written representation of the code the class contains so its easier to read and more user friendly.
	 */
	@Override
	public String toString() {
		StringBuilder buildTablero = new StringBuilder();
		for (int i = 0; i < tablero.length; i++) {
			for (int j = 0; j < tablero[i].length; j++) {
				buildTablero.append((SEP + nullToEspacio(i, j) + SEP));
				if (j < tablero[i].length - 1) {
					buildTablero.append(VERT);
				}
			}
			buildTablero.append(N);
			if (i < tablero.length - 1) {
				for (int k = 0; k < tablero[i].length; k++) {
					buildTablero.append(HORT);
					if (k < tablero[i].length - 1) {
						buildTablero.append(CRUZ);
					}
				}
				buildTablero.append(N);
			}
		}
		return buildTablero.toString();
	}
	/**
	 * Method that replacess null value with a String which contains an empty space.
	 * @param i row
	 * @param j column
	 * @return returns table with the null values replaced with blank space String
	 */
	private Object nullToEspacio(int i, int j) {
		return tablero[i][j] == null ? " " : tablero[i][j];
	}
}
