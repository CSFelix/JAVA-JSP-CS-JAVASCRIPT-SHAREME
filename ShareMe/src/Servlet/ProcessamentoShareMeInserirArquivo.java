package Servlet;

import java.io.IOException;
import java.io.InputStream;
 
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.bson.types.ObjectId;

import Bean.ShareMeArquivoBean;
import Dao.ShareMeArquivoDao;
import Seguranca.GerarHash;
import Seguranca.StripHTML;
 
@WebServlet(urlPatterns = "/ProcessamentoShareMeInserirArquivo")
@MultipartConfig(maxFileSize = 16177215) // processa imagens até 4 GB
public class ProcessamentoShareMeInserirArquivo extends HttpServlet {
	/*
	 * Classe responsável por receber e tratar os arquivos encaminhados
	 * pelo ShareMe
	 * */
	private static final long serialVersionUID = 4L;
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	/*
    	 * Processamento de envio do arquivo em método POST
    	 * Assintótica: O(1)
    	 * */
    	
    	// Tentativa de recebimento dos pacotes
    	// por enquanto está aceitando até 15MB
    	// mas pretendo melhorar a função para aceitar até 900MB
    	// e retirar este 'try-catch'
    	try {
    		InputStream arquivo_blob = null;
    		ShareMeArquivoBean arquivo = null;
    		Part partes_arquivo = request.getPart("arquivo");

    		// Caso a imagem foi encaminhada com sucesso à Servlet
    		// Tal será processada e inserida no banco de dados
    		if (partes_arquivo != null) {
    			// printa informações do arquivo
    			// System.out.println(partes_avatar.getName());
    			// System.out.println(partes_avatar.getSize());
    			//System.out.println(partes_arquivo.getContentType()); 
    			arquivo_blob = partes_arquivo.getInputStream();
            
    			// Caso o tamanho do arquivo não passar do limite de 1GB do mysql
    			// o mesmo será salvo no banco de dados.
    			// Mesmo o limite sendo de 1GB, travei em 900MB por segurança.
    			if (partes_arquivo.getSize() <= 943718400) {
    				try {  					
    					arquivo = new ShareMeArquivoBean(StripHTML.StripString(request.getParameter("nome_arquivo")), partes_arquivo.getSize(), 
    							GerarHash.GerarHashString(7), partes_arquivo.getContentType());
    					ShareMeArquivoDao arquivo_dao = new ShareMeArquivoDao();
    					ObjectId id_arquivo = arquivo_dao.InserirArquivo(arquivo, arquivo_blob);
    					
    					request.getSession().setAttribute("limite_upload", 0);	
    					request.getSession().setAttribute("Download", 1);	
    					
    					request.getSession().setAttribute("url_arquivo_enviado", "http://localhost:8080/ShareMe/HTML/download-arquivo.jsp?hash=" 
    																			  + id_arquivo
    																			  + "&nomeArquivo="
    																			  + arquivo.getNome_arquivo());
    					
    					String paginaRedirecionamento = "HTML/arquivo-enviado.jsp?hash=" 
    													+ id_arquivo
    													+ "&nomeArquivo="
    													+ arquivo.getNome_arquivo();
    					response.sendRedirect(paginaRedirecionamento);
    				}
    				catch (Exception e) { 
    					request.getSession().setAttribute("limite_upload", 1);	
    					request.getSession().setAttribute("Download", 0);
    					response.sendRedirect("HTML/index.jsp"); 
    					
    					System.out.println(e);
    				}
    			}
    			
    			// Caso ultrapassar o tamanho limite, o arquivo não será salvo
    			// e o usuário será redirecionado ao início
    			else { 
    				request.getSession().setAttribute("limite_upload", 1);	
    				request.getSession().setAttribute("Download", 0);
    				response.sendRedirect("HTML/index.jsp"); 
    			}
    		}
    	}
    	catch (Exception e) { 
    		request.getSession().setAttribute("limite_upload", 1);	
    		request.getSession().setAttribute("Download", 0);
    		response.sendRedirect("HTML/index.jsp");
    		
    		System.out.println(e);
    	}
    }
}