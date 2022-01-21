package by.academy.it.topic.pojo;

import by.academy.it.user.pojo.AppUser;
import lombok.Data;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name = "topic")
@Data
public class Topic {
    @Id
    @Column(name = "topic_id")
    @SequenceGenerator(name = "topic_pk", sequenceName = "topic_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "topic_pk")
    private int id;

    @Column(name = "theme")
    private String theme;

    @Column(name = "description")
    private String Description;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "creator_id")
    private AppUser appUser;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "user_topic",
            joinColumns = @JoinColumn(name = "topic_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<AppUser> participants;

    @OneToMany(mappedBy = "topic", fetch = FetchType.EAGER)
    private List<TopicMessage> messages;

    @Column(name = "deleted", nullable = false)
    private boolean deleted = false;

}
