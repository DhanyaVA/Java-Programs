<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Student Marks Form</title>

<script>
function validateForm() {
    let marks = document.getElementsByClassName("marks");

    for (let i = 0; i < marks.length; i++) {
        let value = parseInt(marks[i].value);

        if (isNaN(value) || value < 0 || value > 100) {
            alert("Marks must be between 0 and 100");
            return false;
        }
    }
    return true;
}
</script>

</head>

<body>

<h2>Enter Student Details</h2>

<form action="ResultServlet" method="post" onsubmit="return validateForm()">

Roll No: <input type="text" name="rollno" required><br><br>
Student Name: <input type="text" name="name" required><br><br>

Sub1: <input type="number" name="sub1" class="marks" required><br><br>
Sub2: <input type="number" name="sub2" class="marks" required><br><br>
Sub3: <input type="number" name="sub3" class="marks" required><br><br>
Sub4: <input type="number" name="sub4" class="marks" required><br><br>
Sub5: <input type="number" name="sub5" class="marks" required><br><br>

<input type="submit" value="Submit">

</form>

</body>
</html>