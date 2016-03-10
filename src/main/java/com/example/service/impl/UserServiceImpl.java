package com.example.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.service.UserService;
@Component("userService")
public class UserServiceImpl implements UserService {

	@Override
	public Map<String, Object> findById(int id) {
		return get(id);
	}

	@Override
	public List<Map<String, Object>> queryList() {
		List<Map<String, Object>> list = new ArrayList<>();  
        for(int i=1;i<=10;i++)  
        {  
            list.add(get(i));  
        }  
        return list; 
	}

	 private Map<String, Object> get(int id)  
	    {  
	        Map<String, Object> res = new HashMap<>();  
	        res.put("id", id);  
	        res.put("name", "项羽");  
	        res.put("type", "西楚霸王");  
	        res.put("date", "公元前232年―公元前202年");  
	        return res;  
	    }
}
