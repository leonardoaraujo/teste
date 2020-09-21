package br.com.teste.rest.exception;

public class UsuarioCadastradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UsuarioCadastradoException(String login) {
		super("Usu�rio j� cadastrado para o login " + login);
	}
}
