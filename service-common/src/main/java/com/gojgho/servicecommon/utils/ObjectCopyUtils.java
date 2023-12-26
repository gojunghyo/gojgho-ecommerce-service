package com.gojgho.servicecommon.utils;


import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.io.IOException;
import org.springframework.beans.BeanUtils;

public class ObjectCopyUtils {

  public static <S, D> D copyObject(final S source, final D destination, final String... ignoredProperties) {
    // 구현 내용 추가
    ObjectMapper objectMapper = createObjectMapper();
    objectMapper.addMixIn(Object.class, ObjectCopyUtils.PropertyFilterMixIn.class);

    FilterProvider filters
        = new SimpleFilterProvider().addFilter(
            "customPropertiesNameFilter",
        SimpleBeanPropertyFilter.serializeAllExcept(ignoredProperties)
    );

    try {
      String json = objectMapper.writer(filters).writeValueAsString(source);
      return objectMapper.readerForUpdating(destination).readValue(json);
    } catch (IOException e) {
      throw new IllegalArgumentException(e);
    }

  }

  private static ObjectMapper createObjectMapper() {
    ObjectMapper objectMapper = new ObjectMapper();

    objectMapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
    objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);

    objectMapper.setConfig(
        objectMapper.getSerializationConfig().withAttribute("copyProcessing", true)
    );

    objectMapper.registerModule(new JavaTimeModule());
    objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    return objectMapper;

  }


  public static <S, D> D copyNewObject(final S source, final Class<D> destinationType) {
    D instance = BeanUtils.instantiateClass(destinationType);
    copyObject(source, instance);
    return instance;
  }

  @JsonFilter("customPropertiesNameFilter")
  private static class PropertyFilterMixIn {
    //nothing to do
  }
}
