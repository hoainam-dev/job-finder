<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/common/taglib.jsp"%>
<html>
<head>
    <title>thành công</title>
</head>
<body>

<h2>Thanh toán thành công!</h2>

<p>Mã hóa đơn ${vnp_BankTranNo}</p>
<p>Quý khách vui lòng kiểm tra email để xem lại thông tin gói sản phẩm.</p>

<a href="${pageContext.request.contextPath}/nha-tuyen-dung/trang-chu">Quay lại trang chủ</a>

</body>
</html>