package back.kickoff.kickoffback.cotrollers;

import back.kickoff.kickoffback.Commands.FrontEnd.CourtOwnerFrontEnd;
import back.kickoff.kickoffback.Commands.Operation.LoginCommand;
import back.kickoff.kickoffback.Commands.FrontEnd.PlayerFrontEnd;
import back.kickoff.kickoffback.model.CourtOwner;
import back.kickoff.kickoffback.model.Player;
import back.kickoff.kickoffback.services.LoginService;
import com.google.gson.Gson;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

class LoginControllerTest {
    LoginController Controller;
    @Mock
    LoginService loginService;

    @BeforeEach
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        Controller = new LoginController(loginService);
    }

    @Test
    void courtOwnerLoginRequest() throws Exception {
        LoginCommand loginCommand = new LoginCommand("nasrClub@gmail.com", "12345678900");
        CourtOwner newCourtOwner = new CourtOwner("Nasr CLub", "nasrClub@gmail.com", "12345678900",
                "01206555589", 44.5, 44.5);
        newCourtOwner.setRating(0);
        newCourtOwner.setLocation("Nasr CLub");
        newCourtOwner.setImage("https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Image_created_with_a_mobile_phone.png/1200px-Image_created_with_a_mobile_phone.png");
        List list = new ArrayList();
        newCourtOwner.setCourts(list);
        CourtOwnerFrontEnd courtOwnerFrontEnd = new CourtOwnerFrontEnd(newCourtOwner);
        when(loginService.courtOwnerLogin(loginCommand)).thenReturn(courtOwnerFrontEnd);
        ResponseEntity<String> res = Controller.courtOwnerLoginRequest(loginCommand);
        assertEquals(new ResponseEntity<>(new Gson().toJson(courtOwnerFrontEnd), HttpStatus.OK), res);
    }

    @Test
    void playerLoginRequest() throws Exception {
        LoginCommand loginCommand = new LoginCommand("cr7@gmail.com", "12345678900");
        Player newPlayer = new Player("Cristiano Ronaldo", "cr7@gmail.com", "01176553539",
                "12345678900", "Lisbon Portugal",34.5, 24.5);
        PlayerFrontEnd playerFrontEnd = new PlayerFrontEnd(newPlayer);
        when(loginService.playerLogin(loginCommand)).thenReturn(playerFrontEnd);
        ResponseEntity<String> res = Controller.playerLoginRequest(loginCommand);
        assertEquals(new ResponseEntity<>(new Gson().toJson(playerFrontEnd), HttpStatus.OK), res);
    }

}