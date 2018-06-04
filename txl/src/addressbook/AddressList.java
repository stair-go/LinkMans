package addressbook;
import java.io.IOException;
import java.util.ArrayList;  
import java.util.List;  
import java.util.Scanner;  
  
  
public class AddressList {  
    static Scanner scanner = new Scanner(System.in);  
    static List<Entity> enlist = new ArrayList<Entity>();
    static int index=0;
    public static void main(String[] args) {  
        int input;  
        Function fc=new Function();
        AddressList addre = new AddressList();  
        System.out.println("===============欢迎使用同学通讯录===============");  
        do{       
            System.out.println("1、插入联系人");  
            System.out.println("2、删除联系人");  
            System.out.println("3、修改联系人");  
            System.out.println("4、查询联系人");  
            System.out.println("5、查询全部联系人");  
            System.out.println("6、输出txt文件");  
            System.out.println("0、退出系统");  
            System.out.println("请选择：");  
            input = scanner.nextInt();  
            switch(input){  
                case 1:  
                    Entity e = new Entity();  
                    e.id = index++;
                    System.out.println("请输入联系人学号：");  
                    e.stnumber = scanner.nextLong();  
                    System.out.println("请输入联系人姓名：");
                    e.name = scanner.next();  
                    System.out.println("请输入年龄：");  
                    e.age = scanner.nextInt();  
                    System.out.println("请输入电话：");  
                    e.phone = scanner.nextLong();
                    System.out.println("请输入联系地址：");
                    e.address = scanner.next();  
                    System.out.println("请输入联系人邮箱：");
                    e.email = scanner.next();  
                    fc.add(e,enlist);  
                    System.out.println("插入成功！");  
                    break;  
                case 2:  
                	for(Entity entit:enlist){  
                        System.out.println("编号:"+entit.id+"---"+entit.toString());
                    } 
                    System.out.println("请输入要删除联系人编号：");  
                    int num = scanner.nextInt();  
                    if(fc.delete(num,enlist))  
                        System.out.println("删除成功！");  
                    else  
                        System.out.println("删除失败，请确认信息是否正确！");  
                    break;  
                case 3:  //修改联系人
                	for(Entity entit:enlist){  
                        System.out.println("编号:"+entit.id+"---"+entit.toString());
                    } 
                    System.out.println("请输入要修改人编号："); 
                    int unum = scanner.nextInt();  
                    fc.update(unum,enlist);  
                    System.out.println("修改完成！");  
                    break;  
                case 4:  //查询练习人
                	System.out.println("请输入查询方式:"+" 1.通过姓名查询   2.通过电话查询");
                	int choice = scanner.nextInt();
                	switch (choice) {
					case 1:
						System.out.println("请输入要查询人姓名：");  
	                    String name = scanner.next();  
	                    Entity ent = fc.selectforname(name,enlist);  
	                    if(ent!=null){  
	                        System.out.println(ent.toString());
	                    }else{  
	                        System.out.println("查无此人！");  
	                    } 
						break;
					case 2://提供电话查询联系人
						System.out.println("请输入要查询人电话：");  
	                    long phone = scanner.nextLong();
	                    Entity ent2 = fc.selectforphone(phone,enlist);
	                    if(ent2!=null){  
	                        System.out.println(ent2.toString());
	                    }else{  
	                        System.out.println("查无此人！");  
	                    }
						break;

					default:
						System.out.println("请输入1/2!");
						break;
					}
                	
                    break;  
                case 5:  //遍历集合,打印数据
                    for(Entity entit:enlist){  
                        System.out.println(entit.toString());
                    }  
                    break;  
                case 6:  
					try {
						fc.sava(enlist);//保存联系人
					} catch (IOException e1) {//抛出IO异常
						e1.printStackTrace();
					}
                    break;
            }  
        }while(input!=0);  
        System.out.println("谢谢使用！");  
    }    
    
}  
  
