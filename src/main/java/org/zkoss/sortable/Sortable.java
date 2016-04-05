package org.zkoss.sortable;

import org.zkoss.sortable.event.*;
import org.zkoss.zk.au.AuRequest;
import org.zkoss.zk.ui.event.Events;
import org.zkoss.zk.ui.sys.ComponentCtrl;
import org.zkoss.zk.ui.sys.ContentRenderer;
import org.zkoss.zul.impl.XulElement;

import java.io.IOException;

/**
 * @author Sean Connolly
 */
public class Sortable extends XulElement {

    static {
        addClientEvent(Sortable.class, SortableEvents.ON_START, ComponentCtrl.CE_IMPORTANT);
        addClientEvent(Sortable.class, SortableEvents.ON_END, ComponentCtrl.CE_IMPORTANT);
        addClientEvent(Sortable.class, SortableEvents.ON_ADD, ComponentCtrl.CE_IMPORTANT);
        addClientEvent(Sortable.class, SortableEvents.ON_UPDATE, ComponentCtrl.CE_IMPORTANT);
        addClientEvent(Sortable.class, SortableEvents.ON_SORT, ComponentCtrl.CE_IMPORTANT);
        addClientEvent(Sortable.class, SortableEvents.ON_REMOVE, ComponentCtrl.CE_IMPORTANT);
        addClientEvent(Sortable.class, SortableEvents.ON_FILTER, ComponentCtrl.CE_IMPORTANT);
    }

    private String group;
    private Integer animation;
    private String draggable;
    private String handle;

    public void setGroup(String group) {
        if (this.group == null || group == null || !this.group.equals(group)) {
            this.group = group;
            smartUpdate("_group", group);
        }
    }

    public void setAnimation(Integer animation) {
        if (this.animation == null || animation == null || !this.animation.equals(animation)) {
            this.animation = animation;
            smartUpdate("_animation", animation);
        }
    }

    public void setDraggable(String draggable) {
        if (this.draggable == null || draggable == null || !this.draggable.equals(draggable)) {
            this.draggable = draggable;
            smartUpdate("_draggable", draggable);
        }
    }

    public void setHandle(String handle) {
        if (this.handle == null || handle == null || !this.handle.equals(handle)) {
            this.handle = handle;
            smartUpdate("_handle", handle);
        }
    }

    @Override
    protected void renderProperties(ContentRenderer renderer) throws IOException {
        super.renderProperties(renderer);
        render(renderer, "_group", group);
        render(renderer, "_animation", animation);
        render(renderer, "_draggable", draggable);
        render(renderer, "_handle", handle);
    }

    @Override
    public void service(AuRequest request, boolean everError) {
        if (request.getCommand().equals(SortableEvents.ON_START)) {
            Events.postEvent(StartEvent.get(request));
        } else if (request.getCommand().equals(SortableEvents.ON_END)) {
            Events.postEvent(EndEvent.get(request));
        } else if (request.getCommand().equals(SortableEvents.ON_ADD)) {
            Events.postEvent(AddEvent.get(request));
        } else if (request.getCommand().equals(SortableEvents.ON_REMOVE)) {
            Events.postEvent(RemoveEvent.get(request));
        } else if (request.getCommand().equals(SortableEvents.ON_UPDATE)) {
            Events.postEvent(UpdateEvent.get(request));
        } else if (request.getCommand().equals(SortableEvents.ON_SORT)) {
            Events.postEvent(SortEvent.get(request));
        } else if (request.getCommand().equals(SortableEvents.ON_FILTER)) {
            Events.postEvent(FilterEvent.get(request));
        } else {
            super.service(request, everError);
        }
    }


}
