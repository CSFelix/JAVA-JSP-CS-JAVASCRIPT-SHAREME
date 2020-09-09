package BancoDados;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSBuckets;

public class ConexaoMongoDBGridFSBucket {
	/*
	 * Classe responsável por abrir e fechar conexões com o banco de dados MongoDB
	 * Utiliza o Design Pattern Singleton
	 * */
	
	static MongoClient cliente;
	static MongoDatabase banco;
	static GridFSBucket bucket;
	
	static final String SERVIDOR = "localhost"; // configurar ip do servidor caso for rodar em rede
	static final String PORTA = "27017";
	static final String URL = "mongodb://" + SERVIDOR + ":" + PORTA;
	static final String BANCO = "chatme";
	static final String BUCKET = "shareme_arquivos_bucket";
	
	public static GridFSBucket AbrirConexaoShareMeArquivos() {
		try {
			cliente = MongoClients.create(URL);
			banco = cliente.getDatabase(BANCO);
			bucket = GridFSBuckets.create(banco, BUCKET);
			return bucket;
			
		}
		catch (Exception e) { e.printStackTrace(); }
		return null;
	}
	
	public static void FecharConexao(GridFSBucket bucket) {
		try {
			bucket = null;
			banco = null;
			cliente.close();
			cliente = null;
		}
		catch (Exception e) { e.printStackTrace(); }
	}
	
	private static void CriarGridFSBucket(MongoDatabase banco) { GridFSBuckets.create(banco, "shareme_arquivos_bucket"); }
}