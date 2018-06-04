package addressbook;

class Entity{  
    public int id;//编号  
    public long stnumber;//学号
    public String name;//姓名  
    public int age;//年龄
    public long phone;//联系电话  
    public String address;//地址
    public String email;//邮箱
	
	public String toString() {
		return " 学号=" + stnumber + ", 姓名=" + name
				+ ", 年龄=" + age + ", 电话=" + phone + ", 地址=" + address
				+ ", 邮箱=" + email ;
	}
    
}  