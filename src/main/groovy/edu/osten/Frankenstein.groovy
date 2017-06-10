package edu.osten

import org.slf4j.Logger
import org.slf4j.LoggerFactory

Logger log = LoggerFactory.getLogger("Frankenstein");
int HOURS = 4;
int EVERY_FOURTH_HOUR = 1000*60*60*HOURS;
int RUN_RIGHT_AWAY = 0;

def monster = new Monster()
Timer clock = new Timer()

clock.scheduleAtFixedRate(new TimerTask() {
    @Override
    void run() {
        try{
            monster.investigate()
        }catch(AssertionError | Exception e){
            if(e.getMessage().contains("page contains 'It's just you'")){
                log.info "Nothing to do, site is up"
            }
            log.error e.getMessage()
        }
        log.info "Awaiting the next lightning storm in ${HOURS} hours."
    }
}, RUN_RIGHT_AWAY, EVERY_FOURTH_HOUR)

