package tw.teddysoft.gof.Observer.exercise;

public class ThermalCommand implements Command {
	private Thermal thermal = null;
	
	public ThermalCommand(String ipAddress){
		thermal = new Thermal(ipAddress);
	}
	@Override
	public Result execute() {
		Result result = new Result(Status.OK);
		if (thermal.isOverheat()){
			result.setStatus(Status.CRITICAL);
			result.setMessage("溫度過熱 :" + toString());
		}
		return result;
	}
}
