<%-- 
    Document   : home.jsp
    Created on : Feb 25, 2025, 9:38:17 AM
    Author     : diego
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Japo Diego</title>
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
                width: 40px;
                height: 40px;
                margin-right: 5px;
            }
            .modal-body {
                max-height: 400px;
                overflow-y: auto;
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
                            <a class="nav-link" href="#" data-bs-toggle="modal" data-bs-target="#cartModal"><i class="bi bi-cart-fill"></i> Carrito</a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>

        <!-- Ventana modal del carrito -->
        <div class="modal fade" id="cartModal" tabindex="-1" aria-labelledby="cartModalLabel" aria-hidden="true">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="cartModalLabel">Carrito</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <!-- Lista de productos en el carrito -->
                        <c:choose>
                            <c:when test="${not empty carrito}">
                                <ul class="list-group">
                                    <c:forEach items="${carrito}" var="item">
                                        <li class="list-group-item d-flex justify-content-between align-items-center">
                                            ${item.nombre} - ${item.precio} €
                                        </li>
                                    </c:forEach>
                                </ul>
                            </c:when>
                            <c:otherwise>
                                <p>El carrito está vacío.</p>
                            </c:otherwise>
                        </c:choose>
                    </div>
                    <div class="modal-footer">
                        <form action="Controller" method="get" class="d-flex gap-3">
                            <input type="hidden" name="op" value="confirmOrder">
                            <select class="form-select" aria-label="Mesa" name="mesa" required>
                                <option selected disabled>Seleccionar mesa</option>
                                <option value="1">Mesa 1</option>
                                <option value="2">Mesa 2</option>
                                <option value="3">Mesa 3</option>
                            </select>
                            <button type="submit" class="btn btn-primary" style="width:300px;">Realizar Pedido</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>

        <!-- Modal
        <div class="modal fade" id="cartModal" tabindex="-1" aria-labelledby="cartModalLabel" aria-hidden="true">
            <div class="modal-dialog modal-lg">
                <div class="modal-content">
                    <div class="modal-header">
                        <h5 class="modal-title" id="cartModalLabel">Carrito</h5>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <div class="list-group">
                            <div class="list-group-item">
                                <div class="card-horizontal">
                                    <img src="./img/platos/producto1.jpg" alt="Producto 1" class="rounded">
                                    <div>
                                        <h6 class="mb-0">Producto 1</h6>
                                        <p class="text-muted mb-0">$10.00</p>
                                    </div>
                                </div>
                            </div>
                            <div class="list-group-item">
                                <div class="card-horizontal">
                                    <img src="./img/platos/producto2.jpg" alt="Producto 2" class="rounded">
                                    <div>
                                        <h6 class="mb-0">Producto 2</h6>
                                        <p class="text-muted mb-0">$15.00</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <select class="form-select me-2" aria-label="Mesa">
                            <option selected>Seleccionar mesa</option>
                            <option value="1">Mesa 1</option>
                            <option value="2">Mesa 2</option>
                            <option value="3">Mesa 3</option>
                        </select>
                        <button type="button" class="btn btn-primary">Realizar Pedido</button>
                    </div>
                </div>
            </div>
        </div>
        -->

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
                        <img src="./img/slides/slide1.jpg" class="d-block w-100" alt="Slide 1">
                    </div>
                    <div class="carousel-item">
                        <img src="./img/slides/slide2.jpg" class="d-block w-100" alt="Slide 2">
                    </div>
                    <div class="carousel-item">
                        <img src="./img/slides/slide3.jpg" class="d-block w-100" alt="Slide 3">
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
                        <!-- Tarjeta clicable -->
                        <div class="card text-center align-items-center clickable-card"
                             style="width: 15rem; cursor: pointer;"
                             onclick="location.href = 'Controller?op=filtroAlergeno&alergeno=${alergeno.id}'">
                            <img src="./img/alergenos/${alergeno.foto}" alt="${alergeno.nombre}" class="mt-4" style="height: 50px; width: 50px;">
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
                <div class="col-md-4">
                    <div class="filter-buttons">
                        <c:forEach items="${categorias}" var="categoria">
                            <button class="btn btn-outline-secondary w-100 mb-2">${categoria.nombre}</button>
                        </c:forEach>
                    </div>
                </div>
                <div class="col-md-8">
                    <c:choose>
                        <c:when test="${not empty platosFiltrados}">
                            <!-- Mostrar platos filtrados -->
                            <c:forEach items="${platosFiltrados}" var="plato">
                                <div class="card mb-3">
                                    <div class="row g-0">
                                        <div class="col-md-4">
                                            <img src="./img/platos/${plato.foto}" class="img-fluid rounded-start h-100" alt="${plato.nombre}" />
                                        </div>
                                        <div class="col-md-8">
                                            <div class="card-body h-100 d-flex flex-column justify-content-between">
                                                <h5 class="card-title h3">${plato.nombre}</h5>
                                                <div class="allergens mb-2">
                                                    <c:forEach items="${plato.alergenoList}" var="alergeno">
                                                        <img src="./img/alergenos/${alergeno.foto}" alt="${alergeno.nombre}" class="allergens">
                                                    </c:forEach>
                                                </div>
                                                <p class="card-text h4"><strong>${plato.precio} €</strong></p>
                                                <button class="btn btn-primary" onclick="addToCart(${plato.id})">
                                                    <i class="bi bi-cart-plus"></i> Añadir al carrito
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <!-- Mostrar todos los platos -->
                            <c:forEach items="${platos}" var="plato">
                                <div class="card mb-3">
                                    <div class="row g-0">
                                        <div class="col-md-4">
                                            <img src="./img/platos/${plato.foto}" class="img-fluid rounded-start h-100" alt="${plato.nombre}" />
                                        </div>
                                        <div class="col-md-8">
                                            <div class="card-body h-100 d-flex flex-column justify-content-between">
                                                <h5 class="card-title h3">${plato.nombre}</h5>
                                                <div class="allergens mb-2">
                                                    <c:forEach items="${plato.alergenoList}" var="alergeno">
                                                        <img src="./img/alergenos/${alergeno.foto}" alt="${alergeno.nombre}" class="allergens">
                                                    </c:forEach>
                                                </div>
                                                <p class="card-text h4"><strong>${plato.precio} €</strong></p>
                                                <button class="btn btn-primary" onclick="addToCart(${plato.id})">
                                                    <i class="bi bi-cart-plus"></i> Añadir al carrito
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </div>
            </div>
        </section>

        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>

        <script src="./my.js" type="text/javascript"></script>

    </body>
</html>