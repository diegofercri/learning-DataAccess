<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <!DOCTYPE html>
        <html lang="en">

        <head>
            <title>Tourism in Castilla-La Mancha</title>
            <!-- Required meta tags -->
            <meta charset="utf-8" />
            <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />

            <!-- CSS -->
            <link rel="stylesheet" href="css/style.css" />

            <!-- Font Share -->
            <link href="https://api.fontshare.com/v2/css?f[]=outfit@1&display=swap" rel="stylesheet">
        </head>

        <body>
            <header>
                <div>
                    <h1>Tourism in Castilla-La Mancha</h1>
                </div>
            </header>
            <main>
                <div class="menu-container">
                    <a href="Controller?op=start" class="menu-button">
                        Home
                    </a>
                    <c:choose>
						<c:when test="${fav=='1'}">
		                    <a href="Controller?op=filterByFav" class="menu-button">
		                        Remove Filter by Favourites
		                    </a>
						</c:when>
						<c:otherwise>
		                    <a href="Controller?op=filterByFav" class="menu-button">
		                        Filter by Favourites
		                    </a>
						</c:otherwise>
					</c:choose>
                </div>
                <div class="container-flex">
                    <div class="video-container">
                        <video src="./media/video.mp4" controls></video>
                    </div>
                </div>
                <h3>Filter by Provinces</h3>
                <div class="container-flex">
                    <div class="image-container">
                        <img src="./img/molinos.jpg" alt="Mills image">
                    </div>
                    <div class="list-container">
                    	<c:forEach items="${provincesList}" var="province">
	                        <a href="Controller?op=filterByProvince&province=${province.id}" class="list-button">
	                            ${province.name}
	                        </a>
                    	</c:forEach>
                    </div>
                </div>
                <h3>Filter by Categories</h3>
                <div class="card-container">
                    <c:forEach items="${categoriesList}" var="category">
                        <div class="card-image card-filter">
                            <div>
                                <h5 class="card-image-title">${category.name}</h5>
                            </div>
                            <div class="card-image-container">
                                <img src="${category.image}" alt="${category.name} image">
                            </div>
                            <div class="card-image-container-bottom">
                                <a href="Controller?op=filterByCategory&category=${category.id}" class="card-button">
                                    Filter
                                </a>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <h3>Results</h3>
                <div class="card-container">
                    <c:forEach items="${placesList}" var="place">
                        <div class="card-image card-result">
                            <div class="card-image-container">
                                <img src="${place.image}" alt="${place.name} image">
                                <div class="card-image-fav-container">
                                    <c:choose>
                                        <c:when test="${place.fav==0}">
                                            <a href="Controller?op=changefav&placeid=${place.id}&newfav=1">
                                                <div class="fav-icon-container-b">
                                                    <img src="./assets/heart-b.svg" alt="Filled Heart Icon" class="fav-icon">
                                                </div>
                                            </a>
                                        </c:when>
                                        <c:otherwise>
                                            <a href="Controller?op=changefav&placeid=${place.id}&newfav=0">
                                                <div class="fav-icon-container">
                                                    <img src="./assets/heart.svg" alt="Empty Heart Icon" class="fav-icon">
                                                </div>
                                            </a>
                                        </c:otherwise>
                                    </c:choose>
                                </div>
                            </div>
                            <div>
                                <h5 class="card-image-title">${place.name}</h5>
                            </div>
                        </div>
                    </c:forEach>
                </div>
            </main>
            <footer>
                <a href="https://github.com/diegofercri">
                    <div class="card">
                        <h5 class="card-content">
                            <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24"
                                fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round"
                                stroke-linejoin="round" class="lucide lucide-github">
                                <path
                                    d="M15 22v-4a4.8 4.8 0 0 0-1-3.5c3 0 6-2 6-5.5.08-1.25-.27-2.48-1-3.5.28-1.15.28-2.35 0-3.5 0 0-1 0-3 1.5-2.64-.5-5.36-.5-8 0C6 2 5 2 5 2c-.3 1.15-.3 2.35 0 3.5A5.403 5.403 0 0 0 4 9c0 3.5 3 5.5 6 5.5-.39.49-.68 1.05-.85 1.65-.17.6-.22 1.23-.15 1.85v4" />
                                <path d="M9 18c-4.51 2-5-2-7-2" />
                            </svg>
                            diegofercri
                        </h5>
                    </div>
                </a>
            </footer>
        </body>

        </html>