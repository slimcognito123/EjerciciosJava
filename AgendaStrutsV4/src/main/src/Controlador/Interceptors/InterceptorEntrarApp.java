package controlador.interceptors;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

import static com.opensymphony.xwork2.Action.INPUT;
import static com.opensymphony.xwork2.Action.SUCCESS;

/**
 * Created by Patata kawaii on 26/01/2017.
 */
public class InterceptorEntrarApp extends AbstractInterceptor {
    private String nombre;
    private String pass;

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        if(nombre == null || pass == null) return INPUT;
        else return SUCCESS;
    }
}
