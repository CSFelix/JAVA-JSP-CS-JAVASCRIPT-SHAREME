/* Capturação das id's dos modais, spans de fechamento e botões de abertura dos modais */

// Modal Sobre
var modalShareMeSobre = document.getElementById("modalShareMeSobre");
var btnShareMeSobre = document.getElementById("botaoShareMeSobre");
var spanShareMeSobre = document.getElementById("fecharShareMeSobre");

// Modal Limite Upload
var modalShareMeLimiteUpload = document.getElementById("modalShareMeLimiteUpload");
var spanShareMeLimiteUpload = document.getElementById("fecharShareMeLimiteUpload");

// Modal Download
var modalShareMeDownload = document.getElementById("modalShareMeDownload");
var spanShareMeDownload = document.getElementById("fecharShareMeDownload");

/* Abertura dos Modais */
btnShareMeSobre.onclick = function() { modalShareMeSobre.style.display = "block"; }

/* Fechamento dos Modals ao clicar no Span 'x' */
spanShareMeSobre.onclick = function() { modalShareMeSobre.style.display = "none"; }
spanShareMeLimiteUpload.onclick = function() {  modalShareMeLimiteUpload.style.display = "none";  }
spanShareMeDownload.onclick = function() {  modalShareMeDownload.style.display = "none";  }

/* Fechamento do modal ao clicar fora dele */
window.onclick = function(event) {
	 if (event.target == modalShareMeSobre) { modalShareMeSobre.style.display = "none"; }
	 else if (event.target == modalShareMeLimiteUpload) { modalShareMeLimiteUpload.style.display = "none"; }
	 else if (event.target == modalShareMeDownload) { modalShareMeDownload.style.display = "none"; }
}