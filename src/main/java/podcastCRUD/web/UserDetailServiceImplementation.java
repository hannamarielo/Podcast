package podcastCRUD.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import podcastCRUD.domain.User;
import podcastCRUD.domain.UserRepository;

@Service
public class UserDetailServiceImplementation implements UserDetailsService  {
	private final UserRepository userrepository;

	@Autowired
	public UserDetailServiceImplementation(UserRepository userRepository) {
		this.userrepository = userRepository;
	}

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {   
    	User curruser = userrepository.findByUsername(username);
        UserDetails user = new org.springframework.security.core.userdetails.User(username, curruser.getPassword(), 
        		AuthorityUtils.createAuthorityList(curruser.getRole()));
        return user;
    }   
} 