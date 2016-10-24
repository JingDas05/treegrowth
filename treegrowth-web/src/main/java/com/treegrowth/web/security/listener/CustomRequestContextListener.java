package com.treegrowth.web.security.listener;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestContextListener;

import javax.servlet.annotation.WebListener;

/** "your code is probably running outside of DispatcherServlet/DispatcherPortlet",
 * to avoid above problem so add requestContextListener*/
@Configuration
@WebListener
public class CustomRequestContextListener extends RequestContextListener {

}
