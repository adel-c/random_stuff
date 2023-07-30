package com.ace.htmxrouter;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Page {
    MAIN("main"),
    ABOUT("about");

    final String path;
    final String fragmentPath;

    Page(String path) {
        this.path = path;
        if (path != null) {
            this.fragmentPath = "/page/" + path;
        } else {
            this.fragmentPath = null;
        }

    }

    public static Page getPageByPath(String path) {
        for (Page value : Page.values()) {

            if ( value.path.equals(path)) {
                return value;
            }
        }
        return null;
    }
}
