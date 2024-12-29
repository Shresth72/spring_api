package com.spring.jwt.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

  private int id;
  private String name;
  private Integer marks;

  @Override
  public String toString() {
    return "Strudent {" + "id = " + id + ", name = '" + name + "'" + ", marks = " + marks + "}";
  }
}
