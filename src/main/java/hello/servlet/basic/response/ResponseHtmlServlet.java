package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;



@WebServlet(name = "responseHtmlServlet", urlPatterns = "/response-html")
// [ 'HTTP 응답 데이터 - 단순 텍스트, HTML'강 ]
//- '포스트맨'에서 '입력 URL: http://localhost:8080/response-html'로 테스트해보면 된다

//'클라이언트 <----> 서버' 간 'HTTP 통신할 때', 아래의 이 복잡하고 귀찮은 과정들을, 이렇게 코드 작성하지 않아도
// 이후에 '스프링MVC'가 'HTTP 통신 과정에서의 귀찮은 처리과정들'을 다~~~ 대신 해준다!

public class ResponseHtmlServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse
            response)
            throws ServletException, IOException {
//Content-Type: text/html;charset=utf-8
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<body>");
        writer.println(" <div>안녕?</div>");
        writer.println("</body>");
        writer.println("</html>");
    }
}