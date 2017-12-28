<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


    <div id="chatcontainer" style="background-color: aliceblue;">
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