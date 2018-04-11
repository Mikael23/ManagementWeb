package management.services.Interfaces;

import management.ORM.entity.AllUsers;
import management.UnauthorizedException;
import org.springframework.stereotype.Service;

@Service
public interface TokenInter {

   String getToken(AllUsers allUsers) throws UnauthorizedException;
   boolean checkToken(String token) throws UnauthorizedException;

}
