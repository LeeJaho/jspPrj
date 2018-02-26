package com.newlecture.jspprj.entity;

import java.sql.Date;

public class AnswerisView extends Answeris {
	/*추가로 필요로 한 column*/
	private int commentCount;
	
	public AnswerisView() {

	}

	public AnswerisView(
			String id, 
			String language, 
			String platform, 
			String runtime, 
			String title, 
			String errorCode,
			String errorMessage, 
			String situation, 
			String triedToFix, 
			String reason, 
			String writerId, 
			String howToFix,
			Date regDate, 
			int hit, 
			int commentCount
		) {
		super(id, language, platform, runtime, title, errorCode, errorMessage, situation, triedToFix, reason, writerId,
				howToFix, regDate, hit);
		
		this.commentCount = commentCount;
	}

	public int getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(int commentCount) {
		this.commentCount = commentCount;
	}
	
	
}
