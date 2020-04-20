
function validateNumber() {
	var x = document.forms["validateForm"]["unit-price"].value;
	
	if (isNaN(x) || x < 1) {
		alert("unit price must be a number");
		return false;
	}
}