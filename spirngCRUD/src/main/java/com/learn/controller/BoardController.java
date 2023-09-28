package com.learn.controller;

import javax.inject.Inject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
}
