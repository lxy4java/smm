package lxy.controller;

import lxy.bean.User;
import lxy.dao.UsersDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorld {

	@Autowired
	private UsersDao dao;

	@RequestMapping("/hello")
	public @ResponseBody String hello() {
		User u = new User();
		u.setAge(24);
		u.setGender(1);
		u.setHobby("coding");
		u.setName("lxy");
		u.setId(1);
		dao.insert(u);
		
		
		
		return "hello";
	}

}
