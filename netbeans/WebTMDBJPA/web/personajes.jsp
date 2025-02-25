<%-- 
    Document   : personajes
    Created on : 02-feb-2025, 19:50:10
    Author     : pacopulido
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">

<head>
    <title>Title</title>
    <!-- Required meta tags -->
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />

    <!-- Bootstrap CSS v5.2.1 -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
        integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous" />
    <link rel="stylesheet" href="mycss.css">
</head>

<body>
    <div class="container px-0 shadow">
        <nav class="navbar navbar-expand-md navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand" href="#"><img src="img/logotmdb.png" alt="" width="80"></a>
                <button class="navbar-toggler d-lg-none" type="button" data-bs-toggle="collapse"
                    data-bs-target="#collapsibleNavId" aria-controls="collapsibleNavId" aria-expanded="false"
                    aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="collapsibleNavId">
                    <ul class="navbar-nav me-auto mt-2 mt-lg-0">
                        <li class="nav-item">
                            <a class="nav-link" href="Controller?op=dameperson"><h2>Person</h2></a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="Controller?op=damemovie"><h2>Movie</h2></a>
                        </li>
                    </ul>
                    <c:choose>
                        <c:when test="${usuario==null}">
                            <form class="d-flex my-2 my-lg-0" action="Controller?op=login" method="post">
                                <input class="form-control me-sm-2" type="text" placeholder="DNI" name="dni" />
                                <input class="form-control me-sm-2" type="text" placeholder="Nombre" name="nombre" />
                                <button class="btn btn-outline-success my-2 my-sm-0" type="submit">
                                    Login/Register
                                </button>
                            </form>                            
                        </c:when>
                        <c:otherwise>
                            <span class="h3 text-white">Welcome ${usuario.nombre}</span>
                            <a href="Controller?op=logout" class="btn btn-outline-danger my-2 my-sm-0 ms-2">
                                Logout
                            </a>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </nav>
        <!-- Personajes -->
        <div class="row justify-content-center px-3">
            <c:forEach items="${personajes}" var="personaje">
                <div class="col-md-6 col-lg-4 p-3">
                    <div class="card h-100">
                        <img class="card-img-top" src="https://image.tmdb.org/t/p/w500${personaje.foto}" class="img-fluid" alt="">
                        <div class="card-body">
                            <p class="text-center">
                                <span class="h2">
                                    <c:forEach begin="1" end="${personaje.avg}">
                                        &#9733;
                                    </c:forEach>
                                </span>
                            <p>
                            <h4 class="card-title text-center">${personaje.nombre}</h4>
                        </div>
                        <c:if test="${usuario!=null}">
                            <div class="text-center">
                                <span class="rating">
                                    <a href="Controller?op=rating&rating=1&idpersonaje=${personaje.id}">&#9733;</a>
                                    <a href="Controller?op=rating&rating=2&idpersonaje=${personaje.id}">&#9733;</a>
                                    <a href="Controller?op=rating&rating=3&idpersonaje=${personaje.id}">&#9733;</a>
                                    <a href="Controller?op=rating&rating=4&idpersonaje=${personaje.id}">&#9733;</a>
                                    <a href="Controller?op=rating&rating=5&idpersonaje=${personaje.id}">&#9733;</a>
                                </span>
                            </div>
                            <div class="card-footer text-center">
                                <button class="btn btn-success" data-bs-toggle="modal" data-bs-target="#modalmovies" data-bs-personajeid="${personaje.id}">FILMOGRAFÍA</button>
                            </div>
                        </c:if>
                    </div>
                </div>
            </c:forEach>
        </div>
        <footer>
            <h2 class="text-center bg-dark text-success py-3 m-0">The MovieDB - Azarquiel</h2>
        </footer>
<div class="position-fixed top-50 start-50 translate-middle">
    	<div id="tostada" class="toast rounded-pill border-2 border-danger" role="alert" aria-live="assertive" aria-atomic="true" data-bs-delay="2000">
        		<div class="toast-body bg-light text-danger text-center rounded-pill">
            		<h5>${msg}</h5>
        		</div>
    	</div>
</div>
                 
        
    </div>
<!-- modal-->
    <div class="modal fade" id="modalmovies" tabindex="-1" data-bs-keyboard="false" role="dialog"
        aria-labelledby="modalTitleId" aria-hidden="true">
        <div class="modal-dialog modal-dialog-scrollable modal-dialog-centered modal-md" role="document">
            <div class="modal-content">
                <div class="modal-body">
                   
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">
                        Ok
                    </button>
                </div>
            </div>
        </div>
    </div>
    <!-- Bootstrap JavaScript Libraries -->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
        integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
        crossorigin="anonymous"></script>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
        integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
        crossorigin="anonymous"></script>
    <script src="myjs.js" type="text/javascript"></script>
<c:if test="${msg!=null}">
        	<script type="text/javascript">
	    	const tostada = document.getElementById('tostada')
	    	const toastBootstrap = bootstrap.Toast.getOrCreateInstance(tostada)
	    	toastBootstrap.show()
        	</script>
 </c:if>
        
</body>

</html>
