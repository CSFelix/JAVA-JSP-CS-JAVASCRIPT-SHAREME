var dropFileForm = document.getElementById("dropFileForm");
var fileLabelText = document.getElementById("fileLabelText");
var uploadStatus = document.getElementById("uploadStatus");
var fileInput = document.getElementById("fileInput");
var nome_arquivo = document.getElementById("nome_arquivo");
var droppedFiles;

function overrideDefault(event) {
	event.preventDefault();
	event.stopPropagation();
}

function fileHover() { dropFileForm.classList.add("fileHover"); }
function fileHoverEnd() { dropFileForm.classList.remove("fileHover"); }

function addFiles(event) {
	droppedFiles = event.target.files || event.dataTransfer.files;
	showFiles(droppedFiles);
}

function showFiles(files) {
	if(files.length > 1) { fileLabelText.innerText = files.length + " files selected"; }

	else { 
		fileLabelText.innerText = files[0].name; 
		nome_arquivo.value = files[0].name;
	}
}

function uploadFiles(event) {
	event.preventDefault();
	changeStatus("Uploading...");

	var formData = new FormData();
	for (var i = 0, file; file=droppedFiles[i]; i++) { formData.append(fileInput.name, file, file.name); }
	var xhr = new XMLHttpRequest();

	xhr.open(dropFileForm.method, dropFileForm.action, true);
	xhr.send(formData);
}

function changeStatus(text) {uploadStatus.innerText = text; }