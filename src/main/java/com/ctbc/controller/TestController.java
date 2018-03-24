package com.ctbc.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@Scope("prototype")
@RequestMapping("/testController")
public class TestController {

	/**
	 * URL : http://localhost:8080/Angular1_JPA_test/spring/testController/ggg
	 */
	@RequestMapping(value = "/ggg", method = RequestMethod.GET)
	public String myTest() {
		System.out.println(" >>>>>>>> Fuck YOU Fuck YOU Fuck YOU Fuck YOU <<<<<<<<<<< ");
		return "result";
	}

}
