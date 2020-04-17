package com.bee.content.backend.filter;

import com.bee.content.backend.utils.ThreadState;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;

@Component
@Order(HIGHEST_PRECEDENCE)
public class MerchantFilter implements Filter {
    private static final String MERCHANT_HEADER_KEY = "M-ID";

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        String merchant = req.getHeader(MERCHANT_HEADER_KEY);

        if (null == merchant) {
            merchant = "MONOPOLI";
            //throw new IllegalAccessError("Header " + MERCHANT_HEADER_KEY + " is missing.");
        }

        System.out.println("> set merchant " + merchant);
        ThreadState.INSTANCE.setMerchant(merchant);
        chain.doFilter(request, response);
    }
}