package yan.zx.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import yan.zx.dao.UserDao;
import yan.zx.entity.User;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	UserDao userDao;
	
	@RequestMapping(value="/login", produces="application/json;charset=utf-8")
	public boolean login(String u_id,String password,HttpSession session) {
		User user = userDao.findUserByU_id(u_id);
		if(password!=null && password.equals(user.getPassword())) {
			session.setAttribute("u_id", u_id);
			session.setAttribute("name", user.getName());
			session.setAttribute("password", password);
			return true;
		}
		
		return false;
	}
	
	@RequestMapping(value="/register", produces="application/json;charset=utf-8")
	public  boolean register(String u_id,String name,String password) {
		
		User user = new User();
		user.setU_id(u_id);
		user.setName(name);
		user.setPassword(password);
		return userDao.addUser(user)>0?true:false;
	}
}
