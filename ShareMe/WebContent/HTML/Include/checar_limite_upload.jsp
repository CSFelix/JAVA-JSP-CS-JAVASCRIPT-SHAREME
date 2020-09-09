<%
	// Tentativa de Uploaddo Arquivo
	try {
		// Limite de upload ultrapassado
		if ((int) request.getSession().getAttribute("limite_upload") == 1) {
%>
			<!-- Display do modal correspondete -->
			<script>document.getElementById("modalShareMeLimiteUpload").style.display = "block";</script>
<%			
			// Reseta valor da variável de limite estourado
			// para que o modal não fique aparecendo a too momento
			request.getSession().setAttribute("limite_upload", 0);
		}
	}

	// Erro ao realizar upload do arquivo
	catch (Exception e) { System.out.println(e); }
%>