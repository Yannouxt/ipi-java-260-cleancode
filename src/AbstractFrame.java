import java.util.LinkedList;
import java.util.List;

public abstract class AbstractFrame {
	
	protected FrameDetail frameDetail = FrameDetail.NONE;
	
	protected Throw firstThrow;
	
	protected Throw secondThrow;
	
	/** Points apportés par les lancés suivants si Strike. */
	abstract int getThisNextFrameStrikeBonus(LinkedList<AbstractFrame> frames);
	
	/** Points apportés par les lancés suivants si Spare. */
	abstract int getThisNextFrameSpareBonus(LinkedList<AbstractFrame> frames);
	
	/** Analyse les deux lancers pour établir s'il y a faute strike ou spare.*/
	public void searchForParticularitiesInThrows() {
		if (this.getFirstThrow().getKeelDownCount() == 10) {
			this.frameDetail = FrameDetail.STRIKE;
		}
		
		else if (ThrowDetail.FAULT.equals(this.firstThrow.getThrowDetail()) 
				|| (!this.frameDetail.equals(FrameDetail.STRIKE) && ThrowDetail.FAULT.equals(this.secondThrow.getThrowDetail()))) {
			this.frameDetail = FrameDetail.FAULT;
		}
		
		else if (this.getFirstThrow().getKeelDownCount() + this.getSecondThrow().getKeelDownCount() == 10) {
			this.frameDetail = FrameDetail.SPARE;
		}
	}
	

	public FrameDetail getFrameDetail() {
		return frameDetail;
	}

	public void setFrameDetail(FrameDetail frameDetail) {
		this.frameDetail = frameDetail;
	}

	public Throw getFirstThrow() {
		return firstThrow;
	}

	public void setFirstThrow(Throw firstThrow) {
		this.firstThrow = firstThrow;
	}

	public Throw getSecondThrow() {
		return secondThrow;
	}

	public void setSecondThrow(Throw secondThow) {
		this.secondThrow = secondThow;
	}
}
