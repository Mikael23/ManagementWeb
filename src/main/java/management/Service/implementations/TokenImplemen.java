package management.Service.implementations;

import management.ORM.entity.AllUsers;
import management.UnauthorizedException;
import management.services.Interfaces.TokenInter;
import management.tokens.TokenHandler;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
@Repository
public class TokenImplemen implements TokenInter {


    @Autowired
    TokenHandler tokenHandler;
    @Autowired
    EntityManager em;


    @Override
    public String getToken(AllUsers allUsers) throws UnauthorizedException {


        AllUsers allUsers1 = em.find(AllUsers.class, allUsers.email);
        System.out.println(allUsers.email);
        if (allUsers1 == null) {

            throw new UnauthorizedException("Wrong login");
        }

        String passwordDB = allUsers1.password;
        String passwordFE = allUsers.password;




        System.out.println(passwordDB);
        System.out.println(passwordFE);

        boolean checkpas = BCrypt.checkpw(passwordFE, passwordDB);



        System.out.println(checkpas);
        System.out.println(passwordFE);
        System.out.println(passwordDB);
        if (!checkpas)  {

            throw new UnauthorizedException("Wrong password");
        }

        String res = tokenHandler.generateAccessToken(allUsers1.email, LocalDateTime.now().plusDays(1));

        return res;


    }

    @Override
    public String checkToken(String token) throws UnauthorizedException {


        String emailId = tokenHandler.extractUserLogin(token);

       System.out.println("eto email" + emailId);

        AllUsers user = em.find(AllUsers.class, emailId);
        if (user == null) {

            throw new UnauthorizedException("No user");


        }

        return emailId;

    }
}
