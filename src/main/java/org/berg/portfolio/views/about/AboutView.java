package org.berg.portfolio.views.about;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.Scroller;
import com.vaadin.flow.component.page.Push;
import org.berg.portfolio.client.AsyncRestClientService;
import org.berg.portfolio.client.PersonDTO;
import org.berg.portfolio.views.MainLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import org.springframework.beans.factory.annotation.Autowired;


@PageTitle("About")
@Route(value = "about", layout = MainLayout.class)
public class AboutView extends VerticalLayout {

    private final AsyncRestClientService service;
    private final HorizontalLayout horizontalLayout;

    public AboutView(@Autowired AsyncRestClientService service) {
        this.service = service;
        horizontalLayout = new HorizontalLayout();
        setSpacing(false);

        Image img = new Image("images/empty-plant.png", "placeholder plant");
        img.setWidth("200px");
        add(img);

        H2 header = new H2("This place intentionally left empty");
        header.addClassNames(Margin.Top.XLARGE, Margin.Bottom.MEDIUM);
        add(header);
        add(new Paragraph("It’s a place where you can grow your own UI 🤗"));
        Scroller scroller = new Scroller();
        scroller.setScrollDirection(Scroller.ScrollDirection.HORIZONTAL);
        scroller.setContent(horizontalLayout);

        horizontalLayout.add(new Image("images/empty-plant.png", "placeholder plant"));
        horizontalLayout.add(new Image("images/empty-plant.png", "placeholder plant"));
        add(scroller);

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");

        final Button fetch = new Button("Fetch People", e -> fetchPeople());
        add(fetch);
    }


    private void fetchPeople() {
        service.getAllPeopleAsync(results -> {
            getUI().get().access(() -> {
                horizontalLayout.removeAll();
                for(PersonDTO dto : results) {
                    Icon newIcon = VaadinIcon.MALE.create();
                    newIcon.setTooltipText(dto.getName());
                    newIcon.setVisible(true);
                    newIcon.setColor("Black");
                    horizontalLayout.add(newIcon);
                }
            });
        });
    }
}
