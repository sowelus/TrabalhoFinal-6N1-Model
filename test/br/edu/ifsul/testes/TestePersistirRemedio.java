package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Remedio;
import br.edu.ifsul.modelo.Medico;
import java.util.Calendar;
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
public class TestePersistirRemedio {
    
  EntityManagerFactory emf;
    EntityManager em;
    

    public TestePersistirRemedio() {

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
    public void teste() {
        boolean exception = false;
        try {
            Remedio r1 = new Remedio();
            r1.setNome("Paracetamol");
            r1.setValidade(Calendar.getInstance());
            r1.setLaboratorio("Bayer&Bayer");
            r1.setContraIndicacao("Gastrite");
            r1.setObservacao("600g");
            r1.setTipo("Faixa vermelha");               
    
            Remedio r2 = new Remedio();
            r2.setNome("Neosaldina");
            r2.setValidade(Calendar.getInstance());
            r2.setLaboratorio("Teste&Teste");
            r2.setContraIndicacao("Gastrite");
            r2.setObservacao("400g");
            r2.setTipo("Faixa Vermelha");             
                          
            em.getTransaction().begin();
            em.persist(r1);
            em.persist(r2);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            exception = true;
            
        }
        // verificando se o resultado é igual ao esperado
        Assert.assertEquals(false, exception);
    }
    
}
