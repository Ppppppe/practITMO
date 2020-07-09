package App.Controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.*;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import App.Model.Pokemon;

import javax.servlet.http.HttpServletRequest;

@RestController
public class MainRESTController {

    static Logger LOGGER;
    static {
        try(FileInputStream ins = new FileInputStream("src\\main\\resources\\log.conf")){
            LogManager.getLogManager().readConfiguration(ins);
            LOGGER = Logger.getLogger(MainRESTController.class.getName());
        }catch (Exception ignore){
            ignore.printStackTrace();
        }
    }

    private static Logger log = Logger.getLogger(MainRESTController.class.getName());


    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public String welcome() {
        return "Welcome to PokemonAPI proxy";
    }


    @RequestMapping(value = "/base/{pokeNum}", //
            method = RequestMethod.GET, //
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Pokemon someMethod(@PathVariable("pokeNum") String pokeNum,  HttpServletRequest request) throws IOException {
        //LOGGER.log(Level.INFO,pokeNum + " ----- " + request.getRemoteAddr());
        RestTemplate restTemplate = new RestTemplate();
        Pokemon pokemon = restTemplate.getForObject("https://pokeapi.co/api/v2/pokemon/" + pokeNum, Pokemon.class);
        return pokemon;
    }

}
