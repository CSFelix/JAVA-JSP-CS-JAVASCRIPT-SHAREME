package Bean;

import java.io.FileInputStream;

public class ShareMeArquivoBean {
	/*
	 * Classe responsável por armazenar os dados dos arquivos manipulados
	 * pela ShareMe
	 * 
	 * Atributos:
	 * - id >> id do arquivo
	 * - arquivo >> o arquivo em si (em binário)
	 * - nome_arquivo >> nome
	 * - tamanho_arquivo >> tamanho em B (bytes)
	 * - baixado >> identifica se o arquivo ja chegou a ser baixado (0 >> não, 1 >> sim)
	 * - hash_arquivo >> hash identificadora na URL
	 * - tipo_arquivo >> formato
	 * */
	
	public ShareMeArquivoBean(String nome, long tamanho, String hash, String tipo_arquivo) { 
		this.nome_arquivo = nome; this.tamanho_arquivo = tamanho; this.baixado = 0; this.hash_arquivo = hash; 
		this.tipo_arquivo = tipo_arquivo;
	}
	
	public ShareMeArquivoBean(int id, String nome, int tamanho, String hash) { 
		this.id = id; this.nome_arquivo = nome; this.tamanho_arquivo = tamanho; this.baixado = 0; this.hash_arquivo = hash; 
	}
	
	int id;
	FileInputStream arquivo;
	String nome_arquivo;
	long tamanho_arquivo;
	//String data_upload;
	int baixado;
	String hash_arquivo;
	String tipo_arquivo;
	
	public int getId() { return id; }
	public void setId(int id) { this.id = id; }
	
	public FileInputStream getArquivo() { return arquivo; }
	public void setArquivo(FileInputStream arquivo) { this.arquivo = arquivo; }
	
	public String getNome_arquivo() { return nome_arquivo; }
	public void setNome_arquivo(String nome_arquivo) { this.nome_arquivo = nome_arquivo; }
	
	public long getTamanho_arquivo() { return tamanho_arquivo; }
	public void setTamanho_arquivo(long tamanho_arquivo) { this.tamanho_arquivo = tamanho_arquivo; }
	
	//public String getData_upload() { return data_upload; }
	//public void setData_upload(String data_upload) { this.data_upload = data_upload; }
	
	public int getBaixado() { return baixado; }
	public void setBaixado(int baixado) { this.baixado = baixado; }
	
	public String getHash_arquivo() { return hash_arquivo; }
	public void setHash_arquivo(String hash_arquivo) { this.hash_arquivo = hash_arquivo; }
	
	public String getTipo_arquivo() { return tipo_arquivo; }
	public void setTipo_arquivo(String tipo_arquivo) { this.tipo_arquivo = tipo_arquivo; }

}
