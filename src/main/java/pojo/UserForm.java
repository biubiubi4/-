package pojo;

import lombok.Data;//lombok注解可以简化代码，使用注解生成一个常见方法。但有可能造成调试时找不到lombok注解生成的方法，从而无法调试

@Data//创建getter和setter、无参构造方法、toString、equals、hashCode等方法。
public class UserForm {
	private String uname;//与请求参数名称相同
	private String upass;
	private String reupass;

	/*public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public String getReupass() {
		return reupass;
	}
	public void setReupass(String reupass) {
		this.reupass = reupass;
	}*/
}
