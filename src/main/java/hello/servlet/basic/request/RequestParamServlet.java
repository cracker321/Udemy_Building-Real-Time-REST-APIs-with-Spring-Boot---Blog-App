package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "requestParamServlet", urlPatterns = "/request-param")
//'포스트맨'에서 '입력 URL: http://localhost:8080/request-param'으로 테스트해보면 된다

public class RequestParamServlet extends HttpServlet {


//===================================================================================================================


    //1. < '클라이언트 ---> 서버'로 '쿼리파라미터 전송한 것'을 'GET 쿼리파라미터로 조회'하기  >
    //- 입력 URL(클라이언트로부터 전송된):
    // http://localhost:8080/request-param?request-param?username=yujong_cho&age=32

    //2. < '클라이언트 ---> 서버'로 '쿼리 파라미터 전송한 것'을
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse
            resp) throws ServletException, IOException {


        System.out.println("[전체 파라미터 조회] - start");

        /* # 클라이언트가 요청해온 전체 쿼리파라미터'를 '뽑아내는(조회하는) 것'
        - 저 아래 작성한 것이 최근 방식이고, 이 아래는 과거 방식
        Enumeration<String> parameterNames = request.getParameterNames();
        while (parameterNames.hasMoreElements()) {
        String paramName = parameterNames.nextElement();
        System.out.println(paramName + "=" +
        request.getParameter(paramName));
        }
        */


        request.getParameterNames().asIterator()
                .forEachRemaining(paramName -> System.out.println(paramName +
                        "=" + request.getParameter(paramName)));


        System.out.println("[전체 파라미터 조회] - end");
        System.out.println();
        System.out.println("[단일 파라미터 조회]");
        String username = request.getParameter("username");
        System.out.println("request.getParameter(username) = " + username);
        String age = request.getParameter("age");
        System.out.println("request.getParameter(age) = " + age);
        System.out.println();


        //# '들어온 URL'에 '여러 쿼리파라미터가 입력된' 경우
        //e.g) 입력 URL(클라이언트로부터 전송된):
        //http://localhost:8080/request-param?username=yujong_cho&age=32&username=suckjin_lee&age=31
        System.out.println("[이름이 같은 복수 파라미터 조회]");
        System.out.println("request.getParameterValues(username)");
        String[] usernames = request.getParameterValues("username");
        for (String name : usernames) {
            System.out.println("username=" + name);
        }


        resp.getWriter().write("okaaaayyy!!!");
    }
}


