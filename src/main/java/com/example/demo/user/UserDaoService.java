package com.example.demo.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {
	private static List<User> users=new ArrayList<>();
	private Integer usercount=3;
	
	static{
		users.add(new User(1,"Ramakant",new Date()));
		users.add(new User(2,"Ganesh",new Date()));
		users.add(new User(3,"Akash",new Date()));
		
	}
	
	public List<User> findall()
	{
		return users;
	}
	
	public User save(User client)
	{
		if(client.getId()==null){
			client.setId(++usercount);
		}
		users.add(client);
		return client;
		
	}
	public User findOne(Integer id)
	{
		for(User usser:users)
		{
			if (usser.getId()==id)
			{
				return usser;
			}
			
	}
		return null;
	}
	
	public User delete(Integer id)
	{
		for(User usser:users)
		{
			if (usser.getId()==id)
			{
				users.remove(usser);
				return usser;
			}
			
	}
		return null;
	}

}
