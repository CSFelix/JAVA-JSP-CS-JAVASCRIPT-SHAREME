<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>

	<jsp:include page="Include\head.jsp" />
	<script>window.localStorage.setItem("Download", 0);</script>
<body>
	<jsp:include page="Include\checar_download.jsp" />
	<button id="botaoShareMe" class="botao">Sobre</button>
	
	<section class="container">
		
		<div id="modalShareMeDownload" class="modalArquivoEnviado">
  			<div class="modal-content">				
    			<span id="fecharShareMeDownload" class="close">&times;</span>
    			<center><b class="tag">Arquivo Enviado!</b></center><br><br><br>
    	
    			<div class="bloco">
    				<div class="dados">
    					<div style="width:100%;height:0;padding-bottom:56%;position:relative;"><iframe src="https://giphy.com/embed/l4FGJY5AptZSZUW08" width="100%" height="100%" style="position:absolute; border-radius: 5px;" frameBorder="0" class="giphy-embed" allowFullScreen></iframe></div>
					</div>
			
					<div class="separador"></div>
				
					<div class="dados">
						<p id="depoimento">Seu arquivo está pronto para download.</p>
						<br>
						<input type="text" id="urlDownload" class="campoInput" value="<%=request.getSession().getAttribute("url_arquivo_enviado")%>" oninput="preservarValor()">
						<input type="button" id="btnCopiar" class="campoInput botaoCopiar" value="Copiar link de Download!">
						<br><br>
						<a href="<%="http://localhost:8080/ChatMe3.0/HTML/ShareMe/HTML/download.jsp?hash=" + request.getParameter("hash")%>" 
						download="<%=request.getParameter("nomeArquivo")%>"><button class="campoInput">Baixar!</button></a>
						<br><br>
						<a href="index.jsp"><button class="campoInput">Enviar Outro Arquivo!</button></a>
					</div>
  				</div>
  			</div>
		</div>
		<jsp:include page="Include\hexagonos.jsp" />
	</section>
</body>
	<jsp:include page="Include\script.jsp" />
</html>