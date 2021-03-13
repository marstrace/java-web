package top.top7;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/******
 *       Created by LEARNING on 2020/10/25 17:42.
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
 * cookie的使用--会话追踪,状态保持
 * 服务器将cookie设置在响应头信息中,若浏览器保存了某个cookie,那么它在以后访问该web服务器时,会在请求头中携带该cookie信息
 * 一个cookie主要有标识该信息的name 和 value组成
 */
public class PCookie extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //创建cookie
        //key 与 value均为字符串
        Cookie cookie = new Cookie("key", "value");
        //设置cookie的携带路径,浏览器在访问该路径下的资源时才会携带该cookie
        //默认为项目路径
        cookie.setPath("/project/source");
        //设置cookie在浏览器的保存时间
        //参数取值:>0值为有效时间,单位为秒 =0立即失效 <0会话结束失效(浏览器关闭)
        cookie.setMaxAge(-1);
        //添加cookie到response对象中
        resp.addCookie(cookie);

        //获取本次请求携带的所有cookie
        Cookie[] cookies = req.getCookies();
        for (Cookie c : cookies) {
            System.out.println(c.getName() + "=" + c.getValue());
        }

        //修改客户端保存的cookie
        //保证cookie name 及路径一致就可修改
        Cookie updateCookie = new Cookie("oldname", "newvalue");
        updateCookie.setPath("oldCookiePath");
        resp.addCookie(updateCookie);

        //创建及读取带中文的cookie
        //使用URLEncoder.encode()与URLDecoder.decode() 方法

    }
}
