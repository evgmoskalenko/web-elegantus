<#ftl output_format="HTML">
<#-- @ftlvariable name="com.exness.data" type="io.qameta.allure.attachment.http.HttpResponseAttachment" -->
<div>Status code <#if com.exness.data.responseCode??>${com.exness.data.responseCode} <#else>Unknown</#if></div>
<#if com.exness.data.url??><div>${com.exness.data.url}</div></#if>

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