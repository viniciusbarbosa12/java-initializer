package com.application.application.Mapper;

import com.github.dozermapper.core.DozerBeanMapper;
import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.ArrayList;
import java.util.List;

public class DozerMapper {

    private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    public static <O, D> D ParseObject(O origin, Class<D> destination){
        return mapper.map(origin, destination);
    }



    public static <O, D> List<D> ParseListObject(List<O> origin, Class<D> destination){
        var destinationList = new ArrayList<D>();
        origin.forEach(item -> {
            destinationList.add(mapper.map(item, destination));
        });
        return destinationList;
    }
}
