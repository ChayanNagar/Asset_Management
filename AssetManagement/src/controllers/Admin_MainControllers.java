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
import bean.UserBean;

import dao.MyDao;


@Controller
//.@SessionAttributes("email")
public class Admin_MainControllers {
	MyDao m=null;
	
	Admin_MainControllers()
	{
		if(m==null)
			m=new MyDao();
		
	}
     @RequestMapping("/")
	public String homePage()
	{
	   return "AdminLogin";
	}
    
     @RequestMapping("/adminHome")
 	public String adminHome()
 	{
    	 
 	   return "AdminHome";
 	}
     @RequestMapping("/ALoginCheck")//Login check for admin,emp,manager,support
     public ModelAndView adminCheck(HttpServletRequest request,@RequestParam String email,@RequestParam String pwd,@RequestParam String Designation)
 	{
    	//System.out.println(email+" "+pwd+"  "+Designation);
 	  ModelAndView mv=null;
         if(Designation.equals("Admin"))
         { 		int x=m.adminCheck(email,pwd,Designation);
  		//System.out.println("x="+x);

		 if(x==1 && Designation.equals("Admin"))
 		   {
 		      mv=new ModelAndView("AdminHome") ;
 			 mv.addObject("email",email);
 		     HttpSession session=request.getSession();
				session.setAttribute("email",email);
		
 			 return mv;    

 		   }
         }
         if(Designation.equals("Employee"))
         {
 		int x=m.empCheck(email,pwd,Designation);
 		//System.out.println("x="+x);
 		 if(x==1 && Designation.equals("Employee"))
 		   {
 		      mv=new ModelAndView("EmpHome") ;
 			 mv.addObject("email",email);
 		     HttpSession session=request.getSession();
				session.setAttribute("email",email);
		
 			 return mv;    

 		   }
 		 }
          if(Designation.equals("Manager"))
         {
 		int x=m.managerCheck(email,pwd,Designation);
 		 if(x==1 && Designation.equals("Manager"))
 		   {
 		      mv=new ModelAndView("ManagerHome") ;
 			 mv.addObject("email",email);
 		     HttpSession session=request.getSession();
				session.setAttribute("email",email);
		
 			 return mv;    

 		   }
         }
          if(Designation.equals("Support"))
         {
 		int x=m.supportCheck(email,pwd,Designation);
 		 if(x==1 && Designation.equals("Support"))
 		   {
 		      mv=new ModelAndView("SupportHome") ;
 			 mv.addObject("email",email);
 		     HttpSession session=request.getSession();
				session.setAttribute("email",email);
		
		 return mv;    
		   }
        }
         else {
        	   mv=new ModelAndView("AdminLogin","msg","Login Fail..Try Again") ;
     		   }
     		   return mv;
     	
   
       }
     
     @RequestMapping("/user_Insert")
     public String userInsert()
 	{
 	 return "UserInsert";
 		
 	}
     @RequestMapping("/insertUserDetails")
 	public ModelAndView empinsert(@ModelAttribute UserBean e)//Model Attribute annotation as method parameter
 	{
 			MyDao m=new MyDao();
 		ModelAndView mv=null;
 		
 		int x= m.insertUser(e);
 		   if(x==1)
 		   {
 			mv=new ModelAndView("UserInsert","msg","Data Inserted Succesfully") ;  
 		   }
 		   else {
 			   mv=new ModelAndView("UserInsert","msg","Data not inserted") ;
 		   }
 		   return mv;
 	}
     @RequestMapping("/Logout")
     public String logout(HttpSession session){
    	// session.removeAttribute("email");
         session.invalidate();
        // System.out.println("LOGOUT INVOKED...");
         return "AdminLogin";

 	}
     @RequestMapping("/viewUserDetails")
  	public ModelAndView viewUserDetails(@ModelAttribute UserBean e)//Model Attribute annotation as method parameter
  	{
  			MyDao m=new MyDao();
  		ModelAndView mv=null;
  		
  		ArrayList<UserBean> list= m.viewUser();

  		mv=new ModelAndView("ViewUserDetails") ;
				 mv.addObject("LIST",list);
		 return mv;    
  		  	}
     @RequestMapping("/UserStatus")
     public ModelAndView userStatus(@RequestParam int userid)//Model Attribute annotation as method parameter
  	{
			MyDao m=new MyDao();

	  		ArrayList<UserBean> list= m.getUserDetailsByUid(userid);

  		ModelAndView mv=null;
  		
  		 			mv=new ModelAndView("UserStatusUpdate") ;  
  		            mv.addObject("LIST",list);
  		
  		   return mv;
  	}
     @RequestMapping("/userStatusUpdate")
  	public ModelAndView userStatusUpdate(@ModelAttribute UserBean e)//Model Attribute annotation as method parameter
  	{
  			MyDao m=new MyDao();
  		ModelAndView mv=null;
  		
  		int x= m.statusUpdateUser(e);
  		   if(x==1)
  		   { ArrayList<UserBean> list= m.viewUser();
		      mv=new ModelAndView("ViewUserDetails","msg1","Status Updated Successfully") ; 
		      mv.addObject("LIST",list);
  		   }
  		   else {
  			   mv=new ModelAndView("ViewUserDetails","msg1","Status not Updated Successfully") ;
  		   }
  		   return mv;
  	}
     @RequestMapping("/addAsset")
     public String addAsset()
 	{
 	 return "InsertAsset";
 		
 	}
     @RequestMapping("/insertAssetDetails")
  	public ModelAndView assetinsert(@ModelAttribute AssetBean e)//Model Attribute annotation as method parameter
  	{
  			MyDao m=new MyDao();
  		ModelAndView mv=null;
  		
  		int x= m.insertAsset(e);
  		   if(x==1)
  		   {
  			mv=new ModelAndView("InsertAsset","msg","Asset Inserted Succesfully") ;  
  		   }
  		   else {
  			   mv=new ModelAndView("InsertAsset","msg","Data not inserted") ;
  		   }
  		   return mv;
  	}
     @RequestMapping("/viewAsset")
   	public ModelAndView viewAssetDetails(@ModelAttribute AssetBean e)//Model Attribute annotation as method parameter
   	{
   			MyDao m=new MyDao();
   		ModelAndView mv=null;
   		
   		ArrayList<AssetBean> list= m.viewAsset();

   		mv=new ModelAndView("ViewAsset") ;
 				 mv.addObject("LIST",list);
 		 return mv;    
   		  	}

     
}
