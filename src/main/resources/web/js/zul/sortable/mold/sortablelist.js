function (out) {
    out.push('<ul ', this.domAttrs_(), '>');
    for (var w = this.firstChild; w; w = w.nextSibling) {
        w.redraw(out);
    }
    out.push('</ul>')
}