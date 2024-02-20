package tresenraya;
/**
 * Class Ficha is an Enum class that contains values of the gameplay and also a method that directs to the next player,
 * or better said next symbol's turn to play.
 */
public enum Ficha {
	X, O;

	/**
	 * Method that determines the gameplay rules.X plays only after O and vice versa.
	 * @return returns next playable values of TresEnRaya
	 */
	public Ficha siguiente() {
		if (this == X) {
			return O;
		} else {
			return X;
		}
	}
}
