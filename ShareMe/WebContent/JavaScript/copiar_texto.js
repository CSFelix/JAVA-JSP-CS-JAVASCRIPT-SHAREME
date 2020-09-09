var urlDownload = document.getElementById("urlDownload");
var urlDownloadValor = urlDownload.value;
var btnCopiar = document.getElementById("btnCopiar");

btnCopiar.onclick = function() {
  urlDownload.select();    
  document.execCommand("copy");
  alert("Link Copiado!");
}

function preservarValor() {
	urlDownload.value = urlDownloadValor;
}