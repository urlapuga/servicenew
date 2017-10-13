<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="input" uri="http://www.springframework.org/tags/form" %>

<table>
    <c:forEach items="${messages}" var="message">
        <tr bgcolor="#adff2f">
            <td>
                    ${message.timecreated}
                <a href="#" onclick="setgetter(${message.fromuser})">(${employeenames[String.valueOf(message.fromuser)]})></a>
                <a href="#" onclick="setgetter(${message.touser})">(${employeenames[String.valueOf(message.touser)]})></a>

            </td>
        <tr>
            <td>
                    ${message.text}
            </td>
        </tr>
        </td>

        </tr>
    </c:forEach>
    <tr>
        <td><input type="text" value="0" name="getter" id="getter" hidden>
            <input type="text" value="${room}" name="room" id="room" hidden>
            <input type="text" name="mess" id="mess">
            <input type="button" value="Отправить" onclick="send()"></td>
    </tr>

</table>