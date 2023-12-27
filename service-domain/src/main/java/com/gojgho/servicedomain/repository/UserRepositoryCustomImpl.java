package com.gojgho.servicedomain.repository;

import com.gojgho.servicedomain.entity.user.QUser;
import com.gojgho.servicedomain.entity.user.User;
import com.querydsl.core.types.Projections;
import java.util.List;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

public class UserRepositoryCustomImpl extends QuerydslRepositorySupport implements UserRepositoryCustom {

  public UserRepositoryCustomImpl() {
    super(User.class);
  }

  QUser user = new QUser("user");


  @Override
  public List<User> search() {
    return super.getQuerydsl().createQuery()
        .select(Projections.constructor(
            User.class
        )).from(user)
        .fetch();
  }
}
