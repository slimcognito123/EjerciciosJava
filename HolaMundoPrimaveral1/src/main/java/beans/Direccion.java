package beans;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Direccion {
    private String cp;
    private String calle;

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
