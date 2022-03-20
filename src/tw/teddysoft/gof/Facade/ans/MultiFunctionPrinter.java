package tw.teddysoft.gof.Facade.ans;


public class MultiFunctionPrinter {
	private Scanner scanner;
	private Printer printer;
	private Fax fax;
	private LCD lcd;
	
	public MultiFunctionPrinter(Printer printer, Scanner scanner , 
													Fax fax,  LCD lcd) {
		this.printer = printer;
		this.scanner = scanner;
		this.fax = fax;
		this.lcd = lcd;
	}
	public void copy() {
		try{
			scanner.warmup();
			Image image = scanner.start();
			if (printer.print(image))
				lcd.display("Print OK.");
			else
				lcd.display(printer.getErrorMessage());
		}
		catch (ScannerException | PrinterException e ) {
			lcd.display("Scanner error: " + e.getMessage());
		}
	}
	public void sendFax(int phoneNumber){
		try{
			scanner.warmup();
			Image image = scanner.start();
			lcd.display(fax.send(phoneNumber, image));
		}
		catch (ScannerException e) {
			lcd.display("Scanner error: " + e.getMessage());
		}
	}	
	public String getLCDMessage() {
		return lcd.getMessage();
	}
	public int getNumberOfPapers(){
		return printer.getPaperTray().numberOfPapers();
	}
	public void print(Image image) {
		try {
			printer.print(image);
		} catch (PrinterException e) {
			lcd.display("Scanner error. " + e.getMessage());
		}
	}
}
