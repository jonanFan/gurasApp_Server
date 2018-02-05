function checkLogin(form){
	if(form.userid.value == "admin" && form.pwd.value == "gurasAppAdmin")
	{
		form.reset();
		return true;
	}
	else
	{
		alert("Error Password or Username")
		return false;
	}
}