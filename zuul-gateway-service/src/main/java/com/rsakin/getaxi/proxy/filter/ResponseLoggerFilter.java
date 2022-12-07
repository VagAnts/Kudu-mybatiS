package com.rsakin.getaxi.proxy.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.rsakin.getaxi.proxy.util.FilterUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ResponseLoggerFilter extends ZuulFilter {

    @Override
    public boolean shouldFilter() {
        return FilterUtil.SHOULD_FILTER;
    }

    @Override
    public St