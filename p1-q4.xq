declare namespace p = "http://www.example.org/thermostat";



<p:thermostatData>
{(for $x in distinct-values(doc("thermostat_original.xml")//p:thermostatData/p:dailyMesurement/p:date)
let $t := doc("thermostat_original.xml")//p:thermostatData/p:dailyMesurement[p:date = $x]/p:measurement/p:temprature/p:value
let $avg-int := sum($t/p:integer-part) div count(doc("thermostat_original.xml")//p:thermostatData/p:dailyMesurement[p:date = $x])
let $avg-frac := sum($t/p:fraction-part) div count(doc("thermostat_original.xml")//p:thermostatData/p:dailyMesurement[p:date = $x]) div 10
let $concat := xs:decimal(sum(($avg-int,$avg-frac)))
order by $concat descending
return 
(<p:date>{data($x)}</p:date>,
<p:avg-temprature>{data($concat)}</p:avg-temprature>))
}</p:thermostatData>