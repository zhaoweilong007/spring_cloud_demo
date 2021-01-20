package com.zwl.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/** Created by zwl on 2020/11/26 12:09 自定义zuul过滤器 */
@Component
public class LoginFilter extends ZuulFilter {

  /**
   * 定义过滤器类型 pre 前置 routing 路由 post 后置
   *
   * @return
   */
  @Override
  public String filterType() {
    return "pre";
  }

  /**
   * 指定过滤器的执行顺序 值越小，执行顺序越高
   *
   * @return
   */
  @Override
  public int filterOrder() {
    return 1;
  }

  /**
   * 过滤器是否生效 true 使用 false 不使用
   *
   * @return
   */
  @Override
  public boolean shouldFilter() {
    return true;
  }

  /**
   * 执行过滤器中业务逻辑 zuul网关中，提供了RequestContext的上下文对象
   *
   * @return
   * @throws ZuulException
   */
  @Override
  public Object run() throws ZuulException {
    System.out.println("执行了过滤器");
    RequestContext context = RequestContext.getCurrentContext();
    HttpServletRequest request = context.getRequest();
    String access_token = request.getParameter("access_token");
    if (access_token == null) {
      context.setSendZuulResponse(false);
      context.setResponseStatusCode(HttpStatus.SC_UNAUTHORIZED);
    }
    return null;
  }
}
