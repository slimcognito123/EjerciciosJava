package Example;

import com.opensymphony.xwork2.ActionSupport;

public class HolaMundoAction extends ActionSupport {
    private String saludo = "¡Hola a todos! ";

    public String execute() throws Exception {
        return SUCCESS;
    }

    public String getSaludo() {
        return saludo;
    }

    public void setSaludo(String saludo) {
        this.saludo = saludo;
    }
}