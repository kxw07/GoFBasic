package tw.teddysoft.gof.Facade.ans;

public class Printer {
	private PaperTray paperTray;
	private String errorMessage;
	
	public Printer() {
		paperTray = new PaperTray();
		errorMessage = "";
	}
	public Printer(int initNumberOfPapers){
		paperTray = new PaperTray(initNumberOfPapers);
	}
	public boolean print(Image image) throws PrinterException {
		if(!paperTray.hasPaper())
			throw new PrinterException("No paper!");
		
		if (null != image) {
			Paper paper = paperTray.loadPaper();
			// print image to the loaded paper
			return true;
		}
		return false;
	}
	public PaperTray getPaperTray() {
		return paperTray;	
	}
	public String getErrorMessage() {
		return errorMessage;
	}
}
