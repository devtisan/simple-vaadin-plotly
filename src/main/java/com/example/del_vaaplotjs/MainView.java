package com.example.del_vaaplotjs;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.dependency.JavaScript;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;
import elemental.json.impl.JreJsonFactory;

@Route("")
public class MainView extends Div {
    public MainView() {
        setId("container");
        var chart = new PieChart();
        add(chart);
    }
}

@Tag("div")
@JavaScript("plotly.js")
class PieChart extends Component {
    public PieChart() {
        setId("aaaa");

        var jsonFactory = new JreJsonFactory();

        var data = jsonFactory.createObject();
        var values = jsonFactory.createArray();
        values.set(0, 19);
        values.set(1, 26);
        values.set(2, 55);
        data.put("values", values);
        var labels = jsonFactory.createArray();
        labels.set(0, "Residential");
        labels.set(1, "Non-Residential");
        labels.set(2, "Utility");
        data.put("labels", labels);
        data.put("type", "pie");

        var layout = jsonFactory.createObject();
        layout.put("height", 400);
        layout.put("width", 500);

        var data0 = jsonFactory.createArray();
        data0.set(0, data);

        var config = jsonFactory.createObject();
        config.put("displayModeBar", false);

        UI.getCurrent().getPage().executeJs("Plotly.newPlot($0,$1,$2,$3)", "aaaa", data0, layout, config);
    }
}