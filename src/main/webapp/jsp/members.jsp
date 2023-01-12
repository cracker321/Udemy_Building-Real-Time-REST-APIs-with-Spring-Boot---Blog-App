<%@ page import="java.util.List" %>
<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<%
    //JSP 작성할 때에는, 아래에 '자바 로직'을 먼저 넣고, 그 저~ 아래에 'html 코드'를 넣는 것이다
    MemberRepository memberRepository = MemberRepository.getInstance();

    List<Member> members = memberRepository.findAll();
%>



<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<a href="/index.html">메인</a>
<table>
    <thead>
    <th>id</th>
    <th>username</th>
    <th>age</th>
    <tbody>

<%--    아래 코드 에러남.. 원래는 작동되어야 하는 코드임--%>
<%--    <%--%>
<%--        for (Member member : members) {--%>
<%--            out.write(" <tr>");--%>
<%--            out.write(" <td>" + member.getId() + "</td>");--%>
<%--            out.write(" <td>" + member.getUsername() + "</td>");--%>
<%--            out.write(" <td>" + member.getAge() + "</td>");--%>
<%--            out.write(" </tr>");--%>
<%--        }--%>
<%--    %>--%>

    </tbody>
</table>
</body>
</html>
