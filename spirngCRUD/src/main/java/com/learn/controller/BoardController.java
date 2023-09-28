package com.learn.controller;

import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.learn.domain.BoardVO;
import com.learn.service.BoardService;

@Controller
@RequestMapping(value="/")
public class BoardController {
	@Inject
	private BoardService service;	// Service 호출을 위한 객체생성
	
	@RequestMapping(value="/listAll", method=RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		model.addAttribute("list", service.listAll());	// jsp에 서비스 호출
	}
	
	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public void registerGET(BoardVO board, Model model) throws Exception {
	}

	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String registPOST(BoardVO board, RedirectAttributes rttr) throws Exception { // 인자값으로 REDIRECT 사용 
		service.regist(board); // 글작성 서비스 호출
	    return "redirect:/listAll"; // 작성이 완료된 후, 목록페이지로 리턴
	}
}
