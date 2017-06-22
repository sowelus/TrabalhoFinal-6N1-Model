
package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;


/**
 *
 * @author Suelen A. Camargo
 * @email s-a-camargo@hotmail.com
 */
@Entity
@Table(name = "remedio")
public class Remedio implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_id", sequenceName = "seq_id_remedio", 
            allocationSize = 1)
    @GeneratedValue(generator = "seq_id", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotNull(message = "O nome não pode ser nulo")
    @Length(max = 40, message = "O nome não pode ter mais de {max} caracteres")
    @NotBlank(message = "O nome não pode ser em branco")
    @Column(name = "nome", length = 40, nullable = false)
    private String nome;   
    
    @NotNull(message = "A validade não pode ser nula")
    @Temporal(TemporalType.DATE)
    @Column(name = "validade", nullable = false)
    private Calendar validade;
    
    @NotNull(message = "O laboratorio não pode ser nulo")
    @Length(max = 40, message = "O laboratorio não pode ter mais de {max} caracteres")
    @NotBlank(message = "O laboratorio não pode ser em branco")
    @Column(name = "laboratorio", length = 40, nullable = false)
    private String laboratorio;   
    
    @NotNull(message = "A contra Indicação não pode estar nula")
    @Length(max = 40, message = "A contra Indicação não pode ter mais de {max} caracteres")
    @NotBlank(message = "A contra Indicação não pode estar em branco")
    @Column(name = "contraindicacao", length = 40, nullable = false)
    private String contraIndicacao; 
    
    @Length(max = 50, message = "A observação não pode ter mais de {max} caracteres")
    @Column(name = "observacao", length = 50)
    private String observacao;   
    
    @NotNull(message = "O tipo não pode ser nulo")
    @Length(max = 40, message = "O tipo não pode ter mais de {max} caracteres")
    @NotBlank(message = "O tipo não pode estar em branco")
    @Column(name = "tipo", length = 40, nullable = false)
    private String tipo;  
    
    @ManyToMany
    @JoinTable(name = "remediosreceita",
            joinColumns
            = @JoinColumn(name = "remedio", referencedColumnName = "nome", nullable = false),
            inverseJoinColumns
            = @JoinColumn(name = "receita", referencedColumnName = "id", nullable = false))
    private List<Receita> receitas = new ArrayList<>();
    
    public Remedio() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Calendar getValidade() {
        return validade;
    }

    public void setValidade(Calendar validade) {
        this.validade = validade;
    }

    public String getLaboratorio() {
        return laboratorio;
    }

    public void setLaboratorio(String laboratorio) {
        this.laboratorio = laboratorio;
    }

    public String getContraIndicacao() {
        return contraIndicacao;
    }

    public void setContraIndicacao(String contraIndicacao) {
        this.contraIndicacao = contraIndicacao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Remedio other = (Remedio) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    public List<Receita> getReceitas() {
        return receitas;
    }

    public void setReceitas(List<Receita> receitas) {
        this.receitas = receitas;
    }
    
}