package br.com.desafiosefaz.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

	public static boolean validarEmail(String email) {
		if ((email == null) || (email.trim().length() == 0)) {
			return false;
		}

		String emailPattern = "\\b(^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@([A-Za-z0-9-])+(\\.[A-Za-z0-9-]+)*((\\.[A-Za-z0-9]{2,})|(\\.[A-Za-z0-9]{2,}\\.[A-Za-z0-9]{2,}))$)\\b";
		Pattern pattern = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	public static boolean validarSenha(String senha) {
		if (senha == null) {
			return false;
		}
		return senha.trim().length() > 2;
	}
}
