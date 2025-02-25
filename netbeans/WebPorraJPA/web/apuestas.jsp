<%-- 
    Document   : apuestas
    Created on : 20-ene-2025, 13:33:33
    Author     : diurno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:choose>
    <c:when test="${apuestas!=null}">
        <div class="table-responsive">
            <table
                class="table table-primary table-striped"
            >
                <thead>
                    <tr>
                        <th scope="col">Goles local</th>
                        <th scope="col">Goles visitante</th>
                        <th scope="col">Cuantas</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${apuestas}" var="apuesta">
                    <tr>
                        <td>${apuesta.golesl}</td>
                        <td>${apuesta.golesv}</td>
                        <td>${apuesta.cuantas}</td>
                    </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>

    </c:when>
    <c:otherwise>
        <h5 class="text-danger">Partido sin apuestas...</h5>
    </c:otherwise>
</c:choose>
