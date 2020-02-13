function validation() {
	var name = /(?=.*[0-9])/;
	var rrNum = /(?=.*[-+/*$@#%&!])/;
	var passMatch=/(?=.*[-*+/])/;
	var conMatch = /(?=.*[a-z])(?=.*[A-Z])(?=.*[-/*$@#%&!])/;
	var fName = document.signin.firstName.value;
	var lName = document.signin.lastName.value;
	var rrNumber = document.signin.rrNumber.value;
	var contact = document.signin.contactNumber.value;
	var mail = document.signin.mail.value;

	var password = document.signin.password.value;
	var cpassword = document.signin.cPassword.value;

	var region = document.signin.region.value;
	var consumerType = document.signin.typeOfConsumer.value;
	var address1 = document.signin.address1.value;
	var address2 = document.signin.address2.value;

	if (fName.trim().length < 5 || lName.trim().length < 5
			|| lName.trim().length > 20) {
		alert("Please Enter Valid First Name and Last Name");
		return false;
	}
	if (fName.match(name) || lName.match(name)) {
		alert("name should not contains numbers");
		return false;
	}
	if (rrNumber.match(rrNum) || rrNumber.trim().length < 5) {
		alert("RR number is not valid ");
		return false;
	}
	if (contact.match(conMatch) || contact.trim().length < 10
			|| contact.trim().length > 12) {
		alert('please enter proper contact number');
		return false;
	}
	if (mail.trim().length < 15) {
		alert('please enter valid mail id');
		return false;
	}

	if (password !== cpassword) {
		alert('password and confirm password not matched');
		return false;
	}
	if (password.trim().length < 5||password.match(passMatch)) {
		alert('password is not valid ');
		return false;
	}
	if (region === null || region === "") {
		alert('please select region');
		return false;
	}
	if (consumerType === null || consumerType === "") {
		alert('please select consumerType');
		return false;
	}
	if (address1 === "" || address1.trim().length < 20
			|| address1.trim().length > 70 || address2 === ""
			|| address2.trim().length < 10 || address2.trim().length > 70) {
		alert('please enter valid address');
		return false;
	}
	

}