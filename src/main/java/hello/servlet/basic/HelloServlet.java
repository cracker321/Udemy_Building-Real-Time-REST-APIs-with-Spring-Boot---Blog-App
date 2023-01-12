package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {


    //'서버를 실행'하면, '웹WAS'가 'HttpServletRequest 객체'와 'HttpServletResponse 객체'를 만들어서 '서버로 던져줌'
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.service(request, response);

        System.out.println("HelloServlet.service"); //'단축키 soutm'
        System.out.println("request = " + request); //'단축키 soutv'
        System.out.println("response = " + response); //'단축키 soutv'



        //< 'Request 객체'를 사용하여, '클라이언트가 보내온 URL 속의 쿼리파라미터'를 조회하기 >
        String username = request.getParameter("username"); //- 'Request 객체 속의 메소드 getParameter'를 통해서,
        //개발자는 서블릿 덕에 이렇게 편리하게 'URI속의 쿼리파라미터'를
        //   쉽게 조회할 수 있게 됐다.
        //- 'localhost:8080/hello?username=kim'
        //  여기서의 '쿼리파라미터'는 'username=kim' 이다!
        System.out.println("username= " + username);


        //< 'Response 객체'에 데이터를 담기 >
        response.setContentType("text/plain");
        response.setCharacterEncoding("utf-8");
        response.getWriter().write("hello"); //'HTTP 응답 바디'에 들어갈 데이터로 'hello'를 입력

    }
}
