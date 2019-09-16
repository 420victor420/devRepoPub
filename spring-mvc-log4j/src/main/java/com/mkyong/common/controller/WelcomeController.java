package com.mkyong.common.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WelcomeController {

	private static final Logger logger = Logger.getLogger(WelcomeController.class);

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getWelcome() {

		//logs debug message
//		if(logger.isDebugEnabled()){
//			logger.debug("getWelcome is executed!");
//		}
		try {
		    int i = 0 / 0;
		} catch (ArithmeticException e) {
		    e.printStackTrace();
		    MailSendToException.sendMail("vivek::"+WelcomeController.class.getSimpleName(), e.getMessage(), "222", "11");
		    logger.error("This is eeeeeee message", e);
//		    logger.error("This is Error message", new Exception("Testing"));
		}
		
		//logs exception
		ModelAndView model = new ModelAndView("welcome");
		model.addObject("msg", "Hello Spring MVC + Log4j");
		return model;

	}

}