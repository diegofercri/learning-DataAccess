<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
    <head>
        <title>Foster's Hollywood</title>
        <!-- Required meta tags -->
        <meta charset="utf-8" />
        <meta
            name="viewport"
            content="width=device-width, initial-scale=1, shrink-to-fit=no"
        />

        <!-- Bootstrap CSS v5.2.1 -->
        <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
            crossorigin="anonymous"
        />
        <link rel="stylesheet" href="mycss.css">
    </head>

    <body>
        <header>
           <div class="colorcabecera p-2">
                <img src="img/logo.png" alt="">      
           </div>
        </header>
        <main>
            <section>
                <div id="carouselId" class="carousel slide" data-bs-ride="carousel">
                    <ol class="carousel-indicators list-unstyled">
                        <li
                            data-bs-target="#carouselId"
                            data-bs-slide-to="0"
                            class="active"
                            aria-current="true"
                            aria-label="First slide"
                        ></li>
                        <li
                            data-bs-target="#carouselId"
                            data-bs-slide-to="1"
                            aria-label="Second slide"
                        ></li>
                        <li
                            data-bs-target="#carouselId"
                            data-bs-slide-to="2"
                            aria-label="Third slide"
                        ></li>
                    </ol>
                    <div class="carousel-inner" role="listbox">
                        <div class="carousel-item active">
                            <img
                                src="img/slider1.png"
                                class="w-100 d-block"
                                alt="First slide"
                            />
                        </div>
                        <div class="carousel-item">
                            <img
                                src="img/slider2.png"
                                class="w-100 d-block"
                                alt="Second slide"
                            />
                        </div>
                        <div class="carousel-item">
                            <img
                                src="img/slider3.png"
                                class="w-100 d-block"
                                alt="Third slide"
                            />
                        </div>
                    </div>
                    <button
                        class="carousel-control-prev"
                        type="button"
                        data-bs-target="#carouselId"
                        data-bs-slide="prev"
                    >
                        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Previous</span>
                    </button>
                    <button
                        class="carousel-control-next"
                        type="button"
                        data-bs-target="#carouselId"
                        data-bs-slide="next"
                    >
                        <span class="carousel-control-next-icon" aria-hidden="true"></span>
                        <span class="visually-hidden">Next</span>
                    </button>
                </div>
            </section>
            <section>
                <h3 class="text-center pt-3 text-primary">${nombrecat }</h3>
                <div class="container shadow">
                    <div class="row justify-content-center">
                    	<c:forEach items="${productos}" var="plato">
	                        <div class="col-md-6 col-xl-4 my-3 d-flex">
	                            <div class="card flex-fill">
	                            	<a href="Controller?op=detail&idproducto=${plato.id }">
		                                <div class="row">
		                                    <div>
		                                        <img class="card-img-top" src="${plato.imagen }" alt="Title" />
		                                    </div>
		                                    <div>
		                                        <div class="card-body">
		                                            <h4 class="card-title text-center">${plato.titulo}</h4>
		                                        </div>
		                                    </div>
		                                </div>
	                                </a>
	                            </div>
	                        </div>
                        </c:forEach>
                    </div>
                </div>
            </section>
            
        </main>
        <footer>
            <div class="colorcabecera p-2">
                <h3 class="text-center text-white">Foster's Hollywood</h3>
            </div>
        </footer>
        <!-- Bootstrap JavaScript Libraries -->
        <script
            src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js"
            integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r"
            crossorigin="anonymous"
        ></script>

        <script
            src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"
            integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+"
            crossorigin="anonymous"
        ></script>
    </body>
</html>
    