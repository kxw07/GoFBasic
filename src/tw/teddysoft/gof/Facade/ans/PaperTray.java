package tw.teddysoft.gof.Facade.ans;

import java.util.ArrayList;
import java.util.List;

public class PaperTray {
	private List<Paper> papers;
	
	public PaperTray() {
		papers = new ArrayList<>();
	}
	
	public PaperTray(int initNumberOfPapers){
		papers = new ArrayList<>();
		for(int i = 0; i <initNumberOfPapers; i++)
			papers.add(new Paper());
	}
	
	public boolean print(Image image) throws PrinterException {
		if(!hasPaper())
			throw new PrinterException("No paper!");
		
		if (null != image) {
			Paper paper = loadPaper();
			// print image to the loaded paper
			return true;
		}
		return false;
	}
	
	public boolean hasPaper(){
		if (0 == papers.size())
			return false;
		else
			return true;
	}

	public Paper loadPaper() {
		return papers.remove(papers.size()-1);
	}

	public void addPaper(Paper paper) {
		papers.add(paper);
	}
	
	public int numberOfPapers(){
		return papers.size();
	}
}
