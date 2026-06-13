package com.student.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.student.model.Student;
import com.student.util.DBConnection;

public class StudentDAO {

    // CREATE
    public void addStudent(Student s) {

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "insert into student values(?,?,?)")) {

            ps.setInt(1, s.getId());
            ps.setString(2, s.getName());
            ps.setString(3, s.getCourse());

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Added Successfully");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // READ
    public void viewStudents() {

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "select * from student");
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                System.out.println(
                        rs.getInt("id") + " | " +
                        rs.getString("name") + " | " +
                        rs.getString("course"));
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // UPDATE ✅ FIXED
    public void updateStudent(int id, String newName) {

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "update student set name=? where id=?")) {

            ps.setString(1, newName);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Updated Successfully");
            } else {
                System.out.println("Student ID Not Found");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // DELETE ✅ FIXED
    public void deleteStudent(int id) {

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "delete from student where id=?")) {

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Student Deleted Successfully");
            } else {
                System.out.println("Student ID Not Found");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}