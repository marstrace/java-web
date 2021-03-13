package top.top7;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


/******
 *       Created by LEARNING on 2020/10/25 11:10.
 *
 **********************************************************************
 *                .-~~~~~~~~~-._       _.-~~~~~~~~~-.
 *            __.'              ~.   .~              `.__
 *          .'//                  \./                  \\`.
 *        .'//                     |                     \\`.
 *      .'// .-~"""""""~~~~-._     |     _,-~~~~"""""""~-. \\`.
 *    .'//.-"                 `-.  |  .-'                 "-.\\`.
 *  .'//______.============-..   \ | /   ..-============.______\\`.
 *.'______________________________\|/______________________________`.
 *
 *
 *                     Don't forget to be awesome!                      
 **********************************************************************
 */

/**
 * session的使用:
 * 当request请求中有sessionId(以cookie形式存在,键值为JSESSIONID),并能够获取到对应Session对象时,返
 * 回获取到的对象,若没有SessionID,或
 * 找不到id对应对象,则新创建一个Session对象,并将SessionID以cookie的形式存到响应头中,并将该session对象返回
 */
@WebServlet("/pse")
public class PSession extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //获取Session的方法: 当request请求中有sessionId(以cookie形式存在,键值为JSESSIONID),并能够获取到对应Session对象时,返
        // 回获取到的对象,若没有SessionID,或
        // 找不到id对应对象,则新创建一个Session对象,并将SessionID以cookie的形式存到响应头中,随后返回session对象
        HttpSession session = req.getSession();
        //带参数的getSession(Boolean b),参数值为true时与无参方法相同,参数值为false时,若能获取到Session对象则返回,若不能则返回null
        HttpSession session1 = req.getSession(false);

        //会话作用域:
        //session保存与读取数据
        session.setAttribute("key", "object");
        Object key = (String) session.getAttribute("key");
        //删除数据
        session.removeAttribute("key");

        //设置session对象在服务器的保持时间,session的生存时间从最后一次访问时算起
        //参数值单位为秒 若值为0或负数则表示session永不过期,直到容器关闭
        session.setMaxInactiveInterval(3600);

        //销毁session
        session.invalidate();


        //浏览器禁用cookie时的解决方案
        //实现URL重写,追加SessionID信息
        String newUrl = resp.encodeRedirectURL("/project/source");
        resp.sendRedirect(newUrl);

        System.out.println("HTTPSession的初次登场");
    }
}
