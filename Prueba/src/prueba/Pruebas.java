package prueba;

import beans.Descuento;
import beans.Pelicula;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

public class Pruebas {
        public static void main(String[] args) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("pruebaJPA");
            EntityManager em = emf.createEntityManager();
            EntityTransaction tx = em.getTransaction();

            Descuento descuento= new Descuento();
            descuento.setValue(50);
            descuento.setFechaFinal(LocalDate.now());

            Pelicula pelicula = new Pelicula();
            pelicula.setNombre("Tetanic");
            pelicula.setDuration(269);
            pelicula.setDescuento(descuento);

            Pelicula pelicula2 = new Pelicula();
            pelicula2.setNombre("Nalga blanca");
            pelicula2.setDuration(69);
            pelicula2.setDescuento(descuento);

            Pelicula pelicula3 = new Pelicula();
            pelicula3.setNombre("Blancanita y los siete enanieves");
            pelicula3.setDuration(169);
            pelicula3.setDescuento(descuento);
            try {
                /*em.persist(pelicula);
                tx.commit();
                //pelicula.setNombre("patata kawaii");
                Pelicula p2=em.find(Pelicula.class,1L);
                //em.refresh(pelicula);*/
                tx.begin();
                em.persist(pelicula);
                em.persist(pelicula2);
                em.persist(pelicula3);
                System.out.println("\033[33m"+pelicula.getNombre());
                System.out.println("\033[32m"+pelicula2.getNombre());
                System.out.println("\033[35m"+pelicula3.getNombre());
                System.out.println("\033[39m");
                tx.commit();
            } catch (Exception e) {
                tx.rollback();
                System.out.println(e);
            }
            String sql="select p.descuento from Pelicula p";
            Query query = em.createQuery(sql);
            List<Descuento> descuentos= query.getResultList();
            for (Descuento descuento1 : descuentos) {
                System.out.println("[35m"+descuento1.getValue());
            }
            em.close();
            emf.close();
        }
}
