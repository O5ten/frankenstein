package edu.osten.monster

import geb.Page

class LoopiaPage extends Page{
    static url = "http://www.loopia.se"

    static content = {
        loginCustomerZone {
            $("a#login-btn-cz").click();
            waitFor { $("input#username") && $("input#password") && $("input", value: "Logga in", type: "submit") }
            $("input#username") << System.getProperty("loopia.username")
            $("input#password") << System.getProperty("loopia.password")
            $("input", value: "Logga in", type: "submit").click()
        }
    }
}
