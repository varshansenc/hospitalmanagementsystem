package com.shz.controller;

import com.shz.common.Constants;
import com.shz.entity.Log;
import com.shz.entity.ResultVo;
import com.shz.entity.User;
import com.shz.service.ILogService;
import com.shz.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.Jedis;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @Description
 * @Author shz
 * @Date 2020/10/14 8:42
 * @See com.shz.controller
 */
@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private IUserService userService;

    @Autowired
    private ILogService logService;

    @RequestMapping("login")
    @ResponseBody
    public ResultVo login(HttpSession session, User user) {
        User user1 = userService.selectUserByUsername(user.getUsername());

        Jedis jedis = new Jedis(Constants.JEDIS_HOST, 6379);

        String count = jedis.get("users:" + user.getUsername());

        if(user1 == null) {
            return new ResultVo(1, "用户不存在，请检查用户名", null, null);
//            return new ResultVo(1, "登录错误3次以上，账号被锁定，请5分钟后重试", null, null);
//            if("3".equals(count)) {
//            } else {
//                jedis.hincrBy("login.users", user.getUsername(), Long.parseLong(count));
//            }
        } else {
            if(!user1.getPassword().equals(user.getPassword())) {
                if("3".equals(count)) {
                    Long time = jedis.ttl("users:" + user1.getUsername());
                    if(time == -1) {
                        jedis.expire("users:" + user1.getUsername(),5 * 60);
                    }
                    return new ResultVo(1, "登录错误3次以上，账号被锁定，请5分钟后重试", null, null);
                } else {
                    jedis.incr("users:" + user.getUsername());
                    return new ResultVo(1, "密码错误，请重试", null, null);
                }
            } else {
                jedis.del("users:" + user1.getUsername());
                session.setAttribute("user", user1);

                logService.insertLog(new Log(null, 0, user1.getRealname(), "登陆系统了", new Date()));

                return new ResultVo();
            }
        }
    }

//    @RequestMapping("login")
//    @ResponseBody
//    public ResultVo login(HttpSession session, User user) {
//        User user1 = userService.selectUserByUsername(user.getUsername());
//        if(user1 != null && user1.getPassword().equals(user.getPassword())) {
//            session.setAttribute("user", user1);
//
//            logService.insertLog(new Log(null, 0, user1.getRealname(), "登陆系统了", new Date()));
//
//            return new ResultVo();
//        }
//        return new ResultVo(1, "登录信息有误", null, null);
//    }

    @RequestMapping("getUserInSession")
    @ResponseBody
    public User getUserInSession(HttpSession session) {
        return (User) session.getAttribute("user");
    }

    @RequestMapping("exit")
    public String exit(HttpSession session) {
        logService.insertLog(new Log(null, 0, ((User) session.getAttribute("user")).getRealname(), "退出系统了",
                new Date()));
        session.invalidate();
        return "redirect:/login.html";
    }
}
