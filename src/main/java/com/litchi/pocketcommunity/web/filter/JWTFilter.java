package com.litchi.pocketcommunity.web.filter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.litchi.pocketcommunity.util.ErrorMessage;
import com.litchi.pocketcommunity.util.JWTUtils;
import com.litchi.pocketcommunity.util.ResultMessage;
import io.jsonwebtoken.Claims;
import org.springframework.http.HttpStatus;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: JWTFilter
 * @Description: TODO
 * @author: litchi
 */
public class JWTFilter implements Filter {
    private JWTUtils jwtUtils;
    private List<String> urls = null;
    private static final org.springframework.util.PathMatcher pathMatcher = new AntPathMatcher();
    public JWTFilter(JWTUtils jwtUtils, String[] authorisedUrls) {
        this.jwtUtils = jwtUtils;
        urls = Arrays.asList(authorisedUrls);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, filterConfig.getServletContext());
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setCharacterEncoding("UTF-8");
        httpResponse.setContentType("application/json; charset=utf-8");
        httpResponse.setHeader("Access-Control-Allow-Origin", "*");
        if ("OPTIONS".equals(httpRequest.getMethod())) {
            httpResponse.setStatus(HttpStatus.NO_CONTENT.value()); // HttpStatus.SC_NO_CONTENT = 204
            httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
            httpResponse.setHeader("Access-Control-Allow-Headers", "Content-Type, x-requested-with, Token");
            httpResponse.setHeader("Access-Control-Allow-Methods", "OPTIONS,GET,POST,DELETE,PUT");
        }
        String servletPath = httpRequest.getServletPath();
        try {
            // 验证受保护的接口
            for (String url : urls) {
                if (pathMatcher.match(url, servletPath)) {
                    Claims claims = jwtUtils.validateTokenAndGetClaims(httpRequest);
                    if (claims != null) {
                        request.setAttribute("currentUserId", claims.get("userId"));
                        chain.doFilter(request, response);
                        return;
                    }else{
                        httpResponse.setContentType("application/json; charset=utf-8");
                        PrintWriter writer = httpResponse.getWriter();
                        ResultMessage resultMessage = ResultMessage.getInstance().result(ResultMessage.UNAUTHORIZED).msg(ErrorMessage.UNAUTHORIZED_ERROR);
                        writer.print(JSON.toJSONString(resultMessage, SerializerFeature.WriteMapNullValue));
                        writer.close();
                        return;
                    }
                }
            }
            chain.doFilter(request, response);
        } catch (Exception e) {
            System.out.println("??????????");
            e.printStackTrace();
        }
    }

    @Override
    public void destroy() {

    }
}
