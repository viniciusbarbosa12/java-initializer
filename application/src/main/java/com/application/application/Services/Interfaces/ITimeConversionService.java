package com.application.application.Services.Interfaces;

import com.application.application.Models.Times.Times;
import com.application.application.Params.Times.TimesParams;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ITimeConversionService {
    public Times GetTimeConverted(String s) throws Exception;
    List<Times> findByMilitariesTimesAt(String s) throws Exception;

    List<Times> getAll();

    Optional<Times> findById(Long id) throws Exception;

    Times create(TimesParams times);

    Object update(TimesParams times) throws Exception;

    void delete(Long id) throws Exception;
}
