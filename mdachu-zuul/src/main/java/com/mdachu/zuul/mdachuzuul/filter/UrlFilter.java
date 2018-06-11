package com.mdachu.zuul.mdachuzuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;

public class UrlFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";  //代表被路由之前执行
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;  //是否继续进行过滤其他的filter
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        String accessToken = String.valueOf(request.getParameter("Token"));
        if(!accessToken.equals("zz")){
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            return null;
        }
        return null;
    }
}
