package com.jaimedantas.iso8583decoder.context;

import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

@Component
public class RequestFilter extends OncePerRequestFilter {
    
    /**
     * Adds an the transaction id of the request in the context and removes afterwards
     * @param request
     * @param response
     * @param filterChain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        MDC.put("CorrelationId", getCorrelationId());
        try {
            filterChain.doFilter(request, response);
        } finally {
            MDC.remove("CorrelationId");
        }
    }

    /**
     * Generates an unique UUID 32
     * @return
     */
    private String getCorrelationId() {
        return UUID.randomUUID().toString();
    }
}
