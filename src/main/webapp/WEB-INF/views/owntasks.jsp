<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<script>

</script>

<div style="float: right;
        background-color: aliceblue;">
    <div id="taskcloser" onclick="showTasks()"></div>
    <div id="owntaskscontainer">

        <div id="taskdate"><input type="datetime-local" id="dateTaskTo"/>
            <input type="button" value="Показать" onclick="showTasksByDate()">
        </div>
        <table border="1">
            <c:forEach items="${owntasks}" var="task">
                <tr>
                    <td>
                            ${task.dateto.toString().split(" ")[0]}:
                            ${task.dateto.toString().split(" ")[1].split(":")[0]}:
                            ${task.dateto.toString().split(" ")[1].split(":")[1]}
                    </td>

                    <td>
                        <a href="task-edit-${task.id}" target="_blank">
                                ${task.text}
                        </a>
                    </td>
                    <td>
                        <c:if test = "${task.status == 0}">
                            <input type="button" value="Приступить" onclick="startTask(${task.id})"/>
                        </c:if>
                        <c:if test = "${task.status == 1}">
                            <input type="button" value="Завершить" onclick="closeTask(${task.id})"/>
                        </c:if>

                    </td>
                </tr>
            </c:forEach>
        </table>


        <div id="taskaddform">

                <table>
                    <tr>
                        <td>
                            <select id="tasktype">
                                <c:forEach items="${tasktypes}" var="tasktypes">
                                    <option value="${tasktypes.id}">${tasktypes.name}</option>
                                </c:forEach>
                            </select>
                        </td>

                        <td>
                            <input type="text" id="datepicker1"/>
                        </td>
                    </tr>

                    <tr>

                        <td>
                            Текст
                        </td>
                        <td>
                            <input type="text" id="subscriberid">
                        </td>
                    </tr>

                    <tr>
                        <td colspan="2">
                            <input type="text" id="text" style="width:100%"/>
                        </td>
                    </tr>

                    <tr>
                        <td colspan="2">
                            <input type="button" value="Создать" onclick="createowntask()"/>
                        </td>
                    </tr>

                </table>
        </div>


    </div>


</div>

