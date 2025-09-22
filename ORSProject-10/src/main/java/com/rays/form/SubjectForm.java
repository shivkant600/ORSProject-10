
package com.rays.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

import com.rays.common.BaseDTO;
import com.rays.common.BaseForm;
import com.rays.dto.SubjectDTO;

public class SubjectForm extends BaseForm {

	@NotEmpty(message = "please enter name")
	private String name;

	@Min(value = 1, message = "please enter Student Id")
	private long courseId;

	@NotEmpty(message = "please enter description")
	private String description;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public BaseDTO getDto() {

		SubjectDTO dto = initDTO(new SubjectDTO());

		dto.setName(name);
		dto.setCourseId(courseId);
		dto.setDescription(description);

		return dto;
	}
}
