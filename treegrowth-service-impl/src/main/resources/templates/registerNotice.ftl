<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <style lang="text/css">
        #bt th {
            border: 1px solid #ccc;
            background: #0cf;
            color: #fff;
        }

        #bt td {
            border: 1px solid #ccc;
            background: #fff;
        }

    </style>
</head>
<body>
<h2>预约信息统计</h2>

<table id="bt" cellspacing="0">
    <tr>
        <th>名字</th>
        <th>电话</th>
        <th>邮箱</th>
        <th>组织机构</th>
        <th>注册时间</th>
    </tr>
    <tr>
        <td>${user.name!"无"}</td>
        <td>${user.phone_number!"无"}</td>
        <td>${user.email!"无"}</td>
        <td>${user.organization!"无"}</td>
        <td><#if user.registrationDate??>${user.registrationDate?string["yyyy-MM-dd hh:mm:ss a"]}<#else >无</#if></td>
    </tr>
    <tr>
        <th>联系电话</th>
        <th>预约客户名字</th>
        <th>预约开始时间</th>
        <th>预约结束时间</th>
        <th>预约地点</th>
        <th>预约内容</th>
        <th>创建时间</th>
        <th>取消时间</th>
    </tr>
    <tr>
        <td>${contactPhone!"无"}</td>
        <td>${contactName!"无"}</td>
        <td><#if beginDate??>${beginDate?string["yyyy-MM-dd hh:mm:ss a"]}<#else >无</#if></td>
        <td><#if endDate??>${endDate?string["yyyy-MM-dd hh:mm:ss a"]}<#else >无</#if></td>
        <td><#if location??>${location}<#else >无</#if></td>
        <td><#if comment??>${comment}<#else >无</#if></td>
        <td><#if createDate??>${createDate?string["yyyy-MM-dd hh:mm:ss a"]}<#else >无</#if></td>
        <td><#if cancelDate??>${cancelDate?string["yyyy-MM-dd hh:mm:ss a"]}<#else >无</#if></td>
    </tr>

</table>
</body>
</html>