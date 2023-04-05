<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Insert title here</title>
    <script type="text/javascript" src="scripts/jquery-1.9.1.min.js"></script>
    <script type="text/javascript">


        $(function () {


            $(".delete").click(function () {
                var pagesize = $("#pagesize").val();

                var pageno = $("#pageno").val();

                var href = $(this).attr("href");
                var sum =${sums};

                if (sum % pagesize == 1 && pageno != 0) {

                    var pageno = parseInt(pageno) - 1;
                    $("#deleteForm").attr("action", href + "?pageno=" + pageno + "&pagesize=" + pagesize).submit();

                } else {

                    $("#deleteForm").attr("action", href + "?pageno=" + pageno + "&pagesize=" + pagesize).submit();

                }

                return false;
            })


            $("#lang").change(function () {

                /* alert($(this).val()); */
                window.location.href = "locale?locale=" + $(this).val();
            });


            $("#kexuan").change(function () {
                var pagesize = $(this).val();
                $("#pagesize").val(pagesize);

                var pageno = $("#pageno").val();
                var pagesize = $("#pagesize").val();
                var sum = $("#zonggong").text();


                window.location.href = "query?pageno=" + 0 + "&pagesize=" + pagesize;

            });


            $("#firstpage").click(function () {


                var pagesize = $("#pagesize").val();

                window.location.href = "query?pagesize=" + pagesize;

            });


            $("#toppage").click(function () {
                var pageno = $("#pageno").val();

                var pagesize = $("#pagesize").val();

                window.location.href = "shangye?pageno=" + pageno + "&pagesize=" + pagesize;

            });


            $("#nextpage").click(function () {


                var pageno = $("#pageno").val();
                /* 	  var pageno=parseInt(page)+1; */

                var pagesize = $("#pagesize").val();

                window.location.href = "xiaye?pageno=" + pageno + "&pagesize=" + pagesize;

            });


            $("#endpage").click(function () {
                var pageno = $("#zonggong").text();


                var pagesize = $("#pagesize").val();

                window.location.href = "wei?pageno=" + pageno + "&pagesize=" + pagesize;

            });


            function xiaye() {
                var pageno = $("#pageno").val();
                var pagesize = $("#pagesize").val();
                var jie1 = parseInt(pageno) + 1;
                $("#dangqian").text(parseInt(jie1));


                var sums = '${sums}';
                var sumss = sums / pagesize;
                sumss = Math.ceil(sumss);
                $("#zonggong").text(sumss);


                if (jie1 == sumss) {

                    $("#nextpage").hide()
                }


                $(".xuan").text(parseInt(pagesize));

            }

            xiaye()

        });
    </script>
</head>
<body>


<!-- 	<form action="emp1" method="post">
		<input type="text" name="user">
		<input type="submit">
	</form> -->


<form action="" method="POST" id="deleteForm">
    <input type="hidden" name="_method" value="DELETE">
</form>


<%--
	<c:if test="${empty requestScope.query }">

	</c:if>  --%>

<table border="1" cellpadding="10" cellspacing="0">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>删除</td>
        <td>修改</td>
        <!-- 		<td>删公司</td>
                <td>改公司</td> -->
    </tr>


    <c:forEach items="${requestScope.querys}" var="emp">
        <tr>
            <td>${emp.id}</td>

                <%-- <td><img alt="" src="testxia?path=${emp.hand}" width="50" height="50"></td>   --%>
            <td>${emp.name}</td>
            <td><a class="delete" href="emp/${emp.id}">删除</a></td>
            <td><a href="emp/${emp.id}">修改</a></td>

                <%-- <td><a class="delete" href="gs/${emp.gs_id}">删除</a></td>
                <td><a href="gs/${emp.gs_id}">修改</a></td>  --%>

        </tr>
    </c:forEach>
</table>

<br>


<a href="emp">添加</a>&nbsp;&nbsp;

<%--<select id="lang">--%>
<%--	<!-- <option value="" style="display: none;"></option> -->--%>
<%--	<option value="zh_CN">中文</option>--%>
<%--	<option value="en_US" <c:if test="${lang=='en_US'}">selected</c:if>>English</option>--%>
<%--</select>--%>

<c:set var="limit" scope="request" value="${requestScope.limits}"></c:set>
<c:set var="pagesize" scope="request" value="${requestScope.size}"></c:set>
<input type="hidden" name="pageno" id="pageno" value="${limit}">  <!-- 当前第几页 -->
<input type="hidden" name="pagesize" id="pagesize" value="${pagesize}">
<input type="hidden" name="sum" id="sum">
<input type="hidden" name="pagecount" id="pagecount" value="${pagecounte}">

<br>

当前是<font color="red" id="dangqian"></font>页，&nbsp;&nbsp;
总共<font color="red" id="zonggong"></font>页.&nbsp;&nbsp;
<!--   一共有<font color="red" id="zongtiao"></font>条&nbsp;&nbsp; -->
<select id="kexuan">
    <option value="" class="xuan"></option>
    <option value="2">2</option>
    <option value="3">3</option>
    <option value="4">4</option>
    <option value="5">5</option>
</select>
<br>
<a href="#" id="firstpage">首页</a>&nbsp;&nbsp;
<c:if test="${limit != 0}">
    <a href="#" id="toppage">上一页</a>&nbsp;&nbsp;
</c:if>
<a href="#" id=nextpage>下一页</a>&nbsp;&nbsp;
<a href="#" id="endpage">尾页</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;


</body>
</html>