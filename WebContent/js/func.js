function checkPswd()	{
	if(document.getElementById('password').value == document.getElementById('cpassword').value)	{
		alert("Password are matched!");
	}
	else {
		alert("Password are not matched!");
	}
}
