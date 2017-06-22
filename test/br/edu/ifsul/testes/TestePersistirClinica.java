package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Medico;
import br.edu.ifsul.modelo.Clinica;
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
public class TestePersistirClinica {
    
  EntityManagerFactory emf;
    EntityManager em;
    

    public TestePersistirClinica() {

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
            
            Medico c = new Medico();
            c.setCremers("202020");
            c.setNome("Marcos Narcicisio Santos");
            c.setEmail("marcos.ns@centralclinicas.med");
            
            
            Clinica obj = new Clinica();
            obj.setRazaoSocial("Central das Clinicas Passo Fundo");
            obj.setEndereco("Rua Moron, Nº 777 - Centro");
            obj.setTelefone("(54)3313-0059");  
            
            obj.adicionarMedico(c);
            
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            exception = true;
            
        }
        // verificando se o resultado é igual ao esperado
        Assert.assertEquals(false, exception);
    }
    
}
