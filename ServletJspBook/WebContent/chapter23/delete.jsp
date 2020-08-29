<%@page contentType="text/html; charset=UTF-8" %>
<%@include file="../header.html" %>

<p>削除する商品IDを入力してください。</p>
<form action="Delete.action" method="post">
商品ID<input type="text" name="id">
<input type="submit" value="削除">
</form>

<%@include file="../footer.html" %>
