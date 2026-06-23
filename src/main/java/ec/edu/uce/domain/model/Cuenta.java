package ec.edu.uce.domain.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

@Entity
@Table(name="cuenta")
public class Cuenta {
    @SequenceGenerator(name="seq_cuenta_generador",sequenceName="seq_cuenta", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_cuenta_generador")
    @Id
    @Column(name="cuen_id")
    private Integer id;
    @Column(name="cuen_nombre")
    private String nombre;
    @Column(name="cuen_saldo")
    private BigDecimal saldo;
   
    public Cuenta(){

    }
    public Cuenta(BigDecimal saldo, String nombre) {
        this.saldo = saldo;
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Cuenta{");
        sb.append("id=").append(id);
        sb.append(", nombre=").append(nombre);
        sb.append(", saldo=").append(saldo);
        sb.append('}');
        return sb.toString();
    }





}
