#Create a simulator object set 

ns [new Simulator] 

#Tell the simulator to use dynamic routing 

$ns rtproto DV 

$nsmacTypeMac/802_3 

#Open the nam trace file 

set nf [open distance.nam w] 

$ns namtrace-all $nf 

#Open the output files 

setf0[opendistance.trw] 

$ns trace-all $f0 

#Define a 'finish' procedure 

proc finish {} { 

global ns f0 nf 

$ns flush-trace 

#Close the trace file close 

$f0 

close $nf

#Call xgraph to display the resultsexec 

namdistance.nam& 

exit 0 

} 

#Create seven nodes 

for {set i 0} {$i< 7} {incri} { 

set n($i) [$ns node] 

} 

#Create links between the nodes 

for {set i 0} {$i< 7} {incri} { 

$ns duplex-link $n($i) $n([expr ($i+1)%7]) 1Mb 

10msDropTail} 

#Create a UDP agent and attach it to node n(0) 

set udp0 [newAgent/UDP] 

$ns attach-agent $n(0) $udp0 

#Create a CBR traffic source and attach it to udp0 

set cbr0 [newApplication/Traffic/CBR] 

$cbr0 set packetSize_ 500 

$cbr0 set interval_ 0.005 

$cbr0 attach-agent $udp0 

#Create a Null agent (a traffic sink) and attach it to node n(3) 

set null0 [newAgent/Null] 

$ns attach-agent $n(3) $null0 

#Connectthetrafficsourcewiththetrafficsink 

$ns connect $udp0 $null0 

#Schedule events for the CBR agent and the network dynamics 

$ns at 0.5 "$cbr0 start" 

$ns rtmodel-at 1.0 down $n(1) $n(2) 

$ns rtmodel-at 2.0 up $n(1) $n(2) 

$ns at 4.5 "$cbr0 stop" 

#Call the finish procedure after 5 seconds of simulation time 

$ns at 5.0 "finish" 

#Run the simulation
