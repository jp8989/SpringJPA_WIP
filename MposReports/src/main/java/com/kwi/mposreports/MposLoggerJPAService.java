package com.kwi.mposreports;

import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.servlet.http.HttpSession;

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

@EnableTransactionManagement
@EnableJpaRepositories(basePackages = "com.kwi.mposlogger")
@ComponentScan({ "com.kwi.mposlogger" })
public class MposLoggerJPAService {
	
    @Autowired
    private LogRepository repo;	
    
	public void getLogData() {
		
		System.out.println("4");
		ApplicationContext appContext = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext.xml" });

		LogRepository repo = (LogRepository) appContext.getBean("logRepository");
        //MPOS_LOGGER log = repo.save(new MPOS_LOGGER());
        repo.searchNatively().iterator().next();
        System.out.println("number of rows:"+repo.count());
	}
}
