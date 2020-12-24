package com.min.edu.ctrl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.min.edu.dto.AnswerboardDTO;
import com.min.edu.model.AnswerboardIService;

@Controller
public class BoardController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AnswerboardIService service;
	
	@RequestMapping(value = "/boardList.do")
	public String boardList(Model model) {
		log.info("boardList.do");
		model.addAttribute("list",service.selectDynamic(new HashMap<String, String>()));
		return "boardList";
	}
	
	@RequestMapping(value = "/selectOne.do")
	public String selectOne(Model model,String seq) {
		log.info("selectOne.do");
		Map<String, String> map = new HashMap<String, String>();
		map.put("seq", seq);
		List<AnswerboardDTO> dto = service.selectDynamic(map);
		model.addAttribute("dto",service.selectDynamic(map));
		log.info(service.selectDynamic(map).toString());
		return "boardDetail";
	}
	
	@RequestMapping(value = "/updateBoard.do")
	public String updateBoard(Model model,String content,String seq) {
		log.info("updateBoard.do");
		Map<String, String> map = new HashMap<String, String>();
		map.put("seq", seq);
		map.put("content",content);
		boolean isc = service.modifyBoard(map);
		log.info(isc ? "수정 성공":"수정실패");
		return "redirect:/selectOne.do?seq="+seq;
	}
	@RequestMapping(value = "/delete.do")
	public String delete(String[] seqs) {
		log.info("delete.do 선택된 seq : "+seqs);
		Map<String, String[]> map = new HashMap<String, String[]>();
		map.put("seqs", seqs);
		boolean isc = service.multiDelete2(map);
		log.info(isc ? "삭제성공":"삭제실패");
		return "redirect:/boardList.do";
	}
	
	@RequestMapping(value = "/writeBoard.do")
	public String writeBoard(HttpSession session) {
		log.info("writeBoard.do");
		return "writeBoard";
	}
	
	@RequestMapping(value = "/insert.do")
	public String insert(AnswerboardDTO dto) {
		if(service.insertBoard(dto)) {
			log.info("글 입력 성공 seq : "+ dto.getSeq());
			return "redirect:/selectOne.do?seq="+dto.getSeq();
		}else {
			log.info("글 입력 실패");
			return "redirect:/boardList.do";
		}
	}
	
	@RequestMapping(value = "/replyBoard.do")
	public String replyBoard(Model model,String seq) {
		log.info("replyBoard.do 답글달 seq:"+ seq);
		model.addAttribute("seq",seq);
		return "writeBoard";
	}
	
	@RequestMapping(value = "/writeReply.do")
	public String writeReply(AnswerboardDTO dto) {
		log.info("writeReply.do 답글달 seq :"+dto.getSeq()+" DTO :"+dto);
		if(service.reply(dto)) {
			log.info("답글 입력 성공");
			return "redirect:/boardList.do";
		}else {
			log.info("답글 입력 실패");
			return "redirect:/selectOne.do?seq="+dto.getSeq();
		}
	}
}
