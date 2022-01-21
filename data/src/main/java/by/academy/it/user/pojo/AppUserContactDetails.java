package by.academy.it.user.pojo;

import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_contact_details")
@Data
public class AppUserContactDetails implements Serializable {
    @Id
    @Column(name = "user_contact_details_id")
    @SequenceGenerator(name = "user_contact_details_pk", sequenceName = "user_contact_details_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_contact_details_pk")
    private Integer id;

    @Column(name = "skype")
    private String skype;

    @Column(name = "skype_visible")
    @ColumnDefault("true")
    private boolean skypeVisible;

    @Column(name = "instagram")
    private String instagram;

    @Column(name = "instagram_visible")
    @ColumnDefault("true")
    private boolean instagramVisible;

    @Column(name = "phone")
    private String phoneNumber;

    @Column(name = "phone_visible")
    @ColumnDefault("true")
    private boolean phoneVisible;

    @Column(name = "email")
    private String email;

    @Column(name = "email_visible")
    @ColumnDefault("true")
    private boolean emailVisible;
}
