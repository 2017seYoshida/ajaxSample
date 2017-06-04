package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Bean;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class indexController {

	@RequestMapping("/index")
	public String index (Model model) {
		return "index";
	}

	@RequestMapping(value = "json")
	@ResponseBody
	public List<Bean> getTestData(@RequestParam("data") String data) {

	    log.info("call getTestData");

	    List<Bean> list = new ArrayList<>();
	    list.add(new Bean(1, "aaa", data));
	    list.add(new Bean(2, "bbb", data));
	    list.add(new Bean(3, "ccc", data));
	    list.add(new Bean(4, "ddd", data));
	    list.add(new Bean(5, "eee", data));


	    return list;
	}
}
