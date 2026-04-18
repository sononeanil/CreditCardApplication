package com.hcl.card.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class RequestValidationFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest request,
                            HttpServletResponse response,
                            FilterChain chain)
            throws IOException, ServletException {

        String apiKey = request.getHeader("X-API-KEY");

        // Validate header
        if (apiKey == null || apiKey.isBlank()) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("Missing API Key");
            return;
        } else if (!"08860eba4590ec5a0681d79b843c4148".equals(apiKey)) {
            response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.getWriter().write("Invalid API Key");
            return;
        }

        // Continue request flow
        chain.doFilter(request, response);
    }
}
