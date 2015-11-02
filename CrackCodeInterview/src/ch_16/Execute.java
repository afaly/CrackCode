package ch_16;

public interface Execute {

	public static enum Status {
		OK(0), ERR(1);
		int value;

		Status(int value) {
			this.value = value;
		}
	};

	public Status execute(int workId, String workNm);

}
