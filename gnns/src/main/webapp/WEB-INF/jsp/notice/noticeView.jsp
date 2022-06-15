<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tbody>
			<tr>
				<td colspan="3">${noticeView.subject}</td>
			</tr>
			<tr>
				<td>이름 관리자</td>
				<td>날짜 ${noticeView.regDttm}</td>
				<td> 조회수 1500</td>
			</tr>
			<tr>
				<td colspan="3">${noticeView.contents}</td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td colspan="2">atchfile.txt</td>
			</tr>
		</tbody>
	</table>
	<a href="/notice/noticeList">목록</a>
</body>
</html>