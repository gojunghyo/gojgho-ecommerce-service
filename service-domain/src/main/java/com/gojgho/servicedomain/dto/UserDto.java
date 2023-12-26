package com.gojgho.servicedomain.dto;

import com.gojgho.servicecommon.dto.AbstractDto;
import com.gojgho.servicedomain.entity.user.UserEntity;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class UserDto extends AbstractDto {

  private Long userSeq;
  private String userName;
  private String userEmail;

  public static UserDto fromEntity(UserEntity entity) {
    return AbstractDto.fromEntity(UserDto.class, entity);
  }

  public UserEntity toEntity() {
    return super.createNewEntity(UserEntity.class);
  }

}
