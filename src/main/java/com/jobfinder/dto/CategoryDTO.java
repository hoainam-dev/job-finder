package com.jobfinder.dto;

import org.springframework.stereotype.Component;

@Component
public class CategoryDTO extends AbstractDTO<CategoryDTO>{

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
