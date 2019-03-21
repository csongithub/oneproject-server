/**
 * 
 */
package com.oneproject.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "AppStatusController")
public class AppController {

	@RequestMapping(method = RequestMethod.GET, value = "getApplicationStatus")
	public String getCassandraStatus() {
		return "Running...";
	}
}
