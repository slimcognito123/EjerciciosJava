package EjerAbstract3;

import java.util.ArrayList;

/**
 * Created by curso mañana on 30/11/2016.
 */
public abstract class Menu {
    ArrayList<String> menu;

    public Menu() {
        menu = new ArrayList<>();
    }

    public void addMenu(String opcion) {
        menu.add(opcion);
    }

    public String showMenu() {
        String opcionesMenu = "";
        for (String opcion : menu) {
            opcionesMenu += opcion + "\n";
        }
        return opcionesMenu;
    }

    public abstract boolean seleccionar(int opcion);
}
