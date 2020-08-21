package com.example.demo.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.Model.User;
import com.example.demo.Repos.UserRepo;


@Controller

public class HomeController {
	
	@Autowired
	private UserRepo repos;
	
	
	
	
	@RequestMapping("/")
	
	public String well()
	{
		
		return "register";
		
	}
	
	@RequestMapping("/getData")
	public String getData(HttpServletRequest request)
	{
		String name=request.getParameter("name");
		String password=request.getParameter("password");
		
		//System.out.println(name+" "+passwd);
		
		HttpSession session=request.getSession();
		session.setAttribute("name",name);
		session.setAttribute("password", password);
		return "home";
		
	} 
	@RequestMapping("/uu")
	public ModelAndView  getUserData(User user)
	{
		ModelAndView mv=new ModelAndView();
		mv.addObject("user",user);
		
		mv.setViewName("home");
		repos.save(user);
		return mv;
		
	}
	
	
	@RequestMapping("/getlogin")
	public ModelAndView getLoginData(@RequestParam("name") String name, @RequestParam("password")String password)
	{
		ModelAndView mv=new ModelAndView();
		mv.addObject("name",name);
		mv.addObject("password", password);
		mv.setViewName("home");
		return mv;
		
	}


	
}
