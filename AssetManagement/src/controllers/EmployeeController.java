package controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import bean.AssetBean;
import bean.RequestBean;
import bean.UserBean;
import dao.EmpDao;
import dao.MyDao;

@Controller
@SessionAttributes("eid")
public class EmployeeController {
	@RequestMapping("/empHome")
 	public String employeeHome()
 	{
    	 
 	   return "EmpHome";
 	}
	@RequestMapping("/LogOut")
    public String logout(HttpSession session){
   	// session.removeAttribute("email");
        session.invalidate();
       // System.out.println("LOGOUT INVOKED...");
        return "AdminLogin";

	}
	@RequestMapping("/empRequest")
    public ModelAndView userStatus(@ModelAttribute AssetBean e)//Model Attribute annotation as method parameter
 	{
			EmpDao m=new EmpDao();

	  		ArrayList<AssetBean> list= m.getAssetDetails();

 		ModelAndView mv=null;
 		
 		 			mv=new ModelAndView("EmpAssetRequest") ;  
 		            mv.addObject("LIST",list);
 		
 		   return mv;
 	}
	 @RequestMapping("/empAssetRequest")
	 	public ModelAndView empAssetRequest(HttpServletRequest request,@RequestParam String assetname)//Model Attribute annotation as method parameter
	 	{
		// System.out.println(assetname);
		     String s[]=assetname.split("#");
		    // System.out.println(s[0]);
		     //System.out.println(s[1]);
		     HttpSession session=request.getSession();
		 	int eid=(Integer)session.getAttribute("eid");
           
		 			 		
		     EmpDao m=new EmpDao();
		    
		     //to get Manager id to request table
		     ArrayList<UserBean> list1=m.getManagerId(eid);
		    			
	 			RequestBean r=new RequestBean();
	 			r.setAssetname(s[1]);
	 			r.setAid(Integer.parseInt(s[0]));
	 			
	 			r.setStatus(0);
	 			r.setEid(eid);
	 			for(UserBean e:list1)
	 			r.setMid(e.getMmid());
	 		    r.setManagerApprovedDate(null);
	 			
	 		ModelAndView mv=null;
	 		
	 		int x= m.empAssetRequest(r);
	 		   if(x==1)
	 		   {
	 			  mv=new ModelAndView("EmpAssetRequest","msg","Request Raised Succesfully") ; 

	 			  ArrayList<AssetBean> list= m.getAssetDetails();
	 			 
	 			 	 			mv.addObject("LIST",list);
	 		   }
	 		   else {
	 			   mv=new ModelAndView("EmpAssetRequest","msg","Request not raised") ;
	 			  ArrayList<AssetBean> list= m.getAssetDetails();
		 			 
	 	 			mv.addObject("LIST",list);

	 		   }
	 		   return mv;
	 	}

	 
	 @RequestMapping("/viewRequest")
	  	public ModelAndView viewUserDetails(HttpServletRequest request,@ModelAttribute RequestBean e)//Model Attribute annotation as method parameter
	  	{
	  			EmpDao m=new EmpDao();
	  			 HttpSession session=request.getSession();
	 		 	int eid=(Integer)session.getAttribute("eid");
	            
	  		ModelAndView mv=null;
	  		
	  		ArrayList<RequestBean> list= m.viewRequestEmp(eid);

	  		mv=new ModelAndView("ViewRequestEmp") ;
					 mv.addObject("LIST",list);
			 return mv;    
	  		  	}

 
}
