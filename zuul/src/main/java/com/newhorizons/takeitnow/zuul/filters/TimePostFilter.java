package com.newhorizons.takeitnow.zuul.filters;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class TimePostFilter extends ZuulFilter {

    private static Logger logger = LoggerFactory.getLogger(TimePreFilter.class);

    @Override
    public String filterType() {
        return "post";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {

        logger.info("Ejecutando Post ZuulFilter");

        RequestContext context = RequestContext.getCurrentContext();
        HttpServletRequest request = context.getRequest();

        Long startTime = (Long) request.getAttribute("startTime");
        Long currentTime = System.currentTimeMillis();
        Long requestTime = currentTime - startTime;

        logger.info(String.format("Tiempo transcurrido en segundos %s segundos", requestTime.doubleValue()/1000.00));
        logger.info(String.format("Tiempo transcurrido en segundos %s milisegundos", requestTime.doubleValue()));

        return null;
    }
}
