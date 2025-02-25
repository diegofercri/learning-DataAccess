<%-- 
    Document   : movies
    Created on : 04-feb-2025, 20:54:26
    Author     : pacopulido
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h2 class="text-center text-success">${person.nombre}</h2>
    <div class="row justify-content-center px-3">
        <c:forEach items="${person.movieList}" var="movie">
        <div class="col-12">
            <div class="card p-2 h-100">
                <div class="row">
                    <div class="col-4">
                        <img width="100" src="https://image.tmdb.org/t/p/w500${movie.poster}" class="img-fluid" alt="">
                    </div>
                    <div class="col-8">
                        <h4 class="card-title">${movie.titulo}</h4>
                        <h5 class="card-text">${movie.fecha}</h5>
                    </div>
                </div>
            </div>
        </div>
        </c:forEach>
    </div>
