
package com.rays.ctl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rays.common.BaseCtl;
import com.rays.common.DropdownList;
import com.rays.common.ORSResponse;
import com.rays.dto.RoleDTO;
import com.rays.form.RoleForm;
import com.rays.service.RoleServiceInt;


@RestController
@RequestMapping(value = "Role")
public class RoleCtl extends BaseCtl<RoleForm, RoleDTO, RoleServiceInt> {

	@Autowired
	private RoleServiceInt roleService;

	@GetMapping("/preload")
	public ORSResponse preload() {
		System.out.println("inside preload");
		ORSResponse res = new ORSResponse(true);
		RoleDTO dto = new RoleDTO();
		dto.setStatus(RoleDTO.ACTIVE);
		List<DropdownList> list = roleService.search(dto, userContext);
		res.addResult("roleList", list);
		return res;
	}

	

}
