package org.studystack.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This class is responsible for intercepting HTTP requests and adding CORS headers to the response.
 * It allows cross-origin requests from the specified origin.
 */
@Component
public class StudyStackInterceptor implements HandlerInterceptor {

    /**
     * This method is called before the request is handled by the controller.
     * It adds the Access-Control-Allow-Origin header to the response to allow cross-origin requests.
     *
     * @param request  The HTTP request
     * @param response The HTTP response
     * @param handler  The handler for the request
     * @return true to continue processing the request, false to stop processing
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        response.addHeader("Access-Control-Allow-Origin", "http://localhost:3000/");
        return true;
    }
}
