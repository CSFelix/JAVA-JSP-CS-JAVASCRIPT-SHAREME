// Clique Direito do Mouse
document.addEventListener('contextmenu', function(e) { e.preventDefault(); });

document.onkeydown = function(e) {

	// F12
  	if(event.keyCode == 123) { return false; }

  	// CTRL SHIFT I
  	if(e.ctrlKey && e.shiftKey && e.keyCode == 'I'.charCodeAt(0)) { return false; }

  	// CTRL SHIFT C
  	if(e.ctrlKey && e.shiftKey && e.keyCode == 'C'.charCodeAt(0)) { return false; }

  	// CTRL SHIFT J
  	if(e.ctrlKey && e.shiftKey && e.keyCode == 'J'.charCodeAt(0)) { return false; }

  	// CTRL U
  	if(e.ctrlKey && e.keyCode == 'U'.charCodeAt(0)) { return false; }
}