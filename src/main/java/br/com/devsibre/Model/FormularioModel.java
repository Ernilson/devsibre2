package br.com.devsibre.Model;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "cadastro")
public class FormularioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id_c;
    @Column(length = 200, nullable = false)
    private String nome;
    @Column(length = 20)
    private String fone;
    @Column(length = 40)
    private String email;
    private String data;
    @Column(length = 20)
    private String status;
    private String cep;
    private String logradouro;
    private String bairro;
    private String localidade;
    private String uf;

    @OneToOne(cascade = CascadeType.ALL)
    private FamiliaModel familia;
    
    public FormularioModel() {

    }

	public FormularioModel(Long id_c, String nome, String fone, String email, String data, String status, String cep,
			String logradouro, String bairro, String localidade, String uf, FamiliaModel familia) {
		super();
		this.id_c = id_c;
		this.nome = nome;
		this.fone = fone;
		this.email = email;
		this.data = data;
		this.status = status;
		this.cep = cep;
		this.logradouro = logradouro;
		this.bairro = bairro;
		this.localidade = localidade;
		this.uf = uf;
		this.familia = familia;
	}

	public Long getId_c() {
		return id_c;
	}

	public void setId_c(Long id_c) {
		this.id_c = id_c;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getLocalidade() {
		return localidade;
	}

	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public FamiliaModel getFamilia() {
		return familia;
	}

	public void setFamilia(FamiliaModel familia) {
		this.familia = familia;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bairro, cep, data, email, familia, fone, id_c, localidade, logradouro, nome, status, uf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FormularioModel other = (FormularioModel) obj;
		return Objects.equals(bairro, other.bairro) && Objects.equals(cep, other.cep)
				&& Objects.equals(data, other.data) && Objects.equals(email, other.email)
				&& Objects.equals(familia, other.familia) && Objects.equals(fone, other.fone)
				&& Objects.equals(id_c, other.id_c) && Objects.equals(localidade, other.localidade)
				&& Objects.equals(logradouro, other.logradouro) && Objects.equals(nome, other.nome)
				&& status == other.status && Objects.equals(uf, other.uf);
	}

	@Override
	public String toString() {
		return "FormularioModel [id_c=" + id_c + ", nome=" + nome + ", fone=" + fone + ", email=" + email + ", data="
				+ data + ", status=" + status + ", cep=" + cep + ", logradouro=" + logradouro + ", bairro=" + bairro
				+ ", localidade=" + localidade + ", uf=" + uf + ", familia=" + familia + "]";
	}


   
}
