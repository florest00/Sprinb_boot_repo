<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<link rel="stylesheet" href="/css/common/layout.css">
<script defer src="/js/common/layout.js"></script>

<c:if test="${not empty alertMsg}">
    <script>
    alert("${alertMsg}");
    </script>
</c:if>

<c:remove var="alertMsg"></c:remove>