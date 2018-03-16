<#ftl output_format="HTML">
<#-- @ftlvariable name="com.exness.data" type="io.qameta.allure.attachment.http.HttpRequestAttachment" -->
<div><#if com.exness.data.method??>${com.exness.data.method}<#else>GET</#if> to <#if com.exness.data.url??>${com.exness.data.url}<#else>Unknown</#if></div>

<#if com.exness.data.body??>
<h4>Body</h4>
<div>
    <pre class="preformated-text">
    ${com.exness.data.body}
    </pre>
</div>
</#if>

<#if (com.exness.data.headers)?has_content>
<h4>Headers</h4>
<div>
    <#list com.exness.data.headers as name, value>
        <div>${name}: ${value}</div>
    </#list>
</div>
</#if>


<#if (com.exness.data.cookies)?has_content>
<h4>Cookies</h4>
<div>
    <#list com.exness.data.cookies as name, value>
        <div>${name}: ${value}</div>
    </#list>
</div>
</#if>

<#if com.exness.data.curl??>
<h4>Curl</h4>
<div>
${com.exness.data.curl}
</div>
</#if>