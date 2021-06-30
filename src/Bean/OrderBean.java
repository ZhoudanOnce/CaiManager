package Bean;

public class OrderBean {

	private int id;
	private String order_name;
	private String date;
	private String want;
	private int status;
	private String user_name;
	private String user_mobile;
	private String user_address;

	public OrderBean() {
	}

	public OrderBean(int id, String order_name, String date, String want, int status, String user_name,
			String user_mobile, String user_address) {
		this.id = id;
		this.order_name = order_name;
		this.date = date;
		this.want = want;
		this.status = status;
		this.user_name = user_name;
		this.user_mobile = user_mobile;
		this.user_address = user_address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getOrder_name() {
		return order_name;
	}

	public void setOrder_name(String order_name) {
		this.order_name = order_name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getWant() {
		return want;
	}

	public void setWant(String want) {
		this.want = want;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getUser_mobile() {
		return user_mobile;
	}

	public void setUser_mobile(String user_mobile) {
		this.user_mobile = user_mobile;
	}

	public String getUser_address() {
		return user_address;
	}

	public void setUser_address(String user_address) {
		this.user_address = user_address;
	}
}
