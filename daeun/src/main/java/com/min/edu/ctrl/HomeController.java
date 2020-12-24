package com.min.edu.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.min.edu.dto.AnswerboardDTO;
import com.min.edu.model.AnswerboardIService;

@Controller
public class HomeController {
	
	@Autowired
	private AnswerboardIService service;

//	DB 테스트 컨트롤러
	
	@RequestMapping(value = "/selectDynamic.do")
	public String selectDynamic(String seq) {
		Map<String, String> map = new HashMap<String, String>();
		map.put("seq", seq);
		List<AnswerboardDTO> list = service.selectDynamic(map);
		System.out.println(map);
		System.out.println(list);
		return "hello";
	}
	@RequestMapping(value = "/reply.do")
	public String reply(AnswerboardDTO dto) {
		dto.setId("USER01");
		dto.setSeq("27");
		dto.setTitle("댓글테스트");
		dto.setContent("testtest");
		System.out.println(service.reply(dto));
		return "hello";
	}
	@RequestMapping(value = "/modifyBoard.do")
	public String modifyBoard(String content, String seq) {
		Map<String,String> map = new HashMap<String, String>();
		map.put("content", content);
		map.put("seq", seq);
		System.out.println(service.modifyBoard(map));			
		return "hello";
	}
	@RequestMapping(value = "/insertBoard.do")
	public String insertBoard(AnswerboardDTO dto) {
		dto.setId("TEST01");
		dto.setTitle("인서트테스트");
		dto.setContent("testtest");
		System.out.println(service.insertBoard(dto));
		System.out.println(dto.getSeq());
		return "hello";
	}
	@RequestMapping(value = "/multiDelete.do")
	public String multiDelete(String seq) {
		System.out.println(service.multiDelete(seq));
		return "hello";
	}
	
	@RequestMapping(value = "/multiDelete2.do")
	public String multiDelete2(String[] seqs) {
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("seqs", seqs);				
		System.out.println(service.multiDelete2(map));
		return "hello";
	}
	
	
}
