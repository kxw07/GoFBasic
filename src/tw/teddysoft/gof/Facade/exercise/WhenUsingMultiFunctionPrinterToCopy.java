package tw.teddysoft.gof.Facade.exercise;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class WhenUsingMultiFunctionPrinterToCopy {
	Printer printer;
	MultiFunctionPrinter mfp;
	@Before
	public void setup(){
		printer = new Printer();
		mfp = new MultiFunctionPrinter(
				printer, new Scanner(), new Fax(), new LCD());
	}
	@Test
	public void can_copy_when_there_is_one_paper() {
		printer.getPaperTray().addPaper(new Paper());
		 mfp.copy();
		assertEquals("Print OK.", mfp.getLCDMessage());
		assertEquals(0, mfp.getNumberOfPapers());
	}
	@Test
	public void can_make_10_copies_when_there_are_100_papers() {
		mfp = new MultiFunctionPrinter(
				new Printer(100), new Scanner(), new Fax(), new LCD());
		for(int i = 0; i < 10; i++) {
			mfp.copy();
			assertEquals("Print OK.", mfp.getLCDMessage());
		}
		assertEquals(90, mfp.getNumberOfPapers());
	}
	@Test
	public void cannot_copy_when_no_paper() {
		mfp.copy();
		assertEquals("Scanner error: No paper!", mfp.getLCDMessage());
	}
	@Test
	public void cannot_copy_when_run_out_of_paper() {
		printer.getPaperTray().addPaper(new Paper());
		mfp.copy();
		assertEquals("Print OK.", mfp.getLCDMessage());
		mfp.copy();
		assertEquals("Scanner error: No paper!", mfp.getLCDMessage());
	}
	@Test
	public void cannot_copy_with_bad_scanner() {
		mfp = new MultiFunctionPrinter(
				printer, new BadScanner(), new Fax(), new LCD());
		printer.getPaperTray().addPaper(new Paper());
		mfp.copy();
		assertEquals("Scanner error: Internal error.", mfp.getLCDMessage());
	}
	class BadScanner extends Scanner{
		@Override
		public void warmup() throws ScannerException {
			throw new ScannerException("Internal error.");
		}
	}
}
