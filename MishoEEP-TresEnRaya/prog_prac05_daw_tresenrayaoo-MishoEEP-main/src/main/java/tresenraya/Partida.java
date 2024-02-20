package tresenraya;
/**
 * Class Partida is the game. We create the game, along with size of the table and the players turns.
 */
public class Partida {
	private Tablero tablero;
	private Ficha turno;
	/**
	 * The constructor of the class Partida.
	 * @param tam is the size of the table atribut
	 */
	public Partida(int tam) {
		tablero = new Tablero(tam);
		turno = Ficha.X; // because in the add it says that the game always starts with X
	}
	/**
	 * Boolean method that tells us when the game is finished
	 * @return returns true is the table is full or there is a winner, otherwise returns false
	 */
	public boolean terminada() {
		return tablero.estaLleno() || ganador() != null;
	}
	/**
	 * Void method that represents the gameplay. Contains turns of the play and info about the occupied boxes.
	 * @param i columns
	 * @param j rows
	 */
	public void jugar(int i, int j) {
		if (!terminada()) {
			if (tablero.jugar(turno, i, j)) {
				turno = (turno == Ficha.X) ? Ficha.O : Ficha.X;
			} else
				System.err.println("Casilla [" + i + ", " + j + "] " + "ocupada, vuelve a jugar " + turno);
		}
	}
	/**
	 * Method that calls the method gana() from class Partida to tell us who is the winner (X or O)
	 * @return Enum Ficha (con valores X || O || null)
	 */
	public Ficha ganador() {
		if (tablero.gana(Ficha.X)) {
			return Ficha.X;
		} else if (tablero.gana(Ficha.O)) {
			return Ficha.O;
		} else {
			return null;
		}
	}
	/**
	 * The written representation of the code the class contains so its easier to read and more user friendly.
	 */
	@Override
	public String toString() {
		StringBuilder pintar = new StringBuilder();
		pintar.append(tablero.toString()).append(Tablero.N).append(" Turno: ").append(turno);
		return pintar.toString();
	}

}
