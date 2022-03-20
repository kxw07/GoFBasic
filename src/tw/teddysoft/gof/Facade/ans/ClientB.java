package tw.teddysoft.gof.Facade.ans;

public class ClientB {
	MultiFunctionPrinter mfp;
	
	public  ClientB(MultiFunctionPrinter mfp) {
		this.mfp = mfp;
	}
	
	public String copy() {
		 mfp.copy();
		return mfp.getLCDMessage();
	}
}
