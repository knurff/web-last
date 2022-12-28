package com.example.web.service;


import com.example.web.exception.ScheduleNotFoundException;
import com.example.web.model.Schedule;
import com.example.web.repository.ScheduleRepository;
import java.util.List;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ScheduleService {

  ScheduleRepository repository;

  public List<Schedule> getAll() {
    return repository.findAll();
  }

  public Schedule getByIdOrThrowException(Integer scheduleId) {
    return getOrElseThrow(scheduleId);
  }

  public Schedule create(Schedule Schedule) {
    return repository.save(Schedule);
  }

  public Schedule edit(Schedule schedule, Integer scheduleId) {
    Schedule ScheduleFromDb = getOrElseThrow(scheduleId);
    ScheduleFromDb.setName(schedule.getName());
    ScheduleFromDb.setTeacher(schedule.getTeacher());
    ScheduleFromDb.setDiscipline(schedule.getDiscipline());
    ScheduleFromDb.setGroup(schedule.getGroup());
    ScheduleFromDb.setTime(schedule.getTime());
    ScheduleFromDb.setClassroom(schedule.getClassroom());
    return repository.save(schedule);
  }

  public void delete(Integer scheduleId) {
    repository.deleteById(scheduleId);
  }

  private Schedule getOrElseThrow(Integer scheduleId) {
    return repository.findById(scheduleId)
        .orElseThrow(() -> new ScheduleNotFoundException(
            String.format("Schedule with id %s does not exist", scheduleId)));
  }

}
