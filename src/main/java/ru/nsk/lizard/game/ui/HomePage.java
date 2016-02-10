package ru.nsk.lizard.game.ui;


import org.apache.wicket.markup.html.form.Button;
import org.apache.wicket.model.Model;
import org.apache.wicket.request.mapper.parameter.PageParameters;
import org.apache.wicket.markup.html.basic.Label;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.spring.injection.annot.SpringBean;
import org.wicketstuff.annotation.mount.MountPath;
import ru.nsk.lizard.game.db.common.Filter;
import ru.nsk.lizard.game.db.entities.GameMap;
import ru.nsk.lizard.game.db.services.GameMapService;
import ru.nsk.lizard.game.logic.GameCore;

import java.util.List;

@MountPath("test")
public class HomePage extends WebPage {
    private static final long serialVersionUID = 1L;

    @SpringBean
    private GameCore gameCore;

    @SpringBean
    GameMapService gameMapService;

    public HomePage(final PageParameters parameters) {
        super(parameters);

        add(new Label("version", getApplication().getFrameworkSettings().getVersion()));

        // TODO Add your page's components here

        add(new Button("", Model.of(">>>")));

        List<GameMap> map = gameMapService.search(new Filter());
        for (GameMap gm : map) {
        }


    }
}
