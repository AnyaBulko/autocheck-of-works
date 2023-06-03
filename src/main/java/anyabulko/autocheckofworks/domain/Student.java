package anyabulko.autocheckofworks.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

@Entity
@EqualsAndHashCode(of = {"id"})

public class Student {
    @Id
    @Column(name = "user_id")
    @JsonIgnore
    private Long id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "user_id")
    @JsonView(Views.idName.class)
    private User user;
    @JsonView(Views.idName.class)
    private String studentGroup;

    @ManyToOne
    @JoinColumn(name="teacher_id")
    private Teacher teacher;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStudentGroup() {
        return studentGroup;
    }

    public void setStudentGroup(String studentGroup) {
        this.studentGroup = studentGroup;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}

