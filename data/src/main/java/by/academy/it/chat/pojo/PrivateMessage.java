package by.academy.it.chat.pojo;

import by.academy.it.user.pojo.AppUser;
import lombok.Data;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "private_message")
public class PrivateMessage implements Serializable {
    @Id
    @Column(name = "message_id")
    @SequenceGenerator(name = "message_pk", sequenceName = "message_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "message_pk")
    private int id;

    @OneToOne()
    @JoinColumn(name = "sender_id")
    private AppUser sender;

    @Column(name = "created")
    private LocalDateTime created;

    @Column(name = "message_content")
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "chat_id")
    private PrivateChat chat;

}
