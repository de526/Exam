package com.min.edu.ctrl;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.min.edu.dto.MemberDTO;
import com.min.edu.model.MemberIService;

@Controller
public class MemberController {

private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private MemberIService service;
	
	@RequestMapping(value = "/loginForm.do")
	public String loginForm() {
		log.info("로그인폼으로~~");
		return "login";
	}
	
	@RequestMapping(value = "/login.do",method = RequestMethod.POST)
	public String login(String id, String pw,HttpSession session) {
		log.info("login!!"+id+"////"+pw);
		Map<String,String> map = new HashMap<String,String>();
		map.put("id",id);
		map.put("pw",pw);		
		MemberDTO mdto = service.loginMember(map);
		log.info(mdto.toString());
		session.setAttribute("mdto",mdto);
		return "redirect:/boardList.do";
	}
	
	@RequestMapping(value = "/signUpForm.do",method = RequestMethod.GET)
	public String signUpForm() {
		log.info("signUpForm");
		return "signUp";
	}
	
	@RequestMapping(value = "/signUp.do",method = RequestMethod.GET)
	public String signUp(MemberDTO dto) {
		log.info("signUp");
		boolean isc = service.signUpMember(dto);
		log.info(isc+"");
		if(isc) {
			return "login";
		}else {
			return "hello";
		}
	}
	
	@ResponseBody
	@RequestMapping(value = "/idDuplicateCheck.do",method = RequestMethod.POST)
	public String idDuplicateCheck(String id) {
		log.info("idDuplicateCheck -> "+id);
		int n = service.idDuplicateCheck(id);
		String result="";
		if(n==0) {
			result = "true";
		}else {
			result = "false";
		}
		return result;
	}
}
