package com.dell.services;

import javax.servlet.http.HttpServletRequest;

import com.dell.dto.AnswerDto;
import com.dell.dto.HangmanDto;
import com.dell.exceptions.HangmanException;

public interface HangmanSvc {
	
	public HangmanDto defaultGame(HttpServletRequest request);
	public String getWordById(Long id);
	public void processAnswer(AnswerDto answerDto) throws HangmanException;
	
	public HangmanDto anotherGame(HangmanDto oldHangmanDto, HttpServletRequest request);
	public void updateHangman(HangmanDto oldHangmanDto);
}
