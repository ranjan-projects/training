<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0"
                xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:param name="quote">"</xsl:param>
    <xsl:template match="node()">
        <xsl:copy>
            <xsl:apply-templates select="node() | @*" />
            <xsl:text></xsl:text>
        </xsl:copy>
    </xsl:template>
    <xsl:template match="*">
        <xsl:element name="{local-name()}">
            <xsl:apply-templates select="node() | @*" />
            <xsl:text></xsl:text>
        </xsl:element>
    </xsl:template>
    <xsl:template match="@*">
        <xsl:copy>
            <xsl:apply-templates select="node() | @*" />
            <xsl:text></xsl:text>
        </xsl:copy>
    </xsl:template>
</xsl:stylesheet>