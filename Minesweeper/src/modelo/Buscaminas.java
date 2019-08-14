/**
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 * $Id$
 * Universidad Icesi (Cali - Colombia)
 * Lab 1 apo2 2019-2
 * @author Antonio Cadavinci - acam97@hotmail.com
 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
 */

package modelo;

import java.util.InputMismatchException;

public class Buscaminas {

	/**
	 * Es una constante utilizada para indicar la cantidad de filas en el nivel
	 * principiante
	 */
	public static final int FILAS_PRINCIPIANTE = 8;

	/**
	 * Es una constante utilizada para indicar la cantidad de filas en el nivel
	 * intermedio
	 */
	public static final int FILAS_INTERMEDIO = 16;

	/**
	 * Es una constante utilizada para indicar la cantidad de filas en el nivel
	 * experto
	 */
	public static final int FILAS_EXPERTO = 16;

	/**
	 * Es una constante utilizada para indicar la cantidad de columnas en el nivel
	 * principiante
	 */
	public static final int COLUMNAS_PRINCIPIANTE = 8;

	/**
	 * Es una constante utilizada para indicar la cantidad de columnas en el nivel
	 * intermedio
	 */
	public static final int COLUMNAS_INTERMEDIO = 16;

	/**
	 * Es una constante utilizada para indicar la cantidad de columnas en el nivel
	 * experto
	 */
	public static final int COLUMNAS_EXPERTO = 30;

	/**
	 * Es una constante utilizada para saber la dificultad del juego, representa el
	 * nivel principiante
	 */
	public static final int PRINCIPIANTE = 1;

	/**
	 * Es una constante utilizada para saber la dificultad del juego, representa el
	 * nivel intermedio
	 */
	public static final int INTERMEDIO = 2;

	/**
	 * Es una constante utilizada para saber la dificultad del juego, representa el
	 * nivel experto
	 */
	public static final int EXPERTO = 3;

	/**
	 * Es una constante utilizada para saber la cantidad de minas en nivel
	 * principiante
	 */
	public static final int CANTIDAD_MINAS_PRINCIPANTE = 10;

	/**
	 * Es una constante utilizada para saber la cantidad de minas en nivel
	 * intermedio
	 */
	public static final int CANTIDAD_MINAS_INTERMEDIO = 40;

	/**
	 * Es una constante utilizada para saber la cantidad de minas en nivel experto
	 */
	public static final int CANTIDAD_MINAS_EXPERTO = 99;

	// -----------------------------------------------------------------
	// Atributos y relaciones
	// -----------------------------------------------------------------

	/**
	 * Relacion que tiene la matriz de casillas
	 */
	private Casilla[][] casillas;

	/**
	 * Atributo que representa el nivel del juego <Solo puede tomar valores
	 * PRINCIPIANTE, INTERMEDIO, EXPERTO>
	 */
	private int nivel;

	/**
	 * Atributo que tiene la cantidad de minas en el tablero
	 */
	private int cantidadMinas;

	/**
	 * Atributo que representa si el usuario perdio al abrir una mina
	 */
	private boolean perdio;

	// -----------------------------------------------------------------
	// Constructores
	// -----------------------------------------------------------------

	/**
	 * Constructo de la clase Buscaminas
	 * 
	 * @param nivel - el nivel seleccionado por el usuario
	 */
	public Buscaminas(int nivel) {
		this.nivel = nivel;
		perdio = false;
		inicializarPartida();

	}

	// -----------------------------------------------------------------
	// Metodos
	// -----------------------------------------------------------------

	/**
	 * Se encarga de inicializar los atributos y relaciones de la clase buscaminas a
	 * partir del nivel elegido por el usuario
	 */
	private void inicializarPartida() {
		if (nivel == PRINCIPIANTE) {
			casillas = new Casilla[FILAS_PRINCIPIANTE][COLUMNAS_PRINCIPIANTE];
			cantidadMinas = CANTIDAD_MINAS_PRINCIPANTE;
			inicializarCasillasLibres();
			generarMinas();
		} else if (nivel == INTERMEDIO) {

			casillas = new Casilla[FILAS_INTERMEDIO][COLUMNAS_INTERMEDIO];
			cantidadMinas = CANTIDAD_MINAS_INTERMEDIO;
			inicializarCasillasLibres();
			generarMinas();

		} else if (nivel == EXPERTO) {
			casillas = new Casilla[FILAS_EXPERTO][COLUMNAS_EXPERTO];
			cantidadMinas = CANTIDAD_MINAS_EXPERTO;
			inicializarCasillasLibres();
			generarMinas();

		} else {
			System.out.println("por favor seleccione un nivel válido ");

		}
		// TODO

	}

	/**
	 * Metodo que se encarga de inicializar todas las casillas que no son minas
	 */
	public void inicializarCasillasLibres() {
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[0].length; j++) {
				casillas[i][j] = new Casilla(50);

			}
		}
	}

	/**
	 * Método que se encarga de generar aleatoriomente las minas
	 */
	public void generarMinas() {

		if (nivel == PRINCIPIANTE) {
			generarMinasPrincipiante();
		} else if (nivel == INTERMEDIO) {
			generarMinasIntermedio();
		} else if (nivel == EXPERTO) {
			generarMinasExperto();
		}

	}

	private void generarMinasExperto() {
		int ii;
		int jj;
		for (int i = 0; i < CANTIDAD_MINAS_EXPERTO; i++) {
			ii = (int) (Math.random() * FILAS_EXPERTO);
			jj = (int) (Math.random() * FILAS_EXPERTO);
			if (casillas[ii][jj].darTipo() == 50) {
				casillas[ii][jj].setTipo(100);
			} else if (casillas[ii][jj].darTipo() == 100) {
				i--;
				continue;
			}
		}

	}

	private void generarMinasIntermedio() {
		int ii;
		int jj;
		for (int i = 0; i < CANTIDAD_MINAS_INTERMEDIO; i++) {
			ii = (int) (Math.random() * FILAS_INTERMEDIO);
			jj = (int) (Math.random() * FILAS_INTERMEDIO);
			if (casillas[ii][jj].darTipo() == 50) {
				casillas[ii][jj].setTipo(100);
			} else if (casillas[ii][jj].darTipo() == 100) {
				i--;
				continue;
			}
		}
	}

	private void generarMinasPrincipiante() {
		int ii;
		int jj;
		for (int i = 0; i < CANTIDAD_MINAS_PRINCIPANTE; i++) {
			ii = (int) (Math.random() * FILAS_PRINCIPIANTE);
			jj = (int) (Math.random() * FILAS_PRINCIPIANTE);
			if (casillas[ii][jj].darTipo() == 50) {
				casillas[ii][jj].setTipo(100);
			} else if (casillas[ii][jj].darTipo() == 100) {
				i--;
				continue;
			}

		}

	}

	/**
	 * Metodo que permite contar la cantidad de minas que tiene alrededor una
	 * casillas
	 * 
	 * @param i - La fila de la matriz
	 * @param j - la columna de la matriz
	 * @return int - La cantidad de minas que tiene alrededor la casilla [i][j]
	 */
	public int cantidadMinasAlrededor(int f, int c) {
		int count = 0;
		int x = 1;

		for (int i = f - x; i <= f + 1; i++) {
			for (int j = c - x; j <= c + 1; j++) {
				if (i >= 0 && i < casillas.length && j >= 0 && j < casillas[0].length) {
					if (casillas[i][j].esMina()) {
						count++;
					}
				}

			}
		}

		return count;
	}

	/**
	 * Metodo que se encarga de convertir el tablero a un String para poder verlo en
	 * pantalla
	 * 
	 * @return String - El tablero en formato String
	 */
	public String mostrarTablero() {
//		inicializarCasillasLibres();
//		generarMinas();
		String tablero = " ";
		String wiki = "   ";
		for (int i = 0; i < casillas.length; i++) {
			if (i < 9) {
				tablero += " " + (i + 1) + "|";
			} else {
				tablero += (i + 1) + "|";
			}

			for (int k = 0; k < casillas[0].length; k++) {
				if (casillas[i][k].darTipo() != 100) {
					int valor = cantidadMinasAlrededor(i, k);
					casillas[i][k].setValor(valor);
				}
				tablero += (" " + casillas[i][k].mostrarValorCasilla() + " ");
			}
			tablero += "\n";
			tablero += " ";
		}
		wiki += " ";
		for (int i = 0; i < casillas[0].length; i++) {
			if (i < 10) {
				wiki += " " + (i + 1) + " ";
			} else {
				wiki += (i + 1) + " ";
			}
		}
		wiki += "\n";
		for (int i = 0; i < casillas[0].length; i++) {
			if (i == 0) {
				wiki += "    " + " _ ";
			} else {
				wiki += " _ ";

			}
		}
		wiki += "\n" + tablero;

		return wiki;
	}

	/**
	 * Metodo que se encarga de marcar todas las casillas como destapadas
	 */
	public void resolver() {
		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[0].length; j++) {
				casillas[i][j].destapar();
			}

		}

		System.out.println(mostrarTablero());
	}

	/**
	 * Metodo dar del atributo casillas
	 * 
	 * @return la relacion casillas
	 */
	public Casilla[][] darCasillas() {
		return casillas;
	}

	/**
	 * Este metodo se encargaa de abrir una casilla Si se abre una casilla de tipo
	 * Mina, se marca que el jugador perdio el juego.
	 * 
	 * @param i - la fila donde esta la casilla
	 * @param j - la columna donde esta la casilla
	 * @return boolean - true si fue posible destaparla, false en caso contrario
	 */
	public boolean abrirCasilla(int i, int j) throws InputMismatchException {
		boolean destapado = false;

		if (!casillas[i][j].darSeleccionada() && !casillas[i][j].esMina()) {
			casillas[i][j].destapar();
			mostrarTablero();
			destapado = true;
		} else if (!casillas[i][j].darSeleccionada() && casillas[i][j].esMina()) {
			casillas[i][j].destapar();
			perdio();
			mostrarTablero();
			destapado = true;
		} else if (casillas[i][j].darSeleccionada()) {
			destapado = false;
		}

		return destapado;
	}

	/**
	 * Metodo que se encarga de revisar si el jugador gano el juego
	 * 
	 * @return boolean - true si gano el juego, false en caso contrario
	 */
	public boolean gano() {
		boolean flag = false;
		int cont = 0;
		int campos = (casillas.length * casillas[0].length);
		int notmines = (campos - cantidadMinas);

		for (int i = 0; i < casillas.length; i++) {
			for (int j = 0; j < casillas[0].length; j++) {
				if (casillas[i][j].darSeleccionada() && !casillas[i][j].esMina()) {
					cont++;
				}
			}

		}

		if (cont == notmines) {
			flag = true;
		} else {
			flag = false;
		}

		return flag;
	}

	public void perdio() {
		perdio = true;
	}

	/**
	 * Metodo que se encarga de abrir la primera casilla que no sea una Mina y cuyo
	 * valor sea Mayor que 0
	 * 
	 * @return String, Mensaje de la Casilla que marco abierta, En caso de no haber
	 *         casillas posibles para dar una pista, retorna el mensaje no hay
	 *         pistas para dar
	 */
	public String darPista() {
		String msg = "";
		boolean flag = false;
		for (int i = 0; i < casillas.length && !flag; i++) {
			for (int j = 0; j < casillas[0].length && !flag; j++) {
				if (casillas[i][j].darValor() >= 2
						&& !casillas[i][j].esMina()/* &&!casillas[i][j].darSeleccionada() */) {
					msg = "la casilla que abrio la pista es:" + " " + "[" + i + "]" + " " + "[" + j + "]";
					casillas[i][j].destapar();
					flag = true;
				}
			}

		}

		return msg;
	}

	public void setPerdio(boolean t) {
		this.perdio = t;
	}

	/***
	 * Metodo dar del atributo perdio
	 * 
	 * @return boolean el atributo
	 */
	public boolean darPerdio() {
		return perdio;
	}

}