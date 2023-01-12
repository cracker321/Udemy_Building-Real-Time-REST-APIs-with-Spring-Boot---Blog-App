package hello.servlet.basic.response;

import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * http://localhost:8080/response-json
 *
 */
@WebServlet(name = "responseJsonServlet", urlPatterns = "/response-json")
// [ 'HTTP 응답 데이터 - API JSON'강 ]
//- '포스트맨'에서 '입력 URL: http://localhost:8080/response-json'으로 테스트해보면 된다


//'클라이언트 <----> 서버' 간 'HTTP 통신할 때', 아래의 이 복잡하고 귀찮은 과정들을, 이렇게 코드 작성하지 않아도
// 이후에 '스프링MVC'가 'HTTP 통신 과정에서의 귀찮은 처리과정들'을 다~~~ 대신 해준다!

public class ResponseJsonServlet extends HttpServlet {
    private ObjectMapper objectMapper = new ObjectMapper();


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        //< 'HTTP 응답 헤더의 Content-Type('HTTP 응답 바디의 데이터'가 '어떤 형식'인지 말해주는 부분: application/json >
        response.setHeader("content-type", "application/json");
        response.setCharacterEncoding("utf-8");
        HelloData data = new HelloData();
        data.setUsername("kim");
        data.setAge(20);


        //< 'HTTP 응답 바디': {"username":"kim","age":20} >
        //주소창에 http://localhost:8080/response-json 을 입력하면, 위 json 응답 객체 내용이 조회된다.
        String result = objectMapper.writeValueAsString(data);
        response.getWriter().write(result);
    }
}
