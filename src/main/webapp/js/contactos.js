$(function(){
	$(document).ready(function(){
		
		buscar("buscar", 1, 8, 1, "");
		
		//Asignar funcionalidad al boton agregar contacto
		$('body').on("click","#btnAgregar", function(e){
			e.preventDefault();
			
			$("#modalUserInfo").modal('toggle');
			console.log("click en guardar");
		})
	})
})

function buscar(accion, idUsuario, limite, pagina, busqueda){
	var datos = [
		{name: "accion", value: accion},
		{name: "idUsuario", value: idUsuario},
		{name: "limite", value: limite},
		{name: "pagina", value: pagina},
		{name: "busqueda", value: busqueda}
	]
	
	$.ajax({
		url: "ContactosControladores",
		type: "GET",
		data: datos,
		dataType: "json"
	}).done(function(respuesta){
		console.log(respuesta);
	}).fail(function(error){
		console.log("ERROR: " + error);
	})
}