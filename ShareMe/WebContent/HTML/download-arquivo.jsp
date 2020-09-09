<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<jsp:include page="Include\head.jsp" />
<body>
	<jsp:include page="Include\modal.jsp" />
	<jsp:include page="Include\checar_limite_upload.jsp" />
	<button id="botaoShareMeSobre" class="botao">Sobre</button>
	
	<section class="container">
		<div class="modalArquivoEnviado">
  			<div class="modal-content">				
    		<span class="close">&times;</span>
    		<center><b class="tag">Aqui está seu Arquivo!</b></center><br><br><br>
    	
    		<div class="bloco">
    			<div class="dados">
    				<div style="width:100%;height:0;padding-bottom:56%;position:relative;"><iframe src="https://giphy.com/embed/g1EGGf9NymomY" width="100%" height="100%" style="position:absolute; border-radius: 5px;" frameBorder="0" class="giphy-embed" allowFullScreen></iframe></div>
				</div>
				
				<div class="separador"></div>
			
					<div class="dados">
						<p id="depoimento">Arquivo: <%=request.getParameter("nomeArquivo")%></p>
						<br>
						<a href="<%="http://localhost:8080/ChatMe3.0/HTML/ShareMe/HTML/download.jsp?hash=" + request.getParameter("hash")%>" 
						download="<%=request.getParameter("nomeArquivo")%>"><button class="campoInput">Baixar!</button></a>
						<br><br>
						<a href="index.jsp"><button class="campoInput">Enviar Novo Arquivo!</button></a>
					</div>
  				</div>
  			</div>
		</div>
		
		<jsp:include page="Include\hexagonos.jsp" />
	</section>
	
</body>
	<jsp:include page="Include\script.jsp" />
</html>