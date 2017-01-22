declare namespace p = "http://www.example.org/thermostat";

<p:thermostatData>{for $x in distinct-values(doc("thermostat_original.xml")//p:thermostatData/p:dailyMesurement/p:date)
order by $x
return <p:dailyMesurement>
<p:date>{data($x)}</p:date>
{
for $y in doc("thermostat_original.xml")//p:thermostatData/p:dailyMesurement
where $y/p:date = $x
return
<p:measurement>
<p:temprature>
<p:value>
<p:integer-part>{data($y/p:measurement/p:temprature/p:value/p:integer-part)}</p:integer-part>
<p:fraction-part>{data($y/p:measurement/p:temprature/p:value/p:fraction-part)}</p:fraction-part>
</p:value>
<p:unit>{data($y/p:measurement/p:temprature/p:unit)}</p:unit>
</p:temprature>
<p:time-stump>{data($y/p:time-stump)}</p:time-stump>
<p:humidity>{data($y/p:humidity)}</p:humidity>
</p:measurement>
}</p:dailyMesurement>}</p:thermostatData>