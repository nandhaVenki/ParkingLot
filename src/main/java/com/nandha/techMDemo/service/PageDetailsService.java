package com.nandha.techMDemo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.nandha.techMDemo.pojos.DebugInfo;
import com.nandha.techMDemo.pojos.Response;


@Service
public class PageDetailsService {

	
	public Response getDetails() {
		// TODO Auto-generated method stub
		
		Response ret = new Response();
		ret.setStatus("OK");
		ret.setStatusCode(200);
		ret.setFetchSize(100);
		ret.setPageNumber(2);
		ret.setTotalPages(21);
		ret.setTotalRecords(500);
		
		List<String> ls1= new ArrayList<String>();
		
		ret.setErrorMessages(ls1);
		
		DebugInfo di = new DebugInfo();
		
		di.setRequestProcessingTime(null);
		di.setStoreProcessingTime(null);
		
		ret.setDebugInfo(di);
		
		ret.setUniqueJobId(null);
		
		ret.setMessage("Ariba, Inc. All Rights Reserved");
		ret.setDefaultClusterName("ads-v-d2c1cb2-364-1684817049");
		
		
		return ret;
	}

}
