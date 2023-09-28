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
	private BoardService service;	// Service ȣ���� ���� ��ü����
	
	@RequestMapping(value="/listAll", method=RequestMethod.GET)
	public void listAll(Model model) throws Exception {
		model.addAttribute("list", service.listAll());	// jsp�� ���� ȣ��
	}
	
	@RequestMapping(value = "/regist", method = RequestMethod.GET)
	public void registerGET(BoardVO board, Model model) throws Exception {
	}

	@RequestMapping(value = "/regist", method = RequestMethod.POST)
	public String registPOST(BoardVO board, RedirectAttributes rttr) throws Exception { // ���ڰ����� REDIRECT ��� 
		service.regist(board); // ���ۼ� ���� ȣ��
	    return "redirect:/listAll"; // �ۼ��� �Ϸ�� ��, ����������� ����
	}
}
