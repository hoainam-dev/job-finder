//package com.jobfinder.converter;
//
//import org.springframework.stereotype.Component;
//
//import com.jobfinder.dto.CompanyDTO;
//import com.jobfinder.entity.CompanyEntity;
//
//@Component
//public class CompanyConverter {
//	
//	public CompanyDTO toDto(CompanyEntity entity) {
//		CompanyDTO result = new CompanyDTO();
//		result.setName(entity.getName());
//		result.setAddress(entity.getAddress());
//		result.setPhone(entity.getPhone());
//		result.setEmail(entity.getEmail());
//		result.setWebsite(entity.getWebsite());
//		return result;
//	}
//	
//	public CompanyEntity toEntity(CompanyDTO dto) {
//		CompanyEntity result = new CompanyEntity();
//		result.setName(dto.getName());
//		result.setAddress(dto.getAddress());
//		result.setPhone(dto.getPhone());
//		result.setEmail(dto.getEmail());
//		result.setWebsite(dto.getWebsite());
//		return result;
//	}
//	
//	public CompanyEntity toEntity(CompanyDTO dto, CompanyEntity result) {
//		result.setName(dto.getName());
//		result.setAddress(dto.getAddress());
//		result.setPhone(dto.getPhone());
//		result.setEmail(dto.getEmail());
//		result.setWebsite(dto.getWebsite());
//		return result;
//	}
//
//}
