#!/bin/bash

badges=(guardian liberator pioneer explorer hacker mind_controller builder purifier recharger seer connector)

levels=([1]=bronze silver gold platinum onyx)

for item in ${badges[*]}
do
    for index in ${!levels[*]}
	do
		link="http://niantic.schlarp.com/_media/investigation:apps:ingress:$item$index.png"
		name="ic_badge_"$item"_"${levels[$index]}".png"
		/usr/local/bin/wget $link -O $name
	    
	done

done


