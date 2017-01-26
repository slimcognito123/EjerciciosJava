package interceptores;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class InterceptorLog extends AbstractInterceptor {
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        Object action= actionInvocation.getAction();
        /*action.setHoy(LocalDate.now());
        System.out.println("\033[36m"+LocalDateTime.now().getHour());*/
        String result = actionInvocation.invoke();
        //System.out.println(this.getClass());
        //System.out.println(result.getClass().toString());
        /*System.out.println(actionInvocation.getAction().toString());
        System.out.println(result);*/
        return result;
    }
}