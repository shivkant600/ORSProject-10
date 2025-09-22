package com.rays.service;

import java.sql.Timestamp;
import java.util.Date;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.rays.common.BaseServiceImpl;
import com.rays.common.UserContext;
import com.rays.dao.UserDAOInt;
import com.rays.dto.UserDTO;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<UserDTO, UserDAOInt> implements UserServiceInt {

	@Transactional(readOnly = true)
	public UserDTO findByLoginId(String login, UserContext userContext) {

		return baseDao.findByUniqueKey("loginId", login, userContext);
	}

	@Override
	public UserDTO register(UserDTO dto) {

		UserContext userContext = new UserContext();
		userContext.setLoginId("root@gmail.com");

		Long id = add(dto, userContext);

		dto.setId(id);

		return dto;
	}

	public UserDTO authenticate(String loginId, String password) {
		UserDTO dto = findByLoginId(loginId, null);
		if (dto != null) {
			UserContext userContext = new UserContext(dto);
			if (password.equals(dto.getPassword())) {
				dto.setLastLogin(new Timestamp((new Date()).getTime()));
				dto.setUnsuccessfulLoginAttempt(0);
				update(dto, userContext);
				return dto;
			} else {
				dto.setUnsuccessfulLoginAttempt(1 + dto.getUnsuccessfulLoginAttempt());
				update(dto, userContext);
			}
		}
		return null;
	}
}