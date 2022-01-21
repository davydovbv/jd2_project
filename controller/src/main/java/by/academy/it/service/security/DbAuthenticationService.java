package by.academy.it.service.security;

import by.academy.it.dao.AppUserCredentialsDao;
import by.academy.it.dao.AppUserDao;
import by.academy.it.user.pojo.AppUser;
import by.academy.it.user.pojo.AppUserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DbAuthenticationService implements UserDetailsService {
    @Autowired
    private AppUserCredentialsDao appUserCredentialsDao;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AppUserCredentials appUserCredentials = appUserCredentialsDao.findByUsername(username);
        if (appUserCredentials == null) {
            throw new UsernameNotFoundException("User " + username + " was not found in the database");
        }
//        Set<UserRole> roles = appUser.getRoles();
//
//        List<GrantedAuthority> grantList= new ArrayList<GrantedAuthority>();
//        if(roles!= null)  {
//            for(UserRole role: roles)  {
//                // ROLE_USER, ROLE_ADMIN,..
//                GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role.name());
//                grantList.add(authority);
//            }
//        }
//        return new User(appUser.getLogin(),
//                appUser.getPassword(),grantList);
        return appUserCredentials;
    }

    public AppUserCredentials getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        return (AppUserCredentials) principal;
    }
}
