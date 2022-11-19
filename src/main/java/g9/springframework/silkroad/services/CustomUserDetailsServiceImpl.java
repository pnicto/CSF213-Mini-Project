package g9.springframework.silkroad.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import g9.springframework.silkroad.repositories.UserRepository;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomUserDetailsServiceImpl implements UserDetailsService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    var myUser = userRepository.findByEmail(email);

    if (myUser.isPresent()) {
      return myUser.get();
    } else {
      throw new IllegalStateException("Cannot find user with email" + email);
    }
  }

}
