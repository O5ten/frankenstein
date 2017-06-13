package edu.osten

import edu.osten.criteria.IsupMePage
import edu.osten.information.RouterPage
import edu.osten.information.RouterSettingsPage
import edu.osten.monster.LoopiaPage
import edu.osten.monster.LoopiaSettingsPage
import geb.Browser
import org.slf4j.Logger
import org.slf4j.LoggerFactory

import static org.hamcrest.CoreMatchers.containsString
import static org.hamcrest.CoreMatchers.is
import static org.hamcrest.MatcherAssert.assertThat

class Monster {
    Logger log = LoggerFactory.getLogger("Monster");
    def investigate = {
        Browser.drive {
            to IsupMePage
            assertThat"Page looks down from there", page.isUp.text(), containsString("looks down from here")

            to RouterPage
            page.login()

            to RouterSettingsPage
            String wanIp = page.getWanIpNumber()
            int dotsInIP = wanIp.findAll { v -> v.equals('.')}.size();
            assertThat "WAN IP is well-formed like an IP should be", dotsInIP, is(3)

            to LoopiaPage
            page.loginCustomerZone()

            to LoopiaSettingsPage
            page.selectDomain()
            page.setWanIp(wanIp)
            page.saveDomain()

            waitFor 10, {}
            quit()
        }
        log.info "Corrected WAN IP successfully"
    }
}
