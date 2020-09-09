<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<jsp:include page="Include\head.jsp" />

<body>
	<jsp:include page="Include\modal.jsp" />
	<jsp:include page="Include\checar_limite_upload.jsp" />
	<button id="botaoShareMeSobre" class="botao">Sobre</button>
	
	<section class="container">
		<div class="box">
			<div class="send">
				<br>
				<!-- Título do website -->
				<h2 class="titulo">
					<ruby> ShareMe! <rt>Transfer Among Friends!</rt></ruby>
				</h2>
				
				<!-- Formulário para submissão dos arquivos -->
				<form id="dropFileForm" action="../ProcessamentoShareMeInserirArquivo" method="POST" enctype="multipart/form-data">
					
					<!-- Input para adicionar os arquivos -->
					<input name="arquivo" type="file" name="files[]" id="fileInput"  onchange="addFiles(event)" required>
					<label  for="fileInput" id="fileLabel" 
		ondragover="overrideDefault(event); fileHover();" 
		ondragenter="overrideDefault(event); fileHover();" 
		ondragleave="overrideDefault(event); fileHoverEnd();"
		ondrop="overrideDefault(event); fileHoverEnd()
				addFiles(event);">
						<i class="fa fa-download fa-5x"></i>
						
						<br>
						
						<!-- Campo que exibe os nomes dos arquivos selecionados -->
						<span id="fileLabelText">Escolha o Arquivo!</span>
						<br>
						<spam id="uploadStatus"></spam>
					</label>

					<!-- Botão de Envio -->
					<input type="submit" value="Upload" class="uploadButton">
					
					<br><br>
					<b class="tag">Nome do Arquivo:</b><br><br>
					<input class="campoInput focus" name="nome_arquivo" type="text" id="nome_arquivo" pattern="[a-zA-Z0-9_!#()çáéíóúâêîôûàèìòùãõñ]{1, 200}" required>
					<br><br><br><br>
				</form>
			</div>
		</div>
		
		<jsp:include page="Include\hexagonos.jsp" />
	</section>
	
</body>
	<jsp:include page="Include\script.jsp" />
</html>