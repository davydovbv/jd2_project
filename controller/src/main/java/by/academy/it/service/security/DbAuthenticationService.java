package by.academy.it.service.security;

import by.academy.it.dao.AppUserCredentialsDao;
import by.academy.it.user.pojo.AppUserCredentials;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

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
        return appUserCredentials;
    }



    public AppUserCredentials getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        return (AppUserCredentials) principal;
    }
}
