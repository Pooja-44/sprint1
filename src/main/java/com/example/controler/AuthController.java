package com.example.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.Exception.InvalidPasswordException;
import com.example.entity.loginModel;
import com.example.entity.usermodel;
import com.example.repository.userRepository;


@RestController
@RequestMapping("/api/usermodel/")
public class AuthController
{
	
	
	
		
		@Autowired
     private  userRepository userrepository;
		
		
		@GetMapping("getAll")
		public List<usermodel>  getuser()
		{
			return userrepository.findAll();
		}
		
		
		   @PostMapping("usersignup")
		    public usermodel saveUser(@RequestBody usermodel user) throws InvalidPasswordException  {
		        user.setUserRole("user");
		        if (!user.getPassword().equals(user.getConfirmpassword())) {
		            throw new InvalidPasswordException("Password does not matches!");
		        }
		        return   userrepository.save(user);
		    }
		   
		   @PostMapping("adminsignup")
		   public usermodel saveAdmin(@RequestBody usermodel user) throws InvalidPasswordException {
		      user.setUserRole("admin");
		      user.setEmail("admin@gmail.com");
		      user.setPassword("admin");
		      user.setConfirmpassword("admin");
		      if (!user.getPassword().equals(user.getConfirmpassword())) {
		         throw new InvalidPasswordException("Password does not matches!");
		      }
		      return userrepository.save(user);
		   }
		   
		  
		  


		   
		 //user login
		    @PostMapping("userlogin")
		    public boolean isUserPresent(@RequestBody loginModel loginUser) {
		        usermodel userDB = userrepository.findByEmailAndPasswordAndUserRole(loginUser.getEmail(), loginUser.getPassword(),"user");
		        if (userDB == null)
		        return false;
		        else
		        return true;
		        
		        
		    }
		   
		  //Admin login
		    @PostMapping("adminlogin")
		    public boolean isAdminPresent(@RequestBody loginModel loginAdmin) {
		        usermodel userDB = userrepository.findByEmailAndPasswordAndUserRole(loginAdmin.getEmail(), loginAdmin.getPassword(),"admin");
		        if (userDB == null)
		            return false;
		        else
		            return true;
		    }
	
	}

