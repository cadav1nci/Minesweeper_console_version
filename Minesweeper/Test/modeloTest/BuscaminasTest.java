package modeloTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Buscaminas;
import modelo.Casilla;

class BuscaminasTest {

	Buscaminas mines;

	// Setup escenarios

	public void setupEscenario1() {
		mines = new Buscaminas(1);
	}

	public void setupEscenario2() {
		mines = new Buscaminas(2);
	}

	public void setupEscenario3() {
		mines = new Buscaminas(3);
	}

	public void setupEscenario4() {
		mines = new Buscaminas(1);
		for(int i = 0; i<mines.darCasillas().length;i++) {
			for (int j = 0; j < mines.darCasillas()[0].length; j++) {
				mines.darCasillas()[i][j].setTipo(50);
			}
		}
		mines.darCasillas()[0][0].setTipo(100);
		mines.darCasillas()[0][1].setTipo(100);
		mines.darCasillas()[0][2].setTipo(100);
		mines.darCasillas()[1][2].setTipo(100);
		mines.darCasillas()[2][2].setTipo(100);
		mines.darCasillas()[2][1].setTipo(100);
		mines.darCasillas()[2][0].setTipo(100);

	}

	@Test
	public void testGenerarMinasPrincipiante() {
		setupEscenario1();

		int contador = 0;
		for (int i = 0; i < mines.darCasillas().length; i++) {
			for (int j = 0; j < mines.darCasillas()[0].length; j++) {
				if (mines.darCasillas()[i][j].esMina()) {
					contador++;
				}
			}
		}

		assertEquals(10, contador);

	}

	@Test
	public void testGenerarMinasMedio() {
		setupEscenario2();
		int contador = 0;
		for (int i = 0; i < mines.darCasillas().length; i++) {
			for (int j = 0; j < mines.darCasillas()[0].length; j++) {
				if (mines.darCasillas()[i][j].esMina()) {
					contador++;
				}
			}
		}

		assertEquals(40, contador);

	}

	@Test
	public void testGenerarMinasExperto() {
		setupEscenario3();
		int contador = 0;
		for (int i = 0; i < mines.darCasillas().length; i++) {
			for (int j = 0; j < mines.darCasillas()[0].length; j++) {
				if (mines.darCasillas()[i][j].esMina()) {
					contador++;
				}
			}
		}

		assertEquals(99, contador);
	}
	
	@Test
	public void crearTableroTest1() {
		setupEscenario1();
		int tamanio = mines.darCasillas().length*mines.darCasillas()[0].length;
		assertEquals(64, tamanio);

	}
	
	@Test
	public void crearTableroTest2() {
		setupEscenario2();
		int tamanio = mines.darCasillas().length*mines.darCasillas()[0].length;
		assertEquals(256, tamanio);

	}
	
	@Test
	public void crearTableroTest3() {
		setupEscenario3();
		int tamanio = mines.darCasillas().length*mines.darCasillas()[0].length;
		assertEquals(480, tamanio);

	}
	
	@Test
	public void abrirCasillaTest() {
		setupEscenario1();
		mines.abrirCasilla(0, 0);
		assertTrue(mines.darCasillas()[0][0].darSeleccionada());
	}
	
	
	@Test
	public void cantidadDeMinas() {
		setupEscenario4();
		int minas = mines.cantidadMinasAlrededor(1, 1);
		assertEquals(7, minas);
	}
	
	
	@Test
	public void cantidadDeMinas2() {
		setupEscenario4();
		int minas = mines.cantidadMinasAlrededor(7, 7);
		assertEquals(0, minas);
	}



	

}
