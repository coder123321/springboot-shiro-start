package com.sh.filter;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.sh.entity.AjaxResponse;
import com.sh.jwt.JwtToken;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.web.filter.authc.BasicHttpAuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import static com.sh.exception.CustomExceptionType.SYSTEM_ERROR;
import static com.sh.exception.CustomExceptionType.USERNAME_NOTFOUND;

/**
 * Created by Administrator on 2021/1/26.
 */
public class AesFilter extends BasicHttpAuthenticationFilter {
    /**
     * 执行登录
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @Override
    protected boolean executeLogin(ServletRequest request, ServletResponse response) throws Exception {
        HttpServletRequest httpServletRequest = (HttpServletRequest) request;
        String token = httpServletRequest.getHeader("Token");
        JwtToken jwtToken = new JwtToken(token);
        // 提交给realm进行登入，如果错误他会抛出异常并被捕获
        try {
            getSubject(request, response).login(jwtToken);
            // 如果没有抛出异常则代表登入成功，返回true
            return true;
        } catch (AuthenticationException e) {
            AjaxResponse responseData = AjaxResponse.error(SYSTEM_ERROR, "没有访问权限，原因是:" + e.getMessage());
            //SerializerFeature.WriteMapNullValue为了null属性也输出json的键值对
            Object o = JSONObject.toJSONString(responseData, SerializerFeature.WriteMapNullValue);
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(o);
            return false;
        }

    }
    /**
     * 过滤方法
     */
    protected boolean isAccessAllowed(ServletRequest request,
                                      ServletResponse response, Object object)  throws AuthenticationException {
        String token = ((HttpServletRequest) request).getHeader("X-Token");
        //判断请求的请求头是否带上 "Token"
        if (token != null) {
            try {
                JwtToken jwtToken = new JwtToken(token);
                getSubject(request, response).login(jwtToken);
                return true;
            } catch (AuthenticationException e) {
                //token 错误
                e.printStackTrace();
                AjaxResponse.error(USERNAME_NOTFOUND, "请登录123");
                return false;
            }
        }
        //如果请求头不存在 Token，则可能是执行登陆操作或者是游客状态访问，无需检查 token，直接返回 true
        return true;
    }
}
