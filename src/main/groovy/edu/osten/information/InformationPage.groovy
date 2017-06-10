package edu.osten.information

import geb.Page

class InformationPage extends Page {
    static url = "http://192.168.8.1"
    static content = {
        header {
            $("pre#index_plmn_name")
        }
        loginButton {
            $("span.logout")
        }
        login {
            $("span.logout").click()
            $("input#username") << System.getProperty("information.username")
            $("input#password") << System.getProperty("information.password")
            $("a", text: "Logga In").click()
            waitFor {
                $("span#logout_span", text: "Logga ut")
            }
        }
    }
}
