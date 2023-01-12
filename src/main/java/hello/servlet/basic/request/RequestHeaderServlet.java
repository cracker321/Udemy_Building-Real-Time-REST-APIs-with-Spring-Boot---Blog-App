package hello.servlet.basic.request;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
//'포스트맨'에서 '입력 URL: http://localhost:8080/request-header'으로 테스트해보면 된다

//'클라이언트 <----> 서버' 간 'HTTP 통신할 때', 아래의 이 복잡하고 귀찮은 과정들을, 이렇게 코드 작성하지 않아도
// 이후에 '스프링MVC'가 'HTTP 통신 과정에서의 귀찮은 처리과정들'을 다~~~ 대신 해준다!

public class RequestHeaderServlet extends HttpServlet {


//===================================================================================================================


    @Override //아래 메소드 오버라이딩 방법: 'Generate' --> 'Override Methods'
    protected void service(HttpServletRequest request, HttpServletResponse response) throws
            ServletException, IOException {

        //[ 'HttpServletRequest - 기본 사용법'강 ]

        //아래 작성하고, 서버 재시작 후, 주소창에 'http://localhost:8080/request-header?username=hello' 등등 입력하면
        //'이에 해당하는 HTTP 메시지의 세부 정보'들을 여기 콘솔창에 출력해줌
        //즉, 그렇게나 많은 '시작줄의 정보', '헤더의 정보' 등등을 처리해주는 작업들을 '서블릿 컨테이너(엥? 이후인 스프링MVC인가??)'가
        //다 대신 해주는 것을 보여주기 위해 아래 코드들을 작성한 것임.
        //포스트맨으로 통신 연결해서 확인해봐도 됨.

        printStartLine(request); //< 'HTTP 요청 메시지의 시작줄(Start Line) 정보'를 불러오기 >
        printHeaders(request); //< 'HTTP 요청 메시지의 모든 헤더 정보'를 불러오기 >
        printHeaderUtils(request); //< 'HTTP 요청 메시지의 모든 헤더 정보'를 '편리하게 불러오기' >
        printEtc(request); //< 'HTTP 요청 메시지의 기타 정보'를 불러오기 >
    }


//===================================================================================================================


    //< 'HTTP 요청 메시지의 시작줄(Start Line) 정보'를 불러오기 >

    private void printStartLine(HttpServletRequest request){
        System.out.println("--- REQUEST-LINE - start ---");
        System.out.println("request.getMethod() = " + request.getMethod()); //GET
        System.out.println("request.getProtocol() = " + request.getProtocol()); //HTTP/1.1
        System.out.println("request.getScheme() = " + request.getScheme()); //http
        // http://localhost:8080/request-header
        System.out.println("request.getRequestURL() = " + request.getRequestURL());
        // /request-header
        System.out.println("request.getRequestURI() = " + request.getRequestURI());
        //username=hi
        System.out.println("request.getQueryString() = " +
                request.getQueryString());
        System.out.println("request.isSecure() = " + request.isSecure()); //https사용 유무
        System.out.println("--- REQUEST-LINE - end ---");
        System.out.println();

    }


//===================================================================================================================


    //< 'HTTP 요청 메시지의 모든 헤더 정보'를 불러오기 >

    private void printHeaders(HttpServletRequest request) {
        System.out.println("--- Headers - start ---");


        /* 이 아래 로직은, 저 아래 로직 대비 약간 과거에 쓰였음.
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
        String headerName = headerNames.nextElement();
        System.out.println(headerName + ": " + request.getHeader(headerName));
        }
        */
        request.getHeaderNames().asIterator() //- '메소드 getHeaderNames': 전송된 HTTP 요청 메시지 안에 있는
                                              //                          모든 헤더들을 다 꺼내서 출력할 수 있음
                .forEachRemaining(headerName -> System.out.println(headerName + ": "
                        + request.getHeader(headerName)));
                        System.out.println("--- Headers - end ---");
        System.out.println();

    }


//===================================================================================================================


    //< 'HTTP 요청 메시지의 모든 헤더 정보'를 '편리하게 불러오기' >

    private void printHeaderUtils(HttpServletRequest request) {
        System.out.println("--- Header 편의 조회 start ---");
        System.out.println("[Host 편의 조회]");
        System.out.println("request.getServerName() = " +
                request.getServerName()); //Host 헤더
        System.out.println("request.getServerPort() = " +
                request.getServerPort()); //Host 헤더
        System.out.println();
        System.out.println("[Accept-Language 편의 조회]");
        request.getLocales().asIterator()
                .forEachRemaining(locale -> System.out.println("locale = " +
                        locale));
        System.out.println("request.getLocale() = " + request.getLocale());
        System.out.println();
        System.out.println("[cookie 편의 조회]");
        if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                System.out.println(cookie.getName() + ": " + cookie.getValue());
            }
        }
        System.out.println();
        System.out.println("[Content 편의 조회]");
        System.out.println("request.getContentType() = " +
                request.getContentType());
        System.out.println("request.getContentLength() = " +
                request.getContentLength());
        System.out.println("request.getCharacterEncoding() = " +
                request.getCharacterEncoding());
        System.out.println("--- Header 편의 조회 end ---");
        System.out.println();
    }


//===================================================================================================================


    //< 'HTTP 요청 메시지의 기타 정보'를 불러오기 >
    private void printEtc(HttpServletRequest request) {
        System.out.println("--- 기타 조회 start ---");
        System.out.println("[Remote 정보]");
        System.out.println("request.getRemoteHost() = " +
                request.getRemoteHost()); //
        System.out.println("request.getRemoteAddr() = " +
                request.getRemoteAddr()); //
        System.out.println("request.getRemotePort() = " +
                request.getRemotePort()); //
        System.out.println();
        System.out.println("[Local 정보]");
        System.out.println("request.getLocalName() = " +
                request.getLocalName()); //
        System.out.println("request.getLocalAddr() = " +
                request.getLocalAddr()); //
        System.out.println("request.getLocalPort() = " +
                request.getLocalPort()); //
        System.out.println("--- 기타 조회 end ---");
        System.out.println();
    }



//===================================================================================================================


}



