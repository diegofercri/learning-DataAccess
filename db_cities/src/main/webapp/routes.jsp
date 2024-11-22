<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
		<!doctype html>
		<html lang="en">

		<head>
			<title>${city.name} Routes</title>
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
					<h1>${city.name} Routes</h1>
				</div>
			</header>
			<main>
				<div class="menu-container">
					<a href="Controller?op=start" class="menu-button">
						Cities
					</a>
					<form action="Controller?op=sendCityWithRoutes" method="post">
						<select class="form-select" name="cityWithRoutes" onchange="this.form.submit()">
							<option selected disabled>Filter routes</option>
							<c:forEach items="${citiesListWithRoutes}" var="cityWithRoutes">
								<option value="${cityWithRoutes.id}">${cityWithRoutes.name}</option>
							</c:forEach>
						</select>
					</form>
				</div>
				<div class="card-container">
					<c:forEach items="${routesList}" var="route">
						<div class="card-image">
							<div class="stars-container">
                    			<c:forEach begin="1" end="${route.rating}">
                        			<img src="./assets/star.svg" alt="Yellow Star Icon">
                        		</c:forEach>
							</div>
							<div class="card-image-container">
								<img src="${route.image}" alt="${route.name} image">
							</div>
							<div>
								<h5 class="card-image-title">${route.name}</h5>
								<p class="card-image-description">${route.description}</p>
							</div>
							<div class="card-image-container-bottom">
								<div class="rating-container">
									<a href="Controller?op=rating&rating=1&rutaid=${ruta.id}">
										<img src="./assets/star-b.svg" alt="Black Star Icon" class="rating-star" data-value="1">
									</a>
									<a href="Controller?op=rating&rating=2&rutaid=${ruta.id}">
										<img src="./assets/star-b.svg" alt="Black Star Icon" class="rating-star" data-value="2">
									</a>
									<a href="Controller?op=rating&rating=3&rutaid=${ruta.id}">
										<img src="./assets/star-b.svg" alt="Black Star Icon" class="rating-star" data-value="3">
									</a>
									<a href="Controller?op=rating&rating=4&rutaid=${ruta.id}">
										<img src="./assets/star-b.svg" alt="Black Star Icon" class="rating-star" data-value="4">
									</a>
									<a href="Controller?op=rating&rating=5&rutaid=${ruta.id}">
										<img src="./assets/star-b.svg" alt="Black Star Icon" class="rating-star" data-value="5">
									</a>
								</div>
								<a href="${city.link}" class="card-button">
									Show More
								</a>
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
			<script src="js/rating.js"></script>
		</body>

		</html>