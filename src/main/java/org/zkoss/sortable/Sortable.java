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

    public void setGroup(String group) {
        if (this.group == null || group == null || !this.group.equals(group)) {
            this.group = group;
            smartUpdate("group", group);
        }
    }

    public void setAnimation(Integer animation) {
        if (this.animation == null || animation == null || !this.animation.equals(animation)) {
            this.animation = animation;
            smartUpdate("animation", animation);
        }
    }

    @Override
    protected void renderProperties(ContentRenderer renderer) throws IOException {
        super.renderProperties(renderer);
        render(renderer, "group", group);
        render(renderer, "animation", animation);
    }

}
