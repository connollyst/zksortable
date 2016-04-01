package org.zkoss.sortable;

import org.zkoss.zk.ui.sys.ContentRenderer;
import org.zkoss.zul.impl.XulElement;

import java.io.IOException;

/**
 * @author Sean Connolly
 */
public class Sortable extends XulElement {

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

}
