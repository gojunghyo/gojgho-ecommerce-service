package com.gojgho.servicedomain.repository;

import com.gojgho.servicedomain.entity.user.User;
import java.util.List;

public interface UserRepositoryCustom {

  List<User> search();
}
