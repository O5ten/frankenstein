package edu.osten

import edu.osten.criteria.CriteriaPage
import edu.osten.information.InformationPage
import edu.osten.information.InformationSettingsPage
import edu.osten.monster.MonsterPage
import edu.osten.monster.MonsterSettingsPage
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
            to CriteriaPage
            assertThat"Page looks down from there", page.isUp.text(), containsString("looks down from here")
            to InformationPage
            page.login()
            to InformationSettingsPage
            String wan = page.getWanIpNumber()
            int dotsInIP = wan.findAll { v -> v.equals('.')}.size();
            assertThat "WAN IP is well-formed like an IP should be", dotsInIP, is(3)
            to MonsterPage
            page.updateWanIp();
            to MonsterSettingsPage

            log.info "Administered townspeople to correct their WAN IP successfully"
        }
    }
}
