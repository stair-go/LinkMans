package addressbook;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
/**
 * 功能函数
 */
public class Function {
	
	/*  
     * 修改联系人  
     */  
    public void update(int num,List<Entity> list){  
    	 int numover=0;
    	 boolean flag=false;
         for(Entity e : list){  //查询是否有此编号
             if(e.id==num){ 
            	flag=true;
             	break;
             }
             else
             	numover++;
         }
        if(flag==false)  
            System.out.println("查无此人！");
        else{
        	Scanner scanner = new Scanner(System.in);
            Entity e = new Entity();  
            e.id = num;  
            //输入修改信息
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
            list.set(numover,e);  
        }  
    }  
	
    /*  
     * 删除联系人  
     */  
	public boolean delete(int num, List<Entity> enlist) {
		 if(num>enlist.size())  
	            return false;  
	        else  
	            enlist.remove(num);  
	        return true;
	}
    
	/*  
     * 添加联系人  
     */  
    public boolean add(Entity e,List<Entity> list){  
        list.add(e);  
        return true;  
    }  
	/*  
     * 通过姓名查询指定联系人
     */  
    public Entity selectforname(String name,List<Entity> list){  
        Entity en = null;  
        for(Entity e : list){  
            if(e.name.equals(name))  
                en = e;  
        }  
        return en;  
    }  
    /*  
     * 通过电话查询指定联系人
     */  
    public Entity selectforphone(long phone, List<Entity> list) {
    	Entity en = null;  
        for(Entity e : list){  
            if(e.phone==phone)  
                en = e;  
        }  
        return en; 
		
	}
	/**
	 * 接受传递的List集合,输出txt文件在根目录下,保存数据
	 * @param list
	 * @throws IOException
	 */
	public void sava(List<Entity> list) throws IOException{
		BufferedWriter bw = new BufferedWriter(new FileWriter(new File("C:\\Users\\Administrator\\Desktop\\联系人通讯录.txt")));//打开输出流,存储文件在D盘根目录下
		 for(Entity e : list){  //遍历集合
			bw.write(e.toString());//写入数据
			bw.flush();//刷新文件
			System.out.println("添加"+e.name+"..."+"数据成功");
		 }
		bw.close();//关闭输出流
		
	}
	


	


	
}
