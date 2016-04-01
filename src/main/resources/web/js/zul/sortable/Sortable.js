zul.sortable.Sortable = zk.$extends(zk.Widget, {
    $define: {
        sortable: function (s) {
            var n = this.$n();
            if (n)
                s.sortable = s;
        },
        group: null,
        animation: null
    },
    bind_: function () {
        this.$supers(zul.sortable.Sortable, 'bind_', arguments);
        var config = {
            group: this._group,
            animation: this._animation
        };
        this.setSortable(
            $('#' + this.uuid).sortable(config)
        );
    }
});