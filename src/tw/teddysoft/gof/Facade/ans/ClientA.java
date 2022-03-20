package tw.teddysoft.gof.Facade.ans;

public class ClientA {
	MultiFunctionPrinter mfp;
	
	public  ClientA(MultiFunctionPrinter mfp) {
		this.mfp = mfp;
	}
	
	public void copy(int copies) throws ScannerException, PrinterException{
		for(int i = 0; i < copies; i++){
			mfp.copy();
		}
	}
	
	public int getNumberOfPapers(){
		return mfp.getNumberOfPapers();
	}
}
