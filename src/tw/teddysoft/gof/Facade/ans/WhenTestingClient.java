package tw.teddysoft.gof.Facade.ans;

import static org.junit.Assert.*;

import org.junit.Test;

public class WhenTestingClient {
	
	@Test
	public void testClientA() throws ScannerException, PrinterException {
		MultiFunctionPrinter mfp  = new MultiFunctionPrinter(new Printer(100), new Scanner(), new Fax(), new LCD());
		ClientA clientAWithoutFacade = new ClientA(mfp);
		clientAWithoutFacade.copy(12);
		assertEquals(88, clientAWithoutFacade.getNumberOfPapers());
	}

	@Test
	public void testClientBOK()  {
		MultiFunctionPrinter mfp  = new MultiFunctionPrinter(new Printer(20), new Scanner(), new Fax(), new LCD());
		ClientB clientBWithoutFacade = new ClientB(mfp);
		assertEquals("Print OK.", clientBWithoutFacade.copy());
	}
	
	@Test
	public void testClientBError()  {
		MultiFunctionPrinter mfp  = new MultiFunctionPrinter(new Printer(0), new Scanner(), new Fax(), new LCD());
		ClientB clientBWithoutFacade = new ClientB(mfp);
		assertEquals("Scanner error: No paper!", clientBWithoutFacade.copy());
	}
}
