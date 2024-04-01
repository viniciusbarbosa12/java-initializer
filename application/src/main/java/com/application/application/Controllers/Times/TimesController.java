package com.application.application.Controllers.Times;


import com.application.application.Models.Times.Times;
import com.application.application.Params.Times.TimesParams;
import com.application.application.Services.Interfaces.ITimeConversionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@RestController
@RequestMapping("/Times")
public class TimesController {

    private Logger logger = Logger.getLogger(TimesController.class.getName());

    @Autowired
    private ITimeConversionService service;



    @GetMapping(value = "/timesAt/{time}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Times>> findByMilitariesTimesAt(@PathVariable(value = "time") String time) throws Exception{
        var timeConverted = service.findByMilitariesTimesAt(time);
        return ResponseEntity.ok(timeConverted);
    }

    @GetMapping(value = "/GetTimeConverted/{time}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Times> getTimeConverted(@PathVariable(value = "time") String time) throws Exception{
        var timeConverted = service.GetTimeConverted(time);
        return ResponseEntity.ok(timeConverted);
    }


    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Times>> findAll() {

        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Optional<Times>> findBydId(@PathVariable(value = "id") Long id) throws Exception {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Times> create(@RequestBody TimesParams times) throws Exception {
        return ResponseEntity.ok(service.create(times));
    }


    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity update(@RequestBody TimesParams times) throws Exception {
        return ResponseEntity.ok(service.update(times));
    }


    @DeleteMapping(value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity delete(@PathVariable(value = "id") Long id) throws Exception {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }


}
