package org.launchcode.practiceproject;

import org.launchcode.practiceproject.controllers.AuthenticationController;
import org.launchcode.practiceproject.data.UserRepository;
import org.launchcode.practiceproject.models.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AuthenticationFilter extends HandlerInterceptorAdapter {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuthenticationController authenticationController;

    private static final List<String> whitelist = Arrays.asList("/water-needs-teaser", "/check-needs", "/login", "/register", "/logout", "/css", "/static/styles", "/img/water-drop-image", "/about", "/contact","/profile", "/fragments");


    private static boolean isWhitelisted(String path){
        for(String pathRoot : whitelist){
            if(path.startsWith(pathRoot)){
                return true;
            }
        }
        return false;
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {
        if(isWhitelisted(request.getRequestURI())){
            return true;
        }
        HttpSession session = request.getSession();
        UserInfo user = authenticationController.getUserFromSession(session);


        if(user != null){
            System.out.println("AuthenticationFilter " + user.getUsername());
            System.out.println("User Id " + user.getId());
            return true;
        }

        response.sendRedirect("/check-needs");
        return false;
    }

}
