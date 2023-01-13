package hello.servlet.web.frontcontroller.v1.controller;

import hello.servlet.web.frontcontroller.v1.ControllerV1;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


//입력된 url 링크 내용에서 v1 뒤에 어떤 url이 입력되더라도, 일단 v1까지만 입력되었다면, 무조건 이 서블릿이 호출된다!
@WebServlet(name = "frontControllerServletV1", urlPatterns = "/frontcontroller/v1/*")

public class FrontControllerServletV1 extends HttpServlet {

    private Map<String, ControllerV1> controllerMap = new HashMap<>();



    public FrontControllerServletV1() {

        //'클라이언트로부터 입력 URL'로 '왼쪽의 Key 값'이 들어오면, '오른쪽 Value값'이 호출된다!
        controllerMap.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
        controllerMap.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
        controllerMap.put("/front-controller/v1/members", new MemberListControllerV1());
    }



    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        System.out.println("FrontControllerServletV1.service");
        String requestURI = request.getRequestURI(); //'메소드 getRequestURI'를 통해 어떤 컨트롤러를 호출해야 하는지 확인가능.


        ControllerV1 controller = controllerMap.get(requestURI);
        if (controller == null) {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);

            return;
        }

        
        controller.process(request, response);
    }

}


