package com.validador.cpf.validadorCpf;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.validador.cpf.validadorCpf.models.Cliente;


@SpringBootTest
class ValidadorCpfApplicationTests {
// teste positivo
	@Test
	void fazendoTesteDeCpfValido() {
		Cliente cliente = new Cliente(); // criei uma nova instância
		cliente.setNome("Milene");
		cliente.setCpf("42136642014");
		assertEquals(true, cliente.validarCPF());
	}

	// teste negativo
	@Test
	void fazendoTesteDeCpfInvalido() {
		Cliente cliente = new Cliente(); // criei uma nova instância
		cliente.setNome("Milene");
		cliente.setCpf("42136642015");
		assertEquals(false, cliente.validarCPF());
	}

	// teste negativo
	@Test
	void fazendoTesteDeCpfComDigitoAMenos() {
		Cliente cliente = new Cliente(); // criei uma nova instância
		cliente.setNome("Milene");
		cliente.setCpf("421366420");
		assertEquals(false, cliente.validarCPF());
	}

	// teste negativo
	@Test
	void fazendoTesteDeCpfComDigitoAMais() {
		Cliente cliente = new Cliente(); // criei uma nova instância
		cliente.setNome("Milene");
		cliente.setCpf("42136642015555");
		assertEquals(false, cliente.validarCPF());
	}

	// teste positivo para aceitar pontos
	@Test
	void fazendoTesteDeCpfValidoComPontos() {
		Cliente cliente = new Cliente(); // criei uma nova instância
		cliente.setNome("Milene");
		cliente.setCpf("421.366.420-14");
		assertEquals(true, cliente.validarCPF());
	}

	// teste negativo com pontos
	@Test
	void fazendoTesteDeCpfInvalidoComPontos() {
		Cliente cliente = new Cliente(); // criei uma nova instância
		cliente.setNome("Milene");
		cliente.setCpf("421.366.420-15");
		assertEquals(false, cliente.validarCPF());
	}

	// teste positivo com pontos
	@Test
	void fazendoTesteDeCpfValidoComEspaçoNoComeço() {
		Cliente cliente = new Cliente(); // criei uma nova instância
		cliente.setNome("Milene");
		cliente.setCpf(" 421.366.420-14");
		assertEquals(true, cliente.validarCPF());
	}

	// teste positivo com pontos
	@Test
	void fazendoTesteDeCpfValidoComEspaçoNoFinal() {
		Cliente cliente = new Cliente(); // criei uma nova instância
		cliente.setNome("Milene");
		cliente.setCpf("421.366.420-14 ");
		assertEquals(true, cliente.validarCPF());
	}

	// teste positivo com pontos
	@Test
	void fazendoTesteDeCpfValidoComEspaçoNoMeio() {
		Cliente cliente = new Cliente(); // criei uma nova instância
		cliente.setNome("Milene");
		cliente.setCpf("421.366. 420-14");
		assertEquals(true, cliente.validarCPF());
	}

	// teste negativo com pontos
	@Test
	void fazendoTesteDeCpfInvalidoComEspaçoNoComeço() {
		Cliente cliente = new Cliente(); // criei uma nova instância
		cliente.setNome("Milene");
		cliente.setCpf(" 421.366.420-15");
		assertEquals(false, cliente.validarCPF());
	}

	// teste negativo com pontos
	@Test
	void fazendoTesteDeCpfInvalidoComEspaçoNoFinal() {
		Cliente cliente = new Cliente(); // criei uma nova instância
		cliente.setNome("Milene");
		cliente.setCpf("421.366.420-15 ");
		assertEquals(false, cliente.validarCPF());
	}

	// teste negativo com pontos
	@Test
	void fazendoTesteDeCpfInvalidoComEspaçoNoMeio() {
		Cliente cliente = new Cliente(); // criei uma nova instância
		cliente.setNome("Milene");
		cliente.setCpf("421.366. 420-15");
		assertEquals(false, cliente.validarCPF());
	}

	// teste do cpf estranho
	@Test
	void fazendoTesteDeCpfDoidoQuePassou() {
		Cliente cliente = new Cliente(); // criei uma nova instância
		cliente.setNome("Milene");
		cliente.setCpf("69b.969.790-88");
		assertEquals(false, cliente.validarCPF());
	}

	// teste do cpf vazio
	@Test
	void fazendoTesteSemPassarCpf() {
		Cliente cliente = new Cliente(); // criei uma nova instância
		cliente.setNome("Milene");
		assertEquals(false, cliente.validarCPF());
	}

	// esses foram testes de unidades

}
