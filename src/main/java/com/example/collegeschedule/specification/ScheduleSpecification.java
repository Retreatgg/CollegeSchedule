package com.example.collegeschedule.specification;

import com.example.collegeschedule.model.Schedule;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalTime;

public class ScheduleSpecification {
    public static Specification<Schedule> hasGroupId(Long groupId) {
        return (r, q, cb) -> {
            if(groupId == 0) return cb.conjunction();
            return cb.equal(r.get("group").get("id"), groupId);
        };
    }

    public static Specification<Schedule> hasTeacher(Long teacherId) {
        return (r, q, cb) -> {
            if(teacherId == 0) return cb.conjunction();
            return cb.equal(r.get("teacher").get("id"), teacherId);
        };
    }

    public static Specification<Schedule> hasAudience(Long audienceId) {
        return (r, q, cb) -> {
            if(audienceId == 0) return cb.conjunction();
            return cb.equal(r.get("audience").get("id"), audienceId);
        };
    }

    public static Specification<Schedule> hasDiscipline(Long disciplineId) {
        return (r, q, cb) -> {
            if(disciplineId == 0) return cb.conjunction();
            return cb.equal(r.get("discipline").get("id"), disciplineId);
        };
    }

    public static Specification<Schedule> hasDayOfWeek(String dayOfWeek) {
        return (r, q, cb) -> {
            if(dayOfWeek.equals("default")) return cb.conjunction();
            return cb.equal(r.get("dayOfWeek"), dayOfWeek);
        };
    }

    public static Specification<Schedule> betweenTime(LocalTime startTime, LocalTime endTime) {
        return (root, query, criteriaBuilder) -> {
            if (startTime == null && endTime == null) {
                return criteriaBuilder.conjunction();
            }

            if (startTime != null && endTime == null) {
                return criteriaBuilder.greaterThanOrEqualTo(root.get("startTime"), startTime);
            }

            if (startTime == null && endTime != null) {
                return criteriaBuilder.lessThanOrEqualTo(root.get("endTime"), endTime);
            }

            return criteriaBuilder.and(
                    criteriaBuilder.greaterThanOrEqualTo(root.get("startTime"), startTime),
                    criteriaBuilder.lessThanOrEqualTo(root.get("endTime"), endTime)
            );
        };
    }

    public static Specification<Schedule> hasCourse(Integer course) {
        return (r, q, cb) -> cb.equal(r.get("group").get("course"), course);
    }

}
