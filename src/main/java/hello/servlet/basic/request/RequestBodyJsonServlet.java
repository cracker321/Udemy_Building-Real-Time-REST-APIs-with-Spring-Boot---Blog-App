package hello.servlet.basic.request;
import com.fasterxml.jackson.databind.ObjectMapper;
import hello.servlet.basic.HelloData;
import org.springframework.util.StreamUtils;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * http://localhost:8080/request-body-json
 *
 * JSON 형식 전송
 * content-type: application/json
 * message body: {"username": "hello", "age": 20}
 *
 */


@WebServlet(name = "requestBodyJsonServlet", urlPatterns = "/request-body-json")
// [ 'HTTP 요청 데이터 - API 메시지 바디 - JSON'강 ]
//- '포스트맨'에서 '입력 URL: http://localhost:8080/request-body-json'으로 테스트해보면 된다
//  그 전에, 이건 'POST'이기에, 'HTTP 요청 바디'에 아래 내용('HelloData 객체의 내부 필드들'을 입력하고 테스트해봐야 함
// {
//    "username": "hello",
//    "age": 20
// }

public class RequestBodyJsonServlet extends HttpServlet {

    private ObjectMapper objectMapper = new ObjectMapper(); //- JSON 통신으로 '클래스 HelloData'를 'HelloData 객체'로
                                                            //  변환시켜주는 것. '스프링 내장 Jackson 라이브러리'이다.
                                                            //- 이후, '서블릿' 이후 단계인 '스프링MVC'로 넘어가면 아래 로직들은
                                                            //  다 필요없어진다. '스프링MVC'가 알아서 해준다.


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        ServletInputStream inputStream = request.getInputStream();
        String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        System.out.println("messageBody = " + messageBody);


        HelloData helloData = objectMapper.readValue(messageBody, HelloData.class);
        System.out.println("helloData.username = " + helloData.getUsername());
        System.out.println("helloData.age = " + helloData.getAge());
        response.getWriter().write("json test: okay!");


    }
}