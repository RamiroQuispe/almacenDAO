<%@page import="java.util.List"%>
<%@page import="com.emergentes.modelo.DProducto"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    List<DProducto> productos = (List<DProducto>) request.getAttribute("productos");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p >SEGUNDO PARCIAL TEM-742 <br> Nombre: Ramiro Vladimir Quispe Cutipa <br> Carnet: 9910852 </p>

        <h1>--GESTION DE PRODUCTOS--</h1>
        <a href="Inicio?action=add">Nuevo Producto</a>

        <table border="1">
            <tr>
                <th>Id</th>
                <th>Descripcion</th>
                <th>Cantidad</th>
                <th>Precio</th>
                <th>Categoria</th>
                <th></th>
                <th></th>
            </tr>
            <c:forEach var="item" items="${productos}">

                <tr>
                    <td>${item.id}</td>
                    <td>${item.descripcion}</td>
                    <td>${item.cantidad}</td>
                    <td>${item.precio}</td>
                    <td>${item.categoria}</td>
                    <td><a href="Inicio?action=edit&id=${item.id}">EDITAR</a></td>
                    <td><a href="Inicio?action=delete&id=${item.id}" onclick="return(confirm('Esta deguro de Eliminar '))">ELIMINAR</a></td>
                </tr>
            </c:forEach>
        </table>
    </body>
</html>
