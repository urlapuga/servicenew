<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>


<script>
    window.onload = function() {
        console.logg(1);
        $(function () {
            $("#datepicker").datetimepicker();
        });

        $(function () {
            $("#datepicker1").datetimepicker();
        });
    }
</script>
<style>
    #taskcloser {
        width: 20px;
        height: 100%;
        background-color: #cccccc;
        float: right;
    }

    #owntaskscontainer {
        height:100%;
        position:relative;
        width: 350px;
        float: right;
    }

     #taskaddform{
         position: absolute;
         bottom: 0px;
     }

    #taskdate{
        vertical-align: top;
    }
</style>
<div>
    <div id="owntaskscontainer">

        <div id="taskdate"><input type="text" id="datepicker"/>
        </div>
        <table>
            <c:forEach items="${owntasks}" var="task">
                <tr>
                    <td>
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
    <div id="taskcloser" onclick="showTasks()"></div>
</div>

