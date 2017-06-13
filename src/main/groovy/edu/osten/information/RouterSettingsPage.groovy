package edu.osten.information

import geb.Page

class RouterSettingsPage extends Page{
    static url = "http://192.168.8.1/html/deviceinformation.html"
    static content = {
        getWanIpNumber {
            $("td", text: "WAN-IP-adress:").next().text()
        }
    }
}
