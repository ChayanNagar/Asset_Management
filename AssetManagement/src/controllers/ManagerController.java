package controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import bean.AssetBean;
import bean.RequestBean;
import bean.UserBean;
import dao.EmpDao;
import dao.ManagerDao;

@Controller
public class ManagerController {
	@RequestMapping("/managerHome")
 	public String employeeHome()
 	{
    	 
 	   return "ManagerHome";
 	}
	@RequestMapping("/createManagerRequest")
    public ModelAndView userStatus(@ModelAttribute AssetBean e)//Model Attribute annotation as method parameter
 	{
			ManagerDao m=new ManagerDao();

	  		ArrayList<AssetBean> list= m.getAssetDetails();

 		ModelAndView mv=null;
 		
 		 			mv=new ModelAndView("ManagerAssetRequest") ;  
 		            mv.addObject("LIST",list);
 		
 		   return mv;
 	}
	 @RequestMapping("/managerAssetRequest")
	 	public ModelAndView empAssetRequest(HttpServletRequest request,@RequestParam String assetname)//Model Attribute annotation as method parameter
	 	{
		// System.out.println(assetname);
		     String s[]=assetname.split("#");
		    // System.out.println(s[0]);
		     //System.out.println(s[1]);
		     HttpSession session=request.getSession();
		 	int eid=(Integer)session.getAttribute("eid");
        
		 			 		
		     ManagerDao m=new ManagerDao();
		    
		     //to get Manager id to request table
		   //  ArrayList<UserBean> list1=m.getManagerId(eid);
		    			
	 			RequestBean r=new RequestBean();
	 			r.setAssetname(s[1]);
	 			r.setAid(Integer.parseInt(s[0]));
	 			
	 			r.setStatus(0);
	 			r.setEid(0);
	 			//for(UserBean e:list1)
	 			r.setMid(eid);
	 		    r.setManagerApprovedDate(null);
	 			
	 		ModelAndView mv=null;
	 		
	 		int x= m.managerAssetRequest(r);
	 		   if(x==1)
	 		   {
	 			  mv=new ModelAndView("ManagerAssetRequest","msg","Request Raised Succesfully") ; 

	 			  ArrayList<AssetBean> list= m.getAssetDetails();
	 			 
	 			 	 			mv.addObject("LIST",list);
	 		   }
	 		   else {
	 			   mv=new ModelAndView("ManagerAssetRequest","msg","Request not raised") ;
	 			  ArrayList<AssetBean> list= m.getAssetDetails();
		 			 
	 	 			mv.addObject("LIST",list);

	 		   }
	 		   return mv;
	 	}

	 @RequestMapping("/viewManagerRequest")
	  	public ModelAndView viewUserDetails(HttpServletRequest request,@ModelAttribute RequestBean e)//Model Attribute annotation as method parameter
	  	{
	  			ManagerDao m=new ManagerDao();
	  			 HttpSession session=request.getSession();
	 		 	int eid=(Integer)session.getAttribute("eid");
	            //System.out.println(eid);
	  		ModelAndView mv=null;
	  		
	  		ArrayList<RequestBean> list= m.viewManagerRequest(eid);

	  		mv=new ModelAndView("ViewManagerRequest") ;
					 mv.addObject("LIST",list);
			 return mv;    
	  		  	}

	 @RequestMapping("/empPendingRequest")
	  	public ModelAndView empPendingRequest(HttpServletRequest request,@ModelAttribute RequestBean e)//Model Attribute annotation as method parameter
	  	{
	  			ManagerDao m=new ManagerDao();
	  			 HttpSession session=request.getSession();
	 		 	int eid=(Integer)session.getAttribute("eid");
	           //System.out.println(eid);
	  		ModelAndView mv=null;
	  		
	  		ArrayList<RequestBean> list= m.viewEmpPendingRequest(eid);

	  		mv=new ModelAndView("ViewEmpPendingRequest") ;
					 mv.addObject("LIST",list);
			 return mv;    
	  		  	}


}
