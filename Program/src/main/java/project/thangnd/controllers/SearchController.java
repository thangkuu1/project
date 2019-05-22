package project.thangnd.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import project.thangnd.models.Restaurant;
import project.thangnd.services.RestaurantService;

@Controller
public class SearchController {
	
	Logger logger = Logger.getLogger(SearchController.class);
	@Autowired
	private RestaurantService restService;
	
	@RequestMapping(value="search")
	@ResponseBody
	public Map<String, Object> listSp(@RequestParam("key") String key){
		Map<String, Object> map = new HashMap<String, Object>();
		List<Restaurant> list_rest = new ArrayList<>();
		list_rest = restService.listRestaurantByName(key); 
		map.put("list_rest", list_rest);
		return map;
		
	}

}
