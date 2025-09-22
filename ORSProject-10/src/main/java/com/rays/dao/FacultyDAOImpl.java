package com.rays.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rays.common.BaseDAOImpl;
import com.rays.common.UserContext;
import com.rays.dto.CollegeDTO;
import com.rays.dto.CourseDTO;
import com.rays.dto.FacultyDTO;
import com.rays.dto.SubjectDTO;

@Repository
public class FacultyDAOImpl extends BaseDAOImpl<FacultyDTO> implements FacultyDAOInt {

	@Override
	public Class<FacultyDTO> getDTOClass() {
		return FacultyDTO.class;
	}

	@Override
	protected List<Predicate> getWhereClause(FacultyDTO dto, CriteriaBuilder builder, Root<FacultyDTO> qRoot) {
		return null;
	}
	@Autowired
	CollegeDAOInt collegeDao;
	
	@Autowired
	CourseDAOInt courseDao;
	
	@Autowired
	SubjectDAOInt subjectDao;
	
	@Override
	protected void populate(FacultyDTO dto, UserContext userContext) {
		if (dto.getCollegeId() > 0) {
			CollegeDTO collegeDto = collegeDao.findByPK(dto.getCollegeId(), userContext);
			dto.setCollegeName(collegeDto.getName());
		}
		if (dto.getCourseId() > 0) {
			CourseDTO courseDto = courseDao.findByPK(dto.getCourseId(), userContext);
			dto.setCourseName(courseDto.getName());
		}
		if (dto.getSubjectId()> 0) {
			SubjectDTO subjectDto = subjectDao.findByPK(dto.getSubjectId(), userContext);
			dto.setSubjectName(subjectDto.getName());
		}
	}

}