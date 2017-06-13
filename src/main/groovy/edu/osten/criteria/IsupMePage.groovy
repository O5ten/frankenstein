package edu.osten.criteria

import geb.Page

class IsupMePage extends Page{
    static url = "http://www.isup.me/anders-maria.nu"
    static content = {
        isUp {
            $("div#container")
        }
    }
}
