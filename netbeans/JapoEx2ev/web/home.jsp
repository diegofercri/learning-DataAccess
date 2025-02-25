<%-- 
    Document   : home.jsp
    Created on : Feb 25, 2025, 9:38:17 AM
    Author     : diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="es">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Página de Restaurante</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
    <style>
        .navbar-brand img {
            height: 40px;
        }

        .hero-slider img {
            width: 100%;
            height: auto;
        }

        .filter-buttons button {
            margin-bottom: 10px;
        }

        .card-horizontal {
            display: flex;
            align-items: center;
        }

        .card-horizontal img {
            width: 100px;
            height: 100px;
            object-fit: cover;
            margin-right: 15px;
        }

        .allergens img {
            width: 20px;
            height: 20px;
            margin-right: 5px;
        }
    </style>
</head>

<body>

    <!-- Navbar -->
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">
                <img src="./img/logo.jpg" alt="Logo">
            </a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item">
                        <a class="nav-link" href="#"><i class="bi bi-cart-fill"></i> Carrito</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Hero Section -->
    <section class="hero-slider">
        <div id="carouselExampleIndicators" class="carousel slide" data-bs-ride="carousel">
            <div class="carousel-indicators">
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active"
                    aria-current="true" aria-label="Slide 1"></button>
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1"
                    aria-label="Slide 2"></button>
                <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2"
                    aria-label="Slide 3"></button>
            </div>
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="./img/slide1.jpg" class="d-block w-100" alt="Slide 1">
                </div>
                <div class="carousel-item">
                    <img src="./img/slide2.jpg" class="d-block w-100" alt="Slide 2">
                </div>
                <div class="carousel-item">
                    <img src="./img/slide3.jpg" class="d-block w-100" alt="Slide 3">
                </div>
            </div>
            <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators"
                data-bs-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Previous</span>
            </button>
            <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators"
                data-bs-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="visually-hidden">Next</span>
            </button>
        </div>
    </section>

    <!-- Cards Allergens Section -->
    <section class="container my-5">
        <div class="row">
            <c:forEach items="${alergenos}" var="alergeno">
                <div class="col-xl-2 col-sm-4 mb-4 d-flex justify-content-center align-items-center">
                    <div class="card text-center align-items-center" style="width: 15rem;">
                        <img src="${alergeno.foto}" alt="${alergeno.nombre}" class="mt-4" style="height: 50px; width: 50px;">
                        <div class="card-body">
                            <p class="card-text text-uppercase fw-bold">${alergeno.nombre}</p>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </section>

    <!-- Filter and Cards Section -->
    <section class="container my-5">
        <div class="row">
            <div class="col-md-3">
                <div class="filter-buttons">
                    <button class="btn btn-outline-secondary w-100 mb-2">Filtro 1</button>
                    <button class="btn btn-outline-secondary w-100 mb-2">Filtro 2</button>
                    <button class="btn btn-outline-secondary w-100 mb-2">Filtro 3</button>
                    <button class="btn btn-outline-secondary w-100 mb-2">Filtro 4</button>
                </div>
            </div>
            <div class="col-md-9">
                <div class="card mb-3" style="max-width: 540px;">
                    <div class="row g-0">
                        <div class="col-md-4">
                            <img src="./img/plato.png" class="img-fluid rounded-start h-100" alt="Card title" />
                        </div>
                        <div class="col-md-8">
                            <div class="card-body">
                                <h5 class="card-title">Card title</h5>
                                <div class="allergens mb-2">
                                    <img src="./img/alergeno.jpg" alt="Alergeno 1">
                                    <img src="./img/alergeno.jpg" alt="Alergeno 2">
                                </div>
                                <p class="card-text"><strong>Precio:</strong> $10.99</p>
                                <button class="btn btn-primary"><i class="bi bi-cart-plus"></i> Añadir al
                                    carrito</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="card mb-3" style="max-width: 540px;">
                    <div class="row g-0">
                        <div class="col-md-4">
                            <img src="./img/plato.png" class="img-fluid rounded-start h-100" alt="Card title" />
                        </div>
                        <div class="col-md-8">
                            <div class="card-body">
                                <h5 class="card-title">Card title</h5>
                                <div class="allergens mb-2">
                                    <img src="./img/alergeno.jpg" alt="Alergeno 1">
                                    <img src="./img/alergeno.jpg" alt="Alergeno 2">
                                </div>
                                <p class="card-text"><strong>Precio:</strong> $10.99</p>
                                <button class="btn btn-primary"><i class="bi bi-cart-plus"></i> Añadir al
                                    carrito</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="card mb-3" style="max-width: 540px;">
                    <div class="row g-0">
                        <div class="col-md-4">
                            <img src="./img/plato.png" class="img-fluid rounded-start h-100" alt="Card title" />
                        </div>
                        <div class="col-md-8">
                            <div class="card-body">
                                <h5 class="card-title">Card title</h5>
                                <div class="allergens mb-2">
                                    <img src="./img/alergeno.jpg" alt="Alergeno 1">
                                    <img src="./img/alergeno.jpg" alt="Alergeno 2">
                                </div>
                                <p class="card-text"><strong>Precio:</strong> $10.99</p>
                                <button class="btn btn-primary"><i class="bi bi-cart-plus"></i> Añadir al
                                    carrito</button>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="card mb-3" style="max-width: 540px;">
                    <div class="row g-0">
                        <div class="col-md-4">
                            <img src="./img/plato.png" class="img-fluid rounded-start h-100" alt="Card title" />
                        </div>
                        <div class="col-md-8">
                            <div class="card-body">
                                <h5 class="card-title">Card title</h5>
                                <div class="allergens mb-2">
                                    <img src="./img/alergeno.jpg" alt="Alergeno 1">
                                    <img src="./img/alergeno.jpg" alt="Alergeno 2">
                                </div>
                                <p class="card-text"><strong>Precio:</strong> $10.99</p>
                                <button class="btn btn-primary"><i class="bi bi-cart-plus"></i> Añadir al
                                    carrito</button>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>

</html>
