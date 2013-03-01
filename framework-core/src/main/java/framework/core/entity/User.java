package framework.core.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Represents the credentials needed for system authentication.
 * 
 * @author frederick
 */
@Entity
@Table(name = "USER")
public class User extends AbstractEntity {

    private static final long serialVersionUID = -7767487387897790096L;

    @Column
    private String password;

    @Column
    private Long passwordexpiration;

    @Column
    private Long profileexpiration;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Userdetails userdetails;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Usergroup usergroup;

    @Column(unique = true, nullable = false)
    private String username;

    /**
     * Returns the secret 'key' used by the user for authentication.
     * 
     * @return the secret 'key'.
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Returns the date the password is going to expire.
     * 
     * @return the password expiration date.
     */
    public Long getPasswordexpiration() {
        return this.passwordexpiration;
    }

    /**
     * Returns the date the user profile is going to expire.
     * 
     * @return the profile expiration date.
     */
    public Long getProfileexpiration() {
        return this.profileexpiration;
    }

    /**
     * Returns the user's detailed information.
     * 
     * @return the user's detailed information.
     */
    public Userdetails getUserdetails() {
        return this.userdetails;
    }

    /**
     * Returns the {@link Usergroup} of the user.
     * 
     * @return the {@link Usergroup}.
     */
    public Usergroup getUsergroup() {
        return this.usergroup;
    }

    /**
     * Returns the unique 'alias' of the user used for authentication.
     * 
     * @return unique 'alias' of the user.
     */
    public String getUsername() {
        return this.username;
    }

}
