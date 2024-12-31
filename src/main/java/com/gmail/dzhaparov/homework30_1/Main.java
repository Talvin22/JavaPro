package com.gmail.dzhaparov.homework30_1;

import com.gmail.dzhaparov.homework30_1.dao.StudentDao;
import com.gmail.dzhaparov.homework30_1.entity.Homework;
import com.gmail.dzhaparov.homework30_1.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("hillel-persistence-unit");
//
//        try {
//            // Create a DAO instance
//            StudentDao studentDao = new StudentDao(entityManagerFactory);
////
////            // Create and save a new student
////            Student student = new Student();
////            student.setFirstName("John");
////            student.setLastName("Doe");
////            student.setEmail("talvin@example.com");
////
////            Homework homework1 = new Homework();
////            homework1.setDescription("Math homework");
////            homework1.setDeadline(LocalDate.now().plusDays(7));
////            homework1.setMark(0);
////            homework1.setStudent(student);
////
////            Homework homework2 = new Homework();
////            homework2.setDescription("Physics homework");
////            homework2.setDeadline(LocalDate.now().plusDays(10));
////            homework2.setMark(0);
////            homework2.setStudent(student);
////
////            student.addHomework(homework1);
////            student.addHomework(homework2);
////
////            // Save student with homeworks
////            studentDao.save(student);
//            Student byId = studentDao.findById(5L);
//            Homework homeworkToRemove = null;
//            Long targetHomeworkId = 3L;
//
//
//            for (Homework homework : byId.getHomeworks()) {
//                if (homework.getId().equals(targetHomeworkId)) {
//                    homeworkToRemove = homework;
//                    break;
//                }
//            }
//
//
//            if (homeworkToRemove != null) {
//                byId.removeHomework(homeworkToRemove);
//                studentDao.update(byId);
//            } else {
//                System.out.println("Homework not found!");
//            }
//
//            Student retrievedStudent = studentDao.findByEmail("talvin@example.com");
//            System.out.println("Retrieved Student: " + retrievedStudent);
//
//
//            retrievedStudent.getHomeworks().forEach(homework -> {
//                System.out.println("Homework: " + homework);
//            });
//
//        } catch (Exception e) {
//            System.out.println(e.getMessage());
//        } finally {
//            entityManagerFactory.close();
//        }
//    }
}}
