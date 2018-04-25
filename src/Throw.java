
public class Throw {
	
	private int keelDownCount;
	
	private ThrowDetail throwDetail;
	
	public Throw(int keelsDown, ThrowDetail throwDetail) {
		this.throwDetail = throwDetail;
		
		if (ThrowDetail.FAULT.equals(this.throwDetail)) {
			this.keelDownCount = 0;
		}
		else {
			this.keelDownCount = keelsDown;
		}
	}

	public int getKeelDownCount() {
		return keelDownCount;
	}

	public void setKeelDownCount(int keelDownCount) {
		this.keelDownCount = keelDownCount;
	}

	public ThrowDetail getThrowDetail() {
		return throwDetail;
	}

	public void setThrowDetail(ThrowDetail throwDetail) {
		this.throwDetail = throwDetail;
	}
}
