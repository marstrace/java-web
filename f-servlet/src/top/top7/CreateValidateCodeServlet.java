package top.top7;

import cn.dsna.util.images.ValidateCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author top234
 *
 * 动态图片验证码
 */
@WebServlet("/vcode")
public class CreateValidateCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //ValidateCode的构造器参数取值有限制,若取值超过限制范围则会产生异常
        ValidateCode code = new ValidateCode(200, 30, 4, 10);
        String s = code.getCode();
        System.out.println(req.getRemoteAddr()+"的验证码:"+s);
        HttpSession session = req.getSession();
        session.setAttribute("validateCode",s);
        code.write(resp.getOutputStream());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }
}
