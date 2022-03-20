package tw.teddysoft.gof.Observer.ans;

public class Result {
	private Status status;
	private String message = "";
	
	public  Result(Status status) {
		this.status = status;
	}
	public Status getStatus() {
		return status;
	}
	public String getMessage() {
		return message;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	public void setMessage(String msg) {
		message = msg;
	}
}
