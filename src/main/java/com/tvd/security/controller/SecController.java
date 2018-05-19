package com.tvd.security.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecController {

	
	@RequestMapping(value={"/","/home"})
	public ModelAndView home(){
		return new ModelAndView("home");
	}
	
	@RequestMapping(value={"/login"})
	public ModelAndView login(String error,Model model,String logout,HttpServletRequest request){
		
		if(error!=null){
			model.addAttribute("error", "Invalid Username or Password!!");
		}
		
		if(logout!= null){
			HttpSession session=request.getSession(false);
			SecurityContextHolder.clearContext();
			if(session!=null){
				session.invalidate();
			}
			
			
			model.addAttribute("message","You Have been Logged out Successfully");
		}
		
		System.err.println("--login");
		return new ModelAndView("login");
	}
	
}
