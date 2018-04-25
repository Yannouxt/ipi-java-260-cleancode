import java.util.LinkedList;

public class CasualFrame extends AbstractFrame {
	
	@Override
	int getThisNextFrameStrikeBonus(LinkedList<AbstractFrame> frames) {
		AbstractFrame nextFrame = frames.get(frames.indexOf(this)+1);
		return nextFrame.getFirstThrow().getKeelDownCount() + nextFrame.getSecondThrow().getKeelDownCount();
	}

	@Override
	int getThisNextFrameSpareBonus(LinkedList<AbstractFrame> frames) {
		AbstractFrame nextFrame = frames.get(frames.indexOf(this)+1);
		return nextFrame.getFirstThrow().getKeelDownCount();
	}

	public CasualFrame(int i, int j, ThrowDetail throwDetail, ThrowDetail throwDetail2) {
		this.firstThrow = new Throw(i, throwDetail);
		this.secondThrow = new Throw(j, throwDetail2);
		searchForParticularitiesInThrows();
	}
}
