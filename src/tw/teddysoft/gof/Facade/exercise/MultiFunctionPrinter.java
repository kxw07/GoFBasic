package tw.teddysoft.gof.Facade.exercise;

public class MultiFunctionPrinter {
    private final Printer printer;
    private final Scanner scanner;
    private final Fax fax;
    private final LCD lcd;

    public MultiFunctionPrinter(Printer printer, Scanner scanner, Fax fax, LCD lcd) {
        this.printer = printer;
        this.scanner = scanner;
        this.fax = fax;
        this.lcd = lcd;
    }

    public void copy() {
        try {
            scanner.warmup();
            printer.print(scanner.start());
            lcd.display("Print OK.");
        } catch (ScannerException e) {
            lcd.display("Scanner error: Internal error.");
        } catch (PrinterException e) {
            lcd.display("Scanner error: No paper!");
        }
    }

    public String getLCDMessage() {
        return lcd.getMessage();
    }

    public int getNumberOfPapers() {
        return printer.getPaperTray().numberOfPapers();
    }
}
