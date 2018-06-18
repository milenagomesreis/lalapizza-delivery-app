package br.com.jwm.lalapizzadelivery.app.core.util;

import java.text.Normalizer;

public class StringPTBRUtils {
	public static String removeAcentos(String nome) {

		nome = removeNonBreakingSpace(nome);
		nome = Normalizer.normalize(nome, Normalizer.Form.NFD);
		nome = nome.replaceAll("[^\\p{ASCII}]", "");

		return nome.trim();
	}
	public static String removeNonBreakingSpace(String nome) {

		return nome.replace("&nbsp;", "");
	}
}
