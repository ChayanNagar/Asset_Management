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
//.@SessionAttributes("uname")
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
     @RequestMapping("/ALoginCheck")
     public ModelAndView adminCheck(HttpServletRequest request,@RequestParam String uname,@RequestParam String password)
 	{
 	  ModelAndView mv=null;
 
 		int x=m.adminCheck(uname,password);
 		 if(x==1)
 		   {
 		      mv=new ModelAndView("AdminHome","msg","Welcome At Admin Home") ;
 			// mv.addObject("uname",uname);
 		     HttpSession session=request.getSession();
				session.setAttribute("uname",uname);
		
 			 return mv;    

 		   }
 		   else {
 			   mv=new ModelAndView("AdminHome","msg","Login Fail..Try Again") ;
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
    	// session.removeAttribute("uname");
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

  		mv=new ModelAndView("ViewUserDetails","msg","Welcome At Admin Home") ;
				 mv.addObject("LIST",list);
		 return mv;    
  		  	}
     @RequestMapping("/UserStatus")
     public ModelAndView userStatus(@RequestParam int userid)//Model Attribute annotation as method parameter
  	{
			MyDao m=new MyDao();

	  		ArrayList<UserBean> list= m.getUserDetailsByUid(userid);

  		ModelAndView mv=null;
  		
  		 			mv=new ModelAndView("UserStatusUpdate","msg","Welcome at Admin Home") ;  
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

   		mv=new ModelAndView("ViewAsset","msg","Welcome At Admin Home") ;
 				 mv.addObject("LIST",list);
 		 return mv;    
   		  	}

     
}
