package by.academy.it.user.pojo;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "black_list_owners")
@Data
public class BlackListOwners implements Serializable {
    @Id
    @Column(name = "owners_id")
    @SequenceGenerator(name = "blocked_user_pkey", sequenceName = "blocked_user_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "blocked_user_pkey")
    private Integer id;

    @OneToMany(mappedBy = "id")
    @Column(name = "user_id")
    private List<AppUser> appUser;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "black_list", joinColumns = @JoinColumn(name = "owners_id"), inverseJoinColumns = @JoinColumn(name = "blocked_user_id"))
    private List<BlockedUsers> blockedUsersList;
}
