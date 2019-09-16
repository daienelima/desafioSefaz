package br.com.desafiosefaz.util;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidationTestes {

	private String EMAIL_INVALIDO = "teste.com";
	private String EMAIL_INVALIDO1 = "teste@";
	private String EMAIL_VALIDO = "teste@gmail.com";
	private String SENHA_INVALIDA = "1";
	private String SENHA_VALIDA = "123546";
	
	@Test
	public void emailInvalido() {
		assertFalse(Validation.validarEmail(EMAIL_INVALIDO));
		assertFalse(Validation.validarEmail(EMAIL_INVALIDO1));
	}
	
	@Test
	public void emailValido() {
		assertTrue(Validation.validarEmail(EMAIL_VALIDO));
	}
	
	@Test
	public void validarSenhas() {
		assertFalse(Validation.validarSenha(SENHA_INVALIDA));
		assertTrue(Validation.validarSenha(SENHA_VALIDA));
	}
}
