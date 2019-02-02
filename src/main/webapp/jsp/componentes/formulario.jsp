<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<form id="formUserInput">
	<div class="row margin-ligth mt-3 justify-content-center">
		<div
			class="col-12 col-lg-4 text-center avatar-container margin-ligth align-self-center">
			<img class="mx-auto img-fluid rounded-circle d-block"
				style="margin-bottom: 25px;" height="185" width="185"
				src="https://scontent.fgdl3-1.fna.fbcdn.net/v/t1.0-9/18839084_10209408588718318_8122898460382478051_n.jpg?_nc_cat=104&_nc_eui2=AeF28Mrtcu4szwIyaUkyivhtRepfGc-_VwI5giFRy2g4AGOnZRn54vgBDHJemoyD0Tx41IkXV6iRpfl8HiKNV6gwvyVK8pAt2ohd_XRnFwp3gQ&_nc_ht=scontent.fgdl3-1.fna&oh=040a12c7fecc54de023a0ac54708ad8b&oe=5C9AB4DA"
				alt="avatar">
			<div class="input-group mb-3 d-block justify-content-center">
				<div class="row justify-content-center">
					<div class="col-12">
						<h4>Foto de perfil</h4>
						<div class="input-group d-block justify-content-center">
							<label class="input-group-btn">
								<div class="row justify-content-center">
									<div class="col">
										<span class="btn btn-primary"> Seleccionar imagen<input
											type="file" style="display: none;">
										</span>
									</div>
								</div>
							</label>
						</div>
						<span class="help-block"> Try selecting one or more files
							and watch the feedback </span>
					</div>
				</div>
			</div>
		</div>
		<div
			class="col-12 col-lg-6 align-self-center avatar-container margin-ligth ">
			<form action="">
				<div class="form-row">
					<div class="form-group col-sm-6">
						<label for="nombre">Nombre</label> <input type="text"
							class="form-control is-valid" placeholder="Nombre" name="nombre"
							id="nombre">
					</div>
					<div class="form-group col-sm-6">
						<label for="apellidos">Apellidos</label> <input type="text"
							class="form-control" placeholder="Apellidos" name="apellidos"
							id="apellidos">
					</div>
				</div>
				<div class="form-group">
					<label for="direccion">Dirección</label> <input type="text"
						class="form-control" placeholder="5 de Mayo #515, Col. Analco..."
						name="direccion" id="direccion">
				</div>
				<div class="form-row">
					<div class="form-group col-sm-6">
						<label for="telefono">Teléfono</label> <input type="text"
							class="form-control" placeholder="Teléfono" name="telefono"
							id="telefono">
					</div>
					<div class="form-group col-sm-6">
						<label for="email">Email</label> <input type="email"
							class="form-control" placeholder="Email" name="email" id="email">
					</div>
				</div>
				<div class="form-row">
					<div class="form-group col-12">
						<label for="cumple">Cumpleaños</label> <input type="date"
							class="form-control" value="02-16-2012" id="cumple">
					</div>
				</div>
				<div class="form-group">
					<label for="descripcion">Acerca de mi</label>
					<textarea class="form-control" name="descripcion" id="descripcion"></textarea>
				</div>
			</form>
		</div>
	</div>
</form>