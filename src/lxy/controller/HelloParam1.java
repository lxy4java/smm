package lxy.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloParam1 {

	@RequestMapping("/param1")
	public ModelAndView param1() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("param1");
		mv.addObject("lxy", "¿ÓÂ–“£");
		return mv;

	}
	@RequestMapping("/param2")
	public String param2(Map<String ,String> map){
		
		map.put("lxy", "¿ÓÂ–“£ 24ÀÍ");
		
		return "param1";
	}

}
