package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;

import bean.AdminBean;
import bean.AssetBean;
import bean.UserBean;



public class MyDao {
public MyDao()
{

	SessionFactory sf=new AnnotationConfiguration().configure().buildSessionFactory();
	AdminBean a=new AdminBean();
	a.setEmail("chayan@gmail.com");
	a.setPwd("chayan");
    a.setDesignation("Admin");
	Session ss=sf.openSession();
	Transaction tt=ss.beginTransaction();
	ss.saveOrUpdate(a);
	tt.commit();
	ss.close();
	
		
}
public int  adminCheck(String email,String password,String Designation)//method for admin login check
{  	
	SessionFactory sf=new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
int x=0;
	 Session ss=sf.openSession();
      //Transaction tt=ss.beginTransaction();

	Criteria ct=ss.createCriteria(AdminBean.class);
	
	ct.add(Restrictions.eq("email", email));
	ct.add(Restrictions.eq("pwd", password));
	ct.add(Restrictions.eq("Designation", Designation));
	ArrayList<AdminBean> list=(ArrayList<AdminBean>)ct.list();
     
			if(list.isEmpty())
    	 x=0;
     else
    	 x=1;
     
     
     
      ss.close();
      return x;
}
public int  empCheck(String email,String password,String Designation)//method for emp login check
{  	
	SessionFactory sf=new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
int x=0;
	 Session ss=sf.openSession();
      //Transaction tt=ss.beginTransaction();

	Criteria ct=ss.createCriteria(UserBean.class);
	ct.add(Restrictions.eq("email", email));
	ct.add(Restrictions.eq("pwd", password));
	ct.add(Restrictions.eq("Designation", Designation));
	ArrayList<UserBean> list=(ArrayList<UserBean>)ct.list();
	
	 if(list.isEmpty())
    	 x=0;
     else
    	 x=1;
     
     
     
      ss.close();
      return x;
}
public int  managerCheck(String email,String password,String Designation)//method for manager login check
{  	
	SessionFactory sf=new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
int x=0;
	 Session ss=sf.openSession();
      //Transaction tt=ss.beginTransaction();

	Criteria ct=ss.createCriteria(UserBean.class);
	ct.add(Restrictions.eq("email", email));
	ct.add(Restrictions.eq("pwd", password));
	ct.add(Restrictions.eq("Designation", Designation));
	ArrayList<UserBean> list=(ArrayList<UserBean>)ct.list();

     if(list.isEmpty())
    	 x=0;
     else
    	 x=1;
     
     
     
      ss.close();
      return x;
}
public int  supportCheck(String email,String password,String Designation)//method for support login check
{  	
	SessionFactory sf=new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
int x=0;
	 Session ss=sf.openSession();
      //Transaction tt=ss.beginTransaction();

	Criteria ct=ss.createCriteria(UserBean.class);
	
	ct.add(Restrictions.eq("email", email));
	ct.add(Restrictions.eq("pwd", password));
	ct.add(Restrictions.eq("Designation", Designation));
	ArrayList<UserBean> list=(ArrayList<UserBean>)ct.list();
     if(list.isEmpty())
    	 x=0;
     else
    	 x=1;
     
     
     
      ss.close();
      return x;
}

public int insertUser(UserBean e)
{   int x=0;
	
	SessionFactory sf=new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
	Session ss=sf.openSession();
	Transaction tt=ss.beginTransaction();
	Object o=ss.save(e);
	if(o!=null)
		x=1;
	
	tt.commit();
	ss.close();
	return x;

}
public ArrayList<UserBean>   viewUser()
{   
	SessionFactory sf=new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();

	 Session ss=sf.openSession();
	
	 Criteria ct=ss.createCriteria(UserBean.class);
		ArrayList<UserBean> list=(ArrayList<UserBean>)ct.list();

      return list;
	
}
public ArrayList<UserBean> getUserDetailsByUid(int userid)
{
	SessionFactory sf=new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();

	 Session ss=sf.openSession();
	
	 Criteria ct=ss.createCriteria(UserBean.class);
		ct.add(Restrictions.eq("uid",userid));
	 ArrayList<UserBean> list=(ArrayList<UserBean>)ct.list();

   return list;

}
public int statusUpdateUser(UserBean e)
{   int x=0;
	
	SessionFactory sf=new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
	Session ss=sf.openSession();
	Transaction tt=ss.beginTransaction();
	ss.update(e);
			x=1;
	
	tt.commit();
	ss.close();
	return x;

}
public int insertAsset(AssetBean e)
{   int x=0;
	
	SessionFactory sf=new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
	Session ss=sf.openSession();
	Transaction tt=ss.beginTransaction();
	Object o=ss.save(e);
	if(o!=null)
		x=1;
	
	tt.commit();
	ss.close();
	return x;

}
public ArrayList<AssetBean>   viewAsset()
{   
	SessionFactory sf=new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();

	 Session ss=sf.openSession();
	
	 Criteria ct=ss.createCriteria(AssetBean.class);
		ArrayList<AssetBean> list=(ArrayList<AssetBean>)ct.list();

      return list;
	
}


}

