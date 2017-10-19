<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<ul>
    <c:forEach items="${menu}" var="menuitem">
        <li>
            <a href="#${menuitem.value}">${menuitem.key}</a>
        </li>
    </c:forEach>
</ul>