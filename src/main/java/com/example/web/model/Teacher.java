package com.example.web.model;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
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
public class Teacher {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer id;

  String name;

  String surname;

  String email;

  String phone;

  @ToString.Exclude
  @OneToMany(mappedBy = "teacher", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
  Set<Schedule> schedules = new HashSet<>();
  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) {
      return false;
    }
    Teacher teacher = (Teacher) o;
    return id != null && Objects.equals(id, teacher.id);
  }

  @Override
  public int hashCode() {
    return getClass().hashCode();
  }
}
