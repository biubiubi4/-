package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/index")
public class IndexController {
	@RequestMapping("/login")
	public String login() {
		return "login"; //默认是转发
        //也可以写成以下形式，在同一个控制器类中可以省略前缀/index/
        //return "forward:/index/login"
	}

	@RequestMapping("/register")
	public String register() {
		return "register";//默认是转发，也可以写成return "forward:/index/register"
	}

    @RequestMapping("/isLogin")
    public String isLogin() {
        //重定向到一个请求方法
        return "redirect:/index/isRegister";
    }

    @RequestMapping("/isRegister")
    public String isRegister() {
        //重定向到一个请求方法
        return "register";
    }
}
