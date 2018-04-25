import java.util.LinkedList;
import java.util.List;

public class FinalFrame extends AbstractFrame {

	private Throw thirdThrow;

	public FinalFrame(int i, int j, int k, ThrowDetail throwDetail, ThrowDetail throwDetail2, ThrowDetail throwDetail3) {
		this.firstThrow = new Throw(i, throwDetail);
		this.secondThrow = new Throw(j, throwDetail2);
		this.thirdThrow = new Throw(k, throwDetail3);
		searchForParticularitiesInThrows();
	}
	
	@Override
	public int getThisNextFrameStrikeBonus(LinkedList<AbstractFrame> frames) {
		return this.getThirdThrow().getKeelDownCount();
	}

	@Override
	public int getThisNextFrameSpareBonus(LinkedList<AbstractFrame> frames) {
		return this.getThirdThrow().getKeelDownCount();
	}

	public Throw getThirdThrow() {
		return thirdThrow;
	}

	public void setThirdThrow(Throw thirdThrow) {
		this.thirdThrow = thirdThrow;
	}
}
