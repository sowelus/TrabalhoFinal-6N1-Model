package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
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
@Table(name = "receita")
public class Receita implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_receita", sequenceName = "seq_receita_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_receita", strategy = GenerationType.SEQUENCE)
    private Integer id;   
    
    @NotNull(message = "A data da Prescrição não pode ser nula")
    @Temporal(TemporalType.DATE)
    @Column(name = "dataprescricao", nullable = false)
    private Calendar dataPrescricao;
   
    @NotNull(message = "A data da validade não pode ser nula")
    @Temporal(TemporalType.DATE)
    @Column(name = "datavalidade", nullable = false)
    private Calendar dataValidade;
   
    @Length(max = 50, message = "A observação não pode ter mais de {max} caracteres")
    @Column(name = "observacao", length = 50)
    private String observacao;      
        
    @NotNull(message = "O Medico não pode ser nulo")
    @ManyToOne
    @JoinColumn(name = "medico", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_receita_medico"))
    private Medico medico;
           
    @NotNull(message = "O paciente não pode ser nulo")
    @ManyToOne
    @JoinColumn(name = "paciente", referencedColumnName = "id", nullable = false,
            foreignKey = @ForeignKey(name = "fk_receita_paciente"))
    private Paciente paciente;
   
    @ManyToMany
    @JoinTable(name = "remediosreceita",
            joinColumns
            = @JoinColumn(name = "receita", referencedColumnName = "id", nullable = false),
            inverseJoinColumns
            = @JoinColumn(name = "remedio", referencedColumnName = "nome", nullable = false))
    private List<Remedio> remedios = new ArrayList<>();

    public Receita() {
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Calendar getDataPrescricao() {
        return dataPrescricao;
    }

    public void setDataPrescricao(Calendar dataPrescricao) {
        this.dataPrescricao = dataPrescricao;
    }

    public Calendar getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Calendar dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    public List<Remedio> getRemedios() {
        return remedios;
    }

    public void setRemedios(List<Remedio> remedios) {
        this.remedios = remedios;
    }
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
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
        final Receita other = (Receita) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }


  

}
