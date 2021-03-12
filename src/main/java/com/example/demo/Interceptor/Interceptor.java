package com.example.demo.Interceptor;

import com.example.demo.models.Key;
import com.example.demo.models.UserStatus;
import com.example.demo.services.KeyService;
import com.example.demo.services.PetService;
import com.example.demo.services.UserService;
import com.example.demo.store.UserStorage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.Objects;

public class Interceptor implements HandlerInterceptor { // это перехватчик запросов, до момента достижения ими клиенте, дающие возможность вносить коррективы в запрос на данной стадии.
    // ОБЪЯСНИТЬ ВСЮ ЛОГИКУ НАПИСАНИЯ?????

    @Autowired
    PetService petService;

    @Autowired
    UserService userService;

    @Autowired
    KeyService keyService;

    @Override //для чего
    public boolean preHandle (HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{ //рабатает ДО контроллера

       /* String header = request.getHeader("X-Token");
        int newPetId = 5; // для чего задаётся данная переменная????
        StringBuffer requestURL = request.getRequestURL(); // для чего???
        System.out.println(requestURL);

        request.getMethod();
        Enumeration<String> initParameterNames = request.getServletContext().getInitParameterNames();// для чего??
        System.out.println(initParameterNames.toString());

        String method = request.getMethod(); // преобразыем вызванный метод в строку и выводим в консоль с соответствующим статусом
        System.out.println(method);

        response.setStatus(HttpServletResponse.SC_OK);
*/

        String skey = request.getHeader("Key");
        UserStatus userStatus = UserStatus.valueOf(request.getHeader("X-Status"));
        Key key1 = new Key();
        key1.setKey(skey);
        key1.setUserStatus(userStatus);
        if (keyService.valid(key1).equals(key1)){
            return true;
        }else {
            response.setStatus(HttpServletResponse.SC_FORBIDDEN);
            return false;
        }
    }
}
