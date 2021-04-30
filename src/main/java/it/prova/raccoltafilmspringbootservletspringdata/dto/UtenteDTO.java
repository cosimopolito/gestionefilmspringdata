package it.prova.raccoltafilmspringbootservletspringdata.dto;

import it.prova.raccoltafilmspringbootservletspringdata.model.Film;
import it.prova.raccoltafilmspringbootservletspringdata.model.Utente;
import it.prova.raccoltafilmspringbootservletspringdata.utility.Utility;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.math.NumberUtils;

import javax.persistence.Column;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class UtenteDTO {
	private Long id;
 	private String username;
 	private String password;
 	private String nome;
 	private String cognome;
 	private Date dateCreated;

	// questo serve per la validazione quindi la stampa degli errori in pagina
	// non riguarda il binding a differenza dei campi sopra....ecco un buon motivo
	// per
	// disaccoppiare con un DTO...
	private List<String> errors = new ArrayList<String>();

	public UtenteDTO() {
	}

	public UtenteDTO(Long id, String username, String password, String nome, String cognome, Date dateCreated) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.nome = nome;
		this.cognome = cognome;
		this.dateCreated = dateCreated;
	}

	public UtenteDTO(String usernameInputParam, String passwordInputParam, String nomeInputParam, String cognomeParam) {
		this.username = usernameInputParam;
		this.password = passwordInputParam;
		this.nome = nomeInputParam;
		this.cognome = cognomeParam;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public void validate() {
		List<String> validationResult = new ArrayList<String>();

		if (StringUtils.isBlank(this.username))
			validationResult.add("Il campo 'Username' non può essere vuoto");
		if (StringUtils.isBlank(this.password))
			validationResult.add("Il campo 'Password' non può essere vuoto");
		if (StringUtils.isBlank(this.cognome  ))
			validationResult.add("Il campo 'Cognome' non può essere vuoto");
		if (this.dateCreated == null )
			validationResult.add("Il campo 'Durata' deve contenere valori positivi");
		if (StringUtils.isBlank(this.nome) )
			validationResult.add("Il campo 'Nome' non può essere vuoto");

		this.setErrors(validationResult);
	}

	public boolean hasErrors() {
		return this.errors != null && !this.errors.isEmpty();
	}

	public Utente buildFilmModel() {
		return new Utente(this.id, this.username, this.password, this.nome, this.cognome,
				this.dateCreated);
	}

	public static UtenteDTO buildUtenteDTOFromModel(Utente utenteModel ) {
		UtenteDTO result = new UtenteDTO(utenteModel.getId(), utenteModel.getUsername(), utenteModel.getPassword(),
				utenteModel.getNome(), utenteModel.getCognome(),utenteModel.getDateCreated());

		return result;
	}

	public static UtenteDTO createUtenteDTOFromParams(String usernameInputParam, String passwordInputParam,
                                                    String nomeInputParam, String cognomeParam, String dataCreatedParam) {

		UtenteDTO result = new UtenteDTO(usernameInputParam, passwordInputParam,nomeInputParam,cognomeParam);

		result.setDateCreated(Utility.parseDateFromString(dataCreatedParam));

		return result;
	}

	public static List<UtenteDTO> createUtenteDTOListFromModelList(List<Utente> modelListInput ) {
		return modelListInput.stream().map(UtenteEntity -> {
			return UtenteDTO.buildUtenteDTOFromModel(UtenteEntity );
		}).collect(Collectors.toList());
	}
}
