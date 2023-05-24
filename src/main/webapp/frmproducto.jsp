<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>
            <c:if test="${productos.id == 0}">
                NUEVO REGISTRO
            </c:if>
            <c:if test="${productos.id != 0}">
                EDITAR REGISTRO
            </c:if>
        </h1>

        <form action="Inicio" method="post">
            <input type="hidden" name="id" value="${productos.id}">
            <table >
                <thead>
                    <tr>
                        <th>DESCRIPCION</th>
                        <th><input type="type" name="descripcion" value="${productos.descripcion}"></th>
                    </tr>
                </thead>

                <thead>
                    <tr>
                        <th>CANTIDAD</th>
                        <th><input type="type" name="cantidad" value="${productos.cantidad}"></th>
                    </tr>
                </thead>

                <thead>
                    <tr>
                        <th>PRECIO</th>
                        <th><input type="type" name="precio" value="${productos.precio}"></th>
                    </tr>
                </thead>

                <thead>
                    <tr>
                        <th>CATEGORIA</th>
                        <th><input type="type" name="categoria" value="${productos.categoria}"></th>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" name="name"></td>
                    </tr>
                </thead>

            </table>


        </form>
    </body>
</html>
