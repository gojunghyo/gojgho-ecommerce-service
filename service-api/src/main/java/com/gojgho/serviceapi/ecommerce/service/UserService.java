package com.gojgho.serviceapi.ecommerce.service;

import com.gojgho.servicedomain.cache.UserCache;
import com.gojgho.servicedomain.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.gojgho.servicedomain.dto.UserDto;

@Service
@RequiredArgsConstructor
public class UserService {
  // class 로 private final UserRepository 부분을 record 가 대체 가능

  private final UserRepository userRepository;
  private final UserCache userCache;

  public List<UserDto> findAllUsers() {
     return userRepository.findAll()
         .stream()
         .map(UserDto::fromEntity)
         .collect(Collectors.toList());
  }

  public List<UserDto> findAll() {
    return userRepository.search()
        .stream()
        .map(UserDto::fromEntity)
        .collect(Collectors.toList());
  }

  public List<UserDto> findCacheUsers() {
    return userCache.findAll().stream()
        .map(UserDto::fromEntity)
        .collect(Collectors.toList());
  }
}
