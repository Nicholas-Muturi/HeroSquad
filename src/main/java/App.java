import static spark.Spark.*;

import com.github.jknack.handlebars.Handlebars;
import models.Hero;
import models.Squad;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
                if (hero.getSquadAlliance().equals("")) {
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
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        //get: create hero page
        get("/heroes/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("uniqueId", request.session().attribute("uniqueId"));
            return new ModelAndView(model, "hero-form.hbs");
        }, new HandlebarsTemplateEngine());

        //post: submit a new hero - redirect to success page
        post("/heroes/new", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            String name = request.queryParams("name");
            int age = Integer.parseInt(request.queryParams("age"));
            String power = request.queryParams("power");
            String weakness = request.queryParams("weakness");
            Hero newHero = new Hero(name, age, power, weakness);
            return new ModelAndView(model, "success.hbs");
        }, new HandlebarsTemplateEngine());

        //get: new squad page

        //post: create a new squad page - redirect to success page

        //get: retrieve all heroes and squads
        get("/heroes", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            model.put("uniqueId", request.session().attribute("uniqueId"));
            return new ModelAndView(model, "heroes.hbs");
        }, new HandlebarsTemplateEngine());

        //get: each hero detail page
        get("/heroes/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int itemId = Integer.parseInt(request.params(":id"));
            Hero foundHero = Hero.findHero(itemId);
            model.put("hero", foundHero);
            model.put("uniqueId", request.session().attribute("uniqueId"));
            return new ModelAndView(model, "hero-detail.hbs");
        }, new HandlebarsTemplateEngine());

        //get: each squad detail page
        get("/squads/:id", (request, response) -> {
            Map<String, Object> model = new HashMap<>();
            int itemId = Integer.parseInt(request.params(":id"));
            /*Squad foundSquad;*/
            model.put("uniqueId", request.session().attribute("uniqueId"));
            return new ModelAndView(model, "squad-detail.hbs");
        }, new HandlebarsTemplateEngine());



    }
}
