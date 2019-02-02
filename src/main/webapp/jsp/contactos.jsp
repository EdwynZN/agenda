<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<meta http-equiv="X-UA-Compatible" content="ie=edge">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.6.3/css/all.css" integrity="sha384-UHRtZLI+pbxtHCWp1t77Bi1L4ZtiqrqD80Kn4Z8NTSRyMA2Fd33n5dQ8lWUE00s/" crossorigin="anonymous">
	<link rel="stylesheet" href='<c:url value="/css/bootstrap/bootstrap.min.css" />'>
	<link rel="stylesheet" href='<c:url value="/css/styles.css"/>'>
<title>Contactos</title>
</head>
<body>
	<!--Barra de navegasión-->
	<%@ include file="componentes/header.jsp"%>

	<!--Mensaje de alerta-->
	<div class="alert alert-info alert-dismissible fade show" role="alert">
		<p class="text-center">
			<strong>Bienvenido!</strong> Ahora puedes ver todos tus contactos en
			esta sección y hacer búsquedas para que accedas más rapido a ellos.
		</p>

		<button type="button" class="close" data-dismiss="alert"
			aria-label="Close">
			<span aria-hidden="true">&times;</span>
		</button>
	</div>

	<section class="container">
		<!--Controles-->
		<div class="row justify-content-between" style="margin: 25px;">
			<div class="col-auto align-self-center">
				<button id="btnAgregar" class="btn btn-info" type="button">
					<i class="fas fa-plus-circle"></i>
				</button>
				<button class="btn btn-info" type="button">
					<i class="fas fa-birthday-cake"></i>
				</button>
			</div>
			<div class="col-auto align-self-center">
				<div class="input-group">
					<input type="text" class="form-control"
						placeholder="Buscar contacto" aria-label="Buscar contacto"
						aria-describedby="button-addon2">
					<div class="input-group-append">
						<button class="btn btn-info" type="button" id="button-addon2">
							<i class="fas fa-search"></i>
						</button>
					</div>
				</div>
			</div>
		</div>
		<hr>

		<!--Grid View-->
		<div class="row justify-content-between mx-3">
			<div class="col">
				<div class="contacts-container">
					<!--Card Item-->
					<div class="my-card">
						<div class="row no-gutters justify-content-end my-header-card">
							<div class="col-auto">
								<button class="btn btn-link btn-close">
									<i class="far fa-times-circle close"></i>
								</button>
							</div>
						</div>
						<div class="my-body-card" id="card-1">
							<div class="img-container d-flex justify-content-center">
								<img class="rounded-circle" height="100" width="100"
									src="https://scontent.fgdl3-1.fna.fbcdn.net/v/t1.0-9/18839084_10209408588718318_8122898460382478051_n.jpg?_nc_cat=104&_nc_eui2=AeF28Mrtcu4szwIyaUkyivhtRepfGc-_VwI5giFRy2g4AGOnZRn54vgBDHJemoyD0Tx41IkXV6iRpfl8HiKNV6gwvyVK8pAt2ohd_XRnFwp3gQ&_nc_ht=scontent.fgdl3-1.fna&oh=040a12c7fecc54de023a0ac54708ad8b&oe=5C9AB4DA"
									alt="">
							</div>
							<div class="row no-gutters d-flex justify-content-center">
								<div class="col-12">
									<p class="text-center">
										<strong>Joaquín Coronado Ramírez</strong>
									</p>
									<p class="text-muted text-center">joaquincora@hotmail.com</p>
									<p class="text-muted text-center">23 años | Hombre</p>
								</div>
							</div>
						</div>
					</div>

					<!--Card Item-->
					<div class="my-card">
						<div class="row no-gutters justify-content-end my-header-card">
							<div class="col-auto">
								<button class="btn btn-link btn-close">
									<i class="far fa-times-circle close"></i>
								</button>
							</div>
						</div>
						<div class="my-body-card">
							<div class="img-container d-flex justify-content-center">
								<img class="rounded-circle" height="100" width="100"
									src="https://scontent.fgdl3-1.fna.fbcdn.net/v/t1.0-9/48414162_2166423903402412_3914416889878544384_n.jpg?_nc_cat=106&_nc_eui2=AeGhJAU-HrDr7YhJfpMDxHy7mEJDE4oec9dTuYS9crDXQwkfnj0zW5xa4-TdxRDP2cg0rplg6L1TUyfjs3faEGZWCXj9IN9RshYYSkaVuFbs1w&_nc_ht=scontent.fgdl3-1.fna&oh=c02c61a5f9feae2a4774be73d4f8f5b9&oe=5C8DCEFB"
									alt="">
							</div>
							<div class="row no-gutters d-flex justify-content-center">
								<div class="col-12">
									<p class="text-center">
										<strong>Jesica Cervantes Hernandez</strong>
									</p>
									<p class="text-muted text-center">jesica@hotmail.com</p>
									<p class="text-muted text-center">23 años | Mujer</p>
								</div>
							</div>
						</div>
					</div>

					<!--Card Item-->
					<div class="my-card">
						<div class="row no-gutters justify-content-end my-header-card">
							<div class="col-auto">
								<button class="btn btn-link btn-close">
									<i class="far fa-times-circle close"></i>
								</button>
							</div>
						</div>
						<div class="my-body-card">
							<div class="img-container d-flex justify-content-center">
								<img class="rounded-circle" height="100" width="100"
									src="https://scontent.fgdl3-1.fna.fbcdn.net/v/t1.0-9/10492433_614093392058420_7709117532318539816_n.jpg?_nc_cat=102&_nc_eui2=AeHN1241JLlhBREnGq-n4XpdPx7zz-24LCm4YjVAyURLaUS--VySjoBPGqcVEPcWTvd519QX_4Qw706nuVTObLitZ3i-Fq5L5UGNopLhOZ6HFA&_nc_ht=scontent.fgdl3-1.fna&oh=31240a6f183d8f3ba5ddbe30d624e99b&oe=5CD48F8D"
									alt="">
							</div>
							<div class="row no-gutters d-flex justify-content-center">
								<div class="col-12">
									<p class="text-center">
										<strong>Moisés Chávez Ríos</strong>
									</p>
									<p class="text-muted text-center">moy@hotmail.com</p>
									<p class="text-muted text-center">24 años | hombre</p>
								</div>
							</div>
						</div>
					</div>

					<!--Card Item-->
					<div class="my-card">
						<div class="row no-gutters justify-content-end my-header-card">
							<div class="col-auto">
								<button class="btn btn-link btn-close">
									<i class="far fa-times-circle close"></i>
								</button>
							</div>
						</div>
						<div class="my-body-card">
							<div class="img-container d-flex justify-content-center">
								<img class="rounded-circle" height="100" width="100"
									src="https://scontent.fgdl3-1.fna.fbcdn.net/v/t1.0-9/48426744_2070393599665919_7489652554465280000_n.jpg?_nc_cat=100&_nc_eui2=AeHKY6nyTlx1rsV5cO5E9k1DUAWiNQwAtTJwhxfoXFssRsOtQHK5_onP39QGBHyu0NC51dQXgtvlsuihwvev6l-hT7oGNYuohth1wpspOcZ20A&_nc_ht=scontent.fgdl3-1.fna&oh=765a3ce4746d3f5ba38752368f49a410&oe=5C942ED6"
									alt="">
							</div>
							<div class="row no-gutters d-flex justify-content-center">
								<div class="col-12">
									<p class="text-center">
										<strong>Efrén Cabañas Luna</strong>
									</p>
									<p class="text-muted text-center">efren@hotmail.com</p>
									<p class="text-muted text-center">23 años | Hombre</p>
								</div>
							</div>
						</div>
					</div>

					<!--Card Item-->
					<div class="my-card">
						<div class="row no-gutters justify-content-end my-header-card">
							<div class="col-auto">
								<button class="btn btn-link btn-close">
									<i class="far fa-times-circle close"></i>
								</button>
							</div>
						</div>
						<div class="my-body-card">
							<div class="img-container d-flex justify-content-center">
								<img class="rounded-circle" height="100" width="100"
									src="https://scontent.fgdl3-1.fna.fbcdn.net/v/t1.0-9/309781_1783328882452_2139436353_n.jpg?_nc_cat=107&_nc_eui2=AeGH0Y7uyQJtD5qk1Y0LCX_AL-aspIk2MQwK8Kk-ZvO2CmDfeZMx5QIsG1GhRvLnRMA80TjZOS9Vr2uB_b6Kpxx84fM_XA--uq670euei8nNTg&_nc_ht=scontent.fgdl3-1.fna&oh=6d298f32fd0ee29cef404c7ff81c532d&oe=5CCB5A28"
									alt="">
							</div>
							<div class="row no-gutters d-flex justify-content-center">
								<div class="col-12">
									<p class="text-center">
										<strong>Hector Ivan Sánchez Ascencio</strong>
									</p>
									<p class="text-muted text-center">hector@hotmail.com</p>
									<p class="text-muted text-center">23 años | hombre</p>
								</div>
							</div>
						</div>
					</div>

					<!--Card Item-->
					<div class="my-card">
						<div class="row no-gutters justify-content-end my-header-card">
							<div class="col-auto">
								<button class="btn btn-link btn-close">
									<i class="far fa-times-circle close"></i>
								</button>
							</div>
						</div>
						<div class="my-body-card">
							<div class="img-container d-flex justify-content-center">
								<img class="rounded-circle" height="100" width="100"
									src="https://scontent.fgdl3-1.fna.fbcdn.net/v/t1.0-9/43574653_899527056917136_65796699951464448_n.jpg?_nc_cat=109&_nc_eui2=AeGos-6pSZ2Vuao6lDNAxhMDYhfLOYnmSCyskWSM8aYzf0Pro2lNKC7BJXD3ZFc6O_FKz6TE5AEWcFpE-HQr8CJcqJdCWYLXSTy1-jogtmqLlg&_nc_ht=scontent.fgdl3-1.fna&oh=7c8279f9483aad8a3fbbfd2f085c94cf&oe=5CCB2FA3"
									alt="">
							</div>
							<div class="row no-gutters d-flex justify-content-center">
								<div class="col-12">
									<p class="text-center">
										<strong>Gerardo David Gonzalez Velazco </strong>
									</p>
									<p class="text-muted text-center">gera@hotmail.com</p>
									<p class="text-muted text-center">30 años | hombre?</p>
								</div>
							</div>
						</div>
					</div>

					<!--Card Item-->
					<div class="my-card">
						<div class="row no-gutters justify-content-end my-header-card">
							<div class="col-auto">
								<button class="btn btn-link btn-close">
									<i class="far fa-times-circle close"></i>
								</button>
							</div>
						</div>
						<div class="my-body-card">
							<div class="img-container d-flex justify-content-center">
								<img class="rounded-circle" height="100" width="100"
									src="https://scontent.fgdl3-1.fna.fbcdn.net/v/t1.0-9/15390695_10209306926724553_971146306244753036_n.jpg?_nc_cat=111&_nc_eui2=AeH2Ex5CscQcx9GbeuLpdKshqs-AFnd7LQDhxHgIbSlPcqkQ4CoHA35QXYnGDp7Zrz0-G--dl60NQdObjgEHVdnA9PAMXlqsK6G80j7XHUK2Jg&_nc_ht=scontent.fgdl3-1.fna&oh=890f4c4ef71c08d9dab039cc619bdac6&oe=5CCFD7C1"
									alt="">
							</div>
							<div class="row no-gutters d-flex justify-content-center">
								<div class="col-12">
									<p class="text-center">
										<strong>Ricardo Coronado Ramírez</strong>
									</p>
									<p class="text-muted text-center">ricardo@hotmail.com</p>
									<p class="text-muted text-center">25 años | Hombre</p>
								</div>
							</div>
						</div>
					</div>

					<!--Card Item-->
					<div class="my-card">
						<div class="row no-gutters justify-content-end my-header-card">
							<div class="col-auto">
								<button class="btn btn-link btn-close">
									<i class="far fa-times-circle close"></i>
								</button>
							</div>
						</div>
						<div class="my-body-card">
							<div class="img-container d-flex justify-content-center">
								<img class="rounded-circle" height="100" width="100"
									src="https://scontent.fgdl3-1.fna.fbcdn.net/v/t1.0-9/48414162_2166423903402412_3914416889878544384_n.jpg?_nc_cat=106&_nc_eui2=AeGhJAU-HrDr7YhJfpMDxHy7mEJDE4oec9dTuYS9crDXQwkfnj0zW5xa4-TdxRDP2cg0rplg6L1TUyfjs3faEGZWCXj9IN9RshYYSkaVuFbs1w&_nc_ht=scontent.fgdl3-1.fna&oh=c02c61a5f9feae2a4774be73d4f8f5b9&oe=5C8DCEFB"
									alt="">
							</div>
							<div class="row no-gutters d-flex justify-content-center">
								<div class="col-12">
									<p class="text-center">
										<strong>Jesica Cervantes Hernandez</strong>
									</p>
									<p class="text-muted text-center">jesica@hotmail.com</p>
									<p class="text-muted text-center">23 años | Mujer</p>
								</div>
							</div>
						</div>
					</div>

				</div>
			</div>
		</div>
		<hr>

		<!--Paginación-->
		<div class="row no-gutters justify-content-center"
			style="margin-top: 35px;">
			<div class="col-auto align-self-center">
				<nav aria-label="Page navigation example">
					<ul class="pagination">
						<li class="page-item"><a class="page-link" href="#"
							aria-label="Previous"> <span aria-hidden="true">&laquo;</span>
						</a></li>
						<li class="page-item"><a class="page-link" href="#">1</a></li>
						<li class="page-item"><a class="page-link" href="#">2</a></li>
						<li class="page-item"><a class="page-link" href="#">3</a></li>
						<li class="page-item"><a class="page-link" href="#"
							aria-label="Next"> <span aria-hidden="true">&raquo;</span>
						</a></li>
					</ul>
				</nav>
				<p class="text-center text-muted" style="font-size: 13px">1 - 8
					Contactos de 25</p>
			</div>
		</div>
	</section>
	<!--Container-->

	<!--Footer-->
	<%@ include file="componentes/footer.jsp"%>

	<!-- Modal -->
	<%@ include file="componentes/modal.jsp"%>

	<!--JS files-->
	<script src= '<c:url value="/js/Jquery/jquery-3.3.1.js"/>'></script>
	<script src= '<c:url value="/js/popper/popper.min.js"/>'></script>
	<script src= '<c:url value="/js/bootstrap/bootstrap.min.js"/>'></script>
	<script src= '<c:url value="/js/contactos.js"/>'></script>
</body>
</html>