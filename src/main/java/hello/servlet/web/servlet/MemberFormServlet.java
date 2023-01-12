package hello.servlet.web.servlet;

import hello.servlet.domain.member.MemberRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet(name = "memberFormServlet", urlPatterns = "/servlet/members/new-form")
//- '포스트맨'에서 '입력 URL: http://localhost:8080/servlet/members/new-form'로 테스트해보면 된다
//- 위 링크를 그냥 주소창에 입력하면, 아래 작성한 'html 코드들'이 화면에 출력된다!


public class MemberFormServlet extends HttpServlet {


    private MemberRepository memberRepository = MemberRepository.getInstance();


    //이제 여기 '메소드 service'의 내부에 로직을 짜는 것임
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");

        PrintWriter w = response.getWriter(); //'내장 메소드 getWriter'를 호출함으로써, 이제 아래에 내용을 쭉 써내려갈 수 있음

        //'파일 hello-form.html'의 내부 코드들을 자바 형태로 아래에 작성한 것임
        //'스프링'이 아닌 '서블릿'으로 하면 이렇게 아래에 자바 코드로 일일히 다 작성해줘야 해서 굉장히 불편함
        w.write("<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                " <meta charset=\"UTF-8\">\n" +
                " <title>Title</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<form action=\"/servlet/members/save\" method=\"post\">\n" +
                " username: <input type=\"text\" name=\"username\" />\n" +
                " age: <input type=\"text\" name=\"age\" />\n" +
                " <button type=\"submit\">전송</button>\n" +
                "</form>\n" +
                "</body>\n" +
                "</html>\n");

    }

}
