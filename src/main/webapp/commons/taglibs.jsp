<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set value="${pageContext.request.contextPath}" var="ctx"/>
<script type="text/javascript" src="${ctx}/commons/js/jquery-1.6.js"></script>
<script type="text/javascript" src="${ctx}/commons/js/jquery.json-2.2.min.js"></script>
<script type="text/javascript" src="${ctx}/commons/js/ajaxfileupload.js"></script>
<script type="text/javascript" src="${ctx}/commons/js/commons.js"></script>
<script type="text/javascript" src="${ctx}/commons/js/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${ctx}/commons/js/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${ctx}/commons/js/md5.js"></script>
<script type="text/javascript" src="${ctx}/commons/js/97date/WdatePicker.js"></script>

<script type="text/javascript" src="${ctx}/commons/js/numeral.js"></script>
<script type="text/javascript" src="${ctx}/commons/js/jquery.imgareaselect.min.js"></script>
<script type="text/javascript" src="${ctx}/commons/js/jquery.spinner.js"></script>

<link href="${ctx}/commons/css/style.css" rel="stylesheet"/>
<link href="${ctx}/commons/css/easyui.css" rel="stylesheet"/>
<link href="${ctx}/commons/css/icon.css" rel="stylesheet"/>
<link href="${ctx}/commons/css/imgareaselect-animated.css" rel="stylesheet" type="text/css" >

<script type="text/javascript">
    var basePath = "${ctx}";
</script>
