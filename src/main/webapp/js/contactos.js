$(function(){
	$(document).ready(function(){
		
		buscar("buscar", 1, 8, 1, "");
		
		//Se asigna el evento de click a las cards.
	    $('body').on("click", ".my-body-card", function(e){
	        e.preventDefault()
	        $("#title").text("")
	        $('#modalUserInfo').modal('toggle');//open modal
	        idContact = $(this).data('id');
	        console.log("user id: "+idContact);
	        getContact(1, idContact)
	        actualizarContacto(idContact)
	        //subirFoto('1', idContact)
	    });
	    
	    //Limpia los campos del modal cuanod se cierra
    	$("#modalUserInfo").on("hidden.bs.modal", function(event){
			console.log("hide");
			$("#nombre").val('');
			$("#apellidos").val('');
			$("#direccion").val('');
			$("#telefono").val('');
			$("#email").val('');
			$("#cumple").val('');
			$('#profileImage').attr('src', 'http://localhost:8080/img/perfil.png');
		})
	    
	  //Se agrega funcionalidad al search de contactos.
	    $(document).on("submit", "#searchForm", function(event){
	        event.preventDefault()
	        var searchValue = $('#searchTxt').val()
	        buscar("buscar", 1, 8, 1, searchValue)
	    })
		
		//Asignar funcionalidad al boton agregar contacto
		$('body').on("click","#btnAgregar", function(e){
			guardarContacto()
			e.preventDefault();
			$("#modalUserInfo").modal('toggle');
			console.log("click en guardar");
		})
		
		 //Se agrega funcionalidad a la paginación de la busqueda.
	    $('body').on("click", ".btnPage", function(e){
	    	e.preventDefault();
	    	var page = $(this).data('id');
	   	  	var searchValue = $('#searchTxt').val()
	   	  	buscar("buscar", 1, 8, page, searchValue)
	    })
	    
	    		//Agrega funcionalidad al boton de eliminar
	  $("body").on("click",".btnEliminar", function(e){
		  e.preventDefault();
		  Swal.fire({
			  title: '¿Eliminar Contacto?',
			  text: "Esta operacion no puede deshacerse",
			  type: 'warning',
			  showCancelButton: true,
			  confirmButtonColor: '#3085d6',
			  cancelButtonColor: '#d33',
			  confirmButtonText: 'sí'
		  }).then((result) => {
			  if (result.value) {
				  var idContact = $(this).data('id');
				  console.log(idContact);
				  
				  $.ajax({
						url:"ContactoController",
						type: 'GET',
						data:{
							"accion":"eliminarContacto",
							"idUser": 1,
							"idContact":idContact
						},
						dataType: 'json'
					})
					.done(function(response){
						console.log(response)
						  Swal.fire(
						      'Eliminado!',
						      'El contacto fue eliminado correctamente',
						      'success'
						    )
						    
					    var page = $('#actualPage').data('id');
						console.log('page: '+page)
				   	  	var searchValue = $('#searchTxt').val()
				   	  	buscar("buscar", 1, 8, page, searchValue)
					})
					.fail(function(error){
						Swal.fire(
					      'Upps!!',
					      'Algo salio mal',
					      'error'
					    )
					})
			  }
			})
		  })
	    
	})
})

function getContact(idUser, idContact){
	 //Peticion asincrona para obtener la información del usuario.
	  $.ajax({
			url:"ContactoController",
			type: 'GET',
			data:{
				"accion":"traerContacto",
				"idUser": idUser,
				"idContact":idContact
			},
			dataType: 'json'
		})
		.done(function(response){
			console.log("correcto");
			console.log(response);
			$("#title").text("Editar");
			$("#nombre").val(response.nombre);
			$("#apellidos").val(response.apellido);
			$("#direccion").val(response.direccion);
			$("#telefono").val(response.telefono);
			$("#email").val(response.email);
			document.getElementById("cumple").valueAsDate = new Date(response.fechaNacimiento)
			if(response.imagen !== undefined) {
				$('#profileImage').attr('src', response.imagen);
			} else {
				$('#profileImage').attr('src', 'http://localhost:8080/img/perfil.png');				
			}

		    //se abre el modal.
		    $('#modalUserInfo').modal('toggle');//open modal
		});
	
}

function guardarContacto(){

	//Limpia el evento submit del formulario.
	$(document).off("submit","#formUserInput");
	$("#accion").val("agregarContacto");
	
	//Agrega un nuevo envento submit al formulario.
	$(document).on("submit", "#formUserInput", function(event){
		event.preventDefault();
		console.log("Guardar");
		
		//Petición asincrona para guardar un contacto.
		$.ajax({
			url:"ContactoController",
			type: 'POST',
			data: $(this).serialize(),
			dataType: 'json'
		})
		.done(function(respuesta){
			console.log("Usuario agregado: "+respuesta.nombre)
			$('#modalUserInfo').modal('hide')
			
			var page = $('#actualPage').data('id')
	   	  	var searchValue = $('#searchTxt').val()
	   	  	buscar("buscar", 1, 8, page, searchValue)
			
			Swal.fire({
			  type: 'success',
			  title: 'Contacto guardado',
			  showConfirmButton: false,
			  timer: 1500
			})
		})
		.fail(function(error){
			console.log(error.status);
			console.log("Error: ");
			console.log(error.responseText);
			
			//Mensaje de Sweet Alert 2
			Swal.fire({
			 type: 'error',
			 title: 'Oops...',
			 text: 'Algo salio mal >:v',
			});

		})
		.always(function(data){
			console.log("always: "+data);
			
		})
	});	
}

function actualizarContacto(idContacto){
	//Se limian los eventos del formiladio del modal.
	$(document).off("submit","#formUserInput");
	$("#accion").val("actualizarContacto");
	
	$(document).on("submit", "#formUserInput", function(e){
		 e.preventDefault();
		 console.log("Editar: "+idContacto);
		
		 var data = $(this).serializeArray();
		 data.push({name:"id", value:idContacto})
		 
		 console.log(data);
		 
		$.ajax({
			url:"ContactoController",
			type: 'POST',
			data: data,
			dataType: 'json'
		})
		.done(function(response){
			console.log("correcto");
			console.log(response);
			
			$('#modalUserInfo').modal('hide')
			
			Swal.fire({
			  type: 'success',
			  title: 'Contacto Acualizado',
			  showConfirmButton: false,
			  timer: 1500
			})
		})
	})
}


function buscar(accion, idUsuario, limite, pagina, busqueda){
	var datos = [
		{name: "accion", value: accion},
		{name: "idUsuario", value: idUsuario},
		{name: "limite", value: limite},
		{name: "pagina", value: pagina},
		{name: "busqueda", value: busqueda}
	]
	
	$.ajax({
		url: "ContactoController",
		type: "GET",
		data: datos,
		dataType: "json"
	}).done(function(respuesta){
		 $(".my-card").remove();
	        respuesta.contactos.forEach(function(contacto){
	            var card = ""
	            card += '<div class="my-card">'
	            card +=     '<div class="row no-gutters justify-content-end my-header-card">'
	            card +=        '<div class="col-auto">'
	            card +=             '<button data-id="'+contacto.id+'" class="btn btn-link btn-close btnEliminar"><i class="far fa-times-circle close"></i></button>'
	            card +=        '</div>'
	            card +=     '</div>'
	            card +=     '<div data-id="'+contacto.id+'"class="my-body-card" id="'+contacto.id+'">'
	            card +=        '<div class="img-container d-flex justify-content-center">'
	        	if(contacto.imagen !== undefined){
	        	card += 			'<img class="rounded-circle" height="100" width="100" src="'+contacto.imagen+'">'
	        	} else {
	        	card += 			'<img class="rounded-circle" height="100" width="100" src="http://localhost:8080/img/perfil.png" alt="Perfil img">'
	        	}
	            card +=        '</div>'
	            card +=        '<div class="row no-gutters d-flex justify-content-center">'
	            card +=            '<div class="col-12">'
	            card +=                '<p class="text-center"><strong>'+contacto.nombre+'</strong></p>'
	            card +=                '<p class="text-muted text-center">'+contacto.email+'</p>'
	            card +=                '<p class="text-muted text-center">'+contacto.fechaNacimiento+'</p>'
	            card +=             '</div>'
	            card +=         '</div>'
	            card +=     '</div>'
	            card += '</div>'
	            
	            $('#grid-contactos').append(card)
	            
	            console.log("Paginas: "+respuesta.paginas);
	            
	            $(".page").remove();
	            for(var i = 0; i < respuesta.paginas; i++){
	            	
	            	if((i+1) != pagina){
	            		$('.pagination').append('<li class="page-item page"><button data-id="'+(i+1)+'" class="page-link btnPage">'+(i+1)+'</button></li>');
	            	} else {
	            		$('.pagination').append('<li class="page-item page active"><button id="actualPage" data-id="'+(i+1)+'" class="page-link btnPage">'+(i+1)+'</button></li>');
	            	}
	            }
	            
	            var next = '<li class="page-item page">' +
	    				        '<a class="page-link" href="#" aria-label="Next">' +
	    				            '<span aria-hidden="true">&raquo;</span>' +
	    				        '</a>'+
	    				    '</li>'
	            $('.pagination').append(next);
	        });
	}).fail(function(error){
		console.log("ERROR: " + error);
	})
}