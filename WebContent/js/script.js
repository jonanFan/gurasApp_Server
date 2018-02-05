function sendJSON(form, restPath) {
	alert("Sendind JSON Data to Path "+restPath);
	var array = $(form).serializeArray();
	var json = {};

	$.each(array, function() {
		json[this.name] = this.value || '';
	});

	$.ajax({
		type : "POST",
		url : "http://u017633.ehu.eus:28080/gurasApp/rest/gurasApp/" + restPath,
		data : JSON.stringify(json),
		cache : false,
		dataType : "json",
		contentType : "application/json"
	});
	alert("Llegue al fin, el data mandado es "+JSON.stringify(json));
	return true;
}