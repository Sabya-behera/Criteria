package com.example.demo14.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

    @Entity
    public class Student {
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;

        @Column(name = "name")
        private String name;

        @Column(name = "roll_number")
        private String rollNumber;

        @Column(name = "university")
        private String university;

        public Student() {
        }

        public Student(Long id, String name, String rollNumber, String university) {
            this.id = id;
            this.name = name;
            this.rollNumber = rollNumber;
            this.university = university;
        }

        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getRollNumber() {
            return rollNumber;
        }

        public void setRollNumber(String rollNumber) {
            this.rollNumber = rollNumber;
        }

        public String getUniversity() {
            return university;
        }

        public void setUniversity(String university) {
            this.university = university;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", rollNumber='" + rollNumber + '\'' +
                    ", university='" + university + '\'' +
                    '}';
        }
    }
