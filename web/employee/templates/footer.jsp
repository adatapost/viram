<script>
    var f = 0;
    function show() {
        if (f == 0) {
            $("#userPass").attr("type", "text");
            $("#RePass").attr("type", "text");
            $("#pwdShow").html("Hide");
            f = 1;
            return;
        }
        $("#userPass").attr("type", "password");
        $("#RePass").attr("type", "password");
        $("#pwdShow").html("Show");
        f = 0;
        return;
    }
    function matchPwd() {
        $("#pwdErr").html("").removeClass();
        if ($("#userPass").val() === $("#RePass").val()) {
            $("#pwdErr").attr("class", "glyphicon glyphicon-ok");
            return;
        }
        $("#pwdErr").attr("class", "glyphicon glyphicon-remove text-warning");
        return;
    }
    
</script>           
</div>
<div class="clear"/>
<footer>
    <div class="text-info text-center bg-info">
        <img src="../images/logoFoot.png"/>
        Copyright © ${now.year+1900} <a href="http://www.adatapost.com">AVD Infotech</a>. All rights reserved.

        <img src="../images/logoFoot.png"/>
    </div>
</footer>
</div>
</body>
</html>
