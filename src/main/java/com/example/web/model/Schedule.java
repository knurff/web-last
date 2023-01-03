package com.example.web.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import java.time.LocalDateTime;
import java.util.Objects;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.hibernate.Hibernate;

@Entity
@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Schedule {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer id;

  String name;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "teacher_id")
  Teacher teacher;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "discipline_id")
  Discipline discipline;

  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "group_id")
  Group group;

  LocalDateTime time;

  String classroom;

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    Schedule schedule = (Schedule) o;
    return id != null && Objects.equals(id, schedule.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
