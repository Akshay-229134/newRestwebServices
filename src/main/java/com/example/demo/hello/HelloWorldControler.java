package com.example.demo.hello;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldControler {
	@Autowired
	public MessageSource messagesource;
	//@RequestMapping(method=RequestMethod.GET,path= "/hello-world")
	//normal
	@GetMapping(path= "/hello-world")
	public String helloWorld(){
		return "Welcome_Akshay";
	}
	
	//with bean
	@GetMapping(path= "/hello-world-bean")
	public hellobean helloWorldbean()
	{
		return new hellobean("Welcome back Akshay");
	}
	
	//with bean and parame
	@GetMapping(path= "/hello-world/path-variable/{name}")
	public hellobean helloWorld(@PathVariable String name)
	{
		return new hellobean(String.format("hello %s",name));
	}
	//for internationallization
	@GetMapping(path= "/hello-world-international")
	//public String helloWorldinternational(@RequestHeader(name="Accept-Language", required=false) Locale locale)
	public String helloWorldinternational()
	{
		return messagesource.getMessage("good.morning.message", null, LocaleContextHolder.getLocale());
	}
	
	
	

}
