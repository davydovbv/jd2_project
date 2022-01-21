package by.academy.it.user.pojo;

import lombok.Data;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "friend_request")
@Data
public class Friends {
    @Id
    @Column(name = "request_id")
    @SequenceGenerator(name = "request_pkey", sequenceName = "request_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "request_pkey")
    private Integer id;

    @OneToOne
    @JoinColumn(name = "owner_id")
    AppUser owner;

    @OneToOne
    @JoinColumn(name = "friend_id")
    AppUser friend;

    @ElementCollection(targetClass = RequestStatus.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "friend_request_status", joinColumns = @JoinColumn(name = "request_id"))
    @Enumerated(EnumType.STRING)
    Set<RequestStatus> status;
}
