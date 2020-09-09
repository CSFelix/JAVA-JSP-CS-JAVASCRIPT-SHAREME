package Seguranca;

public class GerarHash {
	/*
	 * Classe responsável por gerar Hash's aos arquivos
	 * importados pelo ShareMe.
	 * Estas Hash's são respponsáveis por identificarem os arquivos
	 * na URL de download.
	 * 
	 * Composição da Hash:
	 * - caracteres de a - z: 26 chars
	 * - caracteres de A - Z: 26 chars (CaSe SeNsItIvE)
	 * - caracteres de 0 - 9: 10 chars
	 * 
	 * - Características da Hash: 7 chars, ordem dos caracteres importa
	 * e pode repetir
	 * 
	 * - Probabilidades: 52^7
	 * */
	
	public static String GerarHashString(int qnt_caracteres) { 
		/*
		 * Função responsável por gerar a Hash de links para arquivos e alteração de senha
		 * 
		 * - Assintótica: O(n) >> sendo n a quantidade de caracteres
		 * */
        String caracteres = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                                    + "0123456789"
                                    + "abcdefghijklmnopqrstuvxyz"; 
  
        StringBuilder hash = new StringBuilder(qnt_caracteres); 
  
        for (int i = 0; i < qnt_caracteres; i++) {  
            int index = (int)(caracteres.length() * Math.random()); 
            hash.append(caracteres.charAt(index)); 
        } 
  
        return hash.toString(); 
    } 
	
	public static String GerarHashCodigo(int qnt_caracteres) {
		/*
		 * Função responsável por gerar Código de alteração de senha
		 * 
		 * Assintótica: O(n) >> sendo n a quantidade de caracteres do código
		 * */
		
		String caracteres = "0123456789";
		StringBuilder codigo = new StringBuilder(qnt_caracteres);
		
		for (int i = 0; i < qnt_caracteres; i++) {
			int index = (int)(caracteres.length() * Math.random());
			codigo.append(caracteres.charAt(index));
		}
		
		return codigo.toString();
	}
	
}