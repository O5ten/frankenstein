# The idea
Automate recovering from the bloody DNS reset every goddamn day. 

## IsUp.me
Given: 
A site on a shaky mobile broadband

When: 
The site is down on isup.me

Then: 
Geb-script on a set interval to isup.me to see if the site is down every hour. 

## Router
Given: 
The site is down on isup.me

When: 
Navigated to 192.168.8.1 

And: 
Signed on through the basic auth

Then: 
Navigate to the unit configuration and collect the bloody WAN IP

##Loopia
Given: 
The ip XXX.XXX.XXX.XXX has been collected from the router

When: 
Navigating to loopia

And: 
Signed in with private credentials for site

Then: 
Set the DNS to point to the collected IP
