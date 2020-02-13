function validation() {
	var rrNum = /(?=.*[-+/*$@#%&!])/;
	var rrNumber = document.empsearch.rrNumber.value;
	
	if (rrNumber.match(rrNum) || rrNumber.trim().length < 5) {
		alert("RR number is not valid ");
		return false;
	}
}