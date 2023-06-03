package anyabulko.autocheckofworks.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;

@Entity
@EqualsAndHashCode(of = {"id"})
public class Teacher {
    @Id
    @Column(name = "user_id")
    @JsonIgnore
    private Long id;

    @MapsId
    @OneToOne
    @JoinColumn(name = "user_id")
//    @JsonView(Views.idName.class)
    private User user;



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



}
