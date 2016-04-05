package org.zkoss.sortable;

import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.sortable.event.SortableEvents;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Wire;

import java.util.List;

/**
 * View Model for the demo page.
 *
 * @author Sean Connolly
 */
public class DemoViewModel {

    private static final EventListener<Event> EVENT_PRINTER = new EventListener<Event>() {
        @Override
        public void onEvent(Event event) {
            System.out.println(event.getName() + ": " + event);
        }
    };

    @Wire("sortable")
    private List<Sortable> sortables;

    @AfterCompose
    public void afterCompose(@ContextParam(ContextType.VIEW) Component view) {
        Selectors.wireComponents(view, this, false);
        for (Sortable sortable : sortables) {
            sortable.addEventListener(SortableEvents.ON_START, EVENT_PRINTER);
            sortable.addEventListener(SortableEvents.ON_END, EVENT_PRINTER);
            sortable.addEventListener(SortableEvents.ON_ADD, EVENT_PRINTER);
            sortable.addEventListener(SortableEvents.ON_REMOVE, EVENT_PRINTER);
            sortable.addEventListener(SortableEvents.ON_UPDATE, EVENT_PRINTER);
            sortable.addEventListener(SortableEvents.ON_SORT, EVENT_PRINTER);
            sortable.addEventListener(SortableEvents.ON_FILTER, EVENT_PRINTER);
        }
    }

}
