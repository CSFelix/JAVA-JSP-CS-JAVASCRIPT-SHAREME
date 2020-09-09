<%@ page language="java" contentType="text/html; charset=utf8"
    pageEncoding="utf8"%>

<%@page import="Dao.ShareMeArquivoDao" %>
<%@ page import="java.io.*"%>

<%@ page import="java.io.OutputStream"%>

<%
	ShareMeArquivoDao arquivo_dao = new ShareMeArquivoDao();

	OutputStream arquivo_output = response.getOutputStream();
	arquivo_output.write(arquivo_dao.SelecionarArquivo(request.getParameter("hash")));
	arquivo_output.flush();
	arquivo_output.close();

	arquivo_dao = null;
%>

<jsp:include page="Include\script.jsp" />
<jsp:include page="Include\modal.jsp" />
<jsp:include page="Include\checar_limite_upload.jsp" />