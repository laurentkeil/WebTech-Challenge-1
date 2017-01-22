<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="2.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
	xmlns:l="http://www.example.org/light-sensor" 
	xmlns:u="http://www.example.org/user" 
	xmlns:a="http://www.example.org/air-conditioner" 
	xmlns:b="http://www.example.org/bulb" 
	xmlns:t="http://www.example.org/thermostat"
	>
	<xsl:output
		indent="yes"
	/>
	<xsl:template match="/">
		<xsl:element name="users">
			<xsl:apply-templates select="//u:user"/>
		</xsl:element>
	</xsl:template>
	
	<xsl:template match="u:user">	
		<xsl:copy>
			<xsl:copy-of select="*"/>
			<xsl:variable name="id" select="./u:ID"/>
			<xsl:for-each select="../../a:air-measurements">
				<xsl:copy>
					<xsl:if test="(./a:user-ID)=($id)">
						<xsl:copy-of select="."/>
					</xsl:if>
				</xsl:copy>
			</xsl:for-each>
			<xsl:for-each select="../../b:bulb-measurements">
				<xsl:copy>
					<xsl:if test="(./b:user-ID)=($id)">
						<xsl:copy-of select="."/>
					</xsl:if>
				</xsl:copy>
			</xsl:for-each>
			<xsl:for-each select="../../l:light-measurements">
				<xsl:copy>
					<xsl:if test="(./l:user-ID)=($id)">
						<xsl:copy-of select="."/>
					</xsl:if>
				</xsl:copy>
			</xsl:for-each>
			<xsl:for-each select="../../t:thermostat-measurements">
				<xsl:copy>
					<xsl:if test="(./t:user-ID)=($id)">
						<xsl:copy-of select="."/>
					</xsl:if>
				</xsl:copy>
			</xsl:for-each>
			
		</xsl:copy>
	</xsl:template>
	
	<xsl:template match="type">
		<xsl:copy>
			<xsl:variable name="name" select="."/>
			<xsl:attribute name="name">
				<xsl:value-of select="$name"/>
			</xsl:attribute>
			<xsl:for-each select="../../../patients/patient">
				<xsl:variable name="currentPat" select="."/>
				<xsl:if test="../../records/record[(test-type=$name) and (./patient-id=$currentPat/patient-id)]">
						<xsl:copy-of select="."/>
				</xsl:if>
			</xsl:for-each>
		</xsl:copy>
	</xsl:template>
</xsl:stylesheet>