<center>
    Открыть карточку абонента</br>
    Договор : <input type="text" id="abonentid" name="abonentid">
    <input type="button" value="Открыть" onclick="showAbonent()">
    <div id="pinger">
        <jsp:include page="/pinger"/>
    </div>
    задачи отдела
    <div id="alltasks">
        <jsp:include page="table-tasks.jsp"/>
    </div>


</center>