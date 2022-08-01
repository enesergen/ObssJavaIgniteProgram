package com.enesergen.obss.springStarter.springStarter.Filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.CommonsRequestLoggingFilter;

import javax.servlet.http.HttpServletRequest;

@Component
public class GeneralRequestFilter extends CommonsRequestLoggingFilter {
    private static final Logger LOGGER = LoggerFactory.getLogger(GeneralRequestFilter.class);

    protected boolean shouldLog(HttpServletRequest request) {
        return true;
    }

    protected void beforeRequest(HttpServletRequest request, String message) {
        LOGGER.info("Request filter started. {} {}", request.getRequestURI(), request.getMethod());
    }

    protected void afterRequest(HttpServletRequest request, String message) {
        LOGGER.info("Request filter finished. {} {}", request.getRequestURI(), request.getMethod());
    }


}
