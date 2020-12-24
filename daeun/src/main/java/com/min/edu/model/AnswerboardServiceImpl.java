package com.min.edu.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.min.edu.dto.AnswerboardDTO;

@Service
public class AnswerboardServiceImpl implements AnswerboardIService{

	@Autowired
	private AnswerboardIDao dao;

	@Transactional(readOnly = true)
	@Override
	public List<AnswerboardDTO> selectDynamic(Map<String, String> map) {
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		List<AnswerboardDTO> list = dao.selectDynamic(map);
		for(int i=0;i<list.size();i++) {
//			list.get(i).setRegdate(sdf.format(list.get(i).getRegdate()));
			list.get(i).setRegdate(list.get(i).getRegdate().substring(0, list.get(i).getRegdate().indexOf(" ")));
		}
		return list;
	}
	
	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean reply(AnswerboardDTO dto) {
		boolean isc1 = dao.replyUpdate(dto);
		boolean isc2 = dao.replyInsert(dto);
		//둘다 트루여야 트루 아닌가 ????->up은 0일수있고 in은 1이여야 트루!
		return (isc1 || isc2) ? true : false;
	}

	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean modifyBoard(Map<String, String> map) {
		return dao.modifyBoard(map);
	}
	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean insertBoard(AnswerboardDTO dto) {
		return dao.insertBoard(dto);
	}
	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean multiDelete(String seq) {
		return dao.multiDelete(seq);
	}
	@Transactional(rollbackFor = Exception.class)
	@Override
	public boolean multiDelete2(Map<String, String[]> map) {
		return dao.multiDelete2(map);
	}


	
}
