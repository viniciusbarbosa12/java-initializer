package com.application.application.Services;


import com.application.application.Models.Times.Times;
import com.application.application.Params.Times.TimesParams;
import com.application.application.Repositories.ITimesRepository;
import com.application.application.Services.Interfaces.ITimeConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TimeConversionService implements ITimeConversionService {

    @Autowired
    public ITimesRepository repository;


    private static String TimeConversion(String time) {
        StringBuilder timeConverted = new StringBuilder();

        String hour = time.substring(0, 2);
        String amPmIndicator = time.substring(8);

        if (amPmIndicator.equals("AM")) {
            if (hour.equals("12")) {
                hour = "00";
            }
        } else {
            if (!hour.equals("12")) {
                hour = String.valueOf(Integer.parseInt(hour) + 12);
            }
        }

        timeConverted.append(hour).append(time.substring(2, 8));

        return timeConverted.toString();
    }

    @Override
    public Times GetTimeConverted(String time) throws Exception{
        return repository.findByTimeMilitary(time);
    }

    @Override
    public List<Times> findByMilitariesTimesAt(String time) throws Exception{

        if(time.length() < 2){
            time = "0" + time;
        }


        var times = repository.findByMilitariesTimesAt(time);
        List<Times> timesList = times.stream()
                .filter(Times.class::isInstance)
                .map(Times.class::cast).toList();


        return timesList;
    }

    @Override
    public List<Times> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Times> findById(Long id) throws Exception{

        return repository.findById(id);
    }

    @Override
    public Times create(TimesParams time) {
        var createTimes = new Times();
        createTimes.setTimeAmPm(time.getTimeAmPm());
        createTimes.setTimeMilitary(TimeConversion(time.getTimeAmPm()));

        repository.save(createTimes);

        return createTimes;
    }

    @Override
    public Times update(TimesParams times) throws Exception {
        try {
            var time = repository.findById(times.getId()).orElseThrow(()
                    -> new Exception("Time not found"));

            time.setTimeAmPm(times.getTimeAmPm());
            time.setTimeMilitary(TimeConversion(times.getTimeAmPm()));

            repository.save(time);
            return time;

        } catch (Exception e) {
            throw new Exception(e);
        }
    }

    @Override
    public void delete(Long id) throws Exception{
        var time = repository.findById(id).orElseThrow(()
                -> new Exception("Time not found"));

        repository.delete(time);
    }
}
