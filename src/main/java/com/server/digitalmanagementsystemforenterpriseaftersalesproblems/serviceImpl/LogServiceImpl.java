package com.server.digitalmanagementsystemforenterpriseaftersalesproblems.serviceImpl;

import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.entity.OperationLog;
import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.service.LogService;
import com.server.digitalmanagementsystemforenterpriseaftersalesproblems.service.OperationLogService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.javassist.*;
import org.apache.ibatis.javassist.bytecode.CodeAttribute;
import org.apache.ibatis.javassist.bytecode.LocalVariableAttribute;
import org.apache.ibatis.javassist.bytecode.MethodInfo;
import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Component
@Slf4j
public class LogServiceImpl implements LogService {
    private static final String LOG_CONTENT = "[类名]:%s,[方法]:%s,[参数]:%s,[IP]:%s";

    private String username;

    private OperationLogService operationLogService;

    public String initUsername(String username) {
        if(!StringUtils.isEmpty(username)){
            this.username = username;
        }
        return this.username;
    }


    public void put(JoinPoint joinPoint, String methodName, String module, String description, String userName, Long userId) {
        try {
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            OperationLog log = new OperationLog();
            if (StringUtils.isEmpty(userName)) {
                username =  "未知用户";
            }

            String ip = IPUtil.getIpAddress(request);
            log.setUserId(userId);
            log.setUserName(userName);
            log.setModule(module);
            log.setCreateTime(new Date());
            log.setDescription(description);
            log.setIp(ip);
            log.setContent(operateContent(joinPoint, methodName, ip, request));
            operationLogService.insert(log);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 查询所有日志
     * @param pageNum
     * @param request
     * @return
     */
    public List<OperationLog> findAllLog(int pageNum, HttpServletRequest request) {
        return null;
    }


    public String operateContent(JoinPoint joinPoint, String methodName, String ip, HttpServletRequest request) throws ClassNotFoundException, NotFoundException {
        String className = joinPoint.getTarget().getClass().getName();
        Object[] params = joinPoint.getArgs();
        String classType = joinPoint.getTarget().getClass().getName();
        Class<?> clazz = Class.forName(classType);
        String clazzName = clazz.getName();
        Map<String,Object > nameAndArgs = getFieldsName(this.getClass(), clazzName, methodName,params);
        StringBuffer bf = new StringBuffer();
        if (!CollectionUtils.isEmpty(nameAndArgs)){
            Iterator it = nameAndArgs.entrySet().iterator();
            while (it.hasNext()){
                Map.Entry entry = (Map.Entry) it.next();
                String key = (String) entry.getKey();
                String value = JSONObject.toJSONString(entry.getValue());
                bf.append(key).append("=");
                bf.append(value).append("&");
            }
        }
        if (StringUtils.isEmpty(bf.toString())){
            bf.append(request.getQueryString());
        }
        return String.format(LOG_CONTENT, className, methodName, bf.toString(), ip);
    }

    private Map<String,Object> getFieldsName(Class cls, String clazzName, String methodName,Object[] args) throws NotFoundException {
        Map<String,Object > map=new HashMap<String,Object>();

        ClassPool pool = ClassPool.getDefault();
        ClassClassPath classPath = new ClassClassPath(cls);
        pool.insertClassPath(classPath);

        CtClass cc = pool.get(clazzName);
        CtMethod cm = cc.getDeclaredMethod(methodName);
        MethodInfo methodInfo = cm.getMethodInfo();
        CodeAttribute codeAttribute = methodInfo.getCodeAttribute();
        LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);
        if (attr == null) {
            // exception
            return map;
        }
        int pos = Modifier.isStatic(cm.getModifiers()) ? 0 : 1;
        for (int i = 0; i < cm.getParameterTypes().length; i++){
            map.put( attr.variableName(i + pos),args[i]);//paramNames即参数名
        }
        return map;
    }

}
