package Dao;

import Bean.ShareMeArquivoBean;
import BancoDados.ConexaoMongoDBGridFSBucket;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;

import org.bson.Document;
import org.bson.types.ObjectId;


import com.mongodb.client.gridfs.GridFSBucket;
import com.mongodb.client.gridfs.GridFSDownloadStream;
import com.mongodb.client.gridfs.model.GridFSUploadOptions;

public class ShareMeArquivoDao {
	/*
	 * Classe responsável pelas operações DML no banco de dados
	 * dos arquivos importados e baixados no ShareMe
	 * */
	
	public ShareMeArquivoDao() { }

	public ObjectId InserirArquivo(ShareMeArquivoBean arquivo_objeto, InputStream arquivo) {
		/*
		 * Insere o arquivo no banco de dados
		 * 
		 * - Assintótica: O(1)
		 * */
		try {
			GridFSBucket bucket = ConexaoMongoDBGridFSBucket.AbrirConexaoShareMeArquivos();
			
			GridFSUploadOptions options = new GridFSUploadOptions()
                     .chunkSizeBytes(358400)
                     .metadata(new Document("type", "presentation"));
			ObjectId id_arquivo = bucket.uploadFromStream(arquivo_objeto.getNome_arquivo(), arquivo, options);
			
			ConexaoMongoDBGridFSBucket.FecharConexao(bucket);
			return id_arquivo;
		}
		catch (Exception e) { 
			e.printStackTrace(); 
			return null;
		}
	}
	
	public byte[] SelecionarArquivo(String object_id) {
		try {
			GridFSBucket bucket = ConexaoMongoDBGridFSBucket.AbrirConexaoShareMeArquivos();
			ObjectId obj_id = new ObjectId(object_id);
			GridFSDownloadStream bucket_stream = bucket.openDownloadStream(obj_id);
		
			ByteArrayOutputStream buffer = new ByteArrayOutputStream();
			int leitura;
			byte[] arquivo = new byte[1638];
		
			while ((leitura = bucket_stream.read(arquivo, 0, arquivo.length)) != -1) { buffer.write(arquivo, 0, leitura); }
			buffer.flush();
			
			bucket_stream.close();
			ConexaoMongoDBGridFSBucket.FecharConexao(bucket);
			return buffer.toByteArray();
		}
		catch (Exception e) { 
			e.printStackTrace(); 
			return null;
		}
	}
}
