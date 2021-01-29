package com.sh.controller;

import com.sh.entity.AjaxResponse;
import com.sh.entity.BaseUser;
import com.sh.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

import static com.sh.exception.CustomExceptionType.USERNAME_NOTFOUND;

/**
 * Created by Administrator on 2021/1/19.
 */
@RestController
public class LoginController {
    //加密的字符串,相当于签名
    private static final String SINGNATURE_TOKEN = "加密token";
    @Autowired
    private UserService service;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public AjaxResponse login(HttpServletRequest request,String username,String password ) {
        String id = "system";
//        String username = "system";
//        String password = "123";
        HttpSession session = request.getSession();
        AjaxResponse result = service.login(username,password);
        return result;
//        BaseUser user = service.findUserById(id);
//        BaseUser user = new BaseUser();
//        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(username, password);
//        Subject subject = SecurityUtils.getSubject();
//        try {
//            subject.login(usernamePasswordToken);   //完成登录
//            String sessionId = subject.getSession().getId().toString();
////            String encryptionKey = DigestUtils.md5DigestAsHex((SINGNATURE_TOKEN + username).getBytes());
//            return AjaxResponse.success(sessionId, "登录成功");
//        } catch (UnknownAccountException uae) {
////            logger.info("对用户[" + username + "]进行登录验证..验证未通过,未知账户");
//            request.setAttribute("message", "未知账户");
//            return AjaxResponse.error(USERNAME_NOTFOUND, "未知账户");
////            return "/base/login";//返回登录页面
//        } catch (IncorrectCredentialsException ice) {
////            logger.info("对用户[" + username + "]进行登录验证..验证未通过,错误的凭证");
//            request.setAttribute("message", "密码不正确");
//            return AjaxResponse.error(USERNAME_NOTFOUND, "未知账户");
////            return "/base/login";//返回登录页面
//        } catch (LockedAccountException lae) {
////            logger.info("对用户[" + username + "]进行登录验证..验证未通过,账户已锁定");
//            request.setAttribute("message", "账户已锁定");
//            return AjaxResponse.error(USERNAME_NOTFOUND, "未知账户");
////            return "/base/login";//返回登录页面
//        } catch (ExcessiveAttemptsException eae) {
////            logger.info("对用户[" + username + "]进行登录验证..验证未通过,错误次数过多");
//            request.setAttribute("message", "用户名或密码错误次数过多");
//            return AjaxResponse.error(USERNAME_NOTFOUND, "未知账户");
////            return "/base/login";//返回登录页面
//        } catch (AuthenticationException ae) {
//            //通过处理Shiro的运行时AuthenticationException就可以控制用户登录失败或密码错误时的情景
////            logger.info("对用户[" + username + "]进行登录验证..验证未通过,堆栈轨迹如下");
//            ae.printStackTrace();
//            request.setAttribute("message", "用户名或密码不正确");
//            return AjaxResponse.error(USERNAME_NOTFOUND, "未知账户");
////            return "/base/login";//返回登录页面
//        }
    }

    @RequestMapping(value = "/unauth")
    @ResponseBody
    public AjaxResponse unauth() {
        return AjaxResponse.error(USERNAME_NOTFOUND, "未登录111");
    }
}
