package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Paciente;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Suelen A. Camargo
 * @email s-a-camargo@hotmail.com
 */
public class TestePersistirPaciente {
    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirPaciente() {
    }
    
    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("TrabalhoFinal-6N1-ModelPU");
        em = emf.createEntityManager();
    }
    
    @After
    public void tearDown() {
        em.close();
        emf.close();
    }
    
    @Test
    public void teste(){
        boolean exception = false;
        try {
            Paciente s = new Paciente();
            s.setNome("Suelen");
            s.setEmail("s-a-camargo@hotmail.com");
            s.setEndereco("Rua Bom Recreio, Nº 470 - Santa Marta");
            s.setTelefone("(54)3313-0058");
            
            em.getTransaction().begin();
            em.persist(s);
            em.getTransaction().commit();
        } catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        // verifica se o atributo exception ainda é falso para passar no teste
        Assert.assertEquals(false, exception);
    }
    
    
    
    
}
