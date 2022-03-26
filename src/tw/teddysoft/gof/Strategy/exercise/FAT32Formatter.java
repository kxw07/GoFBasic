package tw.teddysoft.gof.Strategy.exercise;

public class FAT32Formatter implements Formatter {
    @Override
    public void format() {
        System.out.println("格式化為FAT32");
    }
}
