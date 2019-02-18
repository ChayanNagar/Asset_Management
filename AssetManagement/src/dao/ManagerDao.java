package dao;

import java.util.ArrayList;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.criterion.Restrictions;

import bean.AssetBean;
import bean.RequestBean;

public class ManagerDao {
	public ArrayList<AssetBean> getAssetDetails()
	{
		SessionFactory sf=new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();

		 Session ss=sf.openSession();
		
		 Criteria ct=ss.createCriteria(AssetBean.class);
			
		 ArrayList<AssetBean> list=(ArrayList<AssetBean>)ct.list();

	   return list;

	}
	public int managerAssetRequest(RequestBean e)
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
	
	public ArrayList<RequestBean> viewManagerRequest(int eid)
	{
		SessionFactory sf=new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();

		 Session ss=sf.openSession();
		
		 Criteria ct=ss.createCriteria(RequestBean.class);
			ct.add(Restrictions.eq("mid",eid));
			ct.add(Restrictions.eq("eid",0));
		 ArrayList<RequestBean> list=(ArrayList<RequestBean>)ct.list();

	   return list;

	}
	public ArrayList<RequestBean> viewEmpPendingRequest(int eid)
	{
		SessionFactory sf=new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();

		 Session ss=sf.openSession();
		
		 Criteria ct=ss.createCriteria(RequestBean.class);
			ct.add(Restrictions.eq("mid",eid));
			ct.add(Restrictions.ne("eid", 0));
		 ArrayList<RequestBean> list=(ArrayList<RequestBean>)ct.list();

	   return list;

	}

}
