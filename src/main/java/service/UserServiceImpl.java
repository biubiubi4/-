package service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import pojo.UserForm;
@Slf4j
//注解为一个服务
@Service
public class UserServiceImpl implements UserService{
	@Override
	public boolean login(UserForm user) {
		if("zhangsan".equals(user.getUname()) 
				&& "123456".equals(user.getUpass())) {
            log.debug("验证成功");
            return true;
        }else {
            log.debug("验证失败");
            return false;
        }
	}
	@Override
	public boolean register(UserForm user) {
		if("zhangsan".equals(user.getUname()) 
				&& "123456".equals(user.getUpass())){
            log.debug("注册成功");
			return true;
        }
        else{
            log.debug("注册失败");
            return false;
        }
	}
}
