package controller;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
//import org.apache.commons.logging.Log;
//import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pojo.UserForm;
import service.UserService;
@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {
	//得到一个用来记录日志的对象，这样打印信息的时候能够标记打印的是那个类的信息
	//private static final Log logger = LogFactory.getLog(UserController.class);
	//将服务层依赖注入到属性userService
    /* 2.3.6 使用@Autowired注解注入服务层对象
    public UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
		this.userService = userService;
	}
    */

	/**
	 * 处理登录
	 */
	@PostMapping("/login")
	public String login(UserForm user, HttpSession session, Model model) {
        //2.3.4节代码
        if("zhangsan".equals(user.getUname())
                && "123456".equals(user.getUpass())){
            session.setAttribute("u", user);
            log.info("成功");
            return "main";
        }else {
            log.info("失败");
            model.addAttribute("messageError", "用户名或密码错误");
            return "login";
        }
        /* 2.3.6节所需代码
		if(userService.login(user)){
			session.setAttribute("u", user);
			log.info("成功");
			return "main";//登录成功，跳转到main.jsp
		}else{
			log.info("失败");
			model.addAttribute("messageError", "用户名或密码错误");
			return "login";
		}
        */
	}
    /**
	 * 处理注册
     * 使用UserForm对象（实体bean）user接受注册页面提交的请求参数。最常用的方法
     * 要求：请求参数名称必须与实体bean属性名称一致，会把求参数值赋给同名的实体bean属性
     * 如不一致，user接收不到参数值，程序也不会报错，user对象中的相应属性为null
	 */

    @PostMapping("/register")
    public String register(UserForm user ,Model model) {
        if("zhangsan".equals(user.getUname())
                && "123456".equals(user.getUpass())){
            log.info("成功");
            return "login";//注册成功，跳转到login.jsp
        }else {
            log.info("失败");
            model.addAttribute("user", user);
            //在register.jsp页面上可以使用EL表达式${user.uname}取出model中的uname值
            return "register";//返回register.jsp
        }
        /* 2.3.6节所需代码
		if(userService.register(user)){
			log.info("成功");
			return "login";//注册成功，跳转到login.jsp
		}else{
			log.info("失败");
			model.addAttribute("user", user);
		    //在register.jsp页面上可以使用EL表达式${user.uname}取出ModelAttribute的uname值
			return "register";//返回register.jsp
		}

         */
    }
    /**
     * 处理注册
     * 使用形参接受注册页面提交的请求参数
     * 要求：请求参数名称必须与形式参数名称一致。
     * 如不一致，形式参数接收不到参数，其值为null
     */

    @PostMapping("/register1")
    public String register1(String uname, String upass ,Model model) {
        if("zhangsan".equals(uname)
                && "123456".equals(upass)){
            log.info("成功");
            return "login";//注册成功，跳转到login.jsp
        }else {
            log.info("失败");
            model.addAttribute("uname", uname);
            return "register";//返回register.jsp
        }
    }

    /**
     * 处理注册
     * 使用@RequestParam接受注册页面提交的请求参数
     * 要求：请求参数名称必须与@RequestParam指定的名称一致。如果@RequestParam未指定名称，则默认为形式参数名称
     * 如不一致，形式参数接收不到参数，程序会报400错误
     */
    @PostMapping("/register2")
    public String register2(@RequestParam("uname") String username, @RequestParam("upass")String userpass , Model model) {
        if("zhangsan".equals(username)
                && "123456".equals(userpass)){
            log.info("成功");
            return "login";//注册成功，跳转到login.jsp
        }else {
            log.info("失败");
            model.addAttribute("uname", username);
            return "register";//返回register.jsp
        }
    }
    /**
     * 处理注册
     * 使用@ModelAttribute接受注册页面提交的请求参数
     * 要求：请求参数名称必须与实体bean属性名称一致。如果@ModelAttribute未指定名称，则默认为形式参数名称
     * 如不一致，实体bean接收不到参数，也不会报错误
     *
     * 使用@ModelAttribute("user")与model.addAttribute("user", user)功能相同
     */
	@PostMapping("/register3")
	public String register3(@ModelAttribute("user") UserForm user ) {
        if("zhangsan".equals(user.getUname())
                && "123456".equals(user.getUpass())){
            log.info("成功");
            return "login";//注册成功，跳转到login.jsp
        }else {
            log.info("失败");
            //model.addAttribute("uname", user.getUname());
            return "register";//返回register.jsp
        }
        /* 2.3.6节所需代码
		if(userService.register(user)){
			log.info("成功");
			return "login";//注册成功，跳转到login.jsp
		}else{
			log.info("失败");
			//使用@ModelAttribute("user")与model.addAttribute("user", user)功能相同
		    //在register.jsp页面上可以使用EL表达式${user.uname}取出ModelAttribute的uname值
			return "register";//返回register.jsp
		}

         */
	}
}
