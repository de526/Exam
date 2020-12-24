package com.min.edu.model;

import java.util.List;
import java.util.Map;

import com.min.edu.dto.AnswerboardDTO;

public interface AnswerboardIService {

	//seq있으면 seq로 dto 가져오고, 없으면 전체 가져오기  
	public List<AnswerboardDTO> selectDynamic(Map<String,String> map);
	
	//댓글달기 - insert+update
	public boolean reply(AnswerboardDTO dto);
	
//	//댓글달기 - update
//	public boolean replyUpdate(AnswerboardDTO dto);

	//내용 수정 - seq로 (Map - content, seq)
	public boolean modifyBoard(Map<String,String> map);

	//글 입력 - selectkey(해당 seq 받아옴)
	public boolean insertBoard(AnswerboardDTO dto);
	
	//글 삭제 - seq로 deflag Y로 바꿔주기
	public boolean multiDelete(String seq);
	
	//글삭제 - 다중삭제 map<"seqs",seq>
	public boolean multiDelete2(Map<String,String[]> map);
}
