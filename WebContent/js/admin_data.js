var appConstants = {
	//serverURL: "http://localhost:8080/",
	serverURL: "http://u017633.ehu.eus:28080/",
	appPath: "gurasApp/",
	// URLS de los servicios rest
	getAllUsers: function() {
		return this.serverURL+this.appPath+"rest/gurasApp/getAllUsers"; 
	},
	getAllForums: function() {
		return this.serverURL+this.appPath+"rest/gurasApp/getAllForums"; 
	},
	answerQuestion: function() {
		return this.serverURL+this.appPath+"rest/gurasApp/answerQuestion"; 
	}
};

var forums = {
		total: 0,
		forum: []
};

var users = {
		total: 0,
		user: []
};

// '.tbl-content' consumed little space for vertical scrollbar, scrollbar width depend on browser/os/platfrom. Here calculate the scollbar width .
$(window).on("load resize ", function() {
  var scrollWidth = $('.tbl-content').width() - $('.tbl-content table').width();
  $('.tbl-header').css({'padding-right':scrollWidth});
}).resize();

$(document).ready(function(){
	$.ajaxSetup({
		cache : false,
		contentType : "application/json",
		timeout : 30000
	});

	
	$
	.ajax({
		type : "GET",
		url : appConstants.getAllUsers(),
		data : null,
		dataType : "json",
		timeout : 10000,
		success : function(data) {
			users.total=data.total;
			users.user=data.user;
			reloadUsers();
		},
		error : function(request, status, err) {
			alert("Error getting users");
		}
	});
	
	$
	.ajax({
		type : "GET",
		url : appConstants.getAllForums(),
		data : null,
		dataType : "json",
		timeout : 10000,
		success : function(data) {
			forums.total=data.total;
			forums.forum=data.forum;
			reloadForums();
		},
		error : function(request, status, err) {
			alert("Error getting forums");
		}
	});
});

function reloadUsers(){
	var table=$("#user-table");
	
	table.empty();
	
	var content='';
	
	for(var i=0; i < users.total; i++){
		content+='<tr>';
		content+='<td style="text-align:center;">'+users.user[i].name+'</td>';
		content+='<td style="text-align:center;">'+users.user[i].email+'</td>';
		content+='<td style="text-align:center;">'+users.user[i].login+'</td>';
		content+='<td style="text-align:center;">'+users.user[i].password+'</td>';
		content+='</tr>';
	}
	
	table.append(content);
}

function reloadForums(){
	var table=$("#forum-table");
	var modals=$("#Modals");
	
	table.empty();
	modals.empty();
	
	var tableContent='';
	var modalsContent='';

	for(var i=0; i < forums.total; i++){
		tableContent+='<tr>';
		tableContent+='<td style="text-align:center;">'+forums.forum[i].login+'</td>';
		tableContent+='<td style="text-align:center;">'+forums.forum[i].title+'</td>';
		if(forums.forum[i].answer == null || forums.forum[i].answer == undefined)
			tableContent+='<td style="text-align:center;"> </td>';
		else
		tableContent+='<td style="text-align:center;">'+forums.forum[i].answer+'</td>';
		
		if(forums.forum[i].teacher == null || forums.forum[i].teacher == undefined)
			tableContent+='<td style="text-align:center;"> </td>';
		else
		tableContent+='<td style="text-align:center;">'+forums.forum[i].teacher+'</td>';
		
		tableContent+='<td style="text-align:center;"><a href="#openModal'+i+'" ><button type="button" class="btn btn-info">Contestar</button></a></td>';
		tableContent+='</tr>';
	
		modalsContent+='<div id="openModal'+i+'" class="modalDialog">'+
			'<div>'+
			'<a href="#close" id="openModal'+i+'-close"  title="Cerrar" onclick="clearData('+i+')" class="close">X</a>'+
			'<h1>Contestar a la pregunta</h1>'+
			'<div style="text-align:left;margin-top:10px;">'+
		    '<input type="text" style="margin-bottom:10px;height:auto;width:100%;" id="openModal'+i+'-teacher" placeholder="Profesor"/></br>'+
		    '<textarea style="margin-bottom:10px;border-radius:2px;" rows="4" cols="47" id="openModal'+i+'-answer" placeholder="Respuesta"></textarea></br>'+
		   // '<button onclick="sendAnswer('+forums.forum[i].login+','+forums.forum[i].question+','+i+')" >Enviar respuesta</button>'+
			'<button onclick="sendAnswer('+i+')" >Enviar respuesta</button>'+
		    '</div>'+
			'</div>'+
			'</div>';
	}
	
	table.append(tableContent);
	modals.append(modalsContent);

}

function sendAnswer(index){
	var forum=forums.forum[index];
	var answer=$("#openModal"+index+"-answer").val();
	var teacher=$("#openModal"+index+"-teacher").val();
	
	if(answer != null && answer != undefined && answer != "" && teacher != null && teacher != undefined && teacher != "")
	{		
		forum.answer=answer;
		forum.teacher=teacher;
		
		$("#openModal"+index+"-close").click();
		window.location=$("#openModal"+index+"-close").attr("href");
		
		
		$
		.ajax({
			type : "POST",
			url : appConstants.answerQuestion(),
			data : JSON.stringify(forum) ,
			dataType : "text",
			timeout : 10000,
			success : function(data) {
				if(data.localeCompare("OK") == 0)
				{
					reloadForums();
				}
				else
				{
					alert("Ocurrio algún error al actualizar la pregunta en el servidor");
				}
				
			},
			error : function(request, status, err) {
				alert("Error al actualizar la pregunta");
			}
		});
	}
	else
	{
		alert("Se deben de rellenar ambas casillas");
	}
}

function clearData(index){
	var elemento=$("#openModal"+index);
	elemento.find("textarea").val("");
	elemento.find("input").val("");
}