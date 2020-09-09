package Seguranca;

public class StripHTML {
	/*
	 * Classe respons�vel or realizar o processo de Strip em Strings
	 * a fim de evitar HTML e JS Injection. 
	 * Assint�tica da Fun��o: O(1).
	 * 
	 * - OBS.: o SQL Injection j� est� sendo evitado nas classes DAO's
	 * por meio do uso do Prepared Statement
	 * */
	public static String StripString(String dado) { return dado.replaceAll("\\<.*?\\>", "_"); }
	
	public static final String REGEX_EMAIL = "[a-zA-Z0-9_@.]{5,200}";
	public static final String REGEX_NICKNAME_SENHA = "[a-zA-Z0-9_]{5,15}";
	public static final String REGEX_SHAREME_NOME_ARQUIVO = "[a-zA-Z0-9_!#()�������������������]{1, 200}";
	public static final String REGEX_ANNOTEME = "[a-zA-Z0-9_!#().@ ]{1, 100}";
	public static final String REGEX_CODIGO_ALTERACAO_SENHA = "[0-9]{5, 5}]";
}
