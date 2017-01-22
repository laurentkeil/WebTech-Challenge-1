declare namespace u = "http://www.example.org/user";
declare namespace a = "http://www.example.org/air-conditioner";
declare namespace l = "http://www.example.org/lightsensor";
declare namespace b = "http://www.example.org/bulb";
declare namespace t = "http://www.example.org/thermostat";
declare namespace i = "http://www.example.org/actuator";


<a:actuator>
{for $x in doc("actuator.xml")//i:actuator/t:thermostat-measurements
let $avg := xs:float(sum($x/t:dailyMeasurement/t:measurement/t:humidity) div count($x/t:dailyMeasurement))
order by $avg
return <t:avg-humidity>{data($avg)}</t:avg-humidity>
}
</a:actuator>