package edu.osten.monster

import geb.Page

import java.util.concurrent.TimeUnit

class LoopiaSettingsPage extends Page{
    static url = "https://customerzone.loopia.se/"
    static content = {
        selectDomain {
           $("div.list-domain").children("div.object").click()
        }
        setWanIp { v ->
            waitFor 20.0, { $("input#loopia_domain_settings_dns_target") }
            def input = $("input#loopia_domain_settings_dns_target")
            input.value(v)
        }
        saveDomain {
            $("div#loopia_domain_settings_dns").siblings("input", type: "submit", value: "Spara").click()
        }
    }
}
