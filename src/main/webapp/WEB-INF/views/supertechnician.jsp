<center>
    ������� �������� ��������</br>
    ������� : <input type="text" id="abonentid" name="abonentid">
    <input type="button" value="�������" onclick="showAbonent()">
    <div id="pinger">
        <jsp:include page="/pinger"/>
    </div>
    ������ ������
    <div id="alltasks">
        <jsp:include page="table-tasks.jsp"/>
    </div>


</center>