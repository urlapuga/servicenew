<%@ page language="java" contentType="text/html; charset=Cp1251" pageEncoding="Cp1251" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
    #taskcloser {
        width: 20px; /* Ширина правой колонки */
        height: 100%;
        background-color: #cccccc;
        float: right;
    }
    #owntaskscontainer{
        width:250px;
        float: right;
    }
</style>
<div>
    <div id="owntaskscontainer">
        <table>
            <c:forEach items="${owntasks}" var="task">
                <tr>
                    <td>
                        <a href="task-edit-${task.id}" target="_blank">
                                ${task.text}
                        </a>
                    </td>
                    <td>
                            ${task.dateto}
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div id="taskcloser" onclick="showTasks()"></div>
</div>