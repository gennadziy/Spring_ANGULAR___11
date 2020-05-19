package Spring_ANGULAR.Spring_ANGULAR;

/*
@Author Gennadziy GITHUB/gennadziy
Class name: Contr
Date: 2020-04-04
Time: 20:21
*/

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import springfox.documentation.annotations.ApiIgnore;

@Controller
@ApiIgnore
@Api(value = "Test API Controller", hidden=true)
public class Contr {

    @GetMapping("/")
    public String index(){
        return "redirect:/swagger-ui.html#/";
    }
}
