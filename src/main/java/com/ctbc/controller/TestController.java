package com.ctbc.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

	/**
	 * URL : http://localhost:8080/Angular1_JPA_test/spring/testController/ggg/fuck
	 */
	@RequestMapping(value = "/ggg/{param01}", method = { RequestMethod.GET, RequestMethod.POST }, 
			produces = { MediaType.APPLICATION_JSON_UTF8_VALUE }
			,consumes = { MediaType.APPLICATION_JSON_UTF8_VALUE }
	)
	@ResponseBody
	public String myTest2(@PathVariable(value = "param01") String myParam) {
		System.out.println("~~~~ myTest2 ~~~ myParam = " + myParam);
		return "{ \"rtnMsg\" : \"FuckYou\" }";
	}
	
	/**
	 * URL : http://localhost:8080/Angular1_JPA_test/spring/testController/ggg/111,222,333,444
	 */
	@RequestMapping(value = "/ggg/{param01}", method = { RequestMethod.GET }, produces = { MediaType.APPLICATION_JSON_UTF8_VALUE })
	@ResponseBody
	public String myTest3(@PathVariable(value = "param01") String[] myParamArray) {
		System.out.println("~~~~ myTest3 , @PathVariable 接收陣列 ~~~~ ");
		for (String str : myParamArray) {
			System.out.println(" >>> " + str);
		}
		return "{ \"rtnMsg\" : \"FuckYou\" }";
	}

}
