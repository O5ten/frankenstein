package edu.osten.monster

import geb.Page

class MonsterPage extends Page{
    static url = "http://www.loopia.se"

    static content = {
        updateWanIp {
            $("a#login-btn-cz").click();
            waitFor { $("input#username") && $("input#password") }
            $("input#username") << System.getProperty("monster.username")
            $("input#password") << System.getProperty("monster.password")
            $("input", value: "Logga in", type: "submit").click()
        }
    }
}
