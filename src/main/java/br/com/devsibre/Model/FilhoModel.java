package br.com.devsibre.Model;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.devsibre.Enuns.StatusEnum;

@Entity
@Table(name = "filhos")
public class FilhoModel {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String nome;
    private String telefone;
    private String email;
    private String dataNascProl;
    @Enumerated(EnumType.STRING)
    private StatusEnum seBatizado;
    @Enumerated(EnumType.STRING)
    private StatusEnum status;    
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "familia_id")
    private ConjugeModel familia;
    
    public FilhoModel() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDataNascProl() {
		return dataNascProl;
	}

	public void setDataNascProl(String dataNascProl) {
		this.dataNascProl = dataNascProl;
	}

	public StatusEnum getSeBatizado() {
		return seBatizado;
	}

	public void setSeBatizado(StatusEnum seBatizado) {
		this.seBatizado = seBatizado;
	}

	public StatusEnum getStatus() {
		return status;
	}

	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	public ConjugeModel getFamilia() {
		return familia;
	}

	public void setFamilia(ConjugeModel familia) {
		this.familia = familia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataNascProl, email, familia, id, nome, seBatizado, status, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FilhoModel other = (FilhoModel) obj;
		return Objects.equals(dataNascProl, other.dataNascProl) && Objects.equals(email, other.email)
				&& Objects.equals(familia, other.familia) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome) && seBatizado == other.seBatizado && status == other.status
				&& Objects.equals(telefone, other.telefone);
	}

	@Override
	public String toString() {
		return "FilhoModel [id=" + id + ", nome=" + nome + ", telefone=" + telefone + ", email=" + email
				+ ", dataNascProl=" + dataNascProl + ", seBatizado=" + seBatizado + ", status=" + status + ", familia="
				+ familia + "]";
	}
	
	
}
