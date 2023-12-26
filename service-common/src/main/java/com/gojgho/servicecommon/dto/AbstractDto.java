package com.gojgho.servicecommon.dto;

import com.gojgho.servicecommon.utils.ObjectCopyUtils;
import java.io.Serializable;
import org.springframework.beans.BeanUtils;

public abstract class AbstractDto implements Serializable {

  private final String[] ignoredProperties = {
      "createUser", "createDate", "updateUser", "updateDate"
  };

  protected <T> T createNewEntity(final Class<T> entityType, final String... ignoredProperties) {
    T entityInstance = BeanUtils.instantiateClass(entityType);

    this.copyToEntity(entityInstance, ignoredProperties);

    return entityInstance;
  }

  protected  static <T extends AbstractDto> T fromEntity(final Class<T> type, final Object entity) {
    return ObjectCopyUtils.copyNewObject(entity, type);
  }

  private <T> void copyToEntity(final T entity, String... ignoredProperties) {
     ObjectCopyUtils.copyObject(this, entity, ignoredProperties);
  }


}
