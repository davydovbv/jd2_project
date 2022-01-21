package by.academy.it.chat.pojo;

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
import javax.persistence.OneToMany;;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.List;

@Entity
@Data
@Table(name = "chats")
public class PrivateChat {
    @Id
    @Column(name = "chat_id")
    @SequenceGenerator(name = "chat_pk", sequenceName = "chat_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "chat_pk")
    int id;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(name = "user_chat",
            joinColumns = @JoinColumn(name = "chat_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<AppUser> participants;

    @OneToMany(mappedBy = "chat", fetch = FetchType.LAZY)
    private  List<PrivateMessage> messages;
}
