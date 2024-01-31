package com.bruno.APIInterceptor.Middleware2.interceptors;

import com.bruno.APIInterceptor.Middleware2.entities.Month;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Component
public class MonthInterceptor implements HandlerInterceptor {

    private List<Month> getMonthList (){
        List<Month> monthList = new ArrayList<>();
        Month month = new Month(1, "January", "Gennaio", "Januar");
        Month month1 = new Month(2, "February", "Febbraio", "Februar");
        Month month2 = new Month(3, "March", "Marzo", "Marsch");
        Month month3 = new Month(4, "April", "Aprile", "April");
        Month month4 = new Month(5, "May", "Maggio", "Mai");

        monthList.add(month);
        monthList.add(month1);
        monthList.add(month2);
        monthList.add(month3);
        monthList.add(month4);

        return monthList;
    }

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String monthNumberHeader = request.getHeader("monthNumber");

        if(monthNumberHeader == null || monthNumberHeader.isEmpty()){
            response.setStatus(400);
            return false;
        }

        int monthNumber = Integer.parseInt(monthNumberHeader);
        Month selectedMonth = getMonthList().stream()
                .filter(month -> month.getMonthNumber() == monthNumber)
                .findFirst()
                .orElseGet(() -> new Month(0, "nope", "nope", "nope"));

        request.setAttribute("month", selectedMonth);


        return true;
    }
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
