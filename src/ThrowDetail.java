
public enum ThrowDetail {
	FAULT("F"),	
	NONE("");
	
	private String code;
	
	private ThrowDetail(String code) {
		this.code = code;
	}
}
