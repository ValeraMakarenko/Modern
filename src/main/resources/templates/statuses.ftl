<html>
<body>
<h2>This is cool library!</h2>

Statuses available:

<ul>
<#list statusess as status>
    <li>${status_index + 1}. ${status.name}</li>
</#list>
</ul>
</body>
</html>