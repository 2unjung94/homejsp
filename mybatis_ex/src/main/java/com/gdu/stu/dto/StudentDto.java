package com.gdu.stu.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder

public class StudentDto {
  private int stu_no;
  private String name;
  private int kor;
  private int eng;
  private int math;
  private double ave;
  private String mark;
  
}
