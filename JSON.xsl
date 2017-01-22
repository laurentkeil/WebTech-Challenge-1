<xsl:stylesheet xmlns:i="http://www.example.org/actuator" xmlns:l="http://www.example.org/light-sensor" xmlns:u="http://www.example.org/user" xmlns:a="http://www.example.org/air-conditioner" xmlns:b="http://www.example.org/bulb" xmlns:t="http://www.example.org/thermostat" version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	
	<xsl:output indent="yes"/>
	<xsl:template match="/">

		<xsl:text>{</xsl:text>
		<xsl:text>"actuator" : </xsl:text>
		 <xsl:text>[</xsl:text>
		
			<xsl:text>"users" : </xsl:text>
			<xsl:text>[</xsl:text>	
				<xsl:apply-templates select ="i:actuator/u:users"></xsl:apply-templates>
			<xsl:text>] </xsl:text>
			<xsl:text>, </xsl:text>
			
				
			<xsl:text>"air" : </xsl:text>
			<xsl:text>[</xsl:text>		
				<xsl:apply-templates select ="i:actuator/a:air-measurements"></xsl:apply-templates>
			<xsl:text>]</xsl:text>	
			<xsl:text>, </xsl:text>
		
			<xsl:text>"bulb" : </xsl:text>
			<xsl:text>[</xsl:text>		
				<xsl:apply-templates select ="i:actuator/b:bulb-measurements"></xsl:apply-templates>
			<xsl:text>]</xsl:text>	
			<xsl:text>, </xsl:text>
		
			
			<xsl:text>"light" : </xsl:text>
			<xsl:text>[</xsl:text>		
				<xsl:apply-templates select ="i:actuator/l:light-measurements"></xsl:apply-templates>
			<xsl:text>]</xsl:text>	
			<xsl:text>, </xsl:text>
		
			
			<xsl:text>"thermostat" : </xsl:text>
			<xsl:text>[</xsl:text>		
				<xsl:apply-templates select ="i:actuator/t:thermostat-measurements"></xsl:apply-templates>
			<xsl:text>]</xsl:text>	
	
		 <xsl:text>]</xsl:text>
		<xsl:text>}</xsl:text>
	</xsl:template>
	
	
	
	<xsl:template match="u:users">
		<xsl:apply-templates select="u:user"></xsl:apply-templates>	
	</xsl:template>
	
	<xsl:template match="u:user">
		<xsl:text>{</xsl:text>
			<xsl:text>"ID" : </xsl:text> <xsl:text>"</xsl:text><xsl:value-of select="u:ID"></xsl:value-of><xsl:text>"</xsl:text><xsl:text>,</xsl:text> 
			<xsl:text>"First Name" : </xsl:text>  <xsl:text>"</xsl:text><xsl:value-of select="u:firstName"></xsl:value-of><xsl:text>"</xsl:text><xsl:text>,</xsl:text>
			<xsl:text>"Last Name" : </xsl:text>  <xsl:text>"</xsl:text><xsl:value-of select="u:LastName"></xsl:value-of><xsl:text>"</xsl:text>
		<xsl:text>},</xsl:text>
	</xsl:template>
	
	
	<xsl:template match="a:air-measurements">
		<xsl:apply-templates select="a:dailyMeasurement"></xsl:apply-templates>
		<xsl:text>"model" : </xsl:text> <xsl:text>"</xsl:text><xsl:value-of select="a:model"></xsl:value-of><xsl:text>"</xsl:text><xsl:text>, </xsl:text>
		<xsl:text>"user-ID" : </xsl:text><xsl:text>"</xsl:text><xsl:value-of select="a:user-ID"></xsl:value-of><xsl:text>"</xsl:text>
	</xsl:template>
	
	
	<xsl:template match="a:dailyMeasurement">
		<xsl:text>{</xsl:text>
			<xsl:text>"Date" : </xsl:text> <xsl:text>"</xsl:text><xsl:value-of select="a:date"></xsl:value-of><xsl:text>"</xsl:text>
			<xsl:text>,</xsl:text>
			<xsl:text>"Measurements" : {</xsl:text>
				<xsl:text>"temperature" : </xsl:text>
						<xsl:text>{</xsl:text>
							<xsl:text>"value" : </xsl:text> <xsl:text>"</xsl:text><xsl:value-of select="a:measurement/a:temperature/a:value"></xsl:value-of><xsl:text>"</xsl:text>
							<xsl:text>,</xsl:text>
		
							<xsl:text>"unit" : </xsl:text><xsl:text>"</xsl:text><xsl:value-of select="a:measurement/a:temperature/a:unit"></xsl:value-of><xsl:text>"</xsl:text>
						<xsl:text>}</xsl:text>
			<xsl:text>},</xsl:text>
			<xsl:text>"Time-stamp" : </xsl:text><xsl:text>"</xsl:text><xsl:value-of select="a:measurement/a:time-stamp"></xsl:value-of><xsl:text>"</xsl:text>
			<xsl:text>,</xsl:text>
			<xsl:text>"Action" : ></xsl:text><xsl:text>"</xsl:text><xsl:value-of select="a:measurement/a:action"></xsl:value-of><xsl:text>"</xsl:text>
		<xsl:text>},</xsl:text>
	</xsl:template>

	<xsl:template match="b:bulb-measurements">
		<xsl:apply-templates select="b:dailyMeasurement"></xsl:apply-templates>
		<xsl:text>"model" : </xsl:text> <xsl:text>"</xsl:text><xsl:value-of select="b:model"></xsl:value-of><xsl:text>"</xsl:text><xsl:text>, </xsl:text>
		<xsl:text>"user-ID" : </xsl:text><xsl:text>"</xsl:text><xsl:value-of select="b:user-ID"></xsl:value-of><xsl:text>"</xsl:text>
	</xsl:template>


	<xsl:template match="b:dailyMeasurement">
		<xsl:text>{</xsl:text>
			<xsl:text>"Date" : </xsl:text>  <xsl:text>"</xsl:text><xsl:value-of select="b:date"></xsl:value-of><xsl:text>"</xsl:text>
			<xsl:text>,</xsl:text>
	
			<xsl:text>"Measurements" : {</xsl:text>
				<xsl:text>"color-mode" : </xsl:text><xsl:text>"</xsl:text><xsl:value-of select="b:measurement/color-mode"></xsl:value-of><xsl:text>"</xsl:text>
				<xsl:text>,</xsl:text>
				<xsl:text>"time-stamp" : </xsl:text>  <xsl:text>"</xsl:text><xsl:value-of select="b:measurement/time-stamp"></xsl:value-of><xsl:text>"</xsl:text>
				<xsl:text>,</xsl:text>
				<xsl:text>"brightness" : </xsl:text> <xsl:text>"</xsl:text><xsl:value-of select="b:measurement/brightness"></xsl:value-of><xsl:text>"</xsl:text>
				<xsl:text>,</xsl:text>
			<xsl:text>}</xsl:text>
	
		<xsl:text>},</xsl:text>
	</xsl:template>
	
	<xsl:template match="l:light-measurements">
		<xsl:apply-templates select="l:dailyMeasurement"></xsl:apply-templates>
		<xsl:text>"model" : </xsl:text> <xsl:text>"</xsl:text><xsl:value-of select="l:model"></xsl:value-of><xsl:text>"</xsl:text><xsl:text>, </xsl:text>
		<xsl:text>"user-ID" : </xsl:text><xsl:text>"</xsl:text><xsl:value-of select="l:user-ID"></xsl:value-of><xsl:text>"</xsl:text>
	</xsl:template>


	
	<xsl:template match="l:dailyMeasurement">
		<xsl:text>{</xsl:text>
			<xsl:text>"date" : {</xsl:text>
				<xsl:text>"year" : </xsl:text>  <xsl:text>"</xsl:text><xsl:value-of select="l:date/l:year"></xsl:value-of><xsl:text>"</xsl:text>
				<xsl:text>,</xsl:text>
				<xsl:text>"month" : </xsl:text><xsl:text>"</xsl:text><xsl:value-of select="l:date/l:month"></xsl:value-of><xsl:text>"</xsl:text>
				<xsl:text>,</xsl:text>
				<xsl:text>"day" : </xsl:text> <xsl:text>"</xsl:text><xsl:value-of select="l:date/l:day"></xsl:value-of><xsl:text>"</xsl:text>
			<xsl:text>} ,</xsl:text>
			
			<xsl:text>"Measurements" : {</xsl:text>
				<xsl:text>"color-mode" : </xsl:text> <xsl:text>"</xsl:text><xsl:value-of select="l:measurement/l:color-mode"></xsl:value-of><xsl:text>"</xsl:text>
				<xsl:text>,</xsl:text>
				<xsl:text>"brightness" : </xsl:text><xsl:text>"</xsl:text><xsl:value-of select="l:measurement/l:brightness"></xsl:value-of><xsl:text>"</xsl:text>
				<xsl:text>,</xsl:text>
			<xsl:text>}</xsl:text>
		<xsl:text>},</xsl:text>	
	</xsl:template>
	
	
	<xsl:template match="i:actuator/t:thermostat-measurements">
		<xsl:apply-templates select="t:dailyMeasurement"></xsl:apply-templates>
		<xsl:text>"model" : </xsl:text> <xsl:text>"</xsl:text><xsl:value-of select="t:model"></xsl:value-of><xsl:text>"</xsl:text><xsl:text>, </xsl:text>
		<xsl:text>"user-ID" : </xsl:text><xsl:text>"</xsl:text><xsl:value-of select="t:user-ID"></xsl:value-of><xsl:text>"</xsl:text>	
	</xsl:template>

	
	<xsl:template match="t:dailyMeasurement">
		<xsl:text>{</xsl:text>
			<xsl:text>"Date" : </xsl:text> <xsl:text>"</xsl:text><xsl:value-of select="t:date"></xsl:value-of><xsl:text>"</xsl:text>
			<xsl:text>,</xsl:text>
			<xsl:text>"Measurements" : {</xsl:text>
				<xsl:text>"temperature" : </xsl:text>
						<xsl:text>{</xsl:text>
							<xsl:text>"value" : </xsl:text>
									<xsl:text>{</xsl:text>
										<xsl:text>"integer-part" : </xsl:text>  <xsl:text>"</xsl:text><xsl:value-of select="t:measurement/t:temperature/t:value/t:integer-part"></xsl:value-of><xsl:text>"</xsl:text>
										<xsl:text>,</xsl:text>
										<xsl:text>"fraction-part" : </xsl:text> <xsl:text>"</xsl:text><xsl:value-of select="t:measurement/t:temperature/t:value/t:fraction-part"></xsl:value-of><xsl:text>"</xsl:text>
									<xsl:text>},</xsl:text>
							<xsl:text>"unit" : </xsl:text> <xsl:text>"</xsl:text><xsl:value-of select="t:measurement/t:temperature/t:unit"></xsl:value-of><xsl:text>"</xsl:text>
						<xsl:text>},</xsl:text>
						
				<xsl:text>"time-stamp" : </xsl:text> <xsl:text>"</xsl:text><xsl:value-of select="t:measurement/t:time-stamp"></xsl:value-of><xsl:text>"</xsl:text>
				<xsl:text>,</xsl:text>
				<xsl:text>"humidity" : </xsl:text> <xsl:text>"</xsl:text><xsl:value-of select="t:measurement/t:humidity"></xsl:value-of><xsl:text>"</xsl:text>
				<xsl:text>,</xsl:text>
			<xsl:text>}</xsl:text>
		<xsl:text>},</xsl:text>	
	</xsl:template>

</xsl:stylesheet>