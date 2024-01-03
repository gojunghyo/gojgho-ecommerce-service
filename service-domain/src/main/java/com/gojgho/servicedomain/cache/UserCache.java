package com.gojgho.servicedomain.cache;

import com.gojgho.servicedomain.entity.user.User;
import com.gojgho.servicedomain.repository.UserRepository;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class UserCache {

  //캐시에 저장될 엔트리의 개수
  private static final int CACHE_MAXIMUM_SIZE = 1;

  //캐시 유지 시간
  private static final int CACHE_EXPIRATION_MINUTES = 20;
  private static final String CACHE_KEY_NAME = "user-items";

  private final LoadingCache<String, List<User>> users;
  private final UserRepository userRepository;

  @Autowired
  public UserCache(UserRepository userRepository) {
    this.userRepository = userRepository;

    this.users = CacheBuilder.newBuilder()
        .maximumSize(CACHE_MAXIMUM_SIZE)
        .expireAfterAccess(CACHE_EXPIRATION_MINUTES, TimeUnit.SECONDS)
        .build(CacheLoader.from(this::load));
  }

  private List<User> load(final String key) {
    return userRepository.findAll().stream()
        .collect(Collectors.toUnmodifiableList());
  }

  public List<User> findAll() {
    return users.getUnchecked(CACHE_KEY_NAME);
  }
}
