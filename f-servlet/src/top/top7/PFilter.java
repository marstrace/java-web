package top.top7;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/******
 *       Created by LEARNING on 2020/10/25 18:46.
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
 * 过滤器的使用:
 * 过滤器,是处于客户端与服务器目标资源之间的一道过滤技术
 * 可以有效解决多个Servlet之间的代码冗余
 *
 * 在一个Web应用中，可以开发编写多个Filter,这些Filter组合起来称之为一个Filter链。 优先级:
 * ●如果为注解的话，是按照类全名称的字符串顺序决定作用顺序
 * ●如果web.xml,按照filter-mapping注册顺序， 从上往下
 * ●web.xml配置高于注解方式
 * ●如果注解和web.xml同时配置， 会创建多个过滤器对象，造成过滤多次。
 */
//使用注解配置过滤路径,具体匹配策略见web.xml
@WebFilter("/ps1")
public class PFilter implements Filter {

    //初始化方法
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    //执行过滤
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        System.out.println("拦截请求");
        //处理中文乱码问题
        servletRequest.setCharacterEncoding("utf8");
        servletResponse.setContentType("text/html;charset=utf8");

        //权限验证
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        HttpSession session = httpServletRequest.getSession();
        if (session.getAttribute("user") == null) {

            httpServletRequest.getRequestDispatcher("ps2").forward(servletRequest, servletResponse);

           /* 关于在此处使用重定向的问题:
            httpServletResponse.sendRedirect("ps2");
            下方代码会继续执行,并在浏览器执行重定向之前执行,重定向表示本次请求Servlet已执行结束并回到了当前位置
            可使用return结束当前方法
            return;
            */
        } else {

            //用户已登录,放行
            filterChain.doFilter(servletRequest, servletResponse);
        }

        /*
        filterChain.doFilter(servletRequest, servletResponse);
            因为 重定向/请求转发 后会继续向下执行,因此filterChain.doFilter(servletRequest, servletResponse)方法与重定向/转发
            只能有一个有执行机会,若放行方法在此处则会报下述异常
                java.lang.IllegalStateException：提交响应后无法调用sendRedirect（）
                org.apache.catalina.connector.ResponseFacade.sendRedirect（ResponseFacade.java:494）
                top.top7.PFilter.doFilter（PFilter.java:64）
                top.top7.PFilter.doFilter（PFilter.java:70）
         */


        System.out.println("响应之前");
    }

    //销毁方法
    @Override
    public void destroy() {

    }
}
