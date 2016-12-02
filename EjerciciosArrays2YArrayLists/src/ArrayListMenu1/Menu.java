package ArrayListMenu1;

import java.util.ArrayList;

/**
 * Created by curso mañana on 30/11/2016.
 */
public class Menu {
    ArrayList<String> menu;

    public Menu() {
        menu=new ArrayList<>();
    }
    public void addMenu(String opcion){
        menu.add(opcion);
    }
    public void showMenu(){
        for (String opcion : menu) {
            System.out.println(opcion);
        }
    }
}
