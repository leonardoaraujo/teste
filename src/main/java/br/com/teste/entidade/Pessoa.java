package br.com.teste.entidade;



import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;

import com.fasterxml.jackson.annotation.JsonFormat;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Data
@AllArgsConstructor
@Builder
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(length = 100, nullable = true)
	private String nome;

	@Column(length = 10, nullable = true)
	private String sexo;

	@Column(length = 100, nullable = true)
	@Email(message = "{campo.email.invalido}")
	private String email;

	@CPF(message = "{campo.cpf.invalido}")
	@Column(length = 11, nullable = false, unique = true)
	@NotEmpty(message = "{campo.cpf.obrigatorio}")
	private String cpf;

	@Column(length = 100, nullable = true)
	private String naturalidade;

	@Column(length = 100, nullable = true)
	private String nacionalidade;

	@Column(nullable = false)
	@Convert(converter = Jsr310JpaConverters.LocalDateConverter.class)
	private LocalDate dataNascimento;

	@Column(nullable = false, updatable = false)
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataCadastro;

	@Column
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private LocalDateTime dataAtualizacao;

	@PrePersist
	public void prePersist() {
		setDataCadastro(LocalDateTime.now());
	}

	@PreUpdate
	public void preUpdate() {
		setDataAtualizacao(LocalDateTime.now());
	}

}
