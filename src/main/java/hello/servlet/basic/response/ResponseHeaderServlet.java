package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;




@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
// [ 'HTTP 응답 데이터 - 단순 텍스트, HTML'강 ]
//- '포스트맨'에서 '입력 URL: http://localhost:8080/response-header'로 테스트해보면 된다

public class ResponseHeaderServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //'클라이언트 <----> 서버' 간 'HTTP 통신할 때', 아래의 이 복잡하고 귀찮은 과정들을, 이렇게 코드 작성하지 않아도
        // 이후에 '스프링MVC'가 'HTTP 통신 과정에서의 귀찮은 처리과정들'을 다~~~ 대신 해준다!


        //< HTTP 응답 시작줄 status-line >
        response.setStatus(HttpServletResponse.SC_OK); //200


        //< HTTP 응답 헤더 response-headers >
        response.setHeader("Content-Type", "text/plain;charset=utf-8");
        response.setHeader("Cache-Control", "no-cache, no-store,mustrevalidate");
        response.setHeader("Pragma", "no-cache");
        response.setHeader("my-header", "hello");


        //< HTTP 응답 헤더의 편의 메소드 >
//        content(response);
//        cookie(response);
//        redirect(response);


        PrintWriter writer = response.getWriter();
        writer.println("ok");
    }
}
