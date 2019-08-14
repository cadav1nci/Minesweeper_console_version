
package modeloTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Casilla;

class CasillaTest {
	Casilla ksilla;
	// Setup escenarios

	public void setupEscenario1() {
		ksilla = new Casilla(50);
	}

	public void setupEscenario2() {
		ksilla = new Casilla(100);
	}

	@Test
	public void esMinaTest() {
		setupEscenario1();
		assertFalse(ksilla.esMina());
	}

	@Test
	public void esMinaTest2() {
		setupEscenario2();
		assertTrue(ksilla.esMina());
	}

	@Test
	public void mostrarValorCasillaTest() {
		setupEscenario2();
		assertequalsIgnoreCase(ksilla.mostrarValorCasilla(), "*");

	}

	@Test
	public void mostrarValorCasillaTest2() {
		setupEscenario1();
		assertequalsIgnoreCase(ksilla.mostrarValorCasilla(), "-1");

	}

	@Test
	public void destaparTest() {
		setupEscenario1();
		assertFalse(ksilla.darSeleccionada());
	}

	@Test
	public void destaparTest2() {
		setupEscenario2();
		ksilla.destapar();
		assertTrue(ksilla.darSeleccionada());

	}

	/**
	 * asert para validar si dos Strings son iguales
	 * 
	 * @return true si ambos Strings son iguales.
	 */

	private boolean assertequalsIgnoreCase(String a, String b) {
		boolean wiki;
		if (a.equalsIgnoreCase(b)) {
			wiki = true;
		} else {
			wiki = false;
		}
		return wiki;
	}

}
