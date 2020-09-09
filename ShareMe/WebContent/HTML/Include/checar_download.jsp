<%
	// Tentativa de Uploaddo Arquivo
	try {
		// Limite de upload ultrapassado
		if ((int) request.getSession().getAttribute("Download") == 1) {
%>
			<!-- Display do modal correspondete -->
			<script>document.getElementById("modalShareMeDownload").style.display = "block";</script>
<%			
			// Reseta valor da variável de limite estourado
			// para que o modal não fique aparecendo a too momento
			request.getSession().setAttribute("Download", 0);
		}
	}

	// Erro ao realizar upload do arquivo
	catch (Exception e) { System.out.println(e); }
%>