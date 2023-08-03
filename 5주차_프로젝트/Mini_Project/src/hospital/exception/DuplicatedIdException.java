package hospital.exception;

public class DuplicatedIdException extends Exception {
	public DuplicatedIdException() {
	}

	public DuplicatedIdException(String msg) {
		super(msg);
	}
}
