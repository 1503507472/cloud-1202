package com.aaa.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @Author:jyf
 * @Description:
 * @Date:2019/12/3 16:06
 */
@Component
public class ConstomZullFilter extends ZuulFilter {
    /**
     * 过滤器类型
     * pre前置
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 过滤器的优先级，数字越小优先级越高
     * @return
     */
    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 是否需要过滤，为true过滤
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String id = request.getParameter("id");
        if (id==null) {
            //过滤该请求，不进行路由
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);
            try {
                currentContext.getResponse().getWriter().write("this id is null");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            //对该请求进行路由
            currentContext.setSendZuulResponse(true);
            currentContext.setResponseStatusCode(200);
            //让下一个过滤器看到这个过滤器的状态
            currentContext.set("isSuccess",true);
        }
        return null;
    }
}
