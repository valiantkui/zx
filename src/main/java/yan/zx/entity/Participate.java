package yan.zx.entity;

public class Participate {

	private int t_no;
	private String u_id;
	public int getT_no() {
		return t_no;
	}
	public void setT_no(int t_no) {
		this.t_no = t_no;
	}
	public String getU_id() {
		return u_id;
	}
	public void setU_id(String u_id) {
		this.u_id = u_id;
	}
	@Override
	public String toString() {
		return "Participate [t_no=" + t_no + ", u_id=" + u_id + "]";
	}
	
}
