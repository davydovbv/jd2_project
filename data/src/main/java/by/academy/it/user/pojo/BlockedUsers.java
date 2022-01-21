package by.academy.it.user.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "blocked_users")
@Data
public class BlockedUsers implements Serializable {

    @Id
    @Column(name = "blocked_id")
    @SequenceGenerator(name = "lead_pkey", sequenceName = "lead_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lead_pkey")
    private Integer id;

    @OneToMany(mappedBy = "id")
    private List<AppUser> appUser;

    @ManyToMany(mappedBy = "blockedUsersList")
    List<BlackListOwners> blackListOwnersList;
}
