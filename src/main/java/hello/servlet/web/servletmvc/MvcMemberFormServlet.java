package hello.servlet.web.servletmvc;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/ new-form")
public class MvcMemberFormServlet extends HttpServlet {


        @Override
        protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


            String viewPath = "/WEB-INF/views/new-form.jsp"; //경로 생성
            RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath); //'컨트롤러'에서 '뷰'로
                                                                                   //이동하게 됨

            //- 'dispatcher.foward()': 이것을 통해 '다른 서블릿'이나, '다른 JSP'로 '이동할 수 있는 기능'임.
            //                         또한, 현재 서버 내부에서 다시 호출이 발생한다.
            dispatcher.forward(request, response);

        }
}