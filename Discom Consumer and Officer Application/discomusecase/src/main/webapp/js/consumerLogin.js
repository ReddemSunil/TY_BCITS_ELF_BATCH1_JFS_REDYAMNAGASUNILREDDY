function validation() {
	var rrNum = /(?=.*[-+/*$@#%&!])/;
	var passMatch=/(?=.*[-+/*])/;
	var rrNumber = document.clogin.rrNumber.value;
	var password = document.clogin.password.value;
	var checkbox = document.clogin.checkbox.value;
	
	if (rrNumber.match(rrNum) || rrNumber.trim().length < 5) {
		alert("RR number is not valid ");
		return false;
	}
	if (password.trim().length < 5||password.match(passMatch)) {
		alert('password is not valid');
		return false;
	}
//	if (!checkbox.checked) {
//		alert('checked');
//		return true;
//	}
//	else {
//		alert("please check");
//		return false;
//	}
}