
public enum FrameDetail {
	FAULT("F"),
	STRIKE("X"),
	SPARE("/"),
	NONE("");
	
	private String code;
	
	private FrameDetail(String code) {
		this.code = code;
	}
}
