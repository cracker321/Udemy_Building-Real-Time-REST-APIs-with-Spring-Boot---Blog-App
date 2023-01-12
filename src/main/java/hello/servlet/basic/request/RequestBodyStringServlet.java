package hello.servlet.basic.request;
import org.springframework.util.StreamUtils;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;



@WebServlet(name = "requestBodyStringServlet", urlPatterns = "/request-body-string")
//'포스트맨'에서 '입력 URL: http://localhost:8080/request-body-string'으로 테스트해보면 된다


//'클라이언트 <----> 서버' 간 'HTTP 통신할 때', 아래의 이 복잡하고 귀찮은 과정들을, 이렇게 코드 작성하지 않아도
// 이후에 '스프링MVC'가 'HTTP 통신 과정에서의 귀찮은 처리과정들'을 다~~~ 대신 해준다!


public class RequestBodyStringServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        System.out.println("messageBody = " + messageBody);
        response.getWriter().write("okidoki");

    }
}