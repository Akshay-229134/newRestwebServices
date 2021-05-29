package com.example.demo.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class versioningcontroller {
	
	@GetMapping("v1/person")
	public version version1(){
	return new version("Bob Charlie");
	}
	
	@GetMapping("v2/person")
	public version2 versi2(){
		return new version2(new Name("Bob","Charlie"));
		}
	
	//2nd method of versioning
	@GetMapping(value="/person/param" , params="version=1")
	public version versions1(){
	return new version("Bob Charlie");
	}
	
	@GetMapping(value="/person/param" , params="version=2")
	public version2 versis2(){
		return new version2(new Name("Bob","Charlie"));
		}
	
	//3nd method of versioning
	@GetMapping(value="/person/header", headers="X-API-VERSION=1")
	public version headerV1(){
	return new version("Bob Charlie");
	}
	
	@GetMapping(value="/person/header", headers="X-API-VERSION=2")
	public version2 headerV2(){
		return new version2(new Name("Bob","Charlie"));
		}

}
