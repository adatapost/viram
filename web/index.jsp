<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="title" value="Home"/>
<%@include file="templates/header.jsp" %>
<div class="">
        <h2 class="text-success text-justify">What is a co-operative society ?</h2>
            <ul>
                <li>
                <p>A co-operative society is an autonomous association of persons united voluntarily to meet their common economic, social and cultural needs and aspirations through a jointly-owned and democratically-controlled enterprise.</p>
                </li>
                <li>
                <p>A co-operative society is another means for forming a legal entity to conduct business besides forming a company. It pools together human resources in the spirit of self and mutual help with the object of providing services and support to members.</p>
                </li>
                <li>The Co-operative Principles under which a co-operative society operates and carries out its business are :-
                <ol>
                    <li>Voluntary and open membership. </li>
                    <li>Democratic control, one member one vote. </li>
                    <li>Autonomy and independence. </li>
                    <li>Promoting economic activities. </li>
                    <li>Promoting education and information technology. </li>
                    <li>Co-operation among co-operatives. </li>
                    <li>Concern for the social and ecological environment. </li>
                </ol>
                </li>
            </ul>
        <pre><%=in.credit.U.hashPassword("admin")%></pre>
</div>


<%@include file="templates/footer.jsp" %>