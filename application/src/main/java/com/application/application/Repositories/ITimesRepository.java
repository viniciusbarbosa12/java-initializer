package com.application.application.Repositories;

import com.application.application.Models.Times.Times;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ITimesRepository  extends JpaRepository<Times, Long> {
    Times findByTimeMilitary(String timeMilitary);

    @Query(value = "SELECT t.id, t.time_ampm, t.time_military FROM rest_crud.times as t where LEFT(t.time_military,2) = %:time%", nativeQuery = true)
    List<Times> findByMilitariesTimesAt(@Param("time") String time);
}