package com.gojgho.servicedomain.dto;

import com.gojgho.servicecommon.dto.AbstractDto;
import com.gojgho.servicedomain.entity.user.User;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UserDto extends AbstractDto {

  private Long userSeq;
  private String userName;
  private String userEmail;

  public static UserDto fromEntity(User entity) {
    return AbstractDto.fromEntity(UserDto.class, entity);
  }

  public User toEntity() {
    return super.createNewEntity(User.class);
  }

}
