package Controlador.Interceptors;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Pattern;

import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;

public class InterceptorAnadirPersona extends AbstractInterceptor {
    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        HttpServletRequest request = ServletActionContext.getRequest();
        String telefono = (request.getParameter("tlf"));
        Pattern expresion = Pattern.compile("^[9|6|7][0-9]{8}$");
        if (expresion.matches(expresion.pattern(), telefono)) {
            return SUCCESS;
        } else {
            return INPUT;
        }
    }
}