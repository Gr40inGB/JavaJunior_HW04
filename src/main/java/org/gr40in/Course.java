package org.gr40in;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private int duration;

    public Course() {
    }

    public Course(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public Course(int id, String title, int duration) {
        this.id = id;
        this.title = title;
        this.duration = duration;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (!(object instanceof Course course)) return false;
        return id == course.id && duration == course.duration && Objects.equals(title, course.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, duration);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
