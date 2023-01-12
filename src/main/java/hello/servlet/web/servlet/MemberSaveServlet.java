package hello.servlet.web.servlet;


import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "memberSaveServlet", urlPatterns = "/servlet/members/save")
public class MemberSaveServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();



    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {


        System.out.println("MemberSaveServlet.service");

        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age);
        System.out.println("member = " + member);

        memberRepository.save(member);
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        PrintWriter w = response.getWriter(); //'내장 메소드 getWriter'를 호출함으로써, 이제 아래에 내용을 쭉 써내려갈 수 있음


        //서블릿으로 개발하면 이렇게 '뷰 화면'을 위한 'HTML 코드 작업'이 이처럼 하나의 화면에서 '비즈니스 로직(자바 코드)'과
        //섞여서 작성해야 한다! 지저분하고 복잡하다!

        //'파일 hello-form.html'의 내부 코드들을 자바 형태로 아래에 작성한 것임
        //'스프링'이 아닌 '서블릿'으로 하면 이렇게 아래에 자바 코드로 일일히 다 작성해줘야 해서 굉장히 불편함
        w.write("<html>\n" +
                "<head>\n" +
                " <meta charset=\"UTF-8\">\n" +
                "</head>\n" +
                "<body>\n" +
                "성공\n" +
                "<ul>\n" +
                " <li>id="+member.getId()+"</li>\n" +
                " <li>username="+member.getUsername()+"</li>\n" +

                " <li>age="+member.getAge()+"</li>\n" +
                "</ul>\n" +
                "<a href=\"/index.html\">메인</a>\n" +
                "</body>\n" +
                "</html>");


    }

}
