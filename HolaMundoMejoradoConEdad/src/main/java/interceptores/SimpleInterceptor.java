package interceptores;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import java.time.LocalDate;

public class SimpleInterceptor extends AbstractInterceptor {
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        ActionValidar action= (ActionValidar) actionInvocation.getAction();
        action.setHoy(LocalDate.now());
        String result = actionInvocation.invoke();
        System.out.println(result);
        return result;
    }
}
