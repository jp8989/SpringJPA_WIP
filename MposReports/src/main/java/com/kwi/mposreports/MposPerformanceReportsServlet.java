package com.kwi.mposreports;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kwi.mposlogger.LogConfiguration;
import com.kwi.mposlogger.LogRepository;
import com.kwi.mposlogger.MPOS_LOGGER;

import static com.kwi.mposreports.MposUtilReportsConstants.*;
 
/*
 * author: Jonathan
 * 
 */
 
@Controller
public class MposPerformanceReportsServlet {
	
	
    private static final Logger log = LoggerFactory.getLogger(MposPerformanceReportsServlet.class);


/*
 * 
 * Spring will inject HttpSession instance into your controller's method.
 * 
 */
	@RequestMapping("/addItemReport")
	public ModelAndView addItemReport(HttpSession session) {
		
		log.info("dysty");
		System.out.println("1");
		session.setAttribute(SESSIONID, session.getId()); 

		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });

		MposLoggerJPAService logClient = new MposLoggerJPAService();
		logClient.getLogData();
		
		String message = "<br><div style='text-align:center;'>"
				+ "<h3>1) shows parameters 2) run reports 3) display results</div><br><br>";        
		
		return new ModelAndView("addItemReport", "message", message);
	}
 
	@RequestMapping("/welcome")
	public ModelAndView helloWorld() {
		
		//runBean();
		
		//String message = "<br><div style='text-align:center;'>"
		//		//+ "<h3>********** message from SpringMposPerformanceReportsServlet **********</div><br><br>";
		//		+ "<h3>AOPService: " + runBean() + "</div><br><br>";
		
		String message = "<br><div style='text-align:center;'>"
				//+ "<h3>********** message from SpringMposPerformanceReportsServlet **********</div><br><br>";
				+ "<h3>AOPService: runBean() " + "</div><br><br>";		
		
		return new ModelAndView("welcome", "message", message);
	}
	
}
