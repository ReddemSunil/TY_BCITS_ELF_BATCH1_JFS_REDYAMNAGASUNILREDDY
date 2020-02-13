function validation() {
	var passMatch = /(?=.*[-+/*])/;
	var password = document.elogin.password.value;
	var empId = document.elogin.empId.value;
	
	if (empId.match(passMatch)) {
		alert('empid not valid');
		return false;
	}
	
	if (password.trim().length < 5 || password.match(passMatch)) {
		alert('password is not valid');
		return false;
	}
}