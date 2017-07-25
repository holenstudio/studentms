$(document).ready(function () {
    $("#searchBtn").click(function () {
        var studentName = $('#name').val();
        if (studentName == '' ) {
            $.ajax({
                url: 'http://localhost:8080/studentms/student/showStudents',
                type: 'GET',
                success: function (students) {
                    var studentsObj = JSON.parse(students);
                    var length = studentsObj.length;
                    for (var i = 0; i < length; i++) {
                        var student = studentsObj[i];
                        var html = "<tr>";
                        html = html + "<td align=\"center\">" + student["name"] + "</td>"
                        html = html + "<td align=\"center\">" + student["gender"] + "</td>"
                        html = html + "<td align=\"center\">" + student["address"] + "</td>"
                        html = html + "<td align=\"center\">" + student["balance"] + "</td>"
                        html = html + " </tr>";
                        html = html + "<td align=\"center\">\n" +
                            "                <div class=\"btn-group\">\n" +
                            "                    <button type=\"button\" onclick=\"window.location.href = 'student/update?id="+ student["id"] + "'\" class=\"btn btn-default\">更新</button>\n" +
                            "                    <button type=\"button\" onclick=\"window.location.href = 'student/delete?id="+ student["id"] + "'\" class=\"btn btn-default\">删除</button>\n" +
                            "                </div>\n" +
                            "            </td>";
                        $("#studentsTable").append(html);

                    }
                }
            });
        }
    })

})

