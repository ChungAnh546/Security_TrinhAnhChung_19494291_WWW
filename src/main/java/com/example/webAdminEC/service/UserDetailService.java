package com.example.webAdminEC.service;

import java.nio.channels.GatheringByteChannel;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.webAdminEC.model.Employee;
import com.example.webAdminEC.repostirory.EmployeeRepostirory;


@Service
public class UserDetailService implements UserDetailsService{

	@Autowired
	EmployeeRepostirory employeeRepostirory ;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Object accountRepostirory;
		// TODO Auto-generated method stub
		Employee employee =  employeeRepostirory.findEmployeeByUserName(username);
		//if(account!= null) {
			List<GrantedAuthority> grantList =new ArrayList<GrantedAuthority>();
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ADMIN");
			grantList.add(grantedAuthority);
//			System.out.println(""+account.getPassword());
//			System.out.println(""+username);
			UserDetails userDetails = new User(username,""+ employee.getPass(), grantList);
			
			return userDetails;
//		}else
//		{
//			new UsernameNotFoundException("login fail!");
//		}
		//return null;
	}
}
