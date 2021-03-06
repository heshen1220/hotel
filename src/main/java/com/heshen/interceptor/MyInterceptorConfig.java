package com.heshen.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.heshen.Utils.IpUtils;
import com.heshen.Utils.TokenUtils;
import com.heshen.entity.Staff;
import com.heshen.mapper.StaffMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @author tianyuanju
 * @data 2021/11/22 15:26
 */
@Component
@Slf4j
public class MyInterceptorConfig implements HandlerInterceptor {
    @Autowired
    StaffMapper staffMapper;
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        String token = request.getHeader("token");
        if(token==null||token==""){
           return err(response,"请先登录!");
        }
        String ipAddress = IpUtils.getVisitorIp(request);
        try {

            Map<String, String> map = TokenUtils.parseToken(token, ipAddress);
            String phone = map.get("phone");
            Staff staff = staffMapper.getStaffByPhone(phone);
            if (staff == null) {
                return err(response, "登录异常,请重新登录");
            }
        }catch (Exception e){
            return err(response, "登录异常,请重新登录");
        }
        return true;
        }

        public Boolean err(HttpServletResponse response, String msg){
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            PrintWriter out = null;
            try {
                JSONObject res = new JSONObject();
                res.put("code", "401");
                res.put("message", msg);
                out = response.getWriter();
                out.append(res.toString());
                return false;
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        }
    }
