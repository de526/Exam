package com.min.edu.dto;

import java.io.Serializable;

public class AnswerboardDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String title;
	private String step;
	private String seq;
	private String regdate;
	private String refer;
	private String readcount;
	private String id;
	private String depth;
	private String delflag;
	private String content;

	public AnswerboardDTO() {
	}

	public AnswerboardDTO(String title, String seq, String id, String content) {
		super();
		this.title = title;
		this.seq = seq;
		this.id = id;
		this.content = content;
	}

	@Override
	public String toString() {
		return "Answerboard_DTO [title=" + title + ", step=" + step + ", seq=" + seq + ", regdate=" + regdate
				+ ", refer=" + refer + ", readcount=" + readcount + ", id=" + id + ", depth=" + depth + ", delflag="
				+ delflag + ", content=" + content + "]";
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStep() {
		return step;
	}

	public void setStep(String step) {
		this.step = step;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public String getRegdate() {
		return regdate;
	}

	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	public String getRefer() {
		return refer;
	}

	public void setRefer(String refer) {
		this.refer = refer;
	}

	public String getReadcount() {
		return readcount;
	}

	public void setReadcount(String readcount) {
		this.readcount = readcount;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDepth() {
		return depth;
	}

	public void setDepth(String depth) {
		this.depth = depth;
	}

	public String getDelflag() {
		return delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
