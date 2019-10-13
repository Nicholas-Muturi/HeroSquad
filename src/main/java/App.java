import static spark.Spark.*;

import models.Hero;
import models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");

        //get: retrieve user session in homepage first
        get("/", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int totalHeroes = Hero.getHeroRegistry().size();
            int totalSquads = Squad.getAllSquads().size();
            int squadlessHeroes = 0;
            int squadfullHeroes = 0;
            for (Hero hero : Hero.getHeroRegistry()) {
                if (hero.getSquadAlliance().equalsIgnoreCase("none")) {
                    squadlessHeroes += 1;
                } else {
                    squadfullHeroes += 1;
                }
            }
            model.put("totalHeroes", totalHeroes);
            model.put("totalSquads", totalSquads);
            model.put("squadlessHeroes", squadlessHeroes);
            model.put("squadfullHeroes", squadfullHeroes);
            model.put("uniqueId", request.session().attribute("uniqueId"));
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //post: store user session - redirect back home
        post("/success", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String uniqueId = request.queryParams("uniqueId");
            request.session().attribute("uniqueId", uniqueId);
            model.put("uniqueId", uniqueId);
            return new ModelAndView(model, "session-stored.hbs");
        }, new HandlebarsTemplateEngine());


        //get: retrieve all heroes and squads

        //get: create hero page

        //post: submit a new hero - redirect to success page

        //get: each hero detail page

        //get: new squad page

        //post: create a new squad page - redirect to success page

        //get: each squad detail page

    }
}
