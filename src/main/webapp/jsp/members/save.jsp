<%@ page import="hello.servlet.domain.member.MemberRepository" %>
<%@ page import="hello.servlet.domain.member.Member" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%

    //JSP 작성할 때에는, 아래에 '비즈니스 로직(자바 로직)'을 먼저 넣고,  저~ 아래에 'html 코드'를 넣는 것이다
    //즉, 이 공간에는 자바 코드를 작성하는 것
    //request, response 사용 가능

    //< '서블릿'으로 개발할 때의 한계 >
    //- '뷰 화면'을 위한 'HTML을 만드는 작업'이 '비즈니스 로직(자바 코드)'에 섞여 있어서, 지저분하고 복잡해짐
    //- JSP를 사용한 덕분에 '뷰를 생성하는 HTML작업'을 JSP가 깔끔하게 가져가고, '서블릿'은 중간중간 동적으로 변경이 필요한 부분에만
    //  자바 코드를 적용했다. 그런데, 이렇게 해도 해결되지 않는 몇 가지 고민이 남는다.


    //< 'JSP'로 개발할 때의 한계 >
    //- JSP 화면에서 상위 절반은 회원을 저장하기 위한 '비즈니스 로직'이고, 나머지 하위 절반만 '뷰를 보여주기 위한 HTML 코드 영역'임.
    //  이렇게 하나의 JSP 화면에 '자바 코드', 'DB속 데이터를 CRUD하는 레퍼지토리' 등등 다양한 코드들이 모두 하나의 JSP 화면에
    //  담겨있음.
    //  즉, JSP가 너무 많은 역할을 함. 이렇게 작은 프로젝트도 벌써 머리가 아파오는데, 수백 수천 줄이 넘어가는 JSP를 떠올려보면
    //  정말 너무 복잡해질 것임.
    //  만약, 그 중 어떤 코드 하나를 수정(유지보수)해야 한다면, 그와 연관되어 있는 수많은 다른 코드들도 다 같이 수정해야 하는데,
    //  이런 유지보수의 비효율성이 발생함.


       MemberRepository memberRepository = MemberRepository.getInstance();
        System.out.println("save.jsp");
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age);
        System.out.println("member = " + member);

        memberRepository.save(member);

%>

<%--'뷰'를 'html'로 보여주기 위한 'html 코드' 영역. --%>

<html>
<head>
    <meta charset="UTF-8">
</head>
<body>
성공
<ul>
    <li>id=<%=member.getId()%></li>
    <li>username=<%=member.getUsername()%></li>
    <li>age=<%=member.getAge()%></li>
</ul>
<a href="/index.html">메인</a>
</body>
</html>
