package com.example.gateway;

import javax.servlet.http.HttpSession;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.session.Session;
// import org.springframework.session.SessionRepository;
import org.springframework.stereotype.Component;

@Component
public class SessionSavingZuulPreFilter extends ZuulFilter {
    // @Autowired
    // private SessionRepository<Session> repository;

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext context = RequestContext.getCurrentContext();
        HttpSession httpSession = context.getRequest().getSession();

        context.addZuulRequestHeader("Cookie", "SESSION=" + httpSession.getId());
        return null;
    }

    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }
}