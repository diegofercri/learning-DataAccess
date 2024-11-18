<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">

<head>
    <title>AEMET</title>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />

    <!-- Bootstrap CSS v5.2.1 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous" />
</head>
<body>
    <div class="container">
        <header style="background-color: #3A85CA;">
            <div class="row justify-content-between p-3">
                <div class="col">
                    <img src="img/logo.gif" alt="">
                </div>
                <div class="col text-end">
                    <img src="img/logo2.gif" alt="">
                </div>
            </div>
        </header>
        <main>
            <div class="row shadow mx-0 mt-2 p5 justify-content-center">
            	<c:forEach items="${dias}" var="dia">
	                <div class="col-lg-6 my-2 d-flex">
	                    <div class="card flex-fill">
	                        <div class="row">
	                           <div class="col-4"><img class="card-img-top" src="https://www.aemet.es/imagenes/png/estado_cielo/${dia.icono}_g.png" alt="Title" /></div>
	                            <div class="col-8">
	                                <div class="card-body">
	                                    <h4 class="card-title">${dia.fecha}</h4>
	                                    <h5 class="card-text">${dia.prono}</h5>
	                                    <p>Max: <span class="text-danger fw-bold">${dia.max}º</span> - Min: <span class="text-success fw-bold">${dia.min}º</span></p>
	                                    <p>Precipitación: ${dia.preci}%</p>
	                                </div>        
	                            </div>
	                        </div>
	                    </div>
	                </div>
                </c:forEach>
            </div>
        </main>
        <footer  style="background-color: #3A85CA;">
            <h4 class="text-center text-white p-3">&copy; PACO PULIDO</h4>

        </footer>
    </div>
    <!-- Bootstrap JavaScript Libraries -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
        integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
        crossorigin="anonymous"></script>
</body>

</html>