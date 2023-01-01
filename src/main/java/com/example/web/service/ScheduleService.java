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
  TeacherService teacherService;
  DisciplineService disciplineService;
  GroupService groupService;

  public List<Schedule> getAll() {
    return repository.findAll();
  }

  public Schedule getByIdOrThrowException(Integer scheduleId) {
    return getOrElseThrow(scheduleId);
  }

  public Schedule create(Schedule schedule, Integer teacherId, Integer disciplineId, Integer groupId) {
    schedule.setTeacher(teacherService.getByIdOrThrowException(teacherId));
    schedule.setDiscipline(disciplineService.getByIdOrThrowException(disciplineId));
    schedule.setGroup(groupService.getByIdOrThrowException(groupId));
    return repository.save(schedule);
  }

  public Schedule edit(Schedule schedule, Integer scheduleId, Integer teacherId, Integer disciplineId, Integer groupId) {
    Schedule ScheduleFromDb = getOrElseThrow(scheduleId);
    ScheduleFromDb.setName(schedule.getName());
    ScheduleFromDb.setTeacher(teacherService.getByIdOrThrowException(teacherId));
    ScheduleFromDb.setDiscipline(disciplineService.getByIdOrThrowException(disciplineId));
    ScheduleFromDb.setGroup(groupService.getByIdOrThrowException(groupId));
    ScheduleFromDb.setTime(schedule.getTime());
    ScheduleFromDb.setClassroom(schedule.getClassroom());
    return repository.save(ScheduleFromDb);
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
