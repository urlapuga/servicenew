<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

    <style>
        #chatcontainer {
            width: 900px; /* Ширина макета */
        }

        #nav {
            width: 200px; /* Ширина левой колонки */
            float: left;
        }

        #aside {
            width: 20px; /* Ширина правой колонки */
            height: 100%;
            background-color: #cccccc;
            float: left;
        }

        #chatcontent {
            float: left;
        }
    </style>

    <div id="chatcontainer">
        <div id="nav">

            <table>
                <tr>
                    <th>Комнаты</th>
                </tr>
                <c:forEach items="${rooms}" var="room">
                    <tr>
                        <td>
                            <a href="#" onclick="showRoom(${room.id});return false">
                                    ${room.name}
                            </a>
                        </td>
                    </tr>
                </c:forEach>

                <c:forEach items="${employeenames}" var="user">
                    <tr>
                        <td>
                            <a href="#" onclick="showUser(${user.key});return false">
                                    ${user.value}
                            </a>
                        </td>
                    </tr>
                </c:forEach>


            </table>

        </div>
        <div id="chatcontent"></div>
        <div id="aside" onclick="showChat()"></div>
    </div>