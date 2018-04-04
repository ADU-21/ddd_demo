package com.adu21.ddd.mapper;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import ma.glasnost.orika.metadata.ClassMapBuilder;

public abstract class BaseMapper {

    private final MapperFactory mapperFactory;

    protected BaseMapper() {
        mapperFactory = new DefaultMapperFactory.Builder().build();
    }

    protected void registerByDefault(Class<?> typeA, Class<?> typeB) {
        mapperFactory.classMap(typeA, typeB).byDefault().register();
    }

    protected ClassMapBuilder<?, ?> classMap(Class<?> typeA, Class<?> typeB) {
        return mapperFactory.classMap(typeA, typeB);
    }

    public <T> T map(Object source, Class<T> targetType) {
        return mapperFactory.getMapperFacade().map(source, targetType);
    }

    public void map(Object source, Object destination) {
        mapperFactory.getMapperFacade().map(source, destination);
    }
}
