package sk.viawebtour.www.service.exception;

public class UserAlreadyExistsException extends RuntimeException {

	private static final long serialVersionUID = -7403417822866683750L;

	public UserAlreadyExistsException(final String message) {
        super(message);
    }

}
