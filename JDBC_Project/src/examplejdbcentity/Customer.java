package examplejdbcentity;

public class Customer {
	private int customerid;
	private String name;
	private String address;

	public Customer(int customerid, String name, String address) {
		super();
		this.customerid = customerid;
		this.name = name;
		this.address = address;
	}

	public int getCustomerid() {
		return customerid;
	}

	public void setCustomerid(int customerid) {
		this.customerid = customerid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer [customerid=" + customerid + ", name=" + name + ", address=" + address + ", getCustomerid()="
				+ getCustomerid() + ", getName()=" + getName() + ", getAddress()=" + getAddress() + "]";
	}

}
